/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-1 16:32:56
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
import com.transsion.store.bo.GoalSupervisor;
import com.transsion.store.facade.GoalSupervisorFacade;
import com.transsion.store.service.GoalSupervisorService;

@Component("goalSupervisorFacade")
public class GoalSupervisorFacadeImpl implements GoalSupervisorFacade {

	private GoalSupervisorService goalSupervisorService;
	
	@Autowired
	public void setGoalSupervisorService(GoalSupervisorService goalSupervisorService)
	{
		this.goalSupervisorService = goalSupervisorService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public GoalSupervisor getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return goalSupervisorService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<GoalSupervisor> list() throws ServiceException
	{
		return goalSupervisorService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<GoalSupervisor> listByProperty(GoalSupervisor goalSupervisor)
			throws ServiceException
	{
		return goalSupervisorService.listByProperty(goalSupervisor);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<GoalSupervisor> listPaginationByProperty(Pagination<GoalSupervisor> pagination, GoalSupervisor goalSupervisor)
			throws ServiceException
	{
		return goalSupervisorService.listPaginationByProperty(pagination, goalSupervisor);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return goalSupervisorService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		goalSupervisorService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param goalSupervisor
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(GoalSupervisor goalSupervisor) throws ServiceException
	{
		return goalSupervisorService.deleteByProperty(goalSupervisor);
	}

	/**
	 * 保存记录
	 * @param goalSupervisor
	 * @return
	 * @throws ServiceException
	 */
	public void save(GoalSupervisor goalSupervisor) throws ServiceException
	{
		goalSupervisorService.save(goalSupervisor);
	}

	/**
	 * 更新记录
	 * @param goalSupervisor
	 * @return
	 * @throws ServiceException
	 */
	public int update(GoalSupervisor goalSupervisor) throws ServiceException
	{
		return goalSupervisorService.update(goalSupervisor);
	}

	/**
	 * 根据条件查询记录条数
	 * @param goalSupervisor
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(GoalSupervisor goalSupervisor) throws ServiceException
	{
		return goalSupervisorService.findByCount(goalSupervisor);
	}
}
