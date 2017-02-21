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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.VisitScore;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.VisitScoreMapper;

@Service("visitScoreService")
public class VisitScoreService {

	private VisitScoreMapper	visitScoreMapper;

	@Autowired
	public void setVisitScoreMapper(VisitScoreMapper visitScoreMapper)
	{
		this.visitScoreMapper = visitScoreMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitScore getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitScoreMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitScore> list() throws ServiceException
	{
		return visitScoreMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitScore> listByProperty(VisitScore visitScore)
			throws ServiceException
	{
		return visitScoreMapper.listByProperty(visitScore);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitScore> listPaginationByProperty(Pagination<VisitScore> pagination, VisitScore visitScore)
			throws ServiceException
	{
		List<VisitScore> list = visitScoreMapper.listPaginationByProperty(pagination, visitScore, pagination.getOrderBy());
		
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
		return visitScoreMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitScoreMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitScore
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitScore visitScore) throws ServiceException
	{
		return visitScoreMapper.deleteByProperty(visitScore);
	}

	/**
	 * 保存记录
	 * @param visitScore
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitScore visitScore) throws ServiceException
	{
		visitScoreMapper.save(visitScore);
	}

	/**
	 * 更新记录
	 * @param visitScore
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitScore visitScore) throws ServiceException
	{
		return visitScoreMapper.update(visitScore);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitScore
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitScore visitScore) throws ServiceException
	{
		return visitScoreMapper.findByCount(visitScore);
	}
}