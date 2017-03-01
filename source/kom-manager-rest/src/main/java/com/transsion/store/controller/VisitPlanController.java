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
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.VisitPlan;
import com.transsion.store.dto.VisitPlanBriefSummaryDto;
import com.transsion.store.dto.VisitPlanDetailSummaryDto;
import com.transsion.store.dto.VisitPlanDto;
import com.transsion.store.dto.VisitPlanInfoDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.VisitPlanFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("visitPlan")
public class VisitPlanController extends AbstractController{

	@Autowired
	private VisitPlanFacade visitPlanFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public VisitPlan getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return visitPlanFacade.getByPK(primaryKey);
	}

	/**
	* 分页查询记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/listPg")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<VisitPlan> listPgVisitPlan(RequestModel<VisitPlan> requestModel) throws ServiceException
	{
		Pagination<VisitPlan> pagination = new Pagination<VisitPlan>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return visitPlanFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(VisitPlan visitPlan) throws ServiceException
	{
		visitPlanFacade.save(visitPlan);
	}

	/**
	* 根据多条主键值删除记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/delete")
	@Consumes({MediaType.APPLICATION_JSON})
	public void delete(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitPlanFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(VisitPlan visitPlan) throws ServiceException
	{
		visitPlanFacade.update(visitPlan);
	}
	
	/**
	 * PlanList 页面
	 * 巡店计划上传接口
	 * @throws ServiceException
	 * @author guihua.zhang on 2017-02-28
	 * */
	@POST
	@Path("/savePlan")
	@Consumes({MediaType.APPLICATION_JSON})
	public void savePlan(List<VisitPlanDto> visitPlanDtoList) throws ServiceException{
		String token = this.getAuthorization();
		visitPlanFacade.savePlan(token, visitPlanDtoList);
	}
	
	/**
	 * Today's visiting 页面
	 * 巡店计划查询周计划数和天计划数
	 * @return
	 * @throws ServiceException
	 * @author guihua.zhang on 2017-02-28
	 * */
	@GET
	@Path("queryPlanBriefSummary")
	@Produces({MediaType.APPLICATION_JSON})
	public VisitPlanBriefSummaryDto queryPlanBriefSummary(@QueryParam("planDate") String planDate)
					throws ServiceException{
		String token = this.getAuthorization();
		return visitPlanFacade.queryPlanBriefSummary(token, planDate);
	}
	
	/**
	 * plan List 页面
	 * 每天多少店铺数 和 时间
	 * 入参是 第一周第一天和第八周最后一天日期
	 * @return
	 * @throws ServiceException
	 * @author guihua.zhang on 2017-03-01
	 */
	@GET
	@Path("queryPlanDetailSummary")
	@Produces({MediaType.APPLICATION_JSON})
	public List<VisitPlanDetailSummaryDto> queryPlanDetailSummary(@QueryParam("startDate")String startDate, @QueryParam("endDate")String endDate)
			throws ServiceException{
		String token = this.getAuthorization();
		return visitPlanFacade.queryPlanDetailSummary(token, startDate, endDate);
	}
	
	/**
	 * plan details页面
	 * 查询巡店计划详情信息
	 * @return
	 * @throws ServiceException
	 * @author guihua.zhang on 2017-03-01
	 */
	@GET
	@Path("queryPlanInfo")
	@Produces({MediaType.APPLICATION_JSON})
	public List<VisitPlanInfoDto> queryPlanInfo(@QueryParam("startDate")String startDate, @QueryParam("endDate")String endDate) throws ServiceException{
		String token = this.getAuthorization();
		return visitPlanFacade.queryPlanInfo(token, startDate, endDate);
	}
}
