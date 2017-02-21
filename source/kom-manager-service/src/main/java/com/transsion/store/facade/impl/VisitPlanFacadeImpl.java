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

import com.transsion.store.bo.VisitPlan;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.VisitPlanFacade;
import com.transsion.store.service.VisitPlanService;

@Component("visitPlanFacade")
public class VisitPlanFacadeImpl implements VisitPlanFacade {

	private VisitPlanService visitPlanService;
	
	@Autowired
	public void setVisitPlanService(VisitPlanService visitPlanService)
	{
		this.visitPlanService = visitPlanService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitPlan getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitPlanService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitPlan> list() throws ServiceException
	{
		return visitPlanService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitPlan> listByProperty(VisitPlan visitPlan)
			throws ServiceException
	{
		return visitPlanService.listByProperty(visitPlan);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitPlan> listPaginationByProperty(Pagination<VisitPlan> pagination, VisitPlan visitPlan)
			throws ServiceException
	{
		return visitPlanService.listPaginationByProperty(pagination, visitPlan);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitPlanService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitPlanService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitPlan visitPlan) throws ServiceException
	{
		return visitPlanService.deleteByProperty(visitPlan);
	}

	/**
	 * 保存记录
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitPlan visitPlan) throws ServiceException
	{
		visitPlanService.save(visitPlan);
	}

	/**
	 * 更新记录
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitPlan visitPlan) throws ServiceException
	{
		return visitPlanService.update(visitPlan);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitPlan visitPlan) throws ServiceException
	{
		return visitPlanService.findByCount(visitPlan);
	}
}
