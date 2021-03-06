package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Shop;
import com.transsion.store.bo.ShopGrade;
import com.transsion.store.context.UserContext;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.ShopGradeMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("shopGradeManager")
public class ShopGradeManager {
	@Autowired
	ShopGradeMapper shopGradeMapper;
	
	@Autowired
	ShopMapper shopMapper;
	
	@Autowired
	SystemDateService systemDateService;

	public List<ShopGrade> getShopGradeList(String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		String brandCode = userContext.getBrandCode();
		if(UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		ShopGrade sg = new ShopGrade();
		sg.setBrandCode(brandCode);
		sg.setIsInactive(1);
		return shopGradeMapper.listByProperty(sg);
	}
	
	/**
	 * 新增门店等级
	 * @param shopGrade
	 * @param token
	 * @throws ServiceException 
	 */
	public void save(ShopGrade shopGrade, String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if(UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Integer companyId = userContext.isAdmin()?null:userContext.getCompanyId().intValue();
		ShopGrade tempSg = new ShopGrade();
		tempSg.setGradeName(shopGrade.getGradeName());
		if(UtilHelper.isEmpty(companyId)){
			tempSg.setCompanyId(shopGrade.getCompanyId());
		}
		tempSg.setCompanyId(companyId);
		int count = shopGradeMapper.findByCount(tempSg);
		if(count>0){
			throw new ServiceException(ExceptionDef.ERROR_SHOP_GRADE_EXIST.getName());
		}
		shopGrade.setCompanyId(userContext.getUser().getCompanyId());
		shopGrade.setCreateBy(userContext.getUser().getUserCode());
		shopGrade.setCreateDate(systemDateService.getCurrentDate());
		shopGrade.setBrandCode(userContext.getBrandCode());
		shopGradeMapper.save(shopGrade);
		
	}

	/**
	 * 修改门店等级
	 * @param shopGrade
	 * @param token
	 * @throws ServiceException 
	 */
	public int update(ShopGrade shopGrade, String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if(UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Integer companyId = userContext.isAdmin()?null:userContext.getCompanyId().intValue();
		ShopGrade tempSg = new ShopGrade();
		tempSg.setGradeName(shopGrade.getGradeName());
		if(UtilHelper.isEmpty(companyId)){
			tempSg.setCompanyId(shopGrade.getCompanyId());
		}
		tempSg.setCompanyId(companyId);
		int count1 = shopGradeMapper.findByCount(tempSg);
		tempSg.setId(shopGrade.getId());
		int count2 = shopGradeMapper.findByCount(tempSg);
		if(count1>0&&count2<1){
			throw new ServiceException(ExceptionDef.ERROR_SHOP_GRADE_EXIST.getName());
		}
		ShopGrade sg = shopGradeMapper.getByPK(shopGrade.getId());
		sg.setBrandCode(shopGrade.getBrandCode());
		sg.setGradeName(shopGrade.getGradeName());
		sg.setIsInactive(shopGrade.getIsInactive());
		sg.setRemark(shopGrade.getRemark());
		sg.setUpdateBy(userContext.getUser().getUserCode());
		sg.setUpdateDate(systemDateService.getCurrentDate());
		return shopGradeMapper.update(sg);
	}

	/**
	 * 查询已启用的门店等级
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopGrade> findActiveShopGrade(String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if(UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		ShopGrade sg = new ShopGrade();
		sg.setIsInactive(1);
		sg.setCompanyId(userContext.getUser().getCompanyId());
		return shopGradeMapper.listByProperty(sg);
	}

	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException 
	 */
	public void deleteByPKeys(List<Long> primaryKeys) throws ServiceException {
		for(long primaryKey:primaryKeys){
			Shop shop = new Shop();
			shop.setGradeId(primaryKey);
			List<Shop> list = shopMapper.listByProperty(shop);
			if(!UtilHelper.isEmpty(list)){
				throw new ServiceException(ExceptionDef.ERROR_SHOP_GRADE_INUSE.getName());
			}
			shopGradeMapper.deleteByPK(primaryKey);
		}
	}
	

}
