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

import com.transsion.store.bo.RoleResource;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.RoleResourceMapper;

@Service("roleResourceService")
public class RoleResourceService {

	private RoleResourceMapper	roleResourceMapper;

	@Autowired
	public void setRoleResourceMapper(RoleResourceMapper roleResourceMapper)
	{
		this.roleResourceMapper = roleResourceMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public RoleResource getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return roleResourceMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<RoleResource> list() throws ServiceException
	{
		return roleResourceMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<RoleResource> listByProperty(RoleResource roleResource)
			throws ServiceException
	{
		return roleResourceMapper.listByProperty(roleResource);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<RoleResource> listPaginationByProperty(Pagination<RoleResource> pagination, RoleResource roleResource)
			throws ServiceException
	{
		List<RoleResource> list = roleResourceMapper.listPaginationByProperty(pagination, roleResource, pagination.getOrderBy());
		
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
		return roleResourceMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		roleResourceMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param roleResource
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(RoleResource roleResource) throws ServiceException
	{
		return roleResourceMapper.deleteByProperty(roleResource);
	}

	/**
	 * 保存记录
	 * @param roleResource
	 * @return
	 * @throws ServiceException
	 */
	public void save(RoleResource roleResource) throws ServiceException
	{
		roleResourceMapper.save(roleResource);
	}

	/**
	 * 更新记录
	 * @param roleResource
	 * @return
	 * @throws ServiceException
	 */
	public int update(RoleResource roleResource) throws ServiceException
	{
		return roleResourceMapper.update(roleResource);
	}

	/**
	 * 根据条件查询记录条数
	 * @param roleResource
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(RoleResource roleResource) throws ServiceException
	{
		return roleResourceMapper.findByCount(roleResource);
	}
}