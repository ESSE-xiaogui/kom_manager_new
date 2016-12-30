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
import com.transsion.store.bo.SystemResource;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.SystemResourceMapper;

@Service("systemResourceService")
public class SystemResourceService {

	private SystemResourceMapper	systemResourceMapper;

	@Autowired
	public void setSystemResourceMapper(SystemResourceMapper systemResourceMapper)
	{
		this.systemResourceMapper = systemResourceMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public SystemResource getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return systemResourceMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemResource> list() throws ServiceException
	{
		return systemResourceMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemResource> listByProperty(SystemResource systemResource)
			throws ServiceException
	{
		return systemResourceMapper.listByProperty(systemResource);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<SystemResource> listPaginationByProperty(Pagination<SystemResource> pagination, SystemResource systemResource)
			throws ServiceException
	{
		List<SystemResource> list = systemResourceMapper.listPaginationByProperty(pagination, systemResource, pagination.getOrderBy());
		
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
		return systemResourceMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		systemResourceMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param systemResource
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(SystemResource systemResource) throws ServiceException
	{
		return systemResourceMapper.deleteByProperty(systemResource);
	}

	/**
	 * 保存记录
	 * @param systemResource
	 * @return
	 * @throws ServiceException
	 */
	public void save(SystemResource systemResource) throws ServiceException
	{
		systemResourceMapper.save(systemResource);
	}

	/**
	 * 更新记录
	 * @param systemResource
	 * @return
	 * @throws ServiceException
	 */
	public int update(SystemResource systemResource) throws ServiceException
	{
		return systemResourceMapper.update(systemResource);
	}

	/**
	 * 根据条件查询记录条数
	 * @param systemResource
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(SystemResource systemResource) throws ServiceException
	{
		return systemResourceMapper.findByCount(systemResource);
	}
}