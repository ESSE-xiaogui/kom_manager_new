/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-2-21 14:48:56
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

import com.transsion.store.bo.VisitScoreItem;
import com.transsion.store.dto.VisitScoreItemInfoDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.VisitScoreItemMapper;

@Service("visitScoreItemService")
public class VisitScoreItemService {

	private VisitScoreItemMapper	visitScoreItemMapper;

	@Autowired
	public void setVisitScoreItemMapper(VisitScoreItemMapper visitScoreItemMapper)
	{
		this.visitScoreItemMapper = visitScoreItemMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitScoreItem getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitScoreItemMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitScoreItem> list() throws ServiceException
	{
		return visitScoreItemMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitScoreItem> listByProperty(VisitScoreItem visitScoreItem)
			throws ServiceException
	{
		return visitScoreItemMapper.listByProperty(visitScoreItem);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitScoreItem> listPaginationByProperty(Pagination<VisitScoreItem> pagination, VisitScoreItem visitScoreItem)
			throws ServiceException
	{
		List<VisitScoreItem> list = visitScoreItemMapper.listPaginationByProperty(pagination, visitScoreItem, pagination.getOrderBy());
		
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
		return visitScoreItemMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitScoreItemMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitScoreItem
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitScoreItem visitScoreItem) throws ServiceException
	{
		return visitScoreItemMapper.deleteByProperty(visitScoreItem);
	}

	/**
	 * 保存记录
	 * @param visitScoreItem
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitScoreItem visitScoreItem) throws ServiceException
	{
		visitScoreItemMapper.save(visitScoreItem);
	}

	/**
	 * 更新记录
	 * @param visitScoreItem
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitScoreItem visitScoreItem) throws ServiceException
	{
		return visitScoreItemMapper.update(visitScoreItem);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitScoreItem
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitScoreItem visitScoreItem) throws ServiceException
	{
		return visitScoreItemMapper.findByCount(visitScoreItem);
	}
	
	public List<VisitScoreItemInfoDto> queryVisitScoreItemByVisitId(Long visitId) throws ServiceException {
		return visitScoreItemMapper.queryVisitScoreItemByVisitId(visitId);
	}
}