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
package com.transsion.store.facade;

import java.text.ParseException;
import java.util.List;


import com.transsion.store.bo.VisitPlan;
import com.transsion.store.dto.VisitPlanBriefSummaryDto;
import com.transsion.store.dto.VisitPlanDetailDto;
import com.transsion.store.dto.VisitPlanDetailInfoDto;
import com.transsion.store.dto.VisitPlanDto;
import com.transsion.store.dto.VisitPlanInfoDto;
import com.transsion.store.dto.VisitPlanDetailSummaryDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface VisitPlanFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitPlan getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitPlan> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitPlan> listByProperty(VisitPlan visitPlan)
			throws ServiceException;

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException;
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException;

	/**
	 * 根据传入参数删除记录
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitPlan visitPlan) throws ServiceException;

	/**
	 * 保存记录
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitPlan visitPlan) throws ServiceException;

	/**
	 * 更新记录
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitPlan visitPlan) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param visitPlan
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitPlan visitPlan) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 * @throws ParseException 
	 */
	public Pagination<VisitPlanDetailInfoDto> listPaginationByProperty(Pagination<VisitPlanDetailInfoDto> pagination, VisitPlanDetailInfoDto visitPlanDetailInfoDto,String token)
			throws ServiceException, ParseException;

	/********************************* web api **********************************/
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitPlanDetailDto> listPaginationByProperty(Pagination<VisitPlanDetailDto> pagination, VisitPlanDetailDto visitPlan)
			throws ServiceException;
	
	
	/********************************* app api **********************************/
	/**
	 * PlanList 页面
	 * 巡店计划上传接口
	 * */
	public int savePlan(String token, List<VisitPlanDto> visitPlanDtos) throws ServiceException;

	/**
	 * Today's visiting 页面
	 * 巡店计划查询周计划数和天计划数
	 * */
	public VisitPlanBriefSummaryDto queryPlanBriefSummary(String token, String planDate)
			throws ServiceException;
	
	/**
	 * plan List页面
	 * 每天多少店铺数 和 时间
	 * 入参是 第一周第一天和第八周最后一天日期
	 */
	public List<VisitPlanDetailSummaryDto> queryPlanDetailSummary(String token, String startDate, String endDate)
			throws ServiceException;

	/**
	 * plan details页面
	 */
	public List<VisitPlanInfoDto> queryPlanInfo(String token, String startDate, String endDate) throws ServiceException;
	
	/**
	 * make plan页面/selectshop_plan 页面
	 * 查询督导所有店铺某天巡店计划详情
	 * @author guihua.zhang on 2017-03-06
	 * */
	public List<VisitPlanInfoDto> querySelfShopPlanInfo(String token,String startDate,String endDate) throws ServiceException; 

	public byte[] getVisitPlanByExcel(VisitPlanDetailInfoDto visitPlanDetailInfoDto) throws ServiceException, ParseException;
	

}
