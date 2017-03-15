package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Materiel;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.MaterialInfoDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.MaterielMapper;
import com.transsion.store.mapper.VisitMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("materielManager")
public class MaterielManager {
	@Autowired
	private MaterielMapper materielMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private VisitMapper visitMapper;
	
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
		Integer companyId = userContext.isAdmin()?null:userContext.getCompanyId().intValue();
		Materiel tempMateriel = new Materiel();
		tempMateriel.setName(materiel.getName());
		if(UtilHelper.isEmpty(companyId)){
			tempMateriel.setCompanyId(materiel.getCompanyId());
		}
		tempMateriel.setCompanyId(companyId);
		tempMateriel.setType(materiel.getType());
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
		Integer companyId = userContext.isAdmin()?null:userContext.getCompanyId().intValue();
		Materiel tempMateriel = new Materiel();
		tempMateriel.setName(materiel.getName());
		if(UtilHelper.isEmpty(companyId)){
			tempMateriel.setCompanyId(materiel.getCompanyId());
		}
		tempMateriel.setCompanyId(companyId);
		tempMateriel.setType(materiel.getType());
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
	
	/**
	 * 查询所有物料和店铺绑定的物料
	 * @author guihua.zhang on 2017-03-15
	 * */
	public List<MaterialInfoDto> findMateriel(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getCompanyId())
						|| UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		List<MaterialInfoDto> findAll = materielMapper.findMateriel(userContext.getCompanyId());
		List<MaterialInfoDto> lastMaterial =visitMapper.findLastDateMaterial(userContext.getUserCode(), userContext.getCompanyId());
		List<MaterialInfoDto> result = new ArrayList<MaterialInfoDto>();
		/**
		 * 1.所有物料为空,直接返回result
		 * 2.所有物料不为空,巡店物料为空,返回所有物料,isSelect为false
		 * 3.所有物料不为空,巡店物料不为空,如果巡店物料和所有物料比较有相同的,isSelect为true
		 * */
		if(!UtilHelper.isEmpty(findAll)){
			result.addAll(findAll);
			if(!UtilHelper.isEmpty(lastMaterial)){
				for(MaterialInfoDto m:lastMaterial){
					if(result.contains(m)){
						int index = findAll.indexOf(m);
						if(index != -1){
							MaterialInfoDto m2 = findAll.get(index);
							m2.setSelected(true);
						}
					}
				}
			}
		}
		return result;
	}

}
