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

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.RoleResource;
import com.transsion.store.dto.RoleResourceDto;
import com.transsion.store.facade.RoleResourceFacade;
import com.transsion.store.manager.RoleResourceManager;
import com.transsion.store.service.RoleResourceService;

@Component("roleResourceFacade")
public class RoleResourceFacadeImpl implements RoleResourceFacade {

	private RoleResourceService roleResourceService;
	
	@Autowired
	private RoleResourceManager roleResourceManager;
	
	@Autowired
	public void setRoleResourceService(RoleResourceService roleResourceService)
	{
		this.roleResourceService = roleResourceService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public RoleResource getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return roleResourceService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<RoleResource> list() throws ServiceException
	{
		return roleResourceService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<RoleResource> listByProperty(RoleResource roleResource)
			throws ServiceException
	{
		return roleResourceService.listByProperty(roleResource);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<RoleResource> listPaginationByProperty(Pagination<RoleResource> pagination, RoleResource roleResource)
			throws ServiceException
	{
		return roleResourceService.listPaginationByProperty(pagination, roleResource);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return roleResourceService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		roleResourceService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param roleResource
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(RoleResource roleResource) throws ServiceException
	{
		return roleResourceService.deleteByProperty(roleResource);
	}

	/**
	 * 保存记录
	 * @param roleResource
	 * @return
	 * @throws ServiceException
	 */
	public void save(RoleResource roleResource) throws ServiceException
	{
		roleResourceService.save(roleResource);
	}

	/**
	 * 更新记录
	 * @param roleResource
	 * @return
	 * @throws ServiceException
	 */
	public int update(RoleResource roleResource) throws ServiceException
	{
		return roleResourceService.update(roleResource);
	}

	/**
	 * 根据条件查询记录条数
	 * @param roleResource
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(RoleResource roleResource) throws ServiceException
	{
		return roleResourceService.findByCount(roleResource);
	}
	
	/**
	* 新增资源角色
	* @return
	* @throws ServiceException
	*/
	public void saveResRole(String token,RoleResourceDto roleResourceDto) throws ServiceException {
		roleResourceManager.saveResRole(token,roleResourceDto);
	}
}
