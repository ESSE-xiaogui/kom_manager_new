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

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.SaleItem;
import com.transsion.store.facade.SaleItemFacade;
import com.transsion.store.service.SaleItemService;

@Component("saleItemFacade")
public class SaleItemFacadeImpl implements SaleItemFacade {

	private SaleItemService saleItemService;
	
	@Autowired
	public void setSaleItemService(SaleItemService saleItemService)
	{
		this.saleItemService = saleItemService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public SaleItem getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return saleItemService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SaleItem> list() throws ServiceException
	{
		return saleItemService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SaleItem> listByProperty(SaleItem saleItem)
			throws ServiceException
	{
		return saleItemService.listByProperty(saleItem);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<SaleItem> listPaginationByProperty(Pagination<SaleItem> pagination, SaleItem saleItem)
			throws ServiceException
	{
		return saleItemService.listPaginationByProperty(pagination, saleItem);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return saleItemService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		saleItemService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param saleItem
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(SaleItem saleItem) throws ServiceException
	{
		return saleItemService.deleteByProperty(saleItem);
	}

	/**
	 * 保存记录
	 * @param saleItem
	 * @return
	 * @throws ServiceException
	 */
	public void save(SaleItem saleItem) throws ServiceException
	{
		saleItemService.save(saleItem);
	}

	/**
	 * 更新记录
	 * @param saleItem
	 * @return
	 * @throws ServiceException
	 */
	public int update(SaleItem saleItem) throws ServiceException
	{
		return saleItemService.update(saleItem);
	}

	/**
	 * 根据条件查询记录条数
	 * @param saleItem
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(SaleItem saleItem) throws ServiceException
	{
		return saleItemService.findByCount(saleItem);
	}
}
