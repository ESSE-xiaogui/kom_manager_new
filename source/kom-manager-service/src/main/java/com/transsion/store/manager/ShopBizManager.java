package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Shop;
import com.transsion.store.bo.ShopBiz;
import com.transsion.store.context.UserContext;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.ShopBizMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("/shopBizManager")
public class ShopBizManager {
	
	@Autowired
	private ShopBizMapper shopBizMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private ShopMapper shopMapper;
	
	/**
	 * 保存记录
	 * @param shopBiz
	 * @return
	 * @throws ServiceException
	 */
	public void save(ShopBiz shopBiz,String token) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(shopBiz)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) ||UtilHelper.isEmpty(userContext.getCompanyId()) 
						|| UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		ShopBiz existShopBiz = new ShopBiz();
		if(UtilHelper.isEmpty(shopBiz.getCompanyId())){
			existShopBiz.setCompanyId(userContext.getCompanyId());
		}else{
			existShopBiz.setCompanyId(shopBiz.getCompanyId());
		}
		existShopBiz.setChinaName(shopBiz.getChinaName());
		existShopBiz.setEnglishName(shopBiz.getEnglishName());
		int count = shopBizMapper.findByCount(existShopBiz);
		if(count>0){
			throw new ServiceException(ExceptionDef.ERROR_SHOP_BIZ_EXIST.getName());
		}
		shopBiz.setCompanyId(userContext.getCompanyId());
		shopBiz.setBrandCode(userContext.getBrandCode());
		shopBiz.setCreateBy(userContext.getUserCode());
		shopBiz.setCreateDate(systemDateService.getCurrentDate());
		shopBizMapper.save(shopBiz);
	}
	/**
	 * 更新记录
	 * @param shopBiz
	 * @return
	 * @throws ServiceException
	 */
	public int update(ShopBiz shopBiz,String token) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(shopBiz)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext.getCompanyId()) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		ShopBiz shopBizParam = new ShopBiz();
		shopBizParam.setCompanyId(shopBiz.getCompanyId());
		shopBizParam.setEnglishName(shopBiz.getEnglishName());
		shopBizParam.setChinaName(shopBiz.getChinaName());
		int count1 = shopBizMapper.findByCount(shopBizParam);
		shopBizParam.setId(shopBiz.getId());
		int count2 = shopBizMapper.findByCount(shopBizParam);
		if(count1>0 && count2<1){
			throw new ServiceException(ExceptionDef.ERROR_DUTY_IS_EXIST.getName());
		}
		shopBiz.setCompanyId(userContext.getCompanyId());
		shopBiz.setBrandCode(userContext.getBrandCode());
		shopBiz.setCreateBy(userContext.getUserCode());
		shopBiz.setCreateDate(systemDateService.getCurrentDate());
		shopBiz.setUpdateBy(userContext.getUserCode());
		shopBiz.setUpdateDate(systemDateService.getCurrentDate());
		return shopBizMapper.update(shopBiz);
	}
	
	/**
	 * 根据BrandCode查询门店类型列表(app)
	 * @param brandCode
	 * @param shopType 
	 * @param token
	 * @return
	 * @throws ServiceException 
	 */
	public List<ShopBiz> getShopBizListByBrandCode(String brandCode, Integer shopType, String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(brandCode)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext.getCompanyId()) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		ShopBiz shopBiz = new ShopBiz();
		shopBiz.setBrandCode(brandCode);
		shopBiz.setShopType(shopType);
		shopBiz.setIsInactive(1);
		return shopBizMapper.listByProperty(shopBiz);
	}
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		for(long primaryKey:primaryKeys){
		Shop shop = new Shop();
		shop.setBizId(primaryKey);
		List<Shop> list = shopMapper.listByProperty(shop);
		if(!UtilHelper.isEmpty(list)){
			throw new ServiceException(ExceptionDef.ERROR_SHOP_BIZ_INUSE.getName());
		}
		shopBizMapper.deleteByPK(primaryKey);
	}
	}
	
}
