/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:39
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

import com.transsion.store.bo.Stock;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.StockMapper;

@Service("stockService")
public class StockService {

	private StockMapper	stockMapper;

	@Autowired
	public void setStockMapper(StockMapper stockMapper)
	{
		this.stockMapper = stockMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Stock getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return stockMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Stock> list() throws ServiceException
	{
		return stockMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Stock> listByProperty(Stock stock)
			throws ServiceException
	{
		return stockMapper.listByProperty(stock);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Stock> listPaginationByProperty(Pagination<Stock> pagination, Stock stock)
			throws ServiceException
	{
		List<Stock> list = stockMapper.listPaginationByProperty(pagination, stock, pagination.getOrderBy());
		
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
		return stockMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		stockMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param stock
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Stock stock) throws ServiceException
	{
		return stockMapper.deleteByProperty(stock);
	}

	/**
	 * 保存记录
	 * @param stock
	 * @return
	 * @throws ServiceException
	 */
	public void save(Stock stock) throws ServiceException
	{
		stockMapper.save(stock);
	}

	/**
	 * 更新记录
	 * @param stock
	 * @return
	 * @throws ServiceException
	 */
	public int update(Stock stock) throws ServiceException
	{
		return stockMapper.update(stock);
	}

	/**
	 * 根据条件查询记录条数
	 * @param stock
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Stock stock) throws ServiceException
	{
		return stockMapper.findByCount(stock);
	}
}