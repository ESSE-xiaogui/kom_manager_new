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

import com.transsion.store.bo.VisitSale;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitSaleInfoDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.VisitSaleMapper;
import com.transsion.store.utils.CacheUtils;

@Service("visitSaleService")
public class VisitSaleService {

	private VisitSaleMapper	visitSaleMapper;

	@Autowired
	public void setVisitSaleMapper(VisitSaleMapper visitSaleMapper)
	{
		this.visitSaleMapper = visitSaleMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitSale getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitSaleMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitSale> list() throws ServiceException
	{
		return visitSaleMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitSale> listByProperty(VisitSale visitSale)
			throws ServiceException
	{
		return visitSaleMapper.listByProperty(visitSale);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitSaleInfoDto> listPaginationByProperty(Pagination<VisitSaleInfoDto> pagination, VisitSaleInfoDto visitSaleInfoDto,String token)
			throws ServiceException
	{
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		
		Long companyId = userContext.isAdmin()?null:userContext.getCompanyId();
		
		List<VisitSaleInfoDto> list = visitSaleMapper.listPaginationByProperty(pagination, visitSaleInfoDto, pagination.getOrderBy(),companyId);
		
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
		return visitSaleMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitSaleMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitSale
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitSale visitSale) throws ServiceException
	{
		return visitSaleMapper.deleteByProperty(visitSale);
	}

	/**
	 * 保存记录
	 * @param visitSale
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitSale visitSale) throws ServiceException
	{
		visitSaleMapper.save(visitSale);
	}

	/**
	 * 更新记录
	 * @param visitSale
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitSale visitSale) throws ServiceException
	{
		return visitSaleMapper.update(visitSale);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitSale
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitSale visitSale) throws ServiceException
	{
		return visitSaleMapper.findByCount(visitSale);
	}
}