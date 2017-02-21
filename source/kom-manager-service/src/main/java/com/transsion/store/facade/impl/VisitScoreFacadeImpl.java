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

import com.transsion.store.bo.VisitScore;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.VisitScoreFacade;
import com.transsion.store.service.VisitScoreService;

@Component("visitScoreFacade")
public class VisitScoreFacadeImpl implements VisitScoreFacade {

	private VisitScoreService visitScoreService;
	
	@Autowired
	public void setVisitScoreService(VisitScoreService visitScoreService)
	{
		this.visitScoreService = visitScoreService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitScore getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitScoreService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitScore> list() throws ServiceException
	{
		return visitScoreService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitScore> listByProperty(VisitScore visitScore)
			throws ServiceException
	{
		return visitScoreService.listByProperty(visitScore);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitScore> listPaginationByProperty(Pagination<VisitScore> pagination, VisitScore visitScore)
			throws ServiceException
	{
		return visitScoreService.listPaginationByProperty(pagination, visitScore);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitScoreService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitScoreService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitScore
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitScore visitScore) throws ServiceException
	{
		return visitScoreService.deleteByProperty(visitScore);
	}

	/**
	 * 保存记录
	 * @param visitScore
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitScore visitScore) throws ServiceException
	{
		visitScoreService.save(visitScore);
	}

	/**
	 * 更新记录
	 * @param visitScore
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitScore visitScore) throws ServiceException
	{
		return visitScoreService.update(visitScore);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitScore
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitScore visitScore) throws ServiceException
	{
		return visitScoreService.findByCount(visitScore);
	}
}
