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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.ReportShopOtcRate;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.ReportShopOtcRateMapper;

@Service("reportShopOtcRateService")
public class ReportShopOtcRateService {

	private ReportShopOtcRateMapper	reportShopOtcRateMapper;

	@Autowired
	public void setReportShopOtcRateMapper(ReportShopOtcRateMapper reportShopOtcRateMapper)
	{
		this.reportShopOtcRateMapper = reportShopOtcRateMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ReportShopOtcRate getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return reportShopOtcRateMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ReportShopOtcRate> list() throws ServiceException
	{
		return reportShopOtcRateMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ReportShopOtcRate> listByProperty(ReportShopOtcRate reportShopOtcRate)
			throws ServiceException
	{
		return reportShopOtcRateMapper.listByProperty(reportShopOtcRate);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ReportShopOtcRate> listPaginationByProperty(Pagination<ReportShopOtcRate> pagination, ReportShopOtcRate reportShopOtcRate)
			throws ServiceException
	{
		List<ReportShopOtcRate> list = reportShopOtcRateMapper.listPaginationByProperty(pagination, reportShopOtcRate, pagination.getOrderBy());
		
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
		return reportShopOtcRateMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		reportShopOtcRateMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param reportShopOtcRate
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ReportShopOtcRate reportShopOtcRate) throws ServiceException
	{
		return reportShopOtcRateMapper.deleteByProperty(reportShopOtcRate);
	}

	/**
	 * 保存记录
	 * @param reportShopOtcRate
	 * @return
	 * @throws ServiceException
	 */
	public void save(ReportShopOtcRate reportShopOtcRate) throws ServiceException
	{
		reportShopOtcRateMapper.save(reportShopOtcRate);
	}

	/**
	 * 更新记录
	 * @param reportShopOtcRate
	 * @return
	 * @throws ServiceException
	 */
	public int update(ReportShopOtcRate reportShopOtcRate) throws ServiceException
	{
		return reportShopOtcRateMapper.update(reportShopOtcRate);
	}

	/**
	 * 保存或更新记录
	 * @param reportShopOtcRate
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(ReportShopOtcRate reportShopOtcRate) throws ServiceException {
		return reportShopOtcRateMapper.saveOrUpdate(reportShopOtcRate);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<ReportShopOtcRate> list) throws ServiceException {
		return reportShopOtcRateMapper.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param reportShopOtcRate
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ReportShopOtcRate reportShopOtcRate) throws ServiceException
	{
		return reportShopOtcRateMapper.findByCount(reportShopOtcRate);
	}
}