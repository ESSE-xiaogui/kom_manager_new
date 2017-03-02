/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-1 16:31:42
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
import com.transsion.store.bo.GoalPromoter;
import com.transsion.store.facade.GoalPromoterFacade;
import com.transsion.store.service.GoalPromoterService;

@Component("goalPromoterFacade")
public class GoalPromoterFacadeImpl implements GoalPromoterFacade {

	private GoalPromoterService goalPromoterService;
	
	@Autowired
	public void setGoalPromoterService(GoalPromoterService goalPromoterService)
	{
		this.goalPromoterService = goalPromoterService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public GoalPromoter getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return goalPromoterService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<GoalPromoter> list() throws ServiceException
	{
		return goalPromoterService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<GoalPromoter> listByProperty(GoalPromoter goalPromoter)
			throws ServiceException
	{
		return goalPromoterService.listByProperty(goalPromoter);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<GoalPromoter> listPaginationByProperty(Pagination<GoalPromoter> pagination, GoalPromoter goalPromoter)
			throws ServiceException
	{
		return goalPromoterService.listPaginationByProperty(pagination, goalPromoter);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return goalPromoterService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		goalPromoterService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param goalPromoter
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(GoalPromoter goalPromoter) throws ServiceException
	{
		return goalPromoterService.deleteByProperty(goalPromoter);
	}

	/**
	 * 保存记录
	 * @param goalPromoter
	 * @return
	 * @throws ServiceException
	 */
	public void save(GoalPromoter goalPromoter) throws ServiceException
	{
		goalPromoterService.save(goalPromoter);
	}

	/**
	 * 更新记录
	 * @param goalPromoter
	 * @return
	 * @throws ServiceException
	 */
	public int update(GoalPromoter goalPromoter) throws ServiceException
	{
		return goalPromoterService.update(goalPromoter);
	}

	/**
	 * 根据条件查询记录条数
	 * @param goalPromoter
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(GoalPromoter goalPromoter) throws ServiceException
	{
		return goalPromoterService.findByCount(goalPromoter);
	}
}
