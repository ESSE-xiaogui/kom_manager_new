package com.transsion.store.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.UserRole;
import com.transsion.store.dto.UserRoleDto;
import com.transsion.store.mapper.UserRoleMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;

@Service("userRoleManager")
public class UserRoleManager {
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	/**
	 * 用户角色权限绑定
	 * @throws ServiceException
	 * */
	public void addUserRole(UserRoleDto userRoleDto) throws ServiceException{
		if(UtilHelper.isEmpty(userRoleDto) || UtilHelper.isEmpty(userRoleDto.getUserId())
				|| UtilHelper.isEmpty(userRoleDto.getRoleIds())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserRole userR = new UserRole();
		userR.setRoleId(userRoleDto.getUserId());
		userRoleMapper.deleteByProperty(userR);
		for(Long roleId:userRoleDto.getRoleIds()){
			UserRole userRole = new UserRole();
			userRole.setUserId(userRoleDto.getUserId());
			userRole.setRoleId(roleId);
			userRole.setIsInactive(0);
			userRole.setCreateBy(userRoleDto.getUserId().toString());
			userRole.setCreateTime(systemDateService.getCurrentDate());
			userRole.setUpdateBy(userRoleDto.getUserId().toString());
			userRole.setUpdateTime(systemDateService.getCurrentDate());
			userRoleMapper.save(userRole);
		}
	}
}
