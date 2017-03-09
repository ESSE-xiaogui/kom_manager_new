package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.RoleResource;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.RoleResourceDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.RoleResourceMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("roleResourceManager")
public class RoleResourceManager {

	@Autowired
	private RoleResourceMapper roleResourceMapper;

	@Autowired
	private SystemDateService systemDateService;

	public void saveResRole(String token, RoleResourceDto roleResourceDto) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(userContext.getUser())) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
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
