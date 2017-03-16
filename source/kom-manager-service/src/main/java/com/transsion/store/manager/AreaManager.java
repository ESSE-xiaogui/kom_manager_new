package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Area;
import com.transsion.store.bo.AreaRegion;
import com.transsion.store.bo.AreaShop;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.AreaDto;
import com.transsion.store.dto.AreaShopChildrenDto;
import com.transsion.store.dto.AreaShopDto;
import com.transsion.store.dto.ShopAreaDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.AreaMapper;
import com.transsion.store.mapper.AreaRegionMapper;
import com.transsion.store.mapper.AreaShopMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.mapper.SystemDateMapper;
import com.transsion.store.utils.CacheUtils;

@Service("areaManager")
public class AreaManager {
	@Autowired
	private AreaMapper areaMapper;
	
	@Autowired
	private AreaRegionMapper areaRegionMapper;
	
	@Autowired
	private SystemDateMapper systemDateMapper;
	
	@Autowired
	private ShopMapper shopMapper;
	
	@Autowired
	private AreaShopMapper areaShopMapper;
	
	private static final int STATUS_ACTIVE = 1;
	

	public void save(AreaDto areaDto, String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		Long companyId = userContext.getCompanyId();
		String userCode = userContext.getUser().getUserCode();
		Long parentId = areaDto.getParentId();
		if(UtilHelper.isEmpty(parentId)){
			throw new ServiceException(ExceptionDef.ERROR_PARENT_AREA_IS_NULL.getName());
		}
		//Integer areaType = areaDto.getAreaType();

		Area area = new Area();
		BeanUtils.copyProperties(areaDto, area);
		if(UtilHelper.isEmpty(areaDto.getParentId())){
			area.setParentId(0l);
		}
		area.setCompanyId(companyId);
		area.setCreatedBy(userCode);
		area.setCreatedTime(systemDateMapper.getCurrentDate());
		area.setUpdatedBy(userCode);
		area.setUpdatedTime(systemDateMapper.getCurrentDate());
		areaMapper.save(area);
	}


	public int update(AreaDto areaDto, String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		String userCode = userContext.getUser().getUserCode();
		//Integer areaType = areaDto.getAreaType();
		Long areaId = areaDto.getAreaId();
		
		Area area = areaMapper.getByPK(areaId);
		area.setParentId(areaDto.getParentId());
		area.setAreaName(areaDto.getAreaName());
		area.setIsInactive(areaDto.getIsInactive());
		area.setRemark(areaDto.getRemark());
		area.setUpdatedBy(userCode);
		area.setUpdatedTime(systemDateMapper.getCurrentDate());
		areaMapper.update(area);
		return 1;
	}

	public void deleteByPKeys(List<Long> primaryKeys,String token)throws ServiceException {
		areaMapper.deleteByPKeys(primaryKeys);
		for(Long primaryKey:primaryKeys){
			AreaRegion areaRegion = new AreaRegion();
			areaRegion.setAreaId(primaryKey);
			areaRegionMapper.deleteByProperty(areaRegion);
		}
	}


	/**
	 * 查询销售大区树
	 * @return
	 * @throws ServiceException 
	 */
	public List<AreaDto> findAreaTreeList(String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		Long companyId = userContext.isAdmin()?null:userContext.getCompanyId();
		List<AreaDto> areaList = areaMapper.findAreaList(companyId,0l);
		return getChildrenArea(areaList);
	}

	public List<AreaDto> getChildrenArea(List<AreaDto> areaList) throws ServiceException {
		for(AreaDto areaDto:areaList){
			Long pid = areaDto.getAreaId();
			List<AreaDto> list = areaMapper.findAreaList(null,pid);
			if(!UtilHelper.isEmpty(list)){
				List<AreaDto> children = getChildrenArea(list);
				areaDto.setChildren(children);
			}
		}
		return areaList;
	}

	public List<AreaDto> queryAreaPath(Long areaId, Map<Long, AreaDto> areaMap) {
		List<AreaDto> areaList = new ArrayList<AreaDto>();
		AreaDto areaDto = areaMap.get(areaId);
		if (areaDto != null) {
			areaList.add(0, areaDto);
			AreaDto parentAreaDto = areaDto.getParent();
			while (parentAreaDto != null) {
				areaList.add(0, parentAreaDto);
				parentAreaDto = parentAreaDto.getParent();
			}
		}
		return areaList;
	}

	/*
	 * 查询销售区域
	 * @param areaId
	 * @param token
	 * 返回 Map(areaId->areaDto)
	 */
	public Map<Long, AreaDto> queryAreaMap(Long companyId, Long parentId) throws ServiceException{
		Map<Long, AreaDto> areaMap = new HashMap<Long, AreaDto>();
		List<AreaDto> areaList = areaMapper.findAreaList(companyId, parentId);
		if (areaList != null) {
			for (AreaDto areaDto : areaList) {
				areaMap.put(areaDto.getAreaId(), areaDto);
			}
			queryChildrenAreaMap(areaList,areaMap);
		}
		return areaMap;
	}
	
	private void queryChildrenAreaMap(List<AreaDto> areaList, Map<Long, AreaDto> areaMap)
			throws ServiceException {
		for (AreaDto areaDto : areaList) {
			Long pid = areaDto.getAreaId();
			List<AreaDto> list = areaMapper.findAreaList(null, pid);
			if (!UtilHelper.isEmpty(list)) {
				areaDto.setChildren(list);
				for (AreaDto childArea : list) {
					childArea.setParent(areaDto);
					areaMap.put(childArea.getAreaId(), childArea);
				}
				queryChildrenAreaMap(list, areaMap);
			}
		}
	}
	
	/**
	 * 查询销售区域下所有店铺
	 * @param areaId
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public List<AreaShopDto> findAreaShopList(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		Long companyId = userContext.isAdmin()?null:userContext.getCompanyId();
		
		List<AreaShopDto> areaShopList = areaMapper.findArea(companyId, 0l);
	
		return getChildrenAreaShop(areaShopList);
	}


	private List<AreaShopDto> getChildrenAreaShop(List<AreaShopDto> areaShopList) throws ServiceException {
		for(AreaShopDto areaShopDto:areaShopList){
			Long pid = areaShopDto.getAreaId();
			Area area = new Area();
			area.setParentId(pid);
			int count = areaMapper.findByCount(area);
			if(count==0){
				List<AreaShopChildrenDto> areaShopChildrenDtoList = shopMapper.findAreaShop(pid);
				if(!UtilHelper.isEmpty(areaShopChildrenDtoList)){
					areaShopDto.setShopChildren(areaShopChildrenDtoList);
				}
			}
			List<AreaShopDto> list = areaMapper.findArea(null,pid);
			if(!UtilHelper.isEmpty(list)){
				List<AreaShopDto> children = getChildrenAreaShop(list);
				areaShopDto.setChildren(children);
			}
		}
		return areaShopList;
	}


	/**
	 * 销售大区绑定门店
	 * @param shopAreaDto
	 * @param token
	 * @throws ServiceException 
	 */
	public void saveShopArea(ShopAreaDto shopAreaDto, String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		Long companyId = userContext.getCompanyId();
		Long areaId = shopAreaDto.getAreaId();
		String userCode = userContext.getUser().getUserCode();
		List<Long> shopIdList = shopAreaDto.getShopIdList();
		
		AreaShop tempAreaShop = new AreaShop();
		tempAreaShop.setAreaId(areaId);
		areaShopMapper.deleteByProperty(tempAreaShop);
		
		for(Long shopId:shopIdList){
			AreaShop areaShop = new AreaShop();
			areaShop.setCompanyId(companyId);
			areaShop.setAreaId(areaId);
			areaShop.setShopId(shopId);
			areaShop.setIsInactive(STATUS_ACTIVE);
			areaShop.setCreatedBy(userCode);
			areaShop.setCreatedTime(systemDateMapper.getCurrentDate());
			areaShop.setUpdatedBy(userCode);
			areaShop.setUpdatedTime(systemDateMapper.getCurrentDate());
			areaShopMapper.save(areaShop);
		}
	}	
}
