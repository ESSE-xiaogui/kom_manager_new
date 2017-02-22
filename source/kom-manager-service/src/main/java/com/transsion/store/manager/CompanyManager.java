package com.transsion.store.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Company;
import com.transsion.store.bo.Organization;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.OrganizationDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.CompanyMapper;
import com.transsion.store.mapper.OrganizationMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("companyManager")
public class CompanyManager {
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private SystemDateService systemDateService;
	@Autowired
	private OrganizationMapper organizationMapper;
	
	/**
	 * 1 启用
	 * */
	public static final Integer isInactive = 1;
	/**
	 * 新增公司记录,组织机构记录
	 * @author guihua.zhang on 2017-2-22
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
		Company companyParam = new Company();
		companyParam.setCompanyName(company.getCompanyName());
		int count = companyMapper.findByCount(companyParam);
		if(count>0){
			throw new ServiceException(ExceptionDef.ERROR_COMPANY_ISEXIST.getName());
		}
		company.setCreatedBy(userContext.getUserCode());
		company.setCreatedTime(systemDateService.getCurrentDate());
		companyMapper.save(company);
		OrganizationDto orgResult = organizationMapper.findOrgId(company.getParentId());
		
		Organization saveOrg = new Organization();	
		saveOrg.setCompanyId(company.getId().intValue());
		saveOrg.setOrgName(company.getCompanyName());
		saveOrg.setIsInactive(isInactive);
		saveOrg.setCreatedBy(userContext.getUserCode());
		saveOrg.setCreatedTime(systemDateService.getCurrentDate());
		if(UtilHelper.isEmpty(orgResult)){
			saveOrg.setParentId(company.getParentId());
		}else{
			saveOrg.setParentId(orgResult.getId());
		}
		organizationMapper.save(saveOrg);
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
