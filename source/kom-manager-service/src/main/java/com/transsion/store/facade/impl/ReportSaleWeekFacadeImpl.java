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

import com.transsion.store.dto.ReportSaleWeek4CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transsion.store.bo.ReportSaleWeek;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.ReportSaleWeekFacade;
import com.transsion.store.manager.ReportSaleWeekManager;
import com.transsion.store.service.ReportSaleWeekService;

@Component("reportSaleWeekFacade")
public class ReportSaleWeekFacadeImpl implements ReportSaleWeekFacade {

	private ReportSaleWeekService reportSaleWeekService;
	
	@Autowired
	private ReportSaleWeekManager reportSaleWeekManager;
	
	@Autowired
	public void setReportSaleWeekService(ReportSaleWeekService reportSaleWeekService)
	{
		this.reportSaleWeekService = reportSaleWeekService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ReportSaleWeek getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return reportSaleWeekService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ReportSaleWeek> list() throws ServiceException
	{
		return reportSaleWeekService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ReportSaleWeek> listByProperty(ReportSaleWeek reportSaleWeek)
			throws ServiceException
	{
		return reportSaleWeekService.listByProperty(reportSaleWeek);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ReportSaleWeek> listPaginationByProperty(Pagination<ReportSaleWeek> pagination, ReportSaleWeek reportSaleWeek)
			throws ServiceException
	{
		return reportSaleWeekService.listPaginationByProperty(pagination, reportSaleWeek);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return reportSaleWeekService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		reportSaleWeekService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ReportSaleWeek reportSaleWeek) throws ServiceException
	{
		return reportSaleWeekService.deleteByProperty(reportSaleWeek);
	}

	/**
	 * 保存记录
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	public void save(ReportSaleWeek reportSaleWeek) throws ServiceException
	{
		reportSaleWeekService.save(reportSaleWeek);
	}

	/**
	 * 更新记录
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	public int update(ReportSaleWeek reportSaleWeek) throws ServiceException
	{
		return reportSaleWeekService.update(reportSaleWeek);
	}

	/**
	 * 保存或更新记录
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(ReportSaleWeek reportSaleWeek) throws ServiceException {
		return reportSaleWeekService.saveOrUpdate(reportSaleWeek);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<ReportSaleWeek> list) throws ServiceException {
		return reportSaleWeekService.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ReportSaleWeek reportSaleWeek) throws ServiceException
	{
		return reportSaleWeekService.findByCount(reportSaleWeek);
	}

	@Override
	public byte[] getReportSaleWeekListByExcel(ReportSaleWeek reportSaleWeek) throws ServiceException {
		return reportSaleWeekManager.getReportSaleWeekListByExcel(reportSaleWeek);
	}

	/**
	 * 获取销量城市周报表
	 * @param pagination
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public Pagination<ReportSaleWeek4CityDto> listPaginationCityWeekDataByRange(Pagination<ReportSaleWeek4CityDto> pagination, ReportSaleWeek reportSaleWeek) throws ServiceException {
		return reportSaleWeekManager.listPaginationCityWeekDataByRange(pagination, reportSaleWeek);
	}

	/**
	 * 获取销量店铺周报表
	 * @param pagination
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public Pagination<ReportSaleWeek> listPaginationShopWeekData(Pagination<ReportSaleWeek> pagination, ReportSaleWeek reportSaleWeek) throws ServiceException {
		return reportSaleWeekManager.listPaginationShopWeekData(pagination, reportSaleWeek);
	}
	/**
	 * 根据输入周获取前8周列表
	 * @param week
	 * @return
	 */
	@Override
	public List<Integer> getWeeksBefore(Integer week) throws ServiceException {
		return reportSaleWeekManager.getWeeksBefore(week);
	}
}
