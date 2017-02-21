package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Employee;
import com.transsion.store.bo.Organization;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.OrganizationDto;
import com.transsion.store.dto.OrganizationResponseDto;
import com.transsion.store.dto.OrganizationTreeDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.EmployeeMapper;
import com.transsion.store.mapper.OrganizationMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("organizationManager")
public class OrganizationManager {
	
	@Autowired
	private OrganizationMapper	organizationMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	/**
	 * 新增组织机构
	 * @return
	 * @throws ServiceException
	 * */
	public void saveOrg(String token,OrganizationDto organizationDto) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(organizationDto) || UtilHelper.isEmpty(organizationDto.getOrgName())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode()) 
						|| UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		Organization orgParams = new Organization();
		orgParams.setOrgName(organizationDto.getOrgName());
		orgParams.setParentId(organizationDto.getParentId());
		int count = organizationMapper.findByCount(orgParams);
		if(count>0){
			throw new ServiceException(ExceptionDef.ERROR_ORGANIZATION_ALREADY_EXIST.getName());
		}
		Organization organization = new Organization();
		BeanUtils.copyProperties(organizationDto, organization);
		if(UtilHelper.isEmpty(organizationDto.getParentId())){
			organization.setParentId(0l);
		}else{
		organization.setParentId(new Long(organizationDto.getParentId()));
		}
		organization.setCompanyId(userContext.getCompanyId().intValue());
		organization.setCreatedBy(userContext.getUserCode());
		organization.setCreatedTime(systemDateService.getCurrentDate());
		organization.setVersion(0);
		organizationMapper.save(organization);
	}
	
	/**
	 * 查询组织机构名称
	 * @return
	 * @throws ServiceException
	 * */
	public OrganizationResponseDto findOrgName(Integer orgId) throws ServiceException{
		if(UtilHelper.isEmpty(orgId)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		OrganizationResponseDto orgName = organizationMapper.getOrgName(orgId);
		if(UtilHelper.isEmpty(orgName)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		OrganizationResponseDto ord = new OrganizationResponseDto();
		ord.setParentName(orgName.getParentName());
		ord.setChildrenName(orgName.getChildrenName());
		return ord;
	}
	
	/**
	 * 查询树形组织机构
	 * @return
	 * @throws serviceException
	 * */
	public List<OrganizationTreeDto> findOrg(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		List<OrganizationTreeDto> orgList = organizationMapper.findOrg(userContext.getCompanyId());
		if(UtilHelper.isEmpty(orgList)){
			return orgList;
		}else{
		return getChridenOrg(orgList,0);
		}
	}
	
	/**
	 * 获取树形子菜单
	 * */
	public List<OrganizationTreeDto> getChridenOrg(List<OrganizationTreeDto> orgList, Integer parentId)
					throws ServiceException {
		List<OrganizationTreeDto> orgTreeDto = new ArrayList<OrganizationTreeDto>();
		for (OrganizationTreeDto org : orgList) {
			Integer orgId = org.getOrgId();
			Integer pid = org.getParentId();
			if (parentId != null) {
				if (parentId.equals(pid)) {
					List<OrganizationTreeDto> children = getChridenOrg(orgList, orgId);
					org.setChildren(children);
					orgTreeDto.add(org);
				}
			}

		}
		return orgTreeDto;
	}

	/**
	 * 删除组织机构
	 * */
	public void deleteOrg(Long orgId) throws ServiceException{
		if(UtilHelper.isEmpty(orgId)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Employee employee = new Employee();
		employee.setOrgId(orgId.intValue());
		int employeeCount = employeeMapper.findByCount(employee);
		if(employeeCount>0){
			throw new ServiceException(ExceptionDef.ERROR_ORGANIZATION_EMP_BIND.getName());
		}
		Organization org = new Organization();
		org.setParentId(orgId);
		int count = organizationMapper.findByCount(org);
		if(count>0){
			throw new ServiceException(ExceptionDef.ERROR_ORGANIZATION_CHILDREN_EXIST.getName());
		}else{
			organizationMapper.deleteByPK(orgId);
		}
	}

	/**
	 * 修改组织机构
	 * @throws ServiceException 
	 * */
	public void update(String token, Organization organization) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(organization) || UtilHelper.isEmpty(organization.getOrgName())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Organization OrgParam = new Organization();
		OrgParam.setOrgName(organization.getOrgName());
		OrgParam.setParentId(organization.getParentId());
		int count1 = organizationMapper.findByCount(OrgParam);
		OrgParam.setId(organization.getId());
		int count2 = organizationMapper.findByCount(OrgParam);
		if(count1>0 && count2<1){
			throw new ServiceException(ExceptionDef.ERROR_ORGANIZATION_ALREADY_EXIST.getName());
		}
		Organization findOrg = organizationMapper.getByPK(organization.getId());
		findOrg.setOrgName(organization.getOrgName());
		findOrg.setBizId(organization.getBizId());
		findOrg.setIsInactive(organization.getIsInactive());
		findOrg.setRemark(organization.getRemark());
		if(UtilHelper.isEmpty(organization.getParentId())){
			organization.setParentId(0l);
		}else{
		organization.setParentId(new Long(organization.getParentId()));
		}
		findOrg.setUpdatedBy(userContext.getUserCode());
		findOrg.setUpdatedTime(systemDateService.getCurrentDate());
		organizationMapper.update(findOrg);
	}
	
}
