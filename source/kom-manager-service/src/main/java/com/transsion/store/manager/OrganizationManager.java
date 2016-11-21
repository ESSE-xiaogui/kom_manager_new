package com.transsion.store.manager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Organization;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.OrganizationDto;
import com.transsion.store.dto.OrganizationResponseDto;
import com.transsion.store.mapper.OrganizationMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.utils.CacheUtils;

@Service("organizationManager")
public class OrganizationManager {
	
	@Autowired
	private OrganizationMapper	organizationMapper;
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
		BeanUtils.copyProperties(organization, organizationDto);
		organizationMapper.save(organization);
		OrganizationResponseDto ozrd = new OrganizationResponseDto();
		ozrd.setStatus(1);
		return ozrd;
	}
}
