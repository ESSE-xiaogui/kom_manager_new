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
package com.transsion.store.facade.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transsion.store.bo.RoleMenu;
import com.transsion.store.dto.RoleMenuDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.RoleMenuFacade;
import com.transsion.store.manager.RoleMenuManager;
import com.transsion.store.service.RoleMenuService;

@Component("roleMenuFacade")
public class RoleMenuFacadeImpl implements RoleMenuFacade {

	private RoleMenuService roleMenuService;
	
	@Autowired
	private RoleMenuManager roleMenuManager;
	
	@Autowired
	public void setRoleMenuService(RoleMenuService roleMenuService)
	{
		this.roleMenuService = roleMenuService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public RoleMenu getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return roleMenuService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<RoleMenu> list() throws ServiceException
	{
		return roleMenuService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<RoleMenu> listByProperty(RoleMenu roleMenu)
			throws ServiceException
	{
		return roleMenuService.listByProperty(roleMenu);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<RoleMenu> listPaginationByProperty(Pagination<RoleMenu> pagination, RoleMenu roleMenu)
			throws ServiceException
	{
		return roleMenuService.listPaginationByProperty(pagination, roleMenu);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return roleMenuService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		roleMenuService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param roleMenu
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(RoleMenu roleMenu) throws ServiceException
	{
		return roleMenuService.deleteByProperty(roleMenu);
	}

	/**
	 * 保存记录
	 * @param roleMenu
	 * @return
	 * @throws ServiceException
	 */
	public void save(RoleMenu roleMenu) throws ServiceException
	{
		roleMenuService.save(roleMenu);
	}

	/**
	 * 更新记录
	 * @param roleMenu
	 * @return
	 * @throws ServiceException
	 */
	public int update(RoleMenu roleMenu) throws ServiceException
	{
		return roleMenuService.update(roleMenu);
	}

	/**
	 * 根据条件查询记录条数
	 * @param roleMenu
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(RoleMenu roleMenu) throws ServiceException
	{
		return roleMenuService.findByCount(roleMenu);
	}
	
	/**
	* 新增菜单角色
	* @return
	* @throws ServiceException
	*/ 
	public void addMenuRole(String token,RoleMenuDto roleMenuDto) throws ServiceException {
		roleMenuManager.addMenuRole(token,roleMenuDto);
	}
}
