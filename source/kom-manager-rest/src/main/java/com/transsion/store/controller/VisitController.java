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
package com.transsion.store.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rest.service.controller.AbstractController;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.dto.RequestModel;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Visit;
import com.transsion.store.dto.VisitHistorySummaryDto;
import com.transsion.store.dto.VisitInfoDto;
import com.transsion.store.dto.VisitRecordDto;
import com.transsion.store.dto.VisitRecordInfoDto;
import com.transsion.store.dto.VisitSettingDto;
import com.transsion.store.dto.VisitShopInfoDto;
import com.transsion.store.facade.VisitFacade;

@Controller
@Path("visit")
public class VisitController extends AbstractController{

	@Autowired
	private VisitFacade visitFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public Visit getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return visitFacade.getByPK(primaryKey);
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
	public Pagination<Visit> listPgVisit(RequestModel<Visit> requestModel) throws ServiceException
	{
		Pagination<Visit> pagination = new Pagination<Visit>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return visitFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(Visit visit) throws ServiceException
	{
		visitFacade.save(visit);
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
		visitFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(Visit visit) throws ServiceException
	{
		visitFacade.update(visit);
	}
	
	@GET
	@Path("/queryPlanedVisitList")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public List<VisitInfoDto> queryPlanedVisitList(@QueryParam("planDate")String planDate) throws ServiceException {
		String token = this.getAuthorization();
		return visitFacade.queryPlanedVisitList(token, planDate);
	}
	
	/**
	 * app 查询计划之外的巡店列表
	 * @param token
	 * @param planDate
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryUnplanedVisitList")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public List<VisitInfoDto> queryUnplanedVisitList(@QueryParam("planDate")String planDate) throws ServiceException{
		String token = this.getAuthorization();
		return visitFacade.queryUnplanedVisitList(token, planDate);
	}
	
	/**
	 * app 重点机型查询列表
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryVisitModelSettingList")
	@Produces({ MediaType.APPLICATION_JSON })
	public VisitSettingDto queryVisitModelSettingList() throws ServiceException {
		String token = this.getAuthorization();
		return visitFacade.queryVisitSetting(token);
	}
	
	/**
	 * app 查询店铺信息列表
	 * @param planDate
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryVisitShopInfo")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public VisitShopInfoDto queryVisitShopInfo(@QueryParam("planDate")String planDate) throws ServiceException{
		String token = this.getAuthorization();
		return visitFacade.queryVisitShopInfo(token, planDate);
	}
	
	/**
	 * shopscore页面
	 * score setting...
	 * @author guihua.zhang
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryVisitSetting")
	@Produces({ MediaType.APPLICATION_JSON })
	public VisitSettingDto queryVisitSetting() throws ServiceException {
		String token = this.getAuthorization();
		return visitFacade.queryVisitSetting(token);
	}
	
	
	/**
	 * app 保存打分项数据
	 * @param visitRecordDto
	 * @throws ServiceException
	 */
	@POST
	@Path("/saveVisitRecord")
	@Consumes({MediaType.APPLICATION_JSON})
	public void saveVisitRecord(VisitRecordDto visitRecordDto) throws ServiceException {
		String token = this.getAuthorization();
		visitFacade.saveVisitRecord(token, visitRecordDto);
	}
	
	/**
	 * app 历史巡店记录列表查询
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryVisitSummaryHistory")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public List<VisitHistorySummaryDto> queryVisitSummaryHistory(String startDate, String endDate)
			throws ServiceException {
		String token = this.getAuthorization();
		return visitFacade.queryVisitSummaryHistory(token, startDate, endDate);
	}
	
	/**
	 * app 巡店记录信息查询
	 * @param visitId
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryVisitRecordInfo")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public VisitRecordInfoDto queryVisitRecordInfo(String visitId) throws ServiceException {
		String token = this.getAuthorization();
		return visitFacade.queryVisitRecordInfo(token, visitId);
	}
}
