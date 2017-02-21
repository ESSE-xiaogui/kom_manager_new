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

import com.transsion.store.bo.VisitModel;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.VisitModelMapper;

@Service("visitModelService")
public class VisitModelService {

	private VisitModelMapper	visitModelMapper;

	@Autowired
	public void setVisitModelMapper(VisitModelMapper visitModelMapper)
	{
		this.visitModelMapper = visitModelMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitModel getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitModelMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitModel> list() throws ServiceException
	{
		return visitModelMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitModel> listByProperty(VisitModel visitModel)
			throws ServiceException
	{
		return visitModelMapper.listByProperty(visitModel);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitModel> listPaginationByProperty(Pagination<VisitModel> pagination, VisitModel visitModel)
			throws ServiceException
	{
		List<VisitModel> list = visitModelMapper.listPaginationByProperty(pagination, visitModel, pagination.getOrderBy());
		
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
		return visitModelMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitModelMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitModel
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitModel visitModel) throws ServiceException
	{
		return visitModelMapper.deleteByProperty(visitModel);
	}

	/**
	 * 保存记录
	 * @param visitModel
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitModel visitModel) throws ServiceException
	{
		visitModelMapper.save(visitModel);
	}

	/**
	 * 更新记录
	 * @param visitModel
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitModel visitModel) throws ServiceException
	{
		return visitModelMapper.update(visitModel);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitModel
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitModel visitModel) throws ServiceException
	{
		return visitModelMapper.findByCount(visitModel);
	}
}