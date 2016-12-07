package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Organization;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.OrganizationDto;
import com.transsion.store.dto.OrganizationResponseDto;
import com.transsion.store.dto.OrganizationTreeDto;
import com.transsion.store.mapper.OrganizationMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("organizationManager")
public class OrganizationManager {
	
	@Autowired
	private OrganizationMapper	organizationMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	/**
	 * 新增组织机构
	 * @return
	 * @throws ServiceException
	 * */
	public OrganizationResponseDto saveOrg(String token,OrganizationDto organizationDto) throws ServiceException{
		if(UtilHelper.isEmpty(organizationDto) || UtilHelper.isEmpty(organizationDto.getOrgName())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		Organization organization = new Organization();
		BeanUtils.copyProperties(organizationDto, organization);
		if(UtilHelper.isEmpty(organizationDto.getParentId())){
			organization.setParentId(0l);
		}else{
		organization.setParentId(new Long(organizationDto.getParentId()));
		}
		if(!UtilHelper.isEmpty(userContext)&&!UtilHelper.isEmpty(userContext.getUser())){
			organization.setCompanyId(userContext.getUser().getCompanyId());
			organization.setCreatedBy(userContext.getUser().getUserId().toString());
			organization.setUpdatedBy(userContext.getUser().getUserId().toString());
		}
		organization.setCreatedTime(systemDateService.getCurrentDate());
		organization.setUpdatedTime(systemDateService.getCurrentDate());
		organization.setVersion(0);
		organizationMapper.save(organization);
		OrganizationResponseDto ozrd = new OrganizationResponseDto();
		ozrd.setStatus(1);
		return ozrd;
	}
	
	/**
	 * 查询组织机构名称
	 * @return
	 * @throws ServiceException
	 * */
	public OrganizationResponseDto findOrgName(Integer orgId) throws ServiceException{
		if(UtilHelper.isEmpty(orgId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		OrganizationResponseDto orgName = organizationMapper.getOrgName(orgId);
		if(UtilHelper.isEmpty(orgName)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
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
	public List<OrganizationTreeDto> findOrg() throws ServiceException{
		List<OrganizationTreeDto> orgList = organizationMapper.findOrg();
		if(UtilHelper.isEmpty(orgList)){
			return orgList;
		}else{
		return getChridenOrg(orgList,0);
		}
	}
	
	/**
	 * 获取树形子菜单
	 * */
	public List<OrganizationTreeDto> getChridenOrg(List<OrganizationTreeDto> orgList,Integer parentId) throws ServiceException{
		List<OrganizationTreeDto> orgTreeDto = new ArrayList<OrganizationTreeDto>();
		for(OrganizationTreeDto org:orgList){
			Integer orgId = org.getOrgId();  
	    	 Integer pid = org.getParentId();
	           if (parentId == pid) {  
	        	   List<OrganizationTreeDto> children = getChridenOrg(orgList, orgId); 
	        	   org.setChildren(children);
	        	   orgTreeDto.add(org);
	           }  
		}
		return orgTreeDto;
	}
	
	/**
	 * 删除组织机构
	 * */
	public OrganizationResponseDto deleteOrg(Integer orgId) throws ServiceException{
		if(UtilHelper.isEmpty(orgId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		OrganizationResponseDto orDto = new OrganizationResponseDto();
		Organization org = new Organization();
		org.setParentId(new Long(orgId));
		int count = organizationMapper.findByCount(org);
		if(count>0){
			orDto.setStatus(3);
		}else{
			org.setId(new Long(orgId));
			int counts = organizationMapper.deleteByProperty(org);
			if(counts>0){
				orDto.setStatus(1);
			}else{
				orDto.setStatus(2);
			}
			
		}
		return orDto;
	}
}
