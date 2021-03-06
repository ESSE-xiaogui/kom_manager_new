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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.VisitPlan;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitInfoDto;
import com.transsion.store.dto.VisitPlanDetailInfoDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.VisitPlanMapper;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.CalendarUtils;

@Service("visitPlanService")
public class VisitPlanService {

	private VisitPlanMapper	visitPlanMapper;

	@Autowired
	public void setVisitPlanMapper(VisitPlanMapper visitPlanMapper)
	{
		this.visitPlanMapper = visitPlanMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitPlan getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitPlanMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitPlan> list() throws ServiceException
	{
		return visitPlanMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitPlan> listByProperty(VisitPlan visitPlan)
			throws ServiceException
	{
		return visitPlanMapper.listByProperty(visitPlan);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 * @throws ParseException 
	 */
	public Pagination<VisitPlanDetailInfoDto> listPaginationByProperty(Pagination<VisitPlanDetailInfoDto> pagination, VisitPlanDetailInfoDto visitPlanDetailInfoDto,String token)
			throws ServiceException, ParseException
	{
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		
		Integer companyId = userContext.isAdmin()?null:userContext.getCompanyId().intValue();
		
		List<VisitPlanDetailInfoDto> list = visitPlanMapper.listPaginationByProperty(pagination, visitPlanDetailInfoDto, pagination.getOrderBy(),companyId);
		
		for(VisitPlanDetailInfoDto dto : list){   
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
			String dstr = dto.getPlanDate();
			java.util.Date date=sdf.parse(dstr);
			int weekNo= CalendarUtils.getWeekOfYear(date);
			dto.setWeekNo(weekNo);
		}
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
		return visitPlanMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitPlanMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitPlan visitPlan) throws ServiceException
	{
		return visitPlanMapper.deleteByProperty(visitPlan);
	}

	/**
	 * 保存记录
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitPlan visitPlan) throws ServiceException
	{
		visitPlanMapper.save(visitPlan);
	}

	/**
	 * 更新记录
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitPlan visitPlan) throws ServiceException
	{
		return visitPlanMapper.update(visitPlan);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitPlan visitPlan) throws ServiceException
	{
		return visitPlanMapper.findByCount(visitPlan);
	}
	
	public List<VisitInfoDto> queryPlanedVisitList(VisitInfoDto visitInfoDto) throws ServiceException {
		return visitPlanMapper.queryPlanedVisitList(visitInfoDto);
	}
	
	public List<VisitInfoDto> queryWeekPlanCount(VisitInfoDto visitInfoDto) throws ServiceException {
		return visitPlanMapper.queryWeekPlanCount(visitInfoDto);
	}
}