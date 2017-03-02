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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.GoalSupervisor;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.GoalSupervisorMapper;

@Service("goalSupervisorService")
public class GoalSupervisorService {

	private GoalSupervisorMapper	goalSupervisorMapper;

	@Autowired
	public void setGoalSupervisorMapper(GoalSupervisorMapper goalSupervisorMapper)
	{
		this.goalSupervisorMapper = goalSupervisorMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public GoalSupervisor getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return goalSupervisorMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<GoalSupervisor> list() throws ServiceException
	{
		return goalSupervisorMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<GoalSupervisor> listByProperty(GoalSupervisor goalSupervisor)
			throws ServiceException
	{
		return goalSupervisorMapper.listByProperty(goalSupervisor);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<GoalSupervisor> listPaginationByProperty(Pagination<GoalSupervisor> pagination, GoalSupervisor goalSupervisor)
			throws ServiceException
	{
		List<GoalSupervisor> list = goalSupervisorMapper.listPaginationByProperty(pagination, goalSupervisor, pagination.getOrderBy());
		
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
		return goalSupervisorMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		goalSupervisorMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param goalSupervisor
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(GoalSupervisor goalSupervisor) throws ServiceException
	{
		return goalSupervisorMapper.deleteByProperty(goalSupervisor);
	}

	/**
	 * 保存记录
	 * @param goalSupervisor
	 * @return
	 * @throws ServiceException
	 */
	public void save(GoalSupervisor goalSupervisor) throws ServiceException
	{
		goalSupervisorMapper.save(goalSupervisor);
	}

	/**
	 * 更新记录
	 * @param goalSupervisor
	 * @return
	 * @throws ServiceException
	 */
	public int update(GoalSupervisor goalSupervisor) throws ServiceException
	{
		return goalSupervisorMapper.update(goalSupervisor);
	}

	/**
	 * 根据条件查询记录条数
	 * @param goalSupervisor
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(GoalSupervisor goalSupervisor) throws ServiceException
	{
		return goalSupervisorMapper.findByCount(goalSupervisor);
	}
}