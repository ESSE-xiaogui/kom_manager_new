package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.RoleResource;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.RoleResourceDto;
import com.transsion.store.mapper.RoleResourceMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("roleResourceManager")
public class RoleResourceManager {

	@Autowired
	private RoleResourceMapper roleResourceMapper;

	@Autowired
	private SystemDateService systemDateService;

	public void addResRole(String token, RoleResourceDto roleResourceDto) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if (UtilHelper.isEmpty(userContext.getUser())) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		RoleResource roleResource = new RoleResource();
		Long roleId = roleResourceDto.getRoleId();
		roleResource.setRoleId(roleId);
		roleResourceMapper.deleteByProperty(roleResource);
		List<Long> resList = roleResourceDto.getResIds();
		if (!UtilHelper.isEmpty(resList)) {
			for (Long resId : resList) {
				RoleResource rr = new RoleResource();
				rr.setRoleId(roleId);
				rr.setResId(resId);
				rr.setCreatedBy(userContext.getUser().getUserCode());
				rr.setCreateTime(systemDateService.getCurrentDate());
				roleResourceMapper.save(rr);
			}
		}
	}
}
