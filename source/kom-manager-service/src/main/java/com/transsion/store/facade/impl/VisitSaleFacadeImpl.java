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
import com.transsion.store.bo.VisitSale;
import com.transsion.store.dto.VisitSaleInfoDto;
import com.transsion.store.facade.VisitSaleFacade;
import com.transsion.store.manager.VisitSaleManager;
import com.transsion.store.service.VisitSaleService;

@Component("visitSaleFacade")
public class VisitSaleFacadeImpl implements VisitSaleFacade {

	private VisitSaleService visitSaleService;
	
	@Autowired
	private VisitSaleManager visitSaleManager;
	
	@Autowired
	public void setVisitSaleService(VisitSaleService visitSaleService)
	{
		this.visitSaleService = visitSaleService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitSale getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitSaleService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitSale> list() throws ServiceException
	{
		return visitSaleService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitSale> listByProperty(VisitSale visitSale)
			throws ServiceException
	{
		return visitSaleService.listByProperty(visitSale);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitSaleInfoDto> listPaginationByProperty(Pagination<VisitSaleInfoDto> pagination, VisitSaleInfoDto visitSaleInfoDto,String token)
			throws ServiceException
	{
		return visitSaleService.listPaginationByProperty(pagination, visitSaleInfoDto,token);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitSaleService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitSaleService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitSale
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitSale visitSale) throws ServiceException
	{
		return visitSaleService.deleteByProperty(visitSale);
	}

	/**
	 * 保存记录
	 * @param visitSale
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitSale visitSale) throws ServiceException
	{
		visitSaleService.save(visitSale);
	}

	/**
	 * 更新记录
	 * @param visitSale
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitSale visitSale) throws ServiceException
	{
		return visitSaleService.update(visitSale);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitSale
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitSale visitSale) throws ServiceException
	{
		return visitSaleService.findByCount(visitSale);
	}

	
	public byte[] getVisitSaleByExcel(VisitSaleInfoDto visitSaleInfoDto) throws ServiceException {
		return visitSaleManager.getVisitSaleByExcel(visitSaleInfoDto);
	}
}
