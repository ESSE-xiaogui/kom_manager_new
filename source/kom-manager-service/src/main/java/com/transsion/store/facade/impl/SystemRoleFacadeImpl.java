/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:40
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transsion.store.bo.SystemRole;
import com.transsion.store.dto.SystemRoleResponseDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.SystemRoleFacade;
import com.transsion.store.manager.SystemRoleManager;
import com.transsion.store.service.SystemRoleService;

@Component("systemRoleFacade")
public class SystemRoleFacadeImpl implements SystemRoleFacade {

	private SystemRoleService systemRoleService;
	
	@Autowired
	public void setSystemRoleService(SystemRoleService systemRoleService)
	{
		this.systemRoleService = systemRoleService;
	}
	
	@Autowired
	private SystemRoleManager systemRoleManager;
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public SystemRole getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return systemRoleService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemRole> list() throws ServiceException
	{
		return systemRoleService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemRole> listByProperty(SystemRole systemRole)
			throws ServiceException
	{
		return systemRoleService.listByProperty(systemRole);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<SystemRole> listPaginationByProperty(Pagination<SystemRole> pagination, SystemRole systemRole)
			throws ServiceException
	{
		return systemRoleService.listPaginationByProperty(pagination, systemRole);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return systemRoleService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		systemRoleService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param systemRole
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(SystemRole systemRole) throws ServiceException
	{
		return systemRoleService.deleteByProperty(systemRole);
	}

	/**
	 * 保存记录
	 * @param systemRole
	 * @return
	 * @throws ServiceException
	 */
	public void save(SystemRole systemRole) throws ServiceException
	{
		systemRoleService.save(systemRole);
	}

	/**
	 * 更新记录
	 * @param systemRole
	 * @return
	 * @throws ServiceException
	 */
	public int update(SystemRole systemRole) throws ServiceException
	{
		return systemRoleService.update(systemRole);
	}

	/**
	 * 根据条件查询记录条数
	 * @param systemRole
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(SystemRole systemRole) throws ServiceException
	{
		return systemRoleService.findByCount(systemRole);
	}
	/**
	 * 查询用户角色
	 * */
	public List<SystemRoleResponseDto> findSystemRoleByUser(String token) throws ServiceException{
		return systemRoleManager.findSystemRoleByUser(token);
	}
	/**
	 * 查询所有角色
	 * */
	public List<SystemRoleResponseDto> findSystemRole() throws ServiceException{
		return systemRoleManager.findSystemRole();
	}
	/**
	 * 角色权限停用
	 * */
	public SystemRoleResponseDto updateRoleStatus(String token,Long roleId,Integer isInactive) 
			throws ServiceException{
		return systemRoleManager.updateRoleStatus(token, roleId, isInactive);
	}
}
