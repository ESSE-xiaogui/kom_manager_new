package com.transsion.store.manager;


import java.util.ArrayList;
import java.util.List;

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
		
		Organization organization = new Organization();
		organization.setCompanyId(company.getParentId().intValue());
		OrganizationDto orgResult = organizationMapper.findOrgId(organization);
		
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
	 * @author guihua.zhang on 2017-2-22
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
		
		Organization organization = new Organization();
		Organization orgParam = new Organization();
		orgParam.setCompanyId(company.getParentId().intValue());
		OrganizationDto organizationDtoResult = organizationMapper.findOrgId(orgParam);
		if(UtilHelper.isEmpty(organizationDtoResult)){
			organization.setParentId(company.getParentId());
		}else{
			organization.setParentId(organizationDtoResult.getId());
		}
		organization.setOrgName(company.getCompanyName());
		OrganizationDto orgResult = organizationMapper.findOrgId(organization);
		int count1 = organizationMapper.findByCount(organization);
		if(!UtilHelper.isEmpty(orgResult)){
			organization.setId(organizationDtoResult.getId());
			int count2 = organizationMapper.findByCount(organization);
			if(count1>0 && count2<1){
				throw new ServiceException(ExceptionDef.ERROR_ORGANIZATION_ALREADY_EXIST.getName());
			}
		}
		organization.setIsInactive(isInactive);
		organization.setUpdatedBy(userContext.getUserCode());
		organization.setUpdatedTime(systemDateService.getCurrentDate());
		organizationMapper.update(organization);
		
		Company companyParam = new Company();
		companyParam.setParentId(company.getParentId());
		companyParam.setCompanyName(company.getCompanyName());
		int count = companyMapper.findByCount(companyParam);
		companyParam.setId(company.getId());
		int count2 = companyMapper.findByCount(companyParam);
		if(count>0 && count2<1){
			throw new ServiceException(ExceptionDef.ERROR_COMPANY_ISEXIST.getName());
		}
		company.setUpdatedBy(userContext.getUserCode());
		company.setUpdatedTime(systemDateService.getCurrentDate());
		return companyMapper.update(company);
	}
	
	/**
	 * 根据当前登录人角色查询所有事业部名称
	 * @author guihua.zhang on 2017-2-22
	 * @return
	 * */
	public List<Company> findCompanyAll(String token) throws ServiceException{
		
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		List<Company> list = new ArrayList<Company>();
		Company company = new Company();
		if(userContext.isAdmin()){
			Company comp = new Company();
			comp.setCompanyCode("All");
			comp.setId(0l);
			list.add(comp);
			company.setId(null);
		}else{
			company.setId(userContext.getCompanyId());
		}
		List<Company> companyList = companyMapper.listByProperty(company);
		list.addAll(companyList);
		return list;
	}
}
