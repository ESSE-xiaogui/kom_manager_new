/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-2-21 10:24:48
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
import com.transsion.store.bo.VisitStock;
import com.transsion.store.dto.VisitStockDetailDto;
import com.transsion.store.facade.VisitStockFacade;
import com.transsion.store.manager.VisitStockManager;
import com.transsion.store.service.VisitStockService;

@Component("visitStockFacade")
public class VisitStockFacadeImpl implements VisitStockFacade {

	private VisitStockService visitStockService;
	@Autowired
	private VisitStockManager visitStockManager;
	
	@Autowired
	public void setVisitStockService(VisitStockService visitStockService)
	{
		this.visitStockService = visitStockService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitStock getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitStockService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitStock> list() throws ServiceException
	{
		return visitStockService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitStock> listByProperty(VisitStock visitStock)
			throws ServiceException
	{
		return visitStockService.listByProperty(visitStock);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitStockDetailDto> listPaginationByProperty(Pagination<VisitStockDetailDto> pagination, VisitStockDetailDto visitStockDetailDto,String token)
			throws ServiceException
	{
		return visitStockService.listPaginationByProperty(pagination, visitStockDetailDto,token);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitStockService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitStockService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitStock
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitStock visitStock) throws ServiceException
	{
		return visitStockService.deleteByProperty(visitStock);
	}

	/**
	 * 保存记录
	 * @param visitStock
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitStock visitStock) throws ServiceException
	{
		visitStockService.save(visitStock);
	}

	/**
	 * 更新记录
	 * @param visitStock
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitStock visitStock) throws ServiceException
	{
		return visitStockService.update(visitStock);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitStock
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitStock visitStock) throws ServiceException
	{
		return visitStockService.findByCount(visitStock);
	}

	@Override
	public List<VisitStockDetailDto> queryVisitStockList() throws ServiceException {
		return visitStockService.queryVisitStockList();
	}

	/**
	 * 重点机型库存导出Excel
	 */
	@Override
	public byte[] getVisitStockByExcel(VisitStockDetailDto visitStockDetailDto) throws ServiceException {
		return visitStockManager.getVisitStockByExcel(visitStockDetailDto);
	}
}
