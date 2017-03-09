/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-9 15:06:14
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

import com.transsion.store.bo.Area;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.AreaFacade;
import com.transsion.store.service.AreaService;

@Component("areaFacade")
public class AreaFacadeImpl implements AreaFacade {

	private AreaService areaService;
	
	@Autowired
	public void setAreaService(AreaService areaService)
	{
		this.areaService = areaService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Area getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return areaService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Area> list() throws ServiceException
	{
		return areaService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Area> listByProperty(Area area)
			throws ServiceException
	{
		return areaService.listByProperty(area);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Area> listPaginationByProperty(Pagination<Area> pagination, Area area)
			throws ServiceException
	{
		return areaService.listPaginationByProperty(pagination, area);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return areaService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		areaService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Area area) throws ServiceException
	{
		return areaService.deleteByProperty(area);
	}

	/**
	 * 保存记录
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public void save(Area area) throws ServiceException
	{
		areaService.save(area);
	}

	/**
	 * 更新记录
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public int update(Area area) throws ServiceException
	{
		return areaService.update(area);
	}

	/**
	 * 保存或更新记录
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(Area area) throws ServiceException {
		return areaService.saveOrUpdate(area);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<Area> list) throws ServiceException {
		return areaService.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Area area) throws ServiceException
	{
		return areaService.findByCount(area);
	}
}
