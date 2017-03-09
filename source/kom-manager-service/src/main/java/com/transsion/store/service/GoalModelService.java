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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.GoalModel;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.GoalModelInfoDto;
import com.transsion.store.exception.ExceptionDef;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.mapper.GoalModelMapper;
import com.transsion.store.utils.CacheUtils;

@Service("goalModelService")
public class GoalModelService {

	private GoalModelMapper	goalModelMapper;

	@Autowired
	public void setGoalModelMapper(GoalModelMapper goalModelMapper)
	{
		this.goalModelMapper = goalModelMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public GoalModel getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return goalModelMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<GoalModel> list() throws ServiceException
	{
		return goalModelMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<GoalModel> listByProperty(GoalModel goalModel)
			throws ServiceException
	{
		return goalModelMapper.listByProperty(goalModel);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<GoalModelInfoDto> listPaginationByProperty(Pagination<GoalModelInfoDto> pagination, GoalModelInfoDto goalModelInfoDto, String token)
			throws ServiceException
	{
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Long companyId = userContext.isAdmin()?null:userContext.getCompanyId();
		List<GoalModelInfoDto> list = goalModelMapper.listPaginationByProperty(pagination, goalModelInfoDto, pagination.getOrderBy(),companyId);
		
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
		return goalModelMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		goalModelMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param goalModel
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(GoalModel goalModel) throws ServiceException
	{
		return goalModelMapper.deleteByProperty(goalModel);
	}

	/**
	 * 保存记录
	 * @param goalModel
	 * @return
	 * @throws ServiceException
	 */
	public void save(GoalModel goalModel) throws ServiceException
	{
		goalModelMapper.save(goalModel);
	}

	/**
	 * 更新记录
	 * @param goalModel
	 * @return
	 * @throws ServiceException
	 */
	public int update(GoalModel goalModel) throws ServiceException
	{
		return goalModelMapper.update(goalModel);
	}

	/**
	 * 根据条件查询记录条数
	 * @param goalModel
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(GoalModel goalModel) throws ServiceException
	{
		return goalModelMapper.findByCount(goalModel);
	}
}