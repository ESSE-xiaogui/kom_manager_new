package com.transsion.store.manager;

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
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.ShopDefinitionDto;
import com.transsion.store.dto.ShopDetailDto;
import com.transsion.store.dto.ShopUserDto;
import com.transsion.store.dto.UserDto;
import com.transsion.store.mapper.MaterielMapper;
import com.transsion.store.mapper.RegionMapper;
import com.transsion.store.mapper.ShopBizMapper;
import com.transsion.store.mapper.ShopGradeMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.mapper.UserMapper;
import com.transsion.store.resource.MessageStoreResource;
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
 
	/**
	 * 用户已绑定的店铺
	 * */
	public List<ShopUserDto> findShopUser(String token) throws ServiceException{
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
		if(UtilHelper.isEmpty(userContext.getUser().getUserId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERID_IS_NULL);
		}
		return shopMapper.findShopUser(userContext.getUser().getUserId());
	}
	/**
	 * 查询店铺
	 * */
	public List<ShopUserDto> findShop(String token) throws ServiceException{
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
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERID_IS_NULL);
		}
		return shopMapper.findShop(userContext.getUser().getCompanyId());
	}
	/**
	 * 门店授权管理:获取此用户已绑定的所有店铺ID
	 * */
	public List<Long> findShopIds(String userName) throws ServiceException{
		if(UtilHelper.isEmpty(userName)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserDto userDto = new UserDto();
		userDto =  userMapper.findByName(userName);
		if(UtilHelper.isEmpty(userDto)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		return shopMapper.findShopIds(userDto.getId());
	}
	
	/**
	 * 查询促销员的店铺
	 */
	public List<Shop> queryPromoterShop(String token) throws ServiceException {
		validateToken(token);
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_QUERY_ISNULL);
		}
		if (UtilHelper.isEmpty(userContext.getUser())) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_QUERY_USER_ISNULL);
		}
		// 获取token里的用户信息
		Integer userId = userContext.getUser().getId().intValue();
		Integer companyId = userContext.getUser().getCompanyId();
		if (UtilHelper.isEmpty(userId) || UtilHelper.isEmpty(companyId)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_SALESPARAM_IS_NULL);
		}
		return shopMapper.findByPromoter(userId, companyId);
	}
	
	public void validateToken(String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_INVALID);
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
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_QUERY_ISNULL);
		}
		if (UtilHelper.isEmpty(userContext.getUser())) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_QUERY_USER_ISNULL);
		}
		// 获取token里的用户信息
		Integer userId = userContext.getUser().getId().intValue();
		Integer companyId = userContext.getUser().getCompanyId();
		if (UtilHelper.isEmpty(userId) || UtilHelper.isEmpty(companyId)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
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
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERID_IS_NULL);
		}
		String brandCode = userContext.getBrandCode();
		Integer companyId = userContext.getCompanyId().intValue();
		ShopDefinitionDto sdd = new ShopDefinitionDto();
		List<Region> countryList = regionMapper.queryRegionByTypeCode(1);
		sdd.setCountryList(countryList);
		List<Region> cityList = regionMapper.queryRegionByTypeCode(2);
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
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERID_IS_NULL);
		}
		
		Shop shop = shopDetailDto.getShop();
		shopService.save(shop);
		
		ShopExtension shopExtension = shopDetailDto.getShopExtension();
		shopExtensionService.save(shopExtension);
		
		List<ShopMateriel> list = shopDetailDto.getShopMaterielDtoList();
		shopMaterielService.saveShopMateriel(list);
	}
}
