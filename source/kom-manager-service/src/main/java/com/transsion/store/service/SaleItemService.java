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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.SaleItem;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.SaleItemMapper;

@Service("saleItemService")
public class SaleItemService {

	private SaleItemMapper	saleItemMapper;

	@Autowired
	public void setSaleItemMapper(SaleItemMapper saleItemMapper)
	{
		this.saleItemMapper = saleItemMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public SaleItem getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return saleItemMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SaleItem> list() throws ServiceException
	{
		return saleItemMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SaleItem> listByProperty(SaleItem saleItem)
			throws ServiceException
	{
		return saleItemMapper.listByProperty(saleItem);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<SaleItem> listPaginationByProperty(Pagination<SaleItem> pagination, SaleItem saleItem)
			throws ServiceException
	{
		List<SaleItem> list = saleItemMapper.listPaginationByProperty(pagination, saleItem, pagination.getOrderBy());
		
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
		return saleItemMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		saleItemMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param saleItem
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(SaleItem saleItem) throws ServiceException
	{
		return saleItemMapper.deleteByProperty(saleItem);
	}

	/**
	 * 保存记录
	 * @param saleItem
	 * @return
	 * @throws ServiceException
	 */
	public void save(SaleItem saleItem) throws ServiceException
	{
		saleItemMapper.save(saleItem);
	}

	/**
	 * 更新记录
	 * @param saleItem
	 * @return
	 * @throws ServiceException
	 */
	public int update(SaleItem saleItem) throws ServiceException
	{
		return saleItemMapper.update(saleItem);
	}

	/**
	 * 根据条件查询记录条数
	 * @param saleItem
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(SaleItem saleItem) throws ServiceException
	{
		return saleItemMapper.findByCount(saleItem);
	}
	
	public List<String> queryImeiNoList(List<String> imeiList) {
		return saleItemMapper.queryImeiNoList(imeiList);
	}
}