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

import com.transsion.store.bo.SystemResource;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.SystemResourceFacade;
import com.transsion.store.manager.SystemResourceManager;
import com.transsion.store.service.SystemResourceService;

@Component("systemResourceFacade")
public class SystemResourceFacadeImpl implements SystemResourceFacade {

	private SystemResourceService systemResourceService;
	
	@Autowired
	private SystemResourceManager systemResourceManager;
	
	@Autowired
	public void setSystemResourceService(SystemResourceService systemResourceService)
	{
		this.systemResourceService = systemResourceService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public SystemResource getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return systemResourceService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemResource> list() throws ServiceException
	{
		return systemResourceService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemResource> listByProperty(SystemResource systemResource)
			throws ServiceException
	{
		return systemResourceService.listByProperty(systemResource);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<SystemResource> listPaginationByProperty(Pagination<SystemResource> pagination, SystemResource systemResource)
			throws ServiceException
	{
		return systemResourceService.listPaginationByProperty(pagination, systemResource);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return systemResourceService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		systemResourceService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param systemResource
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(SystemResource systemResource) throws ServiceException
	{
		return systemResourceService.deleteByProperty(systemResource);
	}

	/**
	 * 保存记录
	 * @param systemResource
	 * @return
	 * @throws ServiceException
	 */
	public void save(String token,SystemResource systemResource) throws ServiceException
	{
		systemResourceManager.save(token,systemResource);
	}

	/**
	 * 更新记录
	 * @param systemResource
	 * @return
	 * @throws ServiceException
	 */
	public int update(String token,SystemResource systemResource) throws ServiceException
	{
		return systemResourceManager.update(token,systemResource);
	}

	/**
	 * 根据条件查询记录条数
	 * @param systemResource
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(SystemResource systemResource) throws ServiceException
	{
		return systemResourceService.findByCount(systemResource);
	}
	
	/**
	 * 获取所有资源
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemResource> getAllResource() throws ServiceException{
		return systemResourceManager.getAllResource();
	}	
	
	/**
	* 根据roleId查询资源
	* @return
	* @throws ServiceException
	*/
	public List<SystemResource> findResByRoleId(Long roleId) throws ServiceException {
		return systemResourceManager.findResByRoleId(roleId);
	}

	/**
	 * 根据资源类型及用户token获取用户拥有的资源列表
	 * @param type
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public List<String> getResourcesByUser(String type, String token) throws ServiceException {
		return systemResourceManager.getResourcesByUser(type, token);
	}
}
