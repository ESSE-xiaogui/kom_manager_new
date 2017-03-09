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

import com.transsion.store.bo.AreaRegion;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.AreaRegionMapper;

@Service("areaRegionService")
public class AreaRegionService {

	private AreaRegionMapper	areaRegionMapper;

	@Autowired
	public void setAreaRegionMapper(AreaRegionMapper areaRegionMapper)
	{
		this.areaRegionMapper = areaRegionMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public AreaRegion getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return areaRegionMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<AreaRegion> list() throws ServiceException
	{
		return areaRegionMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<AreaRegion> listByProperty(AreaRegion areaRegion)
			throws ServiceException
	{
		return areaRegionMapper.listByProperty(areaRegion);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<AreaRegion> listPaginationByProperty(Pagination<AreaRegion> pagination, AreaRegion areaRegion)
			throws ServiceException
	{
		List<AreaRegion> list = areaRegionMapper.listPaginationByProperty(pagination, areaRegion, pagination.getOrderBy());
		
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
		return areaRegionMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		areaRegionMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param areaRegion
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(AreaRegion areaRegion) throws ServiceException
	{
		return areaRegionMapper.deleteByProperty(areaRegion);
	}

	/**
	 * 保存记录
	 * @param areaRegion
	 * @return
	 * @throws ServiceException
	 */
	public void save(AreaRegion areaRegion) throws ServiceException
	{
		areaRegionMapper.save(areaRegion);
	}

	/**
	 * 更新记录
	 * @param areaRegion
	 * @return
	 * @throws ServiceException
	 */
	public int update(AreaRegion areaRegion) throws ServiceException
	{
		return areaRegionMapper.update(areaRegion);
	}

	/**
	 * 保存或更新记录
	 * @param areaRegion
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(AreaRegion areaRegion) throws ServiceException {
		return areaRegionMapper.saveOrUpdate(areaRegion);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<AreaRegion> list) throws ServiceException {
		return areaRegionMapper.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param areaRegion
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(AreaRegion areaRegion) throws ServiceException
	{
		return areaRegionMapper.findByCount(areaRegion);
	}
}