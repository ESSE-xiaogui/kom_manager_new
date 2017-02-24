package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Materiel;
import com.transsion.store.context.UserContext;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.MaterielMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("materielManager")
public class MaterielManager {
	@Autowired
	private MaterielMapper materielMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	public List<Materiel> getMaterielListByBrandCode(String brandCode, String token) throws ServiceException {
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
		Materiel materiel = new Materiel();
		materiel.setBrandCode(brandCode);
		materiel.setIsInactive(1);
		return materielMapper.listByProperty(materiel);
	}
	
	/**
	 * 新增道具
	 * @param shopGrade
	 * @param token
	 * @throws ServiceException 
	 */
	public void save(Materiel materiel, String token) throws ServiceException {
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
		
		Materiel tempMateriel = new Materiel();
		tempMateriel.setName(materiel.getName());
		tempMateriel.setBrandCode(materiel.getBrandCode());
		int count = materielMapper.findByCount(tempMateriel);
		if(count>0){
			throw new ServiceException(ExceptionDef.ERROR_MATERIEL_ALREADY_EXIST.getName());
		}
		materiel.setCompanyId(userContext.getUser().getCompanyId());
		materiel.setCreateBy(userContext.getUser().getUserCode());
		materiel.setCreateDate(systemDateService.getCurrentDate());
		materiel.setBrandCode(userContext.getBrandCode());
		materielMapper.save(materiel);
		
	}

	/**
	 * 修改道具
	 * @param shopGrade
	 * @param token
	 * @throws ServiceException 
	 */
	public int update(Materiel materiel, String token) throws ServiceException {
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
		
		Materiel tempMateriel = new Materiel();
		tempMateriel.setName(materiel.getName());
		tempMateriel.setBrandCode(materiel.getBrandCode());
		int count1 = materielMapper.findByCount(tempMateriel);
		tempMateriel.setId(materiel.getId());
		int count2 = materielMapper.findByCount(tempMateriel);
		if(count1>0&&count2<1){
			throw new ServiceException(ExceptionDef.ERROR_MODEL_ALREADY_EXIST.getName());
		}
		Materiel m = materielMapper.getByPK(materiel.getId());
		m.setBrandCode(materiel.getBrandCode());
		m.setName(materiel.getName());
		m.setNameCN(materiel.getNameCN());
		m.setIsInactive(materiel.getIsInactive());
		m.setRemark(materiel.getRemark());
		m.setUpdateBy(userContext.getUser().getUserCode());
		m.setUpdateDate(systemDateService.getCurrentDate());
		return materielMapper.update(m);
	}


	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException 
	 */
//	public void deleteByPKeys(List<Long> primaryKeys) throws ServiceException {
//		for(long primaryKey:primaryKeys){
//			ShopMateriel shopMateriel = new ShopMateriel();
//			shopMateriel.setMaterielId(primaryKey);
//			List<ShopMateriel> list = materielMapper.listByProperty(shopMateriel);
//			if(!UtilHelper.isEmpty(list)){
//				throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_MATERIEL_IN_USE);
//			}
//			materielMapper.deleteByPK(primaryKey);
//		}
//	}

}
