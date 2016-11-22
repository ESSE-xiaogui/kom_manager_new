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
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(organizationDto)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser().getUserId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERID_IS_NULL);
		}
		Organization organization = new Organization();
		BeanUtils.copyProperties(organizationDto, organization);
		organization.setParentId(new Long(organizationDto.getParentId()));
		organization.setCreatedBy(userContext.getUser().getUserId().toString());
		organization.setCreatedTime(systemDateService.getCurrentDate());
		organization.setUpdatedBy(userContext.getUser().getUserId().toString());
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
		String orgName = organizationMapper.getOrgName(orgId);
		if(UtilHelper.isEmpty(orgName)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		OrganizationResponseDto ord = new OrganizationResponseDto();
		ord.setOrgName(orgName);
		return ord;
	}
	
	/**
	 * 查询树形组织机构
	 * @return
	 * @throws serviceException
	 * */
	public List<OrganizationTreeDto> findOrg(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext usercontext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(usercontext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(usercontext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		if(UtilHelper.isEmpty(usercontext.getUser().getCompanyId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERID_IS_NULL);
		}
		Integer companyId = usercontext.getUser().getCompanyId();
		List<OrganizationTreeDto> orgList = organizationMapper.findOrg(companyId);
		if(UtilHelper.isEmpty(orgList)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		return getChridenOrg(orgList,0);
	}
	
	/**
	 * 获取树形子菜单
	 * */
	public List<OrganizationTreeDto> getChridenOrg(List<OrganizationTreeDto> orgList,Integer parentId) throws ServiceException{
		List<OrganizationTreeDto> orgTreeDto = new ArrayList<>();
		for(OrganizationTreeDto org:orgList){
			Integer orgId = org.getOrgId();  
	    	 Integer pid = org.getParentId();
	           if (parentId == pid) {  
	        	   List<OrganizationTreeDto> children = getChridenOrg(orgList, orgId); 
	        	   org.setChilden(children);
	        	   orgTreeDto.add(org);
	           }  
		}
		return orgTreeDto;
	}
}
