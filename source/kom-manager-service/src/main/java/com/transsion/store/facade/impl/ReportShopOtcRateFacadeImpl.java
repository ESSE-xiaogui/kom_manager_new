/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-16 14:43:27
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

import com.transsion.store.bo.ReportShopOtcRate;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.ReportShopOtcRateFacade;
import com.transsion.store.manager.ReportShopOtcRateManager;
import com.transsion.store.service.ReportShopOtcRateService;

@Component("reportShopOtcRateFacade")
public class ReportShopOtcRateFacadeImpl implements ReportShopOtcRateFacade {

	private ReportShopOtcRateService reportShopOtcRateService;
	
	@Autowired
	private ReportShopOtcRateManager reportShopOtcRateManager;
	
	@Autowired
	public void setReportShopOtcRateService(ReportShopOtcRateService reportShopOtcRateService)
	{
		this.reportShopOtcRateService = reportShopOtcRateService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ReportShopOtcRate getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return reportShopOtcRateService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ReportShopOtcRate> list() throws ServiceException
	{
		return reportShopOtcRateService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ReportShopOtcRate> listByProperty(ReportShopOtcRate reportShopOtcRate)
			throws ServiceException
	{
		return reportShopOtcRateService.listByProperty(reportShopOtcRate);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ReportShopOtcRate> listPaginationByProperty(Pagination<ReportShopOtcRate> pagination, ReportShopOtcRate reportShopOtcRate)
			throws ServiceException
	{
		return reportShopOtcRateService.listPaginationByProperty(pagination, reportShopOtcRate);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return reportShopOtcRateService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		reportShopOtcRateService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param reportShopOtcRate
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ReportShopOtcRate reportShopOtcRate) throws ServiceException
	{
		return reportShopOtcRateService.deleteByProperty(reportShopOtcRate);
	}

	/**
	 * 保存记录
	 * @param reportShopOtcRate
	 * @return
	 * @throws ServiceException
	 */
	public void save(ReportShopOtcRate reportShopOtcRate) throws ServiceException
	{
		reportShopOtcRateService.save(reportShopOtcRate);
	}

	/**
	 * 更新记录
	 * @param reportShopOtcRate
	 * @return
	 * @throws ServiceException
	 */
	public int update(ReportShopOtcRate reportShopOtcRate) throws ServiceException
	{
		return reportShopOtcRateService.update(reportShopOtcRate);
	}

	/**
	 * 保存或更新记录
	 * @param reportShopOtcRate
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(ReportShopOtcRate reportShopOtcRate) throws ServiceException {
		return reportShopOtcRateService.saveOrUpdate(reportShopOtcRate);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<ReportShopOtcRate> list) throws ServiceException {
		return reportShopOtcRateService.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param reportShopOtcRate
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ReportShopOtcRate reportShopOtcRate) throws ServiceException
	{
		return reportShopOtcRateService.findByCount(reportShopOtcRate);
	}

	public byte[] queryReportShopOtcRateList(ReportShopOtcRate reportShopOtcRate) throws ServiceException {
		return reportShopOtcRateManager.queryReportShopOtcRateList(reportShopOtcRate);
	}
	
	public Pagination<ReportShopOtcRate> listPgReportShopOtcRateByCity(Pagination<ReportShopOtcRate> pagination, ReportShopOtcRate reportShopOtcRate)
			throws ServiceException
	{
		return reportShopOtcRateService.listPgReportShopOtcRateByCity(pagination, reportShopOtcRate);
	}

	@Override
	public byte[] queryReportShopOtcRateListByCity(ReportShopOtcRate reportShopOtcRate) throws ServiceException {
		return reportShopOtcRateManager.queryReportShopOtcRateListByCity(reportShopOtcRate);
	}
}
