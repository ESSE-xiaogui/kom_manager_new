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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ReportSaleWeek;
import com.transsion.store.mapper.ReportSaleWeekMapper;

@Service("reportSaleWeekService")
public class ReportSaleWeekService {

	private ReportSaleWeekMapper	reportSaleWeekMapper;

	@Autowired
	public void setReportSaleWeekMapper(ReportSaleWeekMapper reportSaleWeekMapper)
	{
		this.reportSaleWeekMapper = reportSaleWeekMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ReportSaleWeek getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return reportSaleWeekMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ReportSaleWeek> list() throws ServiceException
	{
		return reportSaleWeekMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ReportSaleWeek> listByProperty(ReportSaleWeek reportSaleWeek)
			throws ServiceException
	{
		return reportSaleWeekMapper.listByProperty(reportSaleWeek);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ReportSaleWeek> listPaginationByProperty(Pagination<ReportSaleWeek> pagination, ReportSaleWeek reportSaleWeek)
			throws ServiceException
	{
		List<ReportSaleWeek> list = reportSaleWeekMapper.listPaginationByProperty(pagination, reportSaleWeek, pagination.getOrderBy());
		
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
		return reportSaleWeekMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		reportSaleWeekMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ReportSaleWeek reportSaleWeek) throws ServiceException
	{
		return reportSaleWeekMapper.deleteByProperty(reportSaleWeek);
	}

	/**
	 * 保存记录
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	public void save(ReportSaleWeek reportSaleWeek) throws ServiceException
	{
		reportSaleWeekMapper.save(reportSaleWeek);
	}

	/**
	 * 更新记录
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	public int update(ReportSaleWeek reportSaleWeek) throws ServiceException
	{
		return reportSaleWeekMapper.update(reportSaleWeek);
	}

	/**
	 * 保存或更新记录
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(ReportSaleWeek reportSaleWeek) throws ServiceException {
		return reportSaleWeekMapper.saveOrUpdate(reportSaleWeek);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<ReportSaleWeek> list) throws ServiceException {
		return reportSaleWeekMapper.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param reportSaleWeek
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ReportSaleWeek reportSaleWeek) throws ServiceException
	{
		return reportSaleWeekMapper.findByCount(reportSaleWeek);
	}
}