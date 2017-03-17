/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-16 14:43:27
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
import com.transsion.store.bo.ReportShopOtcRate;
import com.transsion.store.facade.ReportShopOtcRateFacade;

@Controller
@Path("reportShopOtcRate")
public class ReportShopOtcRateController extends AbstractController{

	@Autowired
	private ReportShopOtcRateFacade reportShopOtcRateFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public ReportShopOtcRate getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return reportShopOtcRateFacade.getByPK(primaryKey);
	}

	/**
	* ITEL销售代表门店覆盖率监控分页查询
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/listPg")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ReportShopOtcRate> listPgReportShopOtcRate(RequestModel<ReportShopOtcRate> requestModel) throws ServiceException
	{
		Pagination<ReportShopOtcRate> pagination = new Pagination<ReportShopOtcRate>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return reportShopOtcRateFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(ReportShopOtcRate reportShopOtcRate) throws ServiceException
	{
		reportShopOtcRateFacade.save(reportShopOtcRate);
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
		reportShopOtcRateFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(ReportShopOtcRate reportShopOtcRate) throws ServiceException
	{
		reportShopOtcRateFacade.update(reportShopOtcRate);
	}
	
	/**
	 * itel销售代表门店覆盖率监控Excel报表导出
	 * @param visitDate
	 * @param modelCode
	 * @param companyId
	 * @param brandCode
	 * @param countryId
	 * @param regionId
	 * @param cityId
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response queryReportShopOtcRateList(
			@QueryParam("visitDate") String visitDate,
			@QueryParam("modelCode") String modelCode,
			@QueryParam("companyId") String companyId,
			@QueryParam("brandCode") String brandCode,
			@QueryParam("countryId") String countryId,
			@QueryParam("regionId") String regionId,
			@QueryParam("cityId") String cityId,
			@QueryParam("regionType") String regionType
		) throws ServiceException,IOException {
		ReportShopOtcRate reportShopOtcRate = new ReportShopOtcRate();
		reportShopOtcRate.setVisitDate(visitDate);
		reportShopOtcRate.setModelCode(modelCode);
		if(!UtilHelper.isEmpty(companyId)){
			reportShopOtcRate.setCompanyId(Long.parseLong(companyId));
		}
		reportShopOtcRate.setBrandCode(brandCode);
		if(!UtilHelper.isEmpty(countryId)){
			reportShopOtcRate.setCompanyId(Long.parseLong(countryId));
		}
		if(!UtilHelper.isEmpty(regionType)){
			reportShopOtcRate.setRegionType(Integer.parseInt(regionType));
		}
		if(!UtilHelper.isEmpty(regionId)){
			reportShopOtcRate.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(cityId)){
			reportShopOtcRate.setCityId(Long.parseLong(cityId));
		}
		byte[] bytes = reportShopOtcRateFacade.queryReportShopOtcRateList(reportShopOtcRate);
		InputStream inputStream = new ByteArrayInputStream(bytes);
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"TOP机型报表.xlsx";
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
            IOUtils.copy(inputStream, output);
        }

        public InputStream getInputStream() {
            return inputStream;
        }
        public void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }
    }
	
	@POST
	@Path("/listPgReportShopOtcRateByCity")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ReportShopOtcRate> listPgReportShopOtcRateByCity(RequestModel<ReportShopOtcRate> requestModel) throws ServiceException
	{
		Pagination<ReportShopOtcRate> pagination = new Pagination<ReportShopOtcRate>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return reportShopOtcRateFacade.listPgReportShopOtcRateByCity(pagination, requestModel.getParams());
	}
	
	@GET
	@Path("/exportExcelByCity") 
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response queryReportShopOtcRateListByCity(
			@QueryParam("visitDate") String visitDate,
			@QueryParam("modelCode") String modelCode,
			@QueryParam("companyId") String companyId,
			@QueryParam("brandCode") String brandCode,
			@QueryParam("countryId") String countryId,
			@QueryParam("regionId") String regionId,
			@QueryParam("cityId") String cityId
		) throws ServiceException,IOException {
		ReportShopOtcRate reportShopOtcRate = new ReportShopOtcRate();
		reportShopOtcRate.setVisitDate(visitDate);
		reportShopOtcRate.setModelCode(modelCode);
		if(!UtilHelper.isEmpty(companyId)){
			reportShopOtcRate.setCompanyId(Long.parseLong(companyId));
		}
		reportShopOtcRate.setBrandCode(brandCode);
		if(!UtilHelper.isEmpty(countryId)){
			reportShopOtcRate.setCompanyId(Long.parseLong(countryId));
		}
		if(!UtilHelper.isEmpty(regionId)){
			reportShopOtcRate.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(cityId)){
			reportShopOtcRate.setCityId(Long.parseLong(cityId));
		}
		byte[] bytes = reportShopOtcRateFacade.queryReportShopOtcRateListByCity(reportShopOtcRate);
		InputStream inputStream = new ByteArrayInputStream(bytes);
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"TOP机型报表.xlsx";
		response.header("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));   
		//根据自己文件类型修改
		response.header("ContentType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");  
		return response.build();
	}
}
