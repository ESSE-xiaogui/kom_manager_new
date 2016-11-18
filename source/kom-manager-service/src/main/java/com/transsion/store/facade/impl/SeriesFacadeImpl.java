/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:38
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

import com.transsion.store.bo.Series;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.SeriesFacade;
import com.transsion.store.service.SeriesService;

@Component("seriesFacade")
public class SeriesFacadeImpl implements SeriesFacade {

	private SeriesService seriesService;
	
	@Autowired
	public void setSeriesService(SeriesService seriesService)
	{
		this.seriesService = seriesService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Series getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return seriesService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Series> list() throws ServiceException
	{
		return seriesService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Series> listByProperty(Series series)
			throws ServiceException
	{
		return seriesService.listByProperty(series);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Series> listPaginationByProperty(Pagination<Series> pagination, Series series)
			throws ServiceException
	{
		return seriesService.listPaginationByProperty(pagination, series);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return seriesService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		seriesService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param series
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Series series) throws ServiceException
	{
		return seriesService.deleteByProperty(series);
	}

	/**
	 * 保存记录
	 * @param series
	 * @return
	 * @throws ServiceException
	 */
	public void save(Series series) throws ServiceException
	{
		seriesService.save(series);
	}

	/**
	 * 更新记录
	 * @param series
	 * @return
	 * @throws ServiceException
	 */
	public int update(Series series) throws ServiceException
	{
		return seriesService.update(series);
	}

	/**
	 * 根据条件查询记录条数
	 * @param series
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Series series) throws ServiceException
	{
		return seriesService.findByCount(series);
	}
}
