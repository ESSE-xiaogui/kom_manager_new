/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-1 16:30:39
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
import com.transsion.store.bo.GoalModel;
import com.transsion.store.facade.GoalModelFacade;
import com.transsion.store.manager.GoalSupervisorManager;
import com.transsion.store.service.GoalModelService;

@Component("goalModelFacade")
public class GoalModelFacadeImpl implements GoalModelFacade {

	private GoalModelService goalModelService;
	
	@Autowired
	private GoalSupervisorManager goalSupervisorManager;
	
	@Autowired
	public void setGoalModelService(GoalModelService goalModelService)
	{
		this.goalModelService = goalModelService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public GoalModel getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return goalModelService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<GoalModel> list() throws ServiceException
	{
		return goalModelService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<GoalModel> listByProperty(GoalModel goalModel)
			throws ServiceException
	{
		return goalModelService.listByProperty(goalModel);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<GoalModel> listPaginationByProperty(Pagination<GoalModel> pagination, GoalModel goalModel)
			throws ServiceException
	{
		return goalModelService.listPaginationByProperty(pagination, goalModel);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return goalModelService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		goalModelService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param goalModel
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(GoalModel goalModel) throws ServiceException
	{
		return goalModelService.deleteByProperty(goalModel);
	}

	/**
	 * 保存记录
	 * @param goalModel
	 * @return
	 * @throws ServiceException
	 */
	public void save(GoalModel goalModel) throws ServiceException
	{
		goalModelService.save(goalModel);
	}

	/**
	 * 更新记录
	 * @param goalModel
	 * @return
	 * @throws ServiceException
	 */
	public int update(GoalModel goalModel) throws ServiceException
	{
		return goalModelService.update(goalModel);
	}

	/**
	 * 根据条件查询记录条数
	 * @param goalModel
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(GoalModel goalModel) throws ServiceException
	{
		return goalModelService.findByCount(goalModel);
	}

	@Override
	public void calcShopModelSaleQty() throws ServiceException {
		goalSupervisorManager.calcShopModelSaleQty();
	}
}
