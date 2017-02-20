package com.transsion.store.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Company;
import com.transsion.store.context.UserContext;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.CompanyMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("companyManager")
public class CompanyManager {
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private SystemDateService systemDateService;
	/**
	 * 保存记录
	 * @param company
	 * @return
	 * @throws ServiceException
	 */
	public void save(Company company,String token) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(company)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		company.setCreatedBy(userContext.getUserCode());
		company.setCreatedTime(systemDateService.getCurrentDate());
		companyMapper.save(company);
	}
	
	/**
	 * 更新记录
	 * @param company
	 * @return
	 * @throws ServiceException
	 */
	public int update(Company company,String token) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(company)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		company.setCreatedBy(userContext.getUserCode());
		company.setCreatedTime(systemDateService.getCurrentDate());
		company.setUpdatedBy(userContext.getUserCode());
		company.setUpdatedTime(systemDateService.getCurrentDate());
		return companyMapper.update(company);
	}
}
