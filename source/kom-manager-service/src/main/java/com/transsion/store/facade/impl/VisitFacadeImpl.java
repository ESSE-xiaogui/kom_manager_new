/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-2-21 10:24:47
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

import com.transsion.store.bo.Visit;
import com.transsion.store.dto.VisitInfoDto;
import com.transsion.store.dto.VisitSettingDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.VisitFacade;
import com.transsion.store.service.VisitService;

@Component("visitFacade")
public class VisitFacadeImpl implements VisitFacade {

	private VisitService visitService;
	
	@Autowired
	public void setVisitService(VisitService visitService)
	{
		this.visitService = visitService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Visit getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Visit> list() throws ServiceException
	{
		return visitService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Visit> listByProperty(Visit visit)
			throws ServiceException
	{
		return visitService.listByProperty(visit);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Visit> listPaginationByProperty(Pagination<Visit> pagination, Visit visit)
			throws ServiceException
	{
		return visitService.listPaginationByProperty(pagination, visit);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visit
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Visit visit) throws ServiceException
	{
		return visitService.deleteByProperty(visit);
	}

	/**
	 * 保存记录
	 * @param visit
	 * @return
	 * @throws ServiceException
	 */
	public void save(Visit visit) throws ServiceException
	{
		visitService.save(visit);
	}

	/**
	 * 更新记录
	 * @param visit
	 * @return
	 * @throws ServiceException
	 */
	public int update(Visit visit) throws ServiceException
	{
		return visitService.update(visit);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visit
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Visit visit) throws ServiceException
	{
		return visitService.findByCount(visit);
	}

	@Override
	public VisitSettingDto queryVisitSetting(String token) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateVisitRecord(String token, VisitInfoDto visitInfoDto) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VisitInfoDto> queryVisitRecords(String token, String startDate, String endDate) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitInfoDto queryShopLatestVisit(String token, String ShopId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
}
