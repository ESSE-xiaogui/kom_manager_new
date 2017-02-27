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
import com.transsion.store.dto.ShopUploadDto;
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
		
		String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Shop shop = shopDetailDto.getShop();
		shop.setCreateBy(userContext.getUser().getId().toString());
		shop.setCreateDate(currentDate);
		shopService.save(shop);
		
		Long shopId = shop.getId();
		
		ShopExtensionDto shopExtensionDto = shopDetailDto.getShopExtensionDto();
		if (shopExtensionDto != null) {
			ShopExtension shopExtension = shopDetailDto.getShopExtensionDto().toModel();
			shopExtension.setShopId(shopId);
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
		String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Shop shop = shopDetailDto.getShop();
		shop.setUpdateBy(userContext.getUser().getId().toString());
		shop.setUpdateDate(currentDate);
		shopMapper.update(shop);
		
		ShopExtension shopExtension = shopDetailDto.getShopExtensionDto().toModel();
		if (shopExtension != null) {
			shopExtensionService.update(shopExtension);
		}
		
		List<ShopMateriel> list = shopDetailDto.getShopMaterielDtoList();
		for (ShopMateriel shopMateriel : list) {
			shopMateriel.setUpdateBy(userContext.getUserCode());
			shopMateriel.setUpdateDate(currentDate);
			shopMaterielService.save(shopMateriel);
		}
		
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
		
		Shop tempShop1 = new Shop();
		tempShop1.setShopName(shopInfoDto.getShopName());
		int countShopName1 = shopService.findByCount(tempShop1);
		tempShop1.setId(shopInfoDto.getId());
		int countShopName2 = shopService.findByCount(tempShop1);
		if(countShopName1>0&&countShopName2<1){
			throw new ServiceException(ExceptionDef.ERROR_SHOP_ALREADY_EXIST.getName());
		}
		
		Shop tempShop2 = new Shop();
		tempShop2.setShopName(shopInfoDto.getShopName());
		int countShopCode1 = shopService.findByCount(tempShop2);
		tempShop1.setId(shopInfoDto.getId());
		int countShopCode2 = shopService.findByCount(tempShop2);
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
}
