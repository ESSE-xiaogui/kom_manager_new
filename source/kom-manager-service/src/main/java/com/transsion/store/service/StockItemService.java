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

import com.transsion.store.bo.StockItem;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.StockItemMapper;

@Service("stockItemService")
public class StockItemService {

	private StockItemMapper	stockItemMapper;

	@Autowired
	public void setStockItemMapper(StockItemMapper stockItemMapper)
	{
		this.stockItemMapper = stockItemMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public StockItem getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return stockItemMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<StockItem> list() throws ServiceException
	{
		return stockItemMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<StockItem> listByProperty(StockItem stockItem)
			throws ServiceException
	{
		return stockItemMapper.listByProperty(stockItem);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<StockItem> listPaginationByProperty(Pagination<StockItem> pagination, StockItem stockItem)
			throws ServiceException
	{
		List<StockItem> list = stockItemMapper.listPaginationByProperty(pagination, stockItem, pagination.getOrderBy());
		
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
		return stockItemMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		stockItemMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param stockItem
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(StockItem stockItem) throws ServiceException
	{
		return stockItemMapper.deleteByProperty(stockItem);
	}

	/**
	 * 保存记录
	 * @param stockItem
	 * @return
	 * @throws ServiceException
	 */
	public void save(StockItem stockItem) throws ServiceException
	{
		stockItemMapper.save(stockItem);
	}

	/**
	 * 更新记录
	 * @param stockItem
	 * @return
	 * @throws ServiceException
	 */
	public int update(StockItem stockItem) throws ServiceException
	{
		return stockItemMapper.update(stockItem);
	}

	/**
	 * 根据条件查询记录条数
	 * @param stockItem
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(StockItem stockItem) throws ServiceException
	{
		return stockItemMapper.findByCount(stockItem);
	}
}