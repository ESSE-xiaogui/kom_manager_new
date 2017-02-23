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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.VisitStock;
import com.transsion.store.dto.VisitStockDetailDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.VisitStockMapper;

@Service("visitStockService")
public class VisitStockService {

	private VisitStockMapper	visitStockMapper;

	@Autowired
	public void setVisitStockMapper(VisitStockMapper visitStockMapper)
	{
		this.visitStockMapper = visitStockMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitStock getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitStockMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitStock> list() throws ServiceException
	{
		return visitStockMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitStock> listByProperty(VisitStock visitStock)
			throws ServiceException
	{
		return visitStockMapper.listByProperty(visitStock);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitStockDetailDto> listPaginationByProperty(Pagination<VisitStockDetailDto> pagination, VisitStockDetailDto visitStockDetailDto)
			throws ServiceException
	{
		List<VisitStockDetailDto> list = visitStockMapper.listPaginationByProperty(pagination, visitStockDetailDto, pagination.getOrderBy());
		
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
		return visitStockMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitStockMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitStock
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitStock visitStock) throws ServiceException
	{
		return visitStockMapper.deleteByProperty(visitStock);
	}

	/**
	 * 保存记录
	 * @param visitStock
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitStock visitStock) throws ServiceException
	{
		visitStockMapper.save(visitStock);
	}

	/**
	 * 更新记录
	 * @param visitStock
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitStock visitStock) throws ServiceException
	{
		return visitStockMapper.update(visitStock);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitStock
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitStock visitStock) throws ServiceException
	{
		return visitStockMapper.findByCount(visitStock);
	}
	
	public List<VisitStockDetailDto> queryVisitStockList() throws ServiceException{
		return visitStockMapper.queryVisitStockList();
	}
}