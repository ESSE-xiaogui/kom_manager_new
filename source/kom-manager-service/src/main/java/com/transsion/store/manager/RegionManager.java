package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Region;
import com.transsion.store.bo.Shop;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.RegionDto;
import com.transsion.store.dto.RegionResponseDto;
import com.transsion.store.dto.RegionShopDto;
import com.transsion.store.dto.ShopDto;
import com.transsion.store.mapper.RegionMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.RegionService;
import com.transsion.store.service.ShopService;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("regionManager")
public class RegionManager {
	@Autowired
	private RegionService regionService ;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private RegionMapper regionMapper;
	
	/**
	 * 查询树形销售区域
	 * @return
	 * @throws serviceException
	 * */
	public List<RegionDto> findRegionsList(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext usercontext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(usercontext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(usercontext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		
		Integer companyId = usercontext.getUser().getCompanyId();
		List<RegionDto> regionList = regionService.findRegionsList(companyId);
		if(UtilHelper.isEmpty(regionList)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		return getChildrenRegion(regionList,Long.valueOf(0));
	}
	
	/**
	 * 获取树形子菜单
	 * */
	public List<RegionDto> getChildrenRegion(List<RegionDto> regionList,Long parentId) throws ServiceException{
		List<RegionDto> regionTreeDto = new ArrayList<>();
		for(RegionDto region:regionList){
			Long regionId = region.getId();  
			Long pid = region.getParentId();
	           if (parentId == pid) {  
	        	   List<RegionDto> children = getChildrenRegion(regionList, regionId); 
	        	   region.setChildren(children);
	        	   regionTreeDto.add(region);
	           }  
		}
		return regionTreeDto;
	}

	/**
	 * 查询销售区域名称
	 * @return
	 * @throws ServiceException
	 */
	public Region findRegionName(java.lang.Long id) throws ServiceException{
		if(UtilHelper.isEmpty(id)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		String regionName = regionService.getRegionName(id);
		if(UtilHelper.isEmpty(regionName)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Region region = new Region();
		region.setRegionName(regionName);
		return region;
	}

	/**
	 * 新增销售区域
	 * @return
	 * @throws ServiceException
	 * */
	public RegionResponseDto saveRegion(String token, RegionDto regionDto) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(regionDto)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}

		Region region = new Region();
		BeanUtils.copyProperties(regionDto, region);
		region.setCreatedBy(userContext.getUser().getUserCode());
		region.setCreatedTime(systemDateService.getCurrentDate());
		region.setUpdatedBy(userContext.getUser().getUserCode());
		region.setUpdatedTime(systemDateService.getCurrentDate());
		region.setCompanyId(userContext.getUser().getCompanyId());
		region.setVersion(0);
		regionService.save(region);
		RegionResponseDto rrd = new RegionResponseDto();
		rrd.setStatus(1);
		return rrd;
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException {
		for(int i=0;i<primaryKeys.size();i++){
			Long primaryKey = primaryKeys.get(i); 
			Region region = new Region();
			region.setParentId(primaryKey);
			int countChildren = regionService.findByCount(region); 
			Shop shop = new Shop();
			shop.setRegionId(primaryKey);
			int countShop = shopService.findByCount(shop);
			if(countChildren>0 || countShop>0){
				throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_REGION_DELETE_FAIL);
			}
		}
		regionService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 查询销售区域已绑定店铺
	 * @return
	 * @throws ServiceException
	 * */
	public List<RegionShopDto> findRegionShop(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser().getCompanyId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		List<RegionShopDto> rsdList = new ArrayList<RegionShopDto>();
		Integer companyId = userContext.getUser().getCompanyId();
		List<RegionShopDto> rsDto = regionMapper.findRegionShop(companyId);
		for(RegionShopDto rs:rsDto){
			List<ShopDto> regDtoList = new ArrayList<ShopDto>();
			Shop shop = new Shop();
			shop.setCity(rs.getId().intValue());
			List<Shop> shopList = shopService.listByProperty(shop);
			if(shopList.size()>0){
				for(Shop s:shopList){
					ShopDto sd = new ShopDto();
					sd.setId(s.getId());
					sd.setCity(s.getCity());
					sd.setShopName(s.getShopName());
					regDtoList.add(sd);
				}
				rs.setChildren(regDtoList);
			}
			rsdList.add(rs);
		}
		return rsdList;
	}
	
}
