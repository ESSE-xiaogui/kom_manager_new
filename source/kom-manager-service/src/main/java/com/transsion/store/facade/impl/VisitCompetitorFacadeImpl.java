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

import com.transsion.store.bo.VisitCompetitor;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.VisitCompetitorFacade;
import com.transsion.store.service.VisitCompetitorService;

@Component("visitCompetitorFacade")
public class VisitCompetitorFacadeImpl implements VisitCompetitorFacade {

	private VisitCompetitorService visitCompetitorService;
	
	@Autowired
	public void setVisitCompetitorService(VisitCompetitorService visitCompetitorService)
	{
		this.visitCompetitorService = visitCompetitorService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitCompetitor getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitCompetitorService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitCompetitor> list() throws ServiceException
	{
		return visitCompetitorService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitCompetitor> listByProperty(VisitCompetitor visitCompetitor)
			throws ServiceException
	{
		return visitCompetitorService.listByProperty(visitCompetitor);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitCompetitor> listPaginationByProperty(Pagination<VisitCompetitor> pagination, VisitCompetitor visitCompetitor)
			throws ServiceException
	{
		return visitCompetitorService.listPaginationByProperty(pagination, visitCompetitor);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitCompetitorService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitCompetitorService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitCompetitor
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitCompetitor visitCompetitor) throws ServiceException
	{
		return visitCompetitorService.deleteByProperty(visitCompetitor);
	}

	/**
	 * 保存记录
	 * @param visitCompetitor
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitCompetitor visitCompetitor) throws ServiceException
	{
		visitCompetitorService.save(visitCompetitor);
	}

	/**
	 * 更新记录
	 * @param visitCompetitor
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitCompetitor visitCompetitor) throws ServiceException
	{
		return visitCompetitorService.update(visitCompetitor);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitCompetitor
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitCompetitor visitCompetitor) throws ServiceException
	{
		return visitCompetitorService.findByCount(visitCompetitor);
	}
}
