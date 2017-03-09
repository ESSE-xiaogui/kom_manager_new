package com.transsion.store.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.UserRole;
import com.transsion.store.dto.UserRoleDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.UserRoleMapper;
import com.transsion.store.service.SystemDateService;

@Service("userRoleManager")
public class UserRoleManager {
	@Autowired
	private SystemDateService systemDateService;

	@Autowired
	private UserRoleMapper userRoleMapper;

	/**
	 * 用户角色权限绑定
	 * 
	 * @throws ServiceException
	 */
	public void saveUserRole(UserRoleDto userRoleDto) throws ServiceException {
		if (UtilHelper.isEmpty(userRoleDto) || UtilHelper.isEmpty(userRoleDto.getUserId())) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserRole userR = new UserRole();
		userR.setUserId(userRoleDto.getUserId());
		userRoleMapper.deleteByProperty(userR);
		if (!UtilHelper.isEmpty(userRoleDto.getRoleIds())) {
			for (Long roleId : userRoleDto.getRoleIds()) {
				UserRole userRole = new UserRole();
				userRole.setUserId(userRoleDto.getUserId());
				userRole.setRoleId(roleId);
				userRole.setIsInactive(1);
				userRole.setCreateBy(userRoleDto.getUserId().toString());
				userRole.setCreateTime(systemDateService.getCurrentDate());
				userRole.setUpdateBy(userRoleDto.getUserId().toString());
				userRole.setUpdateTime(systemDateService.getCurrentDate());
				userRoleMapper.save(userRole);
			}
		}
	}
}
