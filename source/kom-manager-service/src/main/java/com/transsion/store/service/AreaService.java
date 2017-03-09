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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.Area;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.AreaMapper;

@Service("areaService")
public class AreaService {

	private AreaMapper	areaMapper;

	@Autowired
	public void setAreaMapper(AreaMapper areaMapper)
	{
		this.areaMapper = areaMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Area getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return areaMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Area> list() throws ServiceException
	{
		return areaMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Area> listByProperty(Area area)
			throws ServiceException
	{
		return areaMapper.listByProperty(area);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Area> listPaginationByProperty(Pagination<Area> pagination, Area area)
			throws ServiceException
	{
		List<Area> list = areaMapper.listPaginationByProperty(pagination, area, pagination.getOrderBy());
		
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
		return areaMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		areaMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Area area) throws ServiceException
	{
		return areaMapper.deleteByProperty(area);
	}

	/**
	 * 保存记录
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public void save(Area area) throws ServiceException
	{
		areaMapper.save(area);
	}

	/**
	 * 更新记录
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public int update(Area area) throws ServiceException
	{
		return areaMapper.update(area);
	}

	/**
	 * 保存或更新记录
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(Area area) throws ServiceException {
		return areaMapper.saveOrUpdate(area);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<Area> list) throws ServiceException {
		return areaMapper.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Area area) throws ServiceException
	{
		return areaMapper.findByCount(area);
	}
}