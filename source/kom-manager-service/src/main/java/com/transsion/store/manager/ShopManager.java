package com.transsion.store.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Attribute;
import com.transsion.store.bo.Attribute.Type;
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
import com.transsion.store.dto.ShopExtensionDto;
import com.transsion.store.dto.ShopInfoDto;
import com.transsion.store.dto.ShopLoginDto;
import com.transsion.store.dto.ShopParamDto;
import com.transsion.store.dto.ShopQueryDto;
import com.transsion.store.dto.ShopResponseDto;
import com.transsion.store.dto.ShopResponseInfoDto;
import com.transsion.store.dto.ShopUploadDto;
import com.transsion.store.dto.ShopUserDto;
import com.transsion.store.dto.UserDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.MaterielMapper;
import com.transsion.store.mapper.RegionMapper;
import com.transsion.store.mapper.ShopBizMapper;
import com.transsion.store.mapper.ShopExtensionMapper;
import com.transsion.store.mapper.ShopGradeMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.mapper.ShopMaterielMapper;
import com.transsion.store.mapper.UserMapper;
import com.transsion.store.mapper.UserShopMapper;
import com.transsion.store.mapper.VisitMapper;
import com.transsion.store.service.AttributeService;
import com.transsion.store.service.ShopExtensionService;
import com.transsion.store.service.ShopMaterielService;
import com.transsion.store.service.ShopService;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.ExcelUtils;

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
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private ShopExtensionMapper shopExtensionMapper;
	
	@Autowired
	private ShopMaterielMapper shopMaterielMapper;
	@Autowired
	private VisitMapper visitMapper;
 
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
	public List<ShopLoginDto> findShopListByUser(String token) throws ServiceException {
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
		
		Integer companyId = userContext.isAdmin()?null:userContext.getUser().getCompanyId().intValue();
		ShopDefinitionDto sdd = new ShopDefinitionDto();
		List<Region> countryList = regionMapper.queryRegionByRegionType(2);
		sdd.setCountryList(countryList);
		List<Region> cityList = regionMapper.queryRegionByRegionType(4);
		sdd.setCityList(cityList);
		
		Materiel materiel = new Materiel();
		materiel.setCompanyId(companyId);
		materiel.setIsInactive(1);
		List<Materiel> materielList = materielMapper.listByProperty(materiel);
		sdd.setMaterielList(materielList);
		
		ShopBiz shopBiz = new ShopBiz();
		if(!UtilHelper.isEmpty(companyId)){
			shopBiz.setCompanyId(Long.valueOf(companyId));
		}
		shopBiz.setIsInactive(1);
	    List<ShopBiz> shopBizList = shopBizMapper.listByProperty(shopBiz);
	    sdd.setShopBizList(shopBizList);
	    
		ShopGrade sg = new ShopGrade();
		sg.setCompanyId(companyId);
		sg.setIsInactive(1);
		List<ShopGrade> shopGradeList = shopGradeMapper.listByProperty(sg);
		sdd.setShopGradeList(shopGradeList);
		
		List<Attribute> relationshipList = attributeService.getAttributeListByType(Type.SHOP_RELATIONSHIP,companyId);
		sdd.setRelationshipList(relationshipList);
		
		List<Attribute> bizCategoryList = attributeService.getAttributeListByType(Type.SHOP_CATEGORY,companyId);
		sdd.setBizCategoryList(bizCategoryList);
		
		List<Attribute> bizTypeList = attributeService.getAttributeListByType(Type.BIZ_TYPE,companyId);
		sdd.setBizTypeList(bizTypeList);
		return sdd;
	}
	
	public ShopUploadDto createShop(String token, ShopDetailDto shopDetailDto) throws ServiceException {
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
		
		String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Shop shop = shopDetailDto.getShop();
		shop.setCompanyId(userContext.getCompanyId().intValue());
		shop.setParentId(shop.getCountry() == null ? null : new Long(shop.getCountry()));
		shop.setRegionId(shop.getCity() == null ? null : new Long(shop.getCity()));
		shop.setCreateBy(userContext.getUser().getId().toString());
		shop.setCreateDate(currentDate);
		shopService.save(shop);
		
		Long shopId = shop.getId();
		shopMapper.updateShopCodeById(shopId);
		
		ShopExtensionDto shopExtensionDto = shopDetailDto.getShopExtensionDto();
		if (shopExtensionDto != null) {
			ShopExtension shopExtension = shopDetailDto.getShopExtensionDto().toModel();
			shopExtension.setShopId(shopId);
			shopExtension.setShopArea(new Long(shop.getShopArea()));
			shopExtensionService.save(shopExtension);
		}
		
		List<ShopMateriel> list = shopDetailDto.getShopMaterielDtoList();
		String userCode = userContext.getUserCode();
		for (ShopMateriel shopMateriel : list) {
			shopMateriel.setShopId(shopId);
			shopMateriel.setCreateBy(userCode);
			shopMateriel.setCreateDate(currentDate);
		}
		shopMaterielService.saveShopMateriel(list);
		
		ShopUploadDto shopUploadDto = new ShopUploadDto();
		shopUploadDto.setStatus(1);
		return shopUploadDto;
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
		
		Long companyId = userContext.getCompanyId();
		List<ShopDetailDto> list = null;
		list = new ArrayList<ShopDetailDto>();
		for (int i = 0; i < shopIdList.size(); i++) {
			ShopDetailDto shopDetailDto = new ShopDetailDto();
			
			Shop shop = shopMapper.queryShopByShopId(shopIdList.get(i).getShopId(), companyId);
			ShopExtension shopExtension = shopExtensionService.queryShopExtensionByShopId(shopIdList.get(i).getShopId());
			List<ShopMateriel> shopMaterielList = shopMaterielService.queryShopMaterielListByShopId(shopIdList.get(i).getShopId());
			shopDetailDto.setShop(shop);
			if (shopExtension != null) {
				shopDetailDto.setShopExtensionDto(shopExtension.toModel());
			}
			shopDetailDto.setShopMaterielDtoList(shopMaterielList);
			list.add(shopDetailDto);
		}
		return list;
	}
	
	public Integer updateShop(String token, ShopDetailDto shopDetailDto) throws ServiceException {
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
		
		Integer resultStatus = 0;
		String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Shop shop = shopDetailDto.getShop();
		shop.setCompanyId(userContext.getCompanyId().intValue());
		shop.setParentId(shop.getCountry() == null ? null : new Long(shop.getCountry()));
		shop.setRegionId(shop.getCity() == null ? null : new Long(shop.getCity()));
		shop.setUpdateBy(userContext.getUser().getId().toString());
		shop.setUpdateDate(currentDate);
		shopMapper.update(shop);
		
		ShopExtensionDto shopExtensionDto = shopDetailDto.getShopExtensionDto();
		if (shopExtensionDto != null) {
			ShopExtension shopExtension = shopDetailDto.getShopExtensionDto().toModel();
			shopExtension.setShopId(shop.getId());
			shopExtension.setShopArea(new Long(shop.getShopArea()));
			shopExtensionService.update(shopExtension);
		}
		
		List<ShopMateriel> list = shopDetailDto.getShopMaterielDtoList();
		String userCode = userContext.getUserCode();
		for (ShopMateriel shopMateriel : list) {
			shopMateriel.setShopId(shop.getId());
			shopMateriel.setCreateBy(userCode);
			shopMateriel.setCreateDate(currentDate);
		}
		shopMaterielService.saveShopMateriel(list);
		
		resultStatus = 1;
		
		return resultStatus;
	}
	
	/**
	 * 门店审核
	 * @param shop
	 * @param token
	 * @throws ServiceException 
	 */
	public void updateShopStatus(Shop shop, String token) throws ServiceException {
	/*	if(UtilHelper.isEmpty(token)){
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
		
		shopMapper.update(formerShop);*/
		
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
		tempShop.setShopCode(shopInfoDto.getShopCode());
		int countShopCode1 = shopService.findByCount(tempShop);
		tempShop.setId(shopInfoDto.getId());
		int countShopCode2 = shopService.findByCount(tempShop);
		if(countShopCode1>0&&countShopCode2<1){
			throw new ServiceException(ExceptionDef.ERROR_SHOPCODE_ALREADY_EXIST.getName());
		}
		
		Long regionId = shopInfoDto.getRegionId();
		
		Shop shop = shopMapper.getByPK(shopInfoDto.getId());
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
		shop.setShopCode(shopInfoDto.getShopCode());
		shop.setGradeId(shopInfoDto.getGradeId());
		shop.setBizId(shopInfoDto.getBizId());
		shop.setOwnerName(shopInfoDto.getOwnerName());
		shop.setOwnerPhone(shopInfoDto.getOwnerPhone());
		shop.setPurchasChannel(shopInfoDto.getPurchasChannel());
		shop.setMaterielId(shopInfoDto.getMaterielId());
		shop.setPromoter(shopInfoDto.getPromoter());
		shop.setRelationship(shopInfoDto.getRelationship());
		shop.setBizCategory(shopInfoDto.getBizCategory());
		shop.setRemark(shopInfoDto.getRemark());
		shop.setStatus(1);
		shop.setIsInactive(shopInfoDto.getIsInactive());
		shop.setUpdateBy(userContext.getUser().getUserCode());
		shop.setUpdateDate(systemDateService.getCurrentDate());
		shopMapper.update(shop);
		
		ShopExtension tempShopEx = new ShopExtension();
		tempShopEx.setShopId(shopInfoDto.getId());
		List<ShopExtension> shopExtlist = shopExtensionService.listByProperty(tempShopEx);
		if(!UtilHelper.isEmpty(shopExtlist)){
			ShopExtension shopExt = shopExtlist.get(0);
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
			shopExt.setPromoter(shopInfoDto.getPromoter());
			shopExt.setSupervisor(shopInfoDto.getSupervisor());
			shopExt.setSaleBrandQty(shopInfoDto.getSaleBrandQty());
			shopExt.setSaleBrandspQty(shopInfoDto.getSaleBrandspQty());
			shopExt.setSaleTotalQty(shopInfoDto.getSaleTotalQty());
			shopExt.setSaleSpQty(shopInfoDto.getSaleSpQty());
			shopExtensionService.update(shopExt);
		}else{
			ShopExtension newShopExt = new ShopExtension();
			newShopExt.setShopId(shopInfoDto.getId());
			newShopExt.setShopArea(shopInfoDto.getShopArea());
			newShopExt.setClerkTotalQty(shopInfoDto.getClerkTotalQty());
			newShopExt.setClerkBrandQty(shopInfoDto.getClerkBrandQty());
			newShopExt.setRelationship(shopInfoDto.getRelationship());
			newShopExt.setBizCategory(shopInfoDto.getBizCategory());
			newShopExt.setBrandOne(shopInfoDto.getBrandOne());
			newShopExt.setBrandTwo(shopInfoDto.getBrandTwo());
			newShopExt.setBrandThree(shopInfoDto.getBrandThree());
			newShopExt.setBrandFour(shopInfoDto.getBrandFour());
			newShopExt.setBrandFive(shopInfoDto.getBrandFive());
			newShopExt.setClerkOneQty(shopInfoDto.getClerkOneQty());
			newShopExt.setClerkTwoQty(shopInfoDto.getClerkTwoQty());
			newShopExt.setClerkThreeQty(shopInfoDto.getClerkThreeQty());
			newShopExt.setClerkFourQty(shopInfoDto.getClerkFourQty());
			newShopExt.setClerkFiveQty(shopInfoDto.getClerkFiveQty());
			newShopExt.setClerkSixQty(shopInfoDto.getClerkSixQty());
			newShopExt.setPromoter(shopInfoDto.getPromoter());
			newShopExt.setSupervisor(shopInfoDto.getSupervisor());
			newShopExt.setSaleBrandQty(shopInfoDto.getSaleBrandQty());
			newShopExt.setSaleBrandspQty(shopInfoDto.getSaleBrandspQty());
			newShopExt.setSaleTotalQty(shopInfoDto.getSaleTotalQty());
			newShopExt.setSaleSpQty(shopInfoDto.getSaleSpQty());
			shopExtensionService.save(newShopExt);
		}
		return 1;
	}
	
	/**
	 * 门店导出Excel
	 * @param shopInfoDto
	 * @return
	 * @throws ServiceException 
	 */
	public byte[] getShopByExcel(ShopInfoDto shopInfoDto) throws ServiceException {
		String[] headers = {"序号","状态","是否停用","事业部","门店编码","门店名称","门店等级","门店类型", "国家",
		"城市","详细地址","店主姓名","店主联系方式","供货渠道","门店面积","店员总数","TECNO店员数","与TECNO关系",
		"业务类型","竞品品牌1","促销员数量1","竞品品牌2","促销员数量2","竞品品牌3","促销员数量3","竞品品牌4","促销员数量4"
		,"竞品品牌5","促销员数量5","竞品品牌6","促销员数量6","销售代表","促销员","门店月总销量","门店智能机月总销量",
		"品牌月总销量","品牌智能机月总销量","备注","创建人","创建时间","更新人","更新时间"};
		List<ShopInfoDto> list = shopMapper.listShopByProperty(shopInfoDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(ShopInfoDto shopInfoDto1 :list){
			dataset.add(new Object[]{i++,shopInfoDto1.getStatus()==1?"已生效":"新申请",shopInfoDto1.getIsInactive(),
		shopInfoDto1.getCompanyCode(),shopInfoDto1.getShopCode(),shopInfoDto1.getShopName(),
		shopInfoDto1.getGradeName(),shopInfoDto1.getBizName(),shopInfoDto1.getCountryName(),
		shopInfoDto1.getCityName(),shopInfoDto1.getAddress(),shopInfoDto1.getOwnerName(),
		shopInfoDto1.getOwnerPhone(),shopInfoDto1.getPurchasChannel(),shopInfoDto1.getShopArea(),
		shopInfoDto1.getClerkThreeQty(),shopInfoDto1.getClerkBrandQty(),shopInfoDto1.getRelationship(),
		shopInfoDto1.getBizCategoryName(),shopInfoDto1.getBrandOne(),shopInfoDto1.getClerkOneQty(),
		shopInfoDto1.getBrandTwo(),shopInfoDto1.getClerkTwoQty(),shopInfoDto1.getBrandThree(),
		shopInfoDto1.getClerkThreeQty(),shopInfoDto1.getBrandFour(),shopInfoDto1.getClerkFourQty(),
		shopInfoDto1.getBrandFive(),shopInfoDto1.getBrandFive(),shopInfoDto1.getBrandSix(),
		shopInfoDto1.getClerkSixQty(),shopInfoDto1.getSupervisor(),shopInfoDto1.getPromoter(),
		shopInfoDto1.getSaleTotalQty(),shopInfoDto1.getSaleSpQty(),shopInfoDto1.getSaleBrandQty(),
		shopInfoDto1.getSaleBrandspQty(),shopInfoDto1.getRemark(),shopInfoDto1.getCreateBy(),
		shopInfoDto1.getCreateDate(),shopInfoDto1.getUpdateBy(),shopInfoDto1.getUpdateDate()});
		}
		String title = "门店报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	public ShopResponseDto saveShop(String token,ShopParamDto shopParamDto) throws ServiceException{
		if (UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(shopParamDto)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getCompanyId()) 
						|| UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		ShopResponseDto shopDto = new ShopResponseDto();
		/**
		 * 1、缓存中是否有存在店铺名称重复数据
		 * */
		if(CacheUtils.getSupporter().exists(shopParamDto.getShopName())){
			shopDto.setId(shopParamDto.getId());
			shopDto.setShopName(shopParamDto.getShopName());
			shopDto.setDay(systemDateService.getCurrentDate());
			shopDto.setStatus(3);
		}
		/**
		 * 2、查询数据库中是否存在此店铺名称 shopName:店铺名+地址，所以只要根据shopName进行去重
		 * */
		ShopQueryDto sq = new ShopQueryDto();
		// sq.setUserId(userContext.getUser().getId());
		sq.setShopName(shopParamDto.getShopName());
		int count = shopMapper.findShopExist(sq);
		if(count>0){
			shopDto.setId(shopParamDto.getId());
			shopDto.setShopName(shopParamDto.getShopName());
			shopDto.setDay(systemDateService.getCurrentDate());
			shopDto.setStatus(2);
		}else{
			/**
			 * 3、保存数据。
			 * */
		//1.保存店铺主表
		Shop shop = new Shop();
		shop.setShopName(shopParamDto.getShopName());
		shop.setCompanyId(userContext.getCompanyId().intValue());
		shop.setCountry(shopParamDto.getCountry().intValue());
		shop.setParentId(shopParamDto.getCountry());
		shop.setCity(shopParamDto.getCity().intValue());
		shop.setRegionId(shopParamDto.getCity());
		shop.setShopIcon("");
		shop.setAddress(shopParamDto.getAddress());
		shop.setGradeId(shopParamDto.getGradeId());
		shop.setBizId(shopParamDto.getBizId());		
		shop.setOwnerName(shopParamDto.getOwnerName());
		shop.setOwnerPhone(shopParamDto.getOwnerPhone());
		shop.setPurchasChannel("");
		shop.setOpenDate(systemDateService.getCurrentDate());
		//申请中
		shop.setStatus(2);
		shop.setIsInactive(1);
		shop.setRemark(shopParamDto.getRemark());
		shop.setCreateBy(userContext.getUserCode());
		shop.setCreateDate(systemDateService.getCurrentDate());
		shop.setUpdateBy(userContext.getUserCode());
		shop.setUpdateDate(systemDateService.getCurrentDate());
		shopMapper.save(shop);
		shopMapper.updateShopCodeById(shop.getId());
		//2.保存店铺扩展信息
		ShopExtension shopExtension = new ShopExtension();
		shopExtension.setShopId(shop.getId());
		shopExtension.setBrandOne(shopParamDto.getBrandsFirst());
		shopExtension.setBrandTwo(shopParamDto.getBrandsTwo());
		shopExtension.setBrandThree(shopParamDto.getBrandsThree());
		
		//促销员
		shopExtension.setPromoter(shopParamDto.getItelPromoter());
		//督导
		shopExtension.setSupervisor(shopParamDto.getShopAssistant());
		//总销售量
		shopExtension.setSaleTotalQty(new Long(shopParamDto.getTotalnum()));
		//itel 当前销售数量
		shopExtension.setSaleBrandspQty(new Long(shopParamDto.getCurrentnum()));
		
		shopExtensionMapper.save(shopExtension);
		
		//3.保存物料信息
		ShopMateriel sm = new ShopMateriel();
		sm.setMaterielId(shopParamDto.getMaterielId());
		sm.setShopId(shop.getId());
		sm.setMaterielQty(1);
		shopMaterielMapper.save(sm);
		shopMapper.updateShopMaterialId(shop.getId(),sm.getId());
		
		shopDto.setId(shopParamDto.getId());
		shopDto.setShopName(shopDto.getShopName());
		shopDto.setDay(systemDateService.getCurrentDate());
		shopDto.setStatus(1);
		}
		return shopDto;
	}
	
	public List<ShopResponseInfoDto> findShopList(String token) throws ServiceException{
		if (UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getCompanyId()) 
						|| UtilHelper.isEmpty(userContext.getUser()) 
						|| UtilHelper.isEmpty(userContext.getUser().getId())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		return shopMapper.findShopList(userContext.getUser().getId());
	}
	public ShopParamDto findShopDetails(String token,ShopParamDto shopParamDto) throws ServiceException{
		if (UtilHelper.isEmpty(token)){			
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(shopParamDto) || UtilHelper.isEmpty(shopParamDto.getId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUser()) 
						|| UtilHelper.isEmpty(userContext.getUser().getId())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		 return shopMapper.findShopByParam(shopParamDto.getId(),new Long(userContext.getUser().getId()));
	}
	
	public Boolean updateShopDetails(String token,ShopParamDto shopParamDto) throws ServiceException{
		if(UtilHelper.isEmpty(token)){			
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(shopParamDto)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)
						|| UtilHelper.isEmpty(userContext.getUser())
						|| UtilHelper.isEmpty(userContext.getUser().getId())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		ShopQueryDto sq = new ShopQueryDto();
		sq.setUserId(userContext.getUser().getId());
		sq.setShopName(shopParamDto.getShopName());
		int count = shopMapper.findShopExist(sq);
		if(count>0){
			throw new ServiceException(ExceptionDef.ERROR_SHOP_ALREADY_EXIST.getName());
		}
		//1.更新店铺信息
		Shop shop = new Shop();
		shop.setId(shopParamDto.getId());
		shop.setShopCode("1");
		shop.setShopName(shopParamDto.getShopName());
		shop.setCompanyId(userContext.getCompanyId().intValue());
		shop.setCountry(shopParamDto.getCountry().intValue());
		shop.setParentId(shopParamDto.getCountry());
		shop.setRegionId(shopParamDto.getCity());
		shop.setCity(shopParamDto.getCity().intValue());
		shop.setShopIcon("");
		shop.setAddress(shopParamDto.getAddress());
		shop.setGradeId(shopParamDto.getGradeId());
		shop.setBizId(shopParamDto.getBizId());		
		shop.setOwnerName(shopParamDto.getOwnerName());
		shop.setOwnerPhone(shopParamDto.getOwnerPhone());
		shop.setPurchasChannel("");
		shop.setOpenDate(systemDateService.getCurrentDate());
		//申请中
		shop.setStatus(2);
		shop.setIsInactive(1);
		shop.setRemark(shopParamDto.getRemark());
		shop.setCreateBy(userContext.getUserCode());
		shop.setCreateDate(systemDateService.getCurrentDate());
		shop.setUpdateBy(userContext.getUserCode());
		shop.setUpdateDate(systemDateService.getCurrentDate());
		shopMapper.update(shop);
		
		//2.更新店铺扩展信息
		ShopExtension shope = shopExtensionMapper.findShopExtensionByParam(shop.getId(),userContext.getUser().getId());
		if(!UtilHelper.isEmpty(shope)){
		ShopExtension shopExtension = new ShopExtension();
		shopExtension.setId(shope.getId());
		shopExtension.setShopId(shop.getId());
		shopExtension.setBrandOne(shopParamDto.getBrandsFirst());
		shopExtension.setBrandTwo(shopParamDto.getBrandsTwo());
		shopExtension.setBrandThree(shopParamDto.getBrandsThree());
		
		//促销员
		shopExtension.setPromoter(shopParamDto.getItelPromoter());
		//督导
		shopExtension.setSupervisor(shopParamDto.getShopAssistant());
		//总销售量
		shopExtension.setSaleTotalQty(new Long(shopParamDto.getTotalnum()));
		//itel 当前销售数量
		shopExtension.setSaleBrandspQty(new Long(shopParamDto.getCurrentnum()));
		shopExtensionMapper.update(shopExtension);
		}
		
		//3.更新物料信息
		ShopMateriel shopm = shopMaterielMapper.findShopMaterielByParam(shop.getId(),userContext.getUser().getId());
		ShopMateriel sm = new ShopMateriel();
		if(!UtilHelper.isEmpty(shopm)){
			sm.setId(shopm.getId());
			sm.setMaterielId(shopParamDto.getMaterielId());
			sm.setShopId(shop.getId());
			sm.setMaterielQty(1);
			shopMaterielMapper.update(sm);
		}
		return Boolean.TRUE;
	}
	
	/**
	 * 查询用户店铺信息和店铺巡店的最后时间 注:如果用户店铺为巡店的 最后巡店时间为NULL
	 * @author guihua.zhang on 2017-03-15
	 * */
	public List<ShopUserDto> findShopByUserId(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){			
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)
						|| UtilHelper.isEmpty(userContext.getUser())
						|| UtilHelper.isEmpty(userContext.getUser().getId())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		
		List<ShopUserDto> shopUserDtos = shopMapper.findShopByUserId(userContext.getUser().getId());
		if (shopUserDtos != null && shopUserDtos.size() > 0) {
			for (ShopUserDto shopUserDto : shopUserDtos) {
				shopUserDto.setMonthVisitCount(visitMapper.countMonthVisitShopByShopId(shopUserDto.getShopId()));
			}
		}
		
		return shopUserDtos;
	}
}
