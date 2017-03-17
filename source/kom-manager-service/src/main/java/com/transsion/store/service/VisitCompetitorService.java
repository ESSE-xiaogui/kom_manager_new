/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-2-21 10:24:47
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

import com.transsion.store.bo.VisitCompetitor;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitCompetitorDetailDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.VisitCompetitorMapper;
import com.transsion.store.utils.CacheUtils;

@Service("visitCompetitorService")
public class VisitCompetitorService {

	private VisitCompetitorMapper	visitCompetitorMapper;

	@Autowired
	public void setVisitCompetitorMapper(VisitCompetitorMapper visitCompetitorMapper)
	{
		this.visitCompetitorMapper = visitCompetitorMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitCompetitor getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitCompetitorMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitCompetitor> list() throws ServiceException
	{
		return visitCompetitorMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitCompetitor> listByProperty(VisitCompetitor visitCompetitor)
			throws ServiceException
	{
		return visitCompetitorMapper.listByProperty(visitCompetitor);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitCompetitorDetailDto> listPaginationByProperty(Pagination<VisitCompetitorDetailDto> pagination, VisitCompetitorDetailDto visitCompetitorDetailDto, String token)
			throws ServiceException
	{
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		
		Long companyId = userContext.isAdmin()?null:userContext.getCompanyId();
		List<VisitCompetitorDetailDto> list = visitCompetitorMapper.listPaginationByProperty(pagination, visitCompetitorDetailDto, pagination.getOrderBy(), companyId );
		
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
		return visitCompetitorMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitCompetitorMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitCompetitor
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitCompetitor visitCompetitor) throws ServiceException
	{
		return visitCompetitorMapper.deleteByProperty(visitCompetitor);
	}

	/**
	 * 保存记录
	 * @param visitCompetitor
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitCompetitor visitCompetitor) throws ServiceException
	{
		visitCompetitorMapper.save(visitCompetitor);
	}
	
	/**
	 * 批量新增修改
	 * @param visitCompetitors
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<VisitCompetitor> visitCompetitors) throws ServiceException {
		return visitCompetitorMapper.batchSaveOrUpdate(visitCompetitors);
	}

	/**
	 * 更新记录
	 * @param visitCompetitor
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitCompetitor visitCompetitor) throws ServiceException
	{
		return visitCompetitorMapper.update(visitCompetitor);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitCompetitor
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitCompetitor visitCompetitor) throws ServiceException
	{
		return visitCompetitorMapper.findByCount(visitCompetitor);
	}
}