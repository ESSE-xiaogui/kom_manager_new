/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:37
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

import com.transsion.store.bo.RoleMenu;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.RoleMenuMapper;

@Service("roleMenuService")
public class RoleMenuService {

	private RoleMenuMapper	roleMenuMapper;

	@Autowired
	public void setRoleMenuMapper(RoleMenuMapper roleMenuMapper)
	{
		this.roleMenuMapper = roleMenuMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public RoleMenu getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return roleMenuMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<RoleMenu> list() throws ServiceException
	{
		return roleMenuMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<RoleMenu> listByProperty(RoleMenu roleMenu)
			throws ServiceException
	{
		return roleMenuMapper.listByProperty(roleMenu);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<RoleMenu> listPaginationByProperty(Pagination<RoleMenu> pagination, RoleMenu roleMenu)
			throws ServiceException
	{
		List<RoleMenu> list = roleMenuMapper.listPaginationByProperty(pagination, roleMenu, pagination.getOrderBy());
		
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
		return roleMenuMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		roleMenuMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param roleMenu
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(RoleMenu roleMenu) throws ServiceException
	{
		return roleMenuMapper.deleteByProperty(roleMenu);
	}

	/**
	 * 保存记录
	 * @param roleMenu
	 * @return
	 * @throws ServiceException
	 */
	public void save(RoleMenu roleMenu) throws ServiceException
	{
		roleMenuMapper.save(roleMenu);
	}

	/**
	 * 更新记录
	 * @param roleMenu
	 * @return
	 * @throws ServiceException
	 */
	public int update(RoleMenu roleMenu) throws ServiceException
	{
		return roleMenuMapper.update(roleMenu);
	}

	/**
	 * 根据条件查询记录条数
	 * @param roleMenu
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(RoleMenu roleMenu) throws ServiceException
	{
		return roleMenuMapper.findByCount(roleMenu);
	}
	
}