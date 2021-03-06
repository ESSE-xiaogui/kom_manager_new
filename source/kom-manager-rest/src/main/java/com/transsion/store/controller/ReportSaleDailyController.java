/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-7 11:42:41
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
import com.transsion.store.bo.ReportSaleDaily;
import com.transsion.store.dto.ReportSaleDailyDto;
import com.transsion.store.facade.ReportSaleDailyFacade;

@Controller
@Path("reportSaleDaily")
public class ReportSaleDailyController extends AbstractController{

	@Autowired
	private ReportSaleDailyFacade reportSaleDailyFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public ReportSaleDaily getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return reportSaleDailyFacade.getByPK(primaryKey);
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
	public Pagination<ReportSaleDailyDto> listPgReportSaleDailyDto(RequestModel<ReportSaleDailyDto> requestModel) throws ServiceException
	{
		Pagination<ReportSaleDailyDto> pagination = new Pagination<ReportSaleDailyDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return reportSaleDailyFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(ReportSaleDaily reportSaleDaily) throws ServiceException
	{
		reportSaleDailyFacade.save(reportSaleDaily);
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
		reportSaleDailyFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(ReportSaleDaily reportSaleDaily) throws ServiceException
	{
		reportSaleDailyFacade.update(reportSaleDaily);
	}
	
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})
	public Response exportExcelByReportSaleDaily(@QueryParam("companyName") String companyName, @QueryParam("brandCode") String brandCode,
			@QueryParam("saleDate") String saleDate,@QueryParam("week") String week,@QueryParam("countryName") String countryName,
			@QueryParam("cityName") String cityName,@QueryParam("shopCode") String shopCode,@QueryParam("shopName") String shopName,
			@QueryParam("gradeName") String gradeName,@QueryParam("userCode") String userCode,@QueryParam("empName") String empName,
			@QueryParam("modelCode") String modelCode,@QueryParam("saleQty") String saleQty,@QueryParam("stockQty") String stockQty
			) throws ServiceException,IOException {
		
		ReportSaleDailyDto reportSaleDailyDto = new ReportSaleDailyDto();

		reportSaleDailyDto.setCompanyName(companyName);
		reportSaleDailyDto.setBrandCode(brandCode);
		reportSaleDailyDto.setSaleDate(saleDate);
		reportSaleDailyDto.setWeek(Integer.valueOf(week));
		reportSaleDailyDto.setCountryName(countryName);
		reportSaleDailyDto.setCityName(cityName);
		reportSaleDailyDto.setShopCode(shopCode);
		reportSaleDailyDto.setShopName(shopName);
		reportSaleDailyDto.setGradeName(gradeName);
		reportSaleDailyDto.setUserCode(userCode);
		reportSaleDailyDto.setEmpName(empName);
		reportSaleDailyDto.setModelCode(modelCode);
		reportSaleDailyDto.setSaleQty(Integer.valueOf(saleQty));
		reportSaleDailyDto.setStockQty(Integer.valueOf(stockQty));
		
		byte[] bytes = reportSaleDailyFacade.getReportSaleDailyByExcel(reportSaleDailyDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"库存销量日报表.xlsx";
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
	
	/**
	 * TOP 门店查询(分页)
	 * @param requestModel
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/listPgTopShop")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ReportSaleDaily> listPaginationByShop(RequestModel<ReportSaleDaily> requestModel) throws ServiceException
	{
		Pagination<ReportSaleDaily> pagination = new Pagination<ReportSaleDaily>();

		pagination.setPaginationFlag(false);
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return reportSaleDailyFacade.listPaginationByShop(pagination, requestModel.getParams());
	}
	
	/**
	 * TOP 门店查询(导出)
	 * @param startDate
	 * @param endDate
	 * @param companyId
	 * @param brandCode
	 * @param areaId
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcelByShop") 
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response queryReportSaleDailyListByShop(
			@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate,
			@QueryParam("companyId") String companyId,
			@QueryParam("brandCode") String brandCode,
			@QueryParam("areaId") String areaId
		) throws ServiceException,IOException {
		ReportSaleDaily reportSaleDaily = new ReportSaleDaily();
		reportSaleDaily.setStartDate(startDate);
		reportSaleDaily.setEndDate(endDate);
		if(!UtilHelper.isEmpty(companyId)){
			reportSaleDaily.setCompanyId(Long.parseLong(companyId));
		}
		reportSaleDaily.setBrandCode(brandCode);
		if(!UtilHelper.isEmpty(areaId)){
			reportSaleDaily.setAreaId(Long.parseLong(areaId));
		}
		
		byte[] bytes = reportSaleDailyFacade.queryReportSaleDailyListByShop(reportSaleDaily);
		InputStream inputStream = new ByteArrayInputStream(bytes);
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"TOP门店报表.xlsx";
		response.header("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));   
		//根据自己文件类型修改
		response.header("ContentType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");  
		return response.build();
	}
	
	/**
	 * TOP 促销员查询(分页)
	 * @param requestModel
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/listPgTopSale")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ReportSaleDaily> listPaginationBySale(RequestModel<ReportSaleDaily> requestModel) throws ServiceException
	{
		Pagination<ReportSaleDaily> pagination = new Pagination<ReportSaleDaily>();

		pagination.setPaginationFlag(false);
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return reportSaleDailyFacade.listPaginationBySale(pagination, requestModel.getParams());
	}
	
	/**
	 * TOP 促销员查询(导出)
	 * @param startDate
	 * @param endDate
	 * @param companyId
	 * @param brandCode
	 * @param areaId
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcelBySale") 
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response queryReportSaleDailyListBySale(
			@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate,
			@QueryParam("companyId") String companyId,
			@QueryParam("brandCode") String brandCode,
			@QueryParam("areaId") String areaId
		) throws ServiceException,IOException {
		ReportSaleDaily reportSaleDaily = new ReportSaleDaily();
		reportSaleDaily.setStartDate(startDate);
		reportSaleDaily.setEndDate(endDate);
		if(!UtilHelper.isEmpty(companyId)){
			reportSaleDaily.setCompanyId(Long.parseLong(companyId));
		}
		reportSaleDaily.setBrandCode(brandCode);
		if(!UtilHelper.isEmpty(areaId)){
			reportSaleDaily.setAreaId(Long.parseLong(areaId));
		}
		
		byte[] bytes = reportSaleDailyFacade.queryReportSaleDailyListBySale(reportSaleDaily);
		InputStream inputStream = new ByteArrayInputStream(bytes);
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"TOP促销员报表.xlsx";
		response.header("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));   
		//根据自己文件类型修改
		response.header("ContentType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");  
		return response.build();
	}
	
	/**
	 * TOP 机型查询(分页)
	 * @param requestModel
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/listPgTopModel")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ReportSaleDaily> listPaginationByModel(RequestModel<ReportSaleDaily> requestModel) throws ServiceException
	{
		Pagination<ReportSaleDaily> pagination = new Pagination<ReportSaleDaily>();

		pagination.setPaginationFlag(false);
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return reportSaleDailyFacade.listPaginationByModel(pagination, requestModel.getParams());
	}
	
	/**
	 * TOP 机型查询(导出)
	 * @param startDate
	 * @param endDate
	 * @param companyId
	 * @param brandCode
	 * @param areaId
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcelByModel") 
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response queryReportSaleDailyListByModel(
			@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate,
			@QueryParam("companyId") String companyId,
			@QueryParam("brandCode") String brandCode,
			@QueryParam("areaId") String areaId
		) throws ServiceException,IOException {
		ReportSaleDaily reportSaleDaily = new ReportSaleDaily();
		reportSaleDaily.setStartDate(startDate);
		reportSaleDaily.setEndDate(endDate);
		if(!UtilHelper.isEmpty(companyId)){
			reportSaleDaily.setCompanyId(Long.parseLong(companyId));
		}
		reportSaleDaily.setBrandCode(brandCode);
		if(!UtilHelper.isEmpty(areaId)){
			reportSaleDaily.setAreaId(Long.parseLong(areaId));
		}
		
		byte[] bytes = reportSaleDailyFacade.queryReportSaleDailyListByModel(reportSaleDaily);
		InputStream inputStream = new ByteArrayInputStream(bytes);
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"TOP机型报表.xlsx";
		response.header("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));   
		//根据自己文件类型修改
		response.header("ContentType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");  
		return response.build();
	}
	
	/**
	 * 重点机型销量统计(分页查询)
	 * @param requestModel
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/listPgSaleModelData")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ReportSaleDailyDto> listPgSaleModelData(RequestModel<ReportSaleDailyDto> requestModel) throws ServiceException
	{
		Pagination<ReportSaleDailyDto> pagination = new Pagination<ReportSaleDailyDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());
		return reportSaleDailyFacade.listPgSaleModelData(pagination, requestModel.getParams());
	}
	
	/**
	 * 重点机型销量统计(导出)
	 * @param companyId
	 * @param brandCode
	 * @param week
	 * @param modelCode
	 * @param countryName
	 * @param cityName
	 * @param shopCode
	 * @param gradeId
	 * @param userCode
	 * @param empName
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcelBySaleModel") 
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response getReportSaleModeListByExcel(
			@QueryParam("beginSaleTime") String beginSaleTime,
			@QueryParam("endSaleTime") String endSaleTime,
			@QueryParam("companyId") String companyId,
			@QueryParam("brandCode") String brandCode,
			@QueryParam("areaId") String areaId,
			@QueryParam("modelCode") String modelCode
		) throws ServiceException,IOException {
		ReportSaleDailyDto reportSaleDailyDto = new ReportSaleDailyDto();
		reportSaleDailyDto.setBeginSaleTime(beginSaleTime);
		reportSaleDailyDto.setEndSaleTime(endSaleTime);
		if(!UtilHelper.isEmpty(companyId)){
			reportSaleDailyDto.setCompanyId(Long.parseLong(companyId));
		}
		reportSaleDailyDto.setBrandCode(brandCode);
		if(!UtilHelper.isEmpty(areaId)){
			reportSaleDailyDto.setAreaId(Long.parseLong(areaId));
		}
		reportSaleDailyDto.setModelCode(modelCode);
		byte[] bytes = reportSaleDailyFacade.getReportSaleModelListByExcel(reportSaleDailyDto);
		InputStream inputStream = new ByteArrayInputStream(bytes);
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"重点机型销量统计报表.xlsx";
		response.header("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));   
		//根据自己文件类型修改
		response.header("ContentType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");  
		return response.build();
	}
}
