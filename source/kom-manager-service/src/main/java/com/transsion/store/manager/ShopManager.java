package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Attribute;
import com.transsion.store.bo.Materiel;
import com.transsion.store.bo.Region;
import com.transsion.store.bo.Shop;
import com.transsion.store.bo.ShopBiz;
import com.transsion.store.bo.ShopExtension;
import com.transsion.store.bo.ShopGrade;
import com.transsion.store.bo.ShopMateriel;
import com.transsion.store.bo.UserShop;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.ShopDefinitionDto;
import com.transsion.store.dto.ShopDetailDto;
import com.transsion.store.dto.ShopInfoDto;
import com.transsion.store.dto.ShopUserDto;
import com.transsion.store.dto.UserDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.MaterielMapper;
import com.transsion.store.mapper.RegionMapper;
import com.transsion.store.mapper.ShopBizMapper;
import com.transsion.store.mapper.ShopGradeMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.mapper.UserMapper;
import com.transsion.store.mapper.UserShopMapper;
import com.transsion.store.service.AttributeService;
import com.transsion.store.service.ShopExtensionService;
import com.transsion.store.service.ShopMaterielService;
import com.transsion.store.service.ShopService;
import com.transsion.store.utils.CacheUtils;

@Service("shopManager")
public class ShopManager {
	@Autowired
	private ShopMapper shopMapper;
	
	@Autowired
	private RegionMapper regionMapper;
	
	@Autowired
	private ShopBizMapper shopBizMapper;
	
	@Autowired
	private MaterielMapper materielMapper;
	
	@Autowired
	private ShopGradeMapper shopGradeMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AttributeService attributeService;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private ShopExtensionService shopExtensionService;
	
	@Autowired
	private ShopMaterielService shopMaterielService;
	
	@Autowired
	private UserShopMapper userShopMapper;
 
	/**
	 * 用户已绑定的店铺
	 * */
	public List<ShopUserDto> findShopUser(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser().getUserId())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		return shopMapper.findShopUser(userContext.getUser().getUserId());
	}
	/**
	 * 查询店铺
	 * */
	public List<ShopUserDto> findShop(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser().getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		return shopMapper.findShop(userContext.getUser().getCompanyId());
	}
	/**
	 * 门店授权管理:获取此用户已绑定的所有店铺ID
	 * */
	public List<Long> findShopIds(String userName) throws ServiceException{
		if(UtilHelper.isEmpty(userName)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserDto userDto = new UserDto();
		userDto =  userMapper.findByName(userName);
		if(UtilHelper.isEmpty(userDto)){
			throw new ServiceException(ExceptionDef.ERROR_USER_NONEXIST.getName());
		}

		return shopMapper.findShopIds(userDto.getId(), userDto.getCompanyId());
	}
	
	/**
	 * 查询促销员的店铺
	 */
	public List<Shop> queryPromoterShop(String token) throws ServiceException {
		validateToken(token);
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(userContext.getUser())) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		// 获取token里的用户信息
		Integer userId = userContext.getUser().getId().intValue();
		Integer companyId = userContext.getUser().getCompanyId();
		if (UtilHelper.isEmpty(userId) || UtilHelper.isEmpty(companyId)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		return shopMapper.findByPromoter(userId, companyId);
	}
	
	public void validateToken(String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
	}
	
	/**
	 * 根据职位查询店铺(app)
	 * @return
	 * @throws ServiceException
	 */
	public List<Shop> findShopListByUser(String token) throws ServiceException {
		validateToken(token);
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(userContext.getUser())) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		// 获取token里的用户信息
		Integer userId = userContext.getUser().getId().intValue();
		Integer companyId = userContext.getUser().getCompanyId();
		if (UtilHelper.isEmpty(userId) || UtilHelper.isEmpty(companyId)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		return shopMapper.findShopListByUser(userId,companyId);
	}
	
	/**
	 * 查询门店定义
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public ShopDefinitionDto queryShopDefitionDto(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser().getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		String brandCode = userContext.getBrandCode();
		Integer companyId = userContext.getCompanyId().intValue();
		ShopDefinitionDto sdd = new ShopDefinitionDto();
		List<Region> countryList = regionMapper.queryRegionByRegionType(2);
		sdd.setCountryList(countryList);
		List<Region> cityList = regionMapper.queryRegionByRegionType(4);
		sdd.setCityList(cityList);
		
		Materiel materiel = new Materiel();
		materiel.setBrandCode(brandCode);
		materiel.setIsInactive(1);
		List<Materiel> materielList = materielMapper.listByProperty(materiel);
		sdd.setMaterielList(materielList);
		
		ShopBiz shopBiz = new ShopBiz();
		shopBiz.setBrandCode(brandCode);
		shopBiz.setIsInactive(1);
	    List<ShopBiz> shopBizList = shopBizMapper.listByProperty(shopBiz);
	    sdd.setShopBizList(shopBizList);
	    
		ShopGrade sg = new ShopGrade();
		sg.setBrandCode(brandCode);
		sg.setIsInactive(1);
		List<ShopGrade> shopGradeList = shopGradeMapper.listByProperty(sg);
		sdd.setShopGradeList(shopGradeList);
		
		Integer type = Integer.valueOf(1);
		List<Attribute> relationshipList = attributeService.getAttributeListByType(type,companyId);
		sdd.setRelationshipList(relationshipList);
		
		type = Integer.valueOf(2);
		List<Attribute> bizCategoryList = attributeService.getAttributeListByType(type,companyId);
		sdd.setBizCategoryList(bizCategoryList);
		
		type = Integer.valueOf(4);
		List<Attribute> bizTypeList = attributeService.getAttributeListByType(type,companyId);
		sdd.setBizTypeList(bizTypeList);
		return sdd;
	}
	
	public void createShop(String token, ShopDetailDto shopDetailDto) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser().getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		Shop shop = shopDetailDto.getShop();
		shopService.save(shop);
		
		ShopExtension shopExtension = shopDetailDto.getShopExtension();
		shopExtensionService.save(shopExtension);
		
		List<ShopMateriel> list = shopDetailDto.getShopMaterielDtoList();
		shopMaterielService.saveShopMateriel(list);
	}
	
	public List<ShopDetailDto> queryManagedShopList(String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser().getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Integer userId = userContext.getUser().getId().intValue();
		List<UserShop> shopIdList = userShopMapper.queryShopIdByUserId(userId);
		
		List<ShopDetailDto> list = new ArrayList<ShopDetailDto>();
		for (int i = 0; i < shopIdList.size(); i++) {
			ShopDetailDto shopDetailDto = new ShopDetailDto();
			
			Shop shop = shopMapper.queryShopByShopId(shopIdList.get(i).getShopId());
			ShopExtension shopExtension = shopExtensionService.queryShopExtensionByShopId(shopIdList.get(i).getShopId());
			List<ShopMateriel> shopMaterielList = shopMaterielService.queryShopMaterielListByShopId(shopIdList.get(i).getShopId());
			
			shopDetailDto.setShop(shop);
			shopDetailDto.setShopExtension(shopExtension);
			shopDetailDto.setShopMaterielDtoList(shopMaterielList);
			list.add(shopDetailDto);
		}
		if(list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
		
	}
	
	public void updateShop(String token, ShopDetailDto shopDetailDto) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser().getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		Shop shop = shopDetailDto.getShop();
		shopMapper.update(shop);
		
		ShopExtension shopExtension = shopDetailDto.getShopExtension();
		shopExtensionService.update(shopExtension);
		
		List<ShopMateriel> list = shopDetailDto.getShopMaterielDtoList();
		for (int i = 0; i < list.size(); i++) {
			shopMaterielService.update(list.get(i));
		}
	}
	
	/**
	 * 门店审核
	 * @param shop
	 * @param token
	 * @throws ServiceException 
	 */
	public void updateShopStatus(Shop shop, String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser().getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Shop formerShop = shopService.getByPK(shop.getId());
		formerShop.setStatus(shop.getStatus());
		
		shopMapper.update(formerShop);
		
	}
	

	public int updateShopInfo(ShopInfoDto shopInfoDto, String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser().getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		Shop tempShop = new Shop();
		tempShop.setShopName(shopInfoDto.getShopName());
		int count1 = shopService.findByCount(tempShop);
		tempShop.setId(shopInfoDto.getId());
		int count2 = shopService.findByCount(tempShop);
		if(count1>0&&count2<1){
			throw new ServiceException(ExceptionDef.ERROR_SHOP_ALREADY_EXIST.getName());
		}
		Long regionId = shopInfoDto.getRegionId();
		
		Shop shop = shopService.getByPK(shopInfoDto.getId());
		shop.setShopName(shopInfoDto.getShopName());
		shop.setRegionId(regionId);
		Region region = regionMapper.getByPK(regionId);
		if(region.getRegionType()==2){
			shop.setCountry(regionId.intValue());
		}else if(region.getRegionType()==4){
			shop.setCity(regionId.intValue());
			shop.setCountry(region.getParentId().intValue());
		}
		shop.setAddress(shopInfoDto.getAddress());
		shop.setGradeId(shopInfoDto.getGradeId());
		shop.setBizId(shopInfoDto.getBizId());
		shop.setOwnerName(shopInfoDto.getOwnerName());
		shop.setOwnerPhone(shopInfoDto.getOwnerPhone());
		shop.setPurchasChannel(shopInfoDto.getPurchasChannel());
		shop.setRemark(shopInfoDto.getRemark());
		shop.setStatus(1);
		shopMapper.update(shop);
		
		ShopExtension shopExt = shopExtensionService.getByPK(shopInfoDto.getId());
		shopExt.setShopArea(shopInfoDto.getShopArea());
		shopExt.setClerkTotalQty(shopInfoDto.getClerkTotalQty());
		shopExt.setClerkBrandQty(shopInfoDto.getClerkBrandQty());
		shopExt.setRelationship(shopInfoDto.getRelationship());
		shopExt.setBizCategory(shopInfoDto.getBizCategory());
		shopExt.setBrandOne(shopInfoDto.getBrandOne());
		shopExt.setBrandTwo(shopInfoDto.getBrandTwo());
		shopExt.setBrandThree(shopInfoDto.getBrandThree());
		shopExt.setBrandFour(shopInfoDto.getBrandFour());
		shopExt.setBrandFive(shopInfoDto.getBrandFive());
		shopExt.setClerkOneQty(shopInfoDto.getClerkOneQty());
		shopExt.setClerkTwoQty(shopInfoDto.getClerkTwoQty());
		shopExt.setClerkThreeQty(shopInfoDto.getClerkThreeQty());
		shopExt.setClerkFourQty(shopInfoDto.getClerkFourQty());
		shopExt.setClerkFiveQty(shopInfoDto.getClerkFiveQty());
		shopExt.setClerkSixQty(shopInfoDto.getClerkSixQty());
		shopExtensionService.update(shopExt);
		return 1;
	}
}
