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

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Visit;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitDto;
import com.transsion.store.dto.VisitInfoDto;
import com.transsion.store.dto.VisitShopDetailDto;
import com.transsion.store.dto.VisitShopDto;
import com.transsion.store.dto.VisitShopInfoDto;
import com.transsion.store.mapper.VisitMapper;
import com.transsion.store.utils.CacheUtils;

@Service("visitService")
public class VisitService {

	private VisitMapper	visitMapper;

	@Autowired
	public void setVisitMapper(VisitMapper visitMapper)
	{
		this.visitMapper = visitMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Visit getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Visit> list() throws ServiceException
	{
		return visitMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Visit> listByProperty(Visit visit)
			throws ServiceException
	{
		return visitMapper.listByProperty(visit);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Visit> listPaginationByProperty(String token, Pagination<Visit> pagination, Visit visit)
			throws ServiceException
	{
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		
		Long companyId = userContext.isAdmin()?null:userContext.getCompanyId();
		List<Visit> list = visitMapper.listPaginationByProperty(pagination, visit, pagination.getOrderBy(), companyId);
		
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
		return visitMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visit
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Visit visit) throws ServiceException
	{
		return visitMapper.deleteByProperty(visit);
	}

	/**
	 * 保存记录
	 * @param visit
	 * @return
	 * @throws ServiceException
	 */
	public void save(Visit visit) throws ServiceException
	{
		visitMapper.save(visit);
	}

	/**
	 * 更新记录
	 * @param visit
	 * @return
	 * @throws ServiceException
	 */
	public int update(Visit visit) throws ServiceException
	{
		return visitMapper.update(visit);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visit
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Visit visit) throws ServiceException
	{
		return visitMapper.findByCount(visit);
	}
	
	public List<VisitInfoDto> queryUnplanedVisitList(VisitInfoDto visitInfoDto) throws ServiceException {
		return visitMapper.queryUnplanedVisitList(visitInfoDto);
	}
	
	public VisitShopInfoDto queryVisitShopInfo(VisitShopInfoDto visitShopInfoDto) throws ServiceException {
		return visitMapper.queryVisitShopInfo(visitShopInfoDto);
	}
	
	public VisitShopDto queryVisitByVisitId(Long id) throws ServiceException {
		return visitMapper.queryVisitByVisitId(id);
	}
	
	public void saveVisitDto(VisitDto visitDto) throws ServiceException {
		visitMapper.saveVisitDto(visitDto);
	}
	
	public VisitShopDetailDto queryVisitScoreInfoByVisitId(Long visitId) throws ServiceException {
		return visitMapper.queryVisitScoreInfoByVisitId(visitId);
	}
}