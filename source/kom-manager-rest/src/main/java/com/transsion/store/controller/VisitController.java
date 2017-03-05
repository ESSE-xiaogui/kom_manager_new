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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import com.transsion.store.bo.Visit;
import com.transsion.store.dto.VisitHistoryDetailDto;
import com.transsion.store.dto.VisitHistorySummaryDto;
import com.transsion.store.dto.VisitInfoDto;
import com.transsion.store.dto.VisitRecordDto;
import com.transsion.store.dto.VisitRecordInfoDto;
import com.transsion.store.dto.VisitSettingDto;
import com.transsion.store.dto.VisitShopDetailDto;
import com.transsion.store.dto.VisitShopInfoDto;
import com.transsion.store.dto.VisitStockInfoDto;
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
	
	/**
	 * 计划内的巡店列表查询
	 * @param planDate
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryPlanedVisitList")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public List<VisitInfoDto> queryPlanedVisitList(@QueryParam("planDate")String planDate) throws ServiceException {
		String token = this.getAuthorization();
		return visitFacade.queryPlanedVisitList(token, planDate);
	}
	
	/**
	 * 计划外的巡店列表查询
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
	public VisitShopInfoDto queryVisitShopInfo(@QueryParam("shopId")java.lang.Long shopId, @QueryParam("planDate")String planDate) throws ServiceException{
		String token = this.getAuthorization();
		return visitFacade.queryVisitShopInfo(token, shopId, planDate);
	}
	
	/**
	 * shopscore页面
	 * score setting...
	 * 查询所有分数接口
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
	 * 保存巡店记录数据
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
	 * historyList页面 
	 * @author guihua.zhang on 2017-03-02
	 * @param startDate 前八周的第一天
	 * @param endDate 今日日期的前一天
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryVisitSummaryHistory")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<VisitHistorySummaryDto> queryVisitSummaryHistory(@QueryParam("startDate")String startDate, @QueryParam("endDate")String endDate)
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
	public VisitRecordInfoDto queryVisitRecordInfo(@QueryParam("visitId")String visitId) throws ServiceException {
		String token = this.getAuthorization();
		return visitFacade.queryVisitRecordInfo(token, visitId);
	}
	
	/**
	 * 重点机型信息查询列表查询
	 * @param shopId
	 * @param planDate
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryVisitModelInfo")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public List<VisitStockInfoDto> queryVisitModelInfo(@QueryParam("shopId")Long shopId, @QueryParam("planDate")String planDate) throws ServiceException {
		String token = this.getAuthorization();
		return visitFacade.queryVisitModelInfo(token, shopId, planDate);
	}
	
	/**
	 * web 巡店历史详情查询
	 * @param visitId
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryVisitHistoryDataByVisitId")
	@Produces({MediaType.APPLICATION_JSON})
	public VisitShopDetailDto queryVisitHistoryDataByVisitId(@QueryParam("visitId")Long visitId) throws ServiceException {
		return visitFacade.queryVisitHistoryDataByVisitId(visitId);
	}
	
	@GET
	@Path("/queryItelVisitHistoryDetailByVisitId")
	@Produces({MediaType.APPLICATION_JSON})
	public VisitHistoryDetailDto queryItelVisitHistoryDetailByVisitId(@QueryParam("visitId")Long visitId) throws ServiceException {
		return visitFacade.queryItelVisitHistoryDetailByVisitId(visitId);
	}
	
	/**
	 * 门店总销量导出Excel
	 * @param startDate
	 * @param endDate
	 * @param visitId
	 * @param shopCode
	 * @param shopName
	 * @param regionId
	 * @param createBy
	 * @param companyId
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportShopSaleExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getVisitShopSaleByExcel(@QueryParam("startDate") String startDate,
		@QueryParam("endDate") String endDate,@QueryParam("visitId") String visitId,
		@QueryParam("shopCode") String shopCode,@QueryParam("shopName") String shopName,
		@QueryParam("regionId")String regionId,@QueryParam("createBy") String createBy,
		@QueryParam("companyId") String companyId) throws ServiceException,IOException {
		
		Visit visit = new Visit();
		visit.setStartDate(startDate);
		visit.setEndDate(endDate);
		visit.setShopCode(shopCode);
		visit.setShopName(shopName);
		visit.setCreateBy(createBy);
		if(!UtilHelper.isEmpty(regionId)){
			visit.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(companyId)){
			visit.setCompanyId(Long.parseLong(companyId));
		}
		if(!UtilHelper.isEmpty(visitId)){
			visit.setId(Long.parseLong(visitId));
		}
		byte[] bytes = visitFacade.getVisitShopSaleByExcel(visit);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"门店总销量报表.xlsx";
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
	
	@GET
	@Path("/exportShopHistoryExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getShopHistoryByExcel(@QueryParam("startDate") String startDate,
		@QueryParam("endDate") String endDate,@QueryParam("visitId") String visitId,
		@QueryParam("shopCode") String shopCode,@QueryParam("shopName") String shopName,
		@QueryParam("regionId")String regionId,@QueryParam("createBy") String createBy,
		@QueryParam("companyId") String companyId,@QueryParam("planType") String planType) throws ServiceException,IOException {
		
		Visit visit = new Visit();
		visit.setStartDate(startDate);
		visit.setEndDate(endDate);
		visit.setShopCode(shopCode);
		visit.setShopName(shopName);
		visit.setCreateBy(createBy);
		if(!UtilHelper.isEmpty(regionId)){
			visit.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(companyId)){
			visit.setCompanyId(Long.parseLong(companyId));
		}
		if(!UtilHelper.isEmpty(visitId)){
			visit.setId(Long.parseLong(visitId));
		}
		if(!UtilHelper.isEmpty(planType)){
			visit.setPlanType(Integer.valueOf(planType));
		}
		byte[] bytes = visitFacade.getShopHistoryByExcel(visit);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"巡店历史报表.xlsx";
		response.header("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));         
		//根据自己文件类型修改         
		response.header("ContentType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");          
		return response.build();      	
	}

}
