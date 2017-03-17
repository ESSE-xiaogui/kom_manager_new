package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Employee;
import com.transsion.store.bo.Region;
import com.transsion.store.bo.Shop;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.RegionDto;
import com.transsion.store.dto.RegionResponseDto;
import com.transsion.store.dto.RegionShopDto;
import com.transsion.store.dto.ShopBindRegionDto;
import com.transsion.store.dto.ShopChildrenDto;
import com.transsion.store.dto.ShopDto;
import com.transsion.store.dto.ShopRegionChildrenDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.EmployeeMapper;
import com.transsion.store.mapper.RegionMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.service.RegionService;
import com.transsion.store.service.ShopService;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("regionManager")
public class RegionManager {
	@Autowired
	private RegionService regionService;

	@Autowired
	private SystemDateService systemDateService;

	@Autowired
	private ShopService shopService;

	@Autowired
	private RegionMapper regionMapper;

	@Autowired
	private ShopMapper shopMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;

	/**
	 * 查询树形销售区域
	 * 
	 * @return
	 * @throws serviceException
	 */
	public List<RegionDto> findRegionsList(String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext usercontext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(usercontext)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(usercontext.getUser())) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		List<RegionDto> regionList = regionService.findRegionsList(0);
		return getChildrenRegion(regionList);
	}

	/**
	 * 获取树形子菜单
	 */
	public List<RegionDto> getChildrenRegion(List<RegionDto> regionList) throws ServiceException {
		for (RegionDto region : regionList) {
			Integer pid = region.getId().intValue();
			List<RegionDto> list = regionService.findRegionsList(pid);
			if(!UtilHelper.isEmpty(list)){
				region.setChildren(list);
				getChildrenRegion(list);
			}
		}
		return regionList;
	}

	/**
	 * 查询销售区域名称
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public Region findRegionName(java.lang.Long id) throws ServiceException {
		if (UtilHelper.isEmpty(id)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		String regionName = regionService.getRegionName(id);
		if (UtilHelper.isEmpty(regionName)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Region region = new Region();
		region.setRegionName(regionName);
		return region;
	}

	/**
	 * 新增销售区域
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public RegionResponseDto saveRegion(String token, Region region) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(region)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Region tempReg = new Region();
		tempReg.setRegionName(region.getRegionName());
		tempReg.setParentId(region.getParentId());
		int count = regionMapper.findByCount(tempReg);
		if (count > 0) {
			throw new ServiceException(ExceptionDef.ERROR_REGION_ALREADY_EXIST.getName());
		}
		if (UtilHelper.isEmpty(region.getParentId())) {
			region.setParentId(0l);
		}
		region.setCreatedBy(userContext.getUserCode());
		region.setCreatedTime(systemDateService.getCurrentDate());
		region.setCompanyId(userContext.getUser().getCompanyId());
		regionService.save(region);
		RegionResponseDto rrd = new RegionResponseDto();
		rrd.setStatus(1);
		return rrd;
	}

	/**
	 * 修改销售区域
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public RegionResponseDto update(String token, Region region) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(region)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Region tempReg = new Region();
		tempReg.setRegionName(region.getRegionName());
		tempReg.setParentId(region.getParentId());
		int count1 = regionMapper.findByCount(tempReg);
		tempReg.setId(region.getId());
		int count2 = regionMapper.findByCount(tempReg);
		if (count1 > 0 && count2 < 1) {
			throw new ServiceException(ExceptionDef.ERROR_REGION_ALREADY_EXIST.getName());
		}
		Region formerReg = regionMapper.getByPK(region.getId());
		formerReg.setRegionName(region.getRegionName());
		formerReg.setRegionType(region.getRegionType());
		formerReg.setIsInactive(region.getIsInactive());
		formerReg.setRemark(region.getRemark());
		formerReg.setCompanyId(userContext.getCompanyId().intValue());
		formerReg.setUpdatedBy(userContext.getUser().getUserCode());
		formerReg.setUpdatedTime(systemDateService.getCurrentDate());
		regionService.update(formerReg);
		RegionResponseDto rrd = new RegionResponseDto();
		rrd.setStatus(1);
		return rrd;
	}

	/**
	 * 根据主键删除记录
	 * 
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException {
		for (int i = 0; i < primaryKeys.size(); i++) {
			Long primaryKey = primaryKeys.get(i);
			Region region = new Region();
			region.setParentId(primaryKey);
			int countChildren = regionService.findByCount(region);
			Shop shop = new Shop();
			shop.setRegionId(primaryKey);
			int countShop = shopService.findByCount(shop);
			if (countChildren > 0) {
				throw new ServiceException(ExceptionDef.ERROR_REGION_CHILDREN_EXIST.getName());
			} else if (countShop > 0) {
				throw new ServiceException(ExceptionDef.ERROR_REGION_SHOP_BIND.getName());
			} else {
				regionService.deleteByPK(primaryKey);
			}
		}
	}

	/**
	 * 查询销售区域已绑定店铺
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<RegionShopDto> findRegionShop(String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(userContext.getUser())) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(userContext.getUser().getCompanyId())) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		List<RegionShopDto> rsdList = new ArrayList<RegionShopDto>();
		Integer companyId = userContext.getUser().getCompanyId();
		List<RegionShopDto> rsDto = regionMapper.findRegionShop(companyId);
		for (RegionShopDto rs : rsDto) {
			List<ShopDto> regDtoList = new ArrayList<ShopDto>();
			Shop shop = new Shop();
			shop.setCity(rs.getId().intValue());
			List<Shop> shopList = shopService.listByProperty(shop);
			if (shopList.size() > 0) {
				for (Shop s : shopList) {
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

	/**
	 * 门店授权管理:门店绑定区域查询
	 */
	public List<ShopBindRegionDto> findShopBindRegion(String token, String userName) throws ServiceException {
		if (UtilHelper.isEmpty(token) && UtilHelper.isEmpty(userName)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		//List<ShopBindRegionDto> list = new ArrayList<ShopBindRegionDto>();
		List<ShopBindRegionDto> childrenList = regionMapper.findRegion(userName, userContext.getCompanyId());
		if (!UtilHelper.isEmpty(childrenList)) {
			for (ShopBindRegionDto shopBindRegion : childrenList) {
				List<ShopRegionChildrenDto> childrenRegion = childrenRegion(shopBindRegion.getId(), userName, userContext.getCompanyId());
				shopBindRegion.setRegionChildren(childrenRegion);
				//list.add(shopBindRegion);
			}
		}
		return childrenList;
	}

	public List<ShopRegionChildrenDto> childrenRegion(Long parentId, String userName, Long companyId)
					throws DataAccessFailureException {
		//List<ShopRegionChildrenDto> list = new ArrayList<ShopRegionChildrenDto>();
		List<ShopRegionChildrenDto> srcList = regionMapper.findRegionChildren(parentId, userName, companyId);
		if (!UtilHelper.isEmpty(srcList)) {
			for (ShopRegionChildrenDto src : srcList) {
				List<ShopChildrenDto> scDtoList = shopMapper.findShopByRegionId(src.getId(), userName, companyId);
				src.setChildrenShop(scDtoList);
				//list.add(src);
			}
		}
		return srcList;
		//return srcList;
	}
	
	/**
	 * 查询国家销售区域
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public List<Region> findCountryList(String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Long userId = userContext.getUser().getId();
		Integer regionId = null;
		Employee emp = new Employee();
		emp.setuId(userId);
		List<Employee> empList = employeeMapper.listByProperty(emp);
	    if(!UtilHelper.isEmpty(empList)){
	    	regionId = empList.get(0).getRegionId();
	    	if(!UtilHelper.isEmpty(regionId)){
	    		return regionService.findCountryList(userId);
		    }
	    }
	    return regionService.findAllCountryList();	
	}
	
	/**
	 * 查询城市销售区域
	 * @param token 
	 * @param parentRegionId
	 * @return
	 * @throws ServiceException
	 */
	public List<RegionDto> findCityListByParentRegionId(int parentId, String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Long userId = userContext.getUser().getId();
		List<RegionDto> cityList = null; 
		List<Region> list = regionService.findCityListByParentRegionId(parentId,userId);
		if (list != null && list.size() > 0) {
			cityList = new ArrayList<RegionDto>();
			for (Region region : list) {
				RegionDto findRegionsDto = new RegionDto();
				findRegionsDto.setId(region.getId());
				findRegionsDto.setRegionName(region.getRegionName());
				cityList.add(findRegionsDto);
			}
		}
		return cityList;
	}
}
