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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.SystemRole;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.SystemRoleMapper;

@Service("systemRoleService")
public class SystemRoleService {

	private SystemRoleMapper	systemRoleMapper;

	@Autowired
	public void setSystemRoleMapper(SystemRoleMapper systemRoleMapper)
	{
		this.systemRoleMapper = systemRoleMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public SystemRole getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return systemRoleMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemRole> list() throws ServiceException
	{
		return systemRoleMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemRole> listByProperty(SystemRole systemRole)
			throws ServiceException
	{
		return systemRoleMapper.listByProperty(systemRole);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<SystemRole> listPaginationByProperty(Pagination<SystemRole> pagination, SystemRole systemRole)
			throws ServiceException
	{
		List<SystemRole> list = systemRoleMapper.listPaginationByProperty(pagination, systemRole, pagination.getOrderBy());
		
		pagination.setResultList(list);
		
		return pagination;
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return systemRoleMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		systemRoleMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param systemRole
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(SystemRole systemRole) throws ServiceException
	{
		return systemRoleMapper.deleteByProperty(systemRole);
	}

	/**
	 * 保存记录
	 * @param systemRole
	 * @return
	 * @throws ServiceException
	 */
	public void save(SystemRole systemRole) throws ServiceException
	{
		systemRoleMapper.save(systemRole);
	}

	/**
	 * 更新记录
	 * @param systemRole
	 * @return
	 * @throws ServiceException
	 */
	public int update(SystemRole systemRole) throws ServiceException
	{
		return systemRoleMapper.update(systemRole);
	}

	/**
	 * 根据条件查询记录条数
	 * @param systemRole
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(SystemRole systemRole) throws ServiceException
	{
		return systemRoleMapper.findByCount(systemRole);
	}
}