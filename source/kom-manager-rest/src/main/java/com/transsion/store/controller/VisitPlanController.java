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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rest.service.controller.AbstractController;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.dto.RequestModel;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.VisitPlan;
import com.transsion.store.dto.VisitPlanBriefSummaryDto;
import com.transsion.store.dto.VisitPlanDetailInfoDto;
import com.transsion.store.dto.VisitPlanDetailSummaryDto;
import com.transsion.store.dto.VisitPlanDto;
import com.transsion.store.dto.VisitPlanInfoDto;
import com.transsion.store.facade.VisitPlanFacade;

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
	 * @throws ParseException 
	*/
	@POST
	@Path("/listPg")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<VisitPlanDetailInfoDto> listPgVisitPlan(RequestModel<VisitPlanDetailInfoDto> requestModel) throws ServiceException, ParseException
	{
		Pagination<VisitPlanDetailInfoDto> pagination = new Pagination<VisitPlanDetailInfoDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return visitPlanFacade.listPaginationByProperty(pagination, requestModel.getParams(),this.getAuthorization());
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
	@Produces({MediaType.APPLICATION_JSON})
	public int savePlan(List<VisitPlanDto> visitPlanDtos) throws ServiceException{
		String token = this.getAuthorization();
		return visitPlanFacade.savePlan(token, visitPlanDtos);
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
	 * 入参是 需要查询的开始的日期 和 最后结束日期
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
	
	/**
	 * make plan页面/selectshop_plan 页面
	 * 查询督导所有店铺某天巡店计划详情
	 * @return
	 * @throws ServiceException
	 * @author guihua.zhang on 2017-03-01
	 */
	@GET
	@Path("querySelfShopPlanInfo")
	@Produces({MediaType.APPLICATION_JSON})
	public List<VisitPlanInfoDto> querySelfShopPlanInfo(@QueryParam("startDate")String startDate, @QueryParam("endDate")String endDate) throws ServiceException{
		String token = this.getAuthorization();
		return visitPlanFacade.querySelfShopPlanInfo(token, startDate, endDate);
	}
	
	/**
	 * 巡店计划导出Excel
	 * @param createTimeStart
	 * @param createTimeEnd
	 * @param planDateStart
	 * @param planDateEnd
	 * @param gradeId
	 * @param regionId
	 * @param bizId
	 * @param weekNo
	 * @param createBy
	 * @param companyId
	 * @param status
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 * @throws ParseException 
	 */
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getVisitPlanByExcel(@QueryParam("createTimeStart") String createTimeStart,
		@QueryParam("createTimeEnd") String createTimeEnd,@QueryParam("planDateStart") String planDateStart,
		@QueryParam("planDateEnd") String planDateEnd,@QueryParam("gradeId") String gradeId,
		@QueryParam("regionId")String regionId,@QueryParam("bizId")String bizId,
		@QueryParam("weekNo")String weekNo,@QueryParam("createBy") String createBy,
		@QueryParam("companyId") String companyId,@QueryParam("status") String status) throws ServiceException,IOException, ParseException {
		
		VisitPlanDetailInfoDto visitPlanDetailInfoDto = new VisitPlanDetailInfoDto();
		visitPlanDetailInfoDto.setCreateTimeStart(createTimeStart);
		visitPlanDetailInfoDto.setCreateTimeEnd(createTimeEnd);
		visitPlanDetailInfoDto.setPlanDateStart(planDateStart);
		visitPlanDetailInfoDto.setPlanDateEnd(planDateEnd);
		visitPlanDetailInfoDto.setCreateBy(createBy);
		if(!UtilHelper.isEmpty(regionId)){
			visitPlanDetailInfoDto.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(companyId)){
			visitPlanDetailInfoDto.setCompanyId(Long.parseLong(companyId));
		}
		if(!UtilHelper.isEmpty(bizId)){
			visitPlanDetailInfoDto.setBizId(Long.parseLong(bizId));
		}
		if(!UtilHelper.isEmpty(gradeId)){
			visitPlanDetailInfoDto.setGradeId(Long.parseLong(gradeId));
		}
		if(!UtilHelper.isEmpty(weekNo)){
			visitPlanDetailInfoDto.setWeekNo(Integer.valueOf(weekNo));
		}
		if(!UtilHelper.isEmpty(status)){
			visitPlanDetailInfoDto.setStatus(Integer.valueOf(status));
		}
		byte[] bytes = visitPlanFacade.getVisitPlanByExcel(visitPlanDetailInfoDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"巡店计划报表.xlsx";
		response.header("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));         
		//根据自己文件类型修改         
		response.header("ContentType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");          
		return response.build();      	
	}
	class BigFileOutputStream implements javax.ws.rs.core.StreamingOutput {
        private InputStream inputStream;
        public BigFileOutputStream(){}
        public BigFileOutputStream(InputStream inputStream)
        {
            this.inputStream = inputStream;
        }

        @Override
        public void write(OutputStream output) throws IOException,
                WebApplicationException {
            // TODO Auto-generated method stub
            IOUtils.copy(inputStream, output);
        }

        public InputStream getInputStream() {
            return inputStream;
        }
        public void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }
    }
}
