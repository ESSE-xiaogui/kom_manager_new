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

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transsion.store.bo.VisitPlan;
import com.transsion.store.dto.VisitPlanBriefSummaryDto;
import com.transsion.store.dto.VisitPlanDetailDto;
import com.transsion.store.dto.VisitPlanDetailInfoDto;
import com.transsion.store.dto.VisitPlanDto;
import com.transsion.store.dto.VisitPlanInfoDto;
import com.transsion.store.dto.VisitPlanDetailSummaryDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.VisitPlanFacade;
import com.transsion.store.manager.VisitPlanManager;
import com.transsion.store.service.VisitPlanService;

@Component("visitPlanFacade")
public class VisitPlanFacadeImpl implements VisitPlanFacade {

	private VisitPlanService visitPlanService;
	
	@Autowired
	public void setVisitPlanService(VisitPlanService visitPlanService)
	{
		this.visitPlanService = visitPlanService;
	}
	
	@Autowired
	private VisitPlanManager visitPlanManager;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitPlan getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitPlanService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitPlan> list() throws ServiceException
	{
		return visitPlanService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitPlan> listByProperty(VisitPlan visitPlan)
			throws ServiceException
	{
		return visitPlanService.listByProperty(visitPlan);
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
		return visitPlanService.listPaginationByProperty(pagination, visitPlanDetailInfoDto,token);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitPlanService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitPlanService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitPlan visitPlan) throws ServiceException
	{
		return visitPlanService.deleteByProperty(visitPlan);
	}

	/**
	 * 保存记录
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitPlan visitPlan) throws ServiceException
	{
		visitPlanService.save(visitPlan);
	}

	/**
	 * 更新记录
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitPlan visitPlan) throws ServiceException
	{
		return visitPlanService.update(visitPlan);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitPlan visitPlan) throws ServiceException
	{
		return visitPlanService.findByCount(visitPlan);
	}

	/**
	 * 巡店计划上传接口
	 * */
	public int savePlan(String token, List<VisitPlanDto> visitPlanDtos) throws ServiceException {
		return visitPlanManager.savePlan(token, visitPlanDtos);
	}
	
	/**
	 * 巡店计划查询周计划数和天计划数
	 * */
	public VisitPlanBriefSummaryDto queryPlanBriefSummary(String token, String planDate) throws ServiceException {
		return visitPlanManager.queryPlanBriefSummary(token, planDate);
	}

	/**
	 * 查询每天多少店铺数 和 时间
	 */
	public List<VisitPlanDetailSummaryDto> queryPlanDetailSummary(String token, String startDate, String endDate)
			throws ServiceException {
		return visitPlanManager.queryPlanDetailSummary(token, startDate, endDate);
	}

	/**
	 * 查询巡店计划详情信息
	 */
	public List<VisitPlanInfoDto> queryPlanInfo(String token, String startDate, String endDate)
			throws ServiceException {
		return visitPlanManager.queryPlanInfo(token, startDate, endDate);
	}
	/**
	 * make plan页面/selectshop_plan 页面
	 * 查询督导所有店铺某天巡店计划详情
	 * @author guihua.zhang on 2017-03-06
	 * */
	public List<VisitPlanInfoDto> querySelfShopPlanInfo(String token,String startDate,String endDate) throws ServiceException{
		return visitPlanManager.querySelfShopPlanInfo(token,startDate, endDate);
	}

	@Override
	public Pagination<VisitPlanDetailDto> listPaginationByProperty(Pagination<VisitPlanDetailDto> pagination,
			VisitPlanDetailDto visitPlan) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getVisitPlanByExcel(VisitPlanDetailInfoDto visitPlanDetailInfoDto) throws ServiceException, ParseException {
		return visitPlanManager.getVisitPlanByExcel(visitPlanDetailInfoDto);
	}


}
