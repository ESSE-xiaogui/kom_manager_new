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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.GoalPromoter;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.GoalPromoterInfoDto;
import com.transsion.store.exception.ExceptionDef;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.mapper.GoalPromoterMapper;
import com.transsion.store.utils.CacheUtils;

@Service("goalPromoterService")
public class GoalPromoterService {

	private GoalPromoterMapper	goalPromoterMapper;

	@Autowired
	public void setGoalPromoterMapper(GoalPromoterMapper goalPromoterMapper)
	{
		this.goalPromoterMapper = goalPromoterMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public GoalPromoter getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return goalPromoterMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<GoalPromoter> list() throws ServiceException
	{
		return goalPromoterMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<GoalPromoter> listByProperty(GoalPromoter goalPromoter)
			throws ServiceException
	{
		return goalPromoterMapper.listByProperty(goalPromoter);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<GoalPromoterInfoDto> listPaginationByProperty(Pagination<GoalPromoterInfoDto> pagination, GoalPromoterInfoDto goalPromoterInfoDto,String token)
			throws ServiceException
	{
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Long companyId = userContext.isAdmin()?null:userContext.getCompanyId();
		List<GoalPromoterInfoDto> list = goalPromoterMapper.listPaginationByProperty(pagination, goalPromoterInfoDto, pagination.getOrderBy(),companyId);
		
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
		return goalPromoterMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		goalPromoterMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param goalPromoter
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(GoalPromoter goalPromoter) throws ServiceException
	{
		return goalPromoterMapper.deleteByProperty(goalPromoter);
	}

	/**
	 * 保存记录
	 * @param goalPromoter
	 * @return
	 * @throws ServiceException
	 */
	public void save(GoalPromoter goalPromoter) throws ServiceException
	{
		goalPromoterMapper.save(goalPromoter);
	}

	/**
	 * 更新记录
	 * @param goalPromoter
	 * @return
	 * @throws ServiceException
	 */
	public int update(GoalPromoter goalPromoter) throws ServiceException
	{
		return goalPromoterMapper.update(goalPromoter);
	}

	/**
	 * 根据条件查询记录条数
	 * @param goalPromoter
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(GoalPromoter goalPromoter) throws ServiceException
	{
		return goalPromoterMapper.findByCount(goalPromoter);
	}
}