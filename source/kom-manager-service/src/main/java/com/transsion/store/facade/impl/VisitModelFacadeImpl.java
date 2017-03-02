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

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.VisitModel;
import com.transsion.store.facade.VisitModelFacade;
import com.transsion.store.service.VisitModelService;

@Component("visitModelFacade")
public class VisitModelFacadeImpl implements VisitModelFacade {

	private VisitModelService visitModelService;
	
	@Autowired
	public void setVisitModelService(VisitModelService visitModelService)
	{
		this.visitModelService = visitModelService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitModel getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitModelService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitModel> list() throws ServiceException
	{
		return visitModelService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitModel> listByProperty(VisitModel visitModel)
			throws ServiceException
	{
		return visitModelService.listByProperty(visitModel);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitModel> listPaginationByProperty(Pagination<VisitModel> pagination, VisitModel visitModel)
			throws ServiceException
	{
		return visitModelService.listPaginationByProperty(pagination, visitModel);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitModelService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitModelService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitModel
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitModel visitModel) throws ServiceException
	{
		return visitModelService.deleteByProperty(visitModel);
	}

	/**
	 * 保存记录
	 * @param visitModel
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitModel visitModel) throws ServiceException
	{
		visitModelService.save(visitModel);
	}

	/**
	 * 更新记录
	 * @param visitModel
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitModel visitModel) throws ServiceException
	{
		return visitModelService.update(visitModel);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitModel
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitModel visitModel) throws ServiceException
	{
		return visitModelService.findByCount(visitModel);
	}
}
