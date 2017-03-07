/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-7 11:42:41
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

import com.transsion.store.bo.ReportSaleDaily;
import com.transsion.store.dto.ReportSaleDailyDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.ReportSaleDailyFacade;
import com.transsion.store.service.ReportSaleDailyService;

@Component("reportSaleDailyFacade")
public class ReportSaleDailyFacadeImpl implements ReportSaleDailyFacade {

	private ReportSaleDailyService reportSaleDailyService;
	
	@Autowired
	public void setReportSaleDailyService(ReportSaleDailyService reportSaleDailyService)
	{
		this.reportSaleDailyService = reportSaleDailyService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ReportSaleDaily getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return reportSaleDailyService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ReportSaleDaily> list() throws ServiceException
	{
		return reportSaleDailyService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ReportSaleDaily> listByProperty(ReportSaleDaily reportSaleDaily)
			throws ServiceException
	{
		return reportSaleDailyService.listByProperty(reportSaleDaily);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ReportSaleDailyDto> listPaginationByProperty(Pagination<ReportSaleDailyDto> pagination, ReportSaleDailyDto reportSaleDailyDto)
			throws ServiceException
	{
		return reportSaleDailyService.listPaginationByProperty(pagination, reportSaleDailyDto);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return reportSaleDailyService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		reportSaleDailyService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param reportSaleDaily
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ReportSaleDaily reportSaleDaily) throws ServiceException
	{
		return reportSaleDailyService.deleteByProperty(reportSaleDaily);
	}

	/**
	 * 保存记录
	 * @param reportSaleDaily
	 * @return
	 * @throws ServiceException
	 */
	public void save(ReportSaleDaily reportSaleDaily) throws ServiceException
	{
		reportSaleDailyService.save(reportSaleDaily);
	}

	/**
	 * 更新记录
	 * @param reportSaleDaily
	 * @return
	 * @throws ServiceException
	 */
	public int update(ReportSaleDaily reportSaleDaily) throws ServiceException
	{
		return reportSaleDailyService.update(reportSaleDaily);
	}

	/**
	 * 保存或更新记录
	 * @param reportSaleDaily
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(ReportSaleDaily reportSaleDaily) throws ServiceException {
		return reportSaleDailyService.saveOrUpdate(reportSaleDaily);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<ReportSaleDaily> list) throws ServiceException {
		return reportSaleDailyService.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param reportSaleDaily
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ReportSaleDaily reportSaleDaily) throws ServiceException
	{
		return reportSaleDailyService.findByCount(reportSaleDaily);
	}
}
