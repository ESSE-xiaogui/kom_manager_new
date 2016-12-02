package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.SystemRole;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.SystemRoleResponseDto;
import com.transsion.store.mapper.SystemRoleMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("systemRoleManager")
public class SystemRoleManager {
	@Autowired
	private SystemRoleMapper systemRoleMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	/**
	 * 查询用户角色
	 * */
	public List<SystemRoleResponseDto> findSystemRoleByUser(Integer userId) throws ServiceException{
		if(UtilHelper.isEmpty(userId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		return systemRoleMapper.findSystemRoleByUser(userId);
	}
	/**
	 * 查询所有角色
	 * */
	public List<SystemRoleResponseDto> findSystemRole() throws ServiceException{
		return systemRoleMapper.findSystemRole();
	}
	/**
	 * 角色权限停用
	 * */
	public SystemRoleResponseDto updateRoleStatus(String token,Long roleId,Integer isInactive) 
			throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(roleId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		
		SystemRole formerRole = systemRoleMapper.getByPK(roleId);
		formerRole.setIsInactive(isInactive);
		formerRole.setUpdatedBy(userContext.getUser().getUserCode());
		formerRole.setUpdateTime(systemDateService.getCurrentDate());
		systemRoleMapper.update(formerRole);
		SystemRoleResponseDto srd = new SystemRoleResponseDto();
		srd.setStatus(1);
		return srd;
	}
	
	/**
	 * 根据条件查询所有角色
	 * */
	public List<SystemRoleResponseDto> findRole(SystemRole systemRole) throws ServiceException{
		return systemRoleMapper.findRole(systemRole);
	}
	
	/**
	 * 新增角色
	 * @param systemRole
	 * @return
	 * @throws ServiceException
	 */
	public SystemRoleResponseDto save(String token,SystemRole systemRole) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		
		SystemRole tempRole = new SystemRole();
		tempRole.setRoleCode(systemRole.getRoleCode());
		int count = systemRoleMapper.findByCount(tempRole);
		if(count>0){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_ROLECODE_IS_DUPLICATE);
		}else{
			systemRole.setCreatedBy(userContext.getUser().getUserCode());
			systemRole.setCreateTime(systemDateService.getCurrentDate());
			systemRoleMapper.save(systemRole);
			SystemRoleResponseDto srrd = new SystemRoleResponseDto();
			srrd.setStatus(1);
			return srrd;
		}
	}
	
	/**
	 * 更新记录
	 * @param systemRole
	 * @return
	 * @throws ServiceException
	 */
	public SystemRoleResponseDto update(String token,SystemRole systemRole) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		
		SystemRole tempRole = new SystemRole();
		tempRole.setRoleCode(systemRole.getRoleCode());
		int count1 = systemRoleMapper.findByCount(tempRole);
		tempRole.setRoleId(systemRole.getRoleId());
		int count2 = systemRoleMapper.findByCount(tempRole);
		if(count1>0 && count2<1){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_ROLECODE_IS_DUPLICATE);			
		}
		
		SystemRole formerRole = systemRoleMapper.getByPK(systemRole.getRoleId());
		formerRole.setRoleName(systemRole.getRoleName());
		formerRole.setRoleCode(systemRole.getRoleCode());
		formerRole.setIsInactive(systemRole.getIsInactive());
		formerRole.setRemark(systemRole.getRemark());
		formerRole.setUpdatedBy(userContext.getUser().getUserCode());
		formerRole.setUpdateTime(systemDateService.getCurrentDate());
		systemRoleMapper.update(formerRole);
		SystemRoleResponseDto srrd = new SystemRoleResponseDto();
		srrd.setStatus(1);
		return srrd;
	}
}
