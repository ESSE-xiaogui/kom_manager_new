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
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
import com.transsion.store.bo.ReportSaleWeek;
import com.transsion.store.dto.ReportSaleWeek4CityDto;
import com.transsion.store.facade.ReportSaleWeekFacade;
import com.transsion.store.utils.CalendarUtils;

@Controller
@Path("reportSaleWeek")
public class ReportSaleWeekController extends AbstractController{

	@Autowired
	private ReportSaleWeekFacade reportSaleWeekFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public ReportSaleWeek getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return reportSaleWeekFacade.getByPK(primaryKey);
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
	public Pagination<ReportSaleWeek> listPgReportSaleWeek(RequestModel<ReportSaleWeek> requestModel) throws ServiceException
	{
		Pagination<ReportSaleWeek> pagination = new Pagination<ReportSaleWeek>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return reportSaleWeekFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(ReportSaleWeek reportSaleWeek) throws ServiceException
	{
		reportSaleWeekFacade.save(reportSaleWeek);
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
		reportSaleWeekFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(ReportSaleWeek reportSaleWeek) throws ServiceException
	{
		reportSaleWeekFacade.update(reportSaleWeek);
	}
	
	/**
	 * 销量库存周报(导出Excel)
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
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response getReportSaleWeekListByExcel(
			@QueryParam("companyId") String companyId,
			@QueryParam("brandCode") String brandCode,
			@QueryParam("week") String week,
			@QueryParam("modelCode") String modelCode,
			@QueryParam("countryName") String countryName,
			@QueryParam("cityName")String cityName,
			@QueryParam("shopCode")String shopCode,
			@QueryParam("gradeId") String gradeId,
			@QueryParam("userCode") String userCode,
			@QueryParam("empName") String empName
		) throws ServiceException,IOException {
		ReportSaleWeek reportSaleWeek = new ReportSaleWeek();
		if(!UtilHelper.isEmpty(companyId)){
			reportSaleWeek.setCompanyId(Long.parseLong(companyId));
		}
		reportSaleWeek.setBrandCode(brandCode);
		if(!UtilHelper.isEmpty(week)){
			reportSaleWeek.setWeek(Integer.parseInt(week));
		}
		reportSaleWeek.setModelCode(modelCode);
		reportSaleWeek.setCountryName(countryName);
		reportSaleWeek.setCityName(cityName);
		reportSaleWeek.setShopCode(shopCode);
		if(!UtilHelper.isEmpty(gradeId)){
			reportSaleWeek.setGradeId(Long.parseLong(gradeId));
		}
		reportSaleWeek.setUserCode(userCode);
		reportSaleWeek.setEmpName(empName);
		
		byte[] bytes = reportSaleWeekFacade.getReportSaleWeekListByExcel(reportSaleWeek);
		InputStream inputStream = new ByteArrayInputStream(bytes);
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"销量库存周报报表.xlsx";
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
	 * 获取销量城市周报表
	 * @param requestModel
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/listPg4City")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ReportSaleWeek4CityDto> listPaginationCityWeekDataByRange(RequestModel<ReportSaleWeek4CityDto> requestModel) throws ServiceException {

		Pagination<ReportSaleWeek4CityDto> pagination = new Pagination<ReportSaleWeek4CityDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return reportSaleWeekFacade.listPaginationCityWeekDataByRange(pagination, requestModel.getParams());
	}

	/**
	 * 获取销量店铺周报表
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/listPg4Shop")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ReportSaleWeek> listPaginationShopWeekData(RequestModel<ReportSaleWeek> requestModel) throws ServiceException {
		Pagination<ReportSaleWeek> pagination = new Pagination<ReportSaleWeek>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return reportSaleWeekFacade.listPaginationShopWeekData(pagination, requestModel.getParams());

	}
	/**
	 * 获取当前日期所在年中的周数
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getWeekOfYear")
	@Produces({MediaType.APPLICATION_JSON})
	public int getWeekOfYear() throws ServiceException {
		return CalendarUtils.getWeekOfYear(new Date());
	}

	/**
	 * 根据输入周获取前8周列表
	 * @param week
	 * @return
	 */
	@GET
	@Path("/getWeeksBefore/{week}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Integer> getWeeksBefore(@PathParam("week") Integer week) throws ServiceException {
		return reportSaleWeekFacade.getWeeksBefore(week);
	}
	
	/**
	 * 重点机型销量周报报表
	 * @param requestModel
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/listPg4City")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ReportSaleWeek4CityDto> listPaginationModelWeekDataByRange(RequestModel<ReportSaleWeek4CityDto> requestModel) throws ServiceException {

		Pagination<ReportSaleWeek4CityDto> pagination = new Pagination<ReportSaleWeek4CityDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return reportSaleWeekFacade.listPaginationModelWeekDataByRange(pagination, requestModel.getParams());
	}
	
	/**
	 * 重点机型销量周报报表
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
	@Path("/exportExcelByModel") 
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response getReportModelWeekListByExcel(
			@QueryParam("companyId") String companyId,
			@QueryParam("brandCode") String brandCode,
			@QueryParam("week") String week,
			@QueryParam("modelCode") String modelCode,
			@QueryParam("countryName") String countryName,
			@QueryParam("cityName")String cityName,
			@QueryParam("shopCode")String shopCode,
			@QueryParam("gradeId") String gradeId,
			@QueryParam("userCode") String userCode,
			@QueryParam("empName") String empName
		) throws ServiceException,IOException {
		ReportSaleWeek reportSaleWeek = new ReportSaleWeek();
		if(!UtilHelper.isEmpty(companyId)){
			reportSaleWeek.setCompanyId(Long.parseLong(companyId));
		}
		reportSaleWeek.setBrandCode(brandCode);
		if(!UtilHelper.isEmpty(week)){
			reportSaleWeek.setWeek(Integer.parseInt(week));
		}
		reportSaleWeek.setModelCode(modelCode);
		reportSaleWeek.setCountryName(countryName);
		reportSaleWeek.setCityName(cityName);
		reportSaleWeek.setShopCode(shopCode);
		if(!UtilHelper.isEmpty(gradeId)){
			reportSaleWeek.setGradeId(Long.parseLong(gradeId));
		}
		reportSaleWeek.setUserCode(userCode);
		reportSaleWeek.setEmpName(empName);
		
		byte[] bytes = reportSaleWeekFacade.getReportModelWeekListByExcel(reportSaleWeek);
		InputStream inputStream = new ByteArrayInputStream(bytes);
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"重点机型销量周报报表.xlsx";
		response.header("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));   
		//根据自己文件类型修改
		response.header("ContentType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");  
		return response.build();
	}
	
	/**
	 * 城市周销量报表
	 * @param companyId
	 * @param brandCode
	 * @param week
	 * @param year
	 * @param areaId
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcelByReportSaleWeekCity") 
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response getReportSaleWeekCityByExcel(
			@QueryParam("companyId") String companyId,
			@QueryParam("brandCode") String brandCode,
			@QueryParam("week") String week,
			@QueryParam("year") String year,
			@QueryParam("regionId") String regionId,
			@QueryParam("areaId") String areaId
		) throws ServiceException,IOException {
		ReportSaleWeek reportSaleWeek = new ReportSaleWeek();
		if(!UtilHelper.isEmpty(companyId)){
			reportSaleWeek.setCompanyId(Long.parseLong(companyId));
		}
		reportSaleWeek.setBrandCode(brandCode);
		if(!UtilHelper.isEmpty(year)){
			reportSaleWeek.setYear(Integer.parseInt(year));
		}
		if(!UtilHelper.isEmpty(week)){
			reportSaleWeek.setWeek(Integer.parseInt(week));
		}
		if(!UtilHelper.isEmpty(areaId)){
			reportSaleWeek.setAreaId(Long.parseLong(areaId));
		}
		if(!UtilHelper.isEmpty(regionId)){
			reportSaleWeek.setRegionId(Long.parseLong(regionId));
		}
		
		byte[] bytes = reportSaleWeekFacade.getReportSaleWeekCityByExcel(reportSaleWeek);
		InputStream inputStream = new ByteArrayInputStream(bytes);
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"城市周销量报表.xlsx";
		response.header("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));   
		//根据自己文件类型修改
		response.header("ContentType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");  
		return response.build();
	}
	
	/**
	 * 门店总销量走势-按员工(分页查询)
	 * @param requestModel
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/listPgSRWeek")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ReportSaleWeek4CityDto> listPaginationSRWeekDataByRange(RequestModel<ReportSaleWeek4CityDto> requestModel) throws ServiceException {

		Pagination<ReportSaleWeek4CityDto> pagination = new Pagination<ReportSaleWeek4CityDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());
		
		return reportSaleWeekFacade.listPaginationSRWeekDataByRange(pagination, requestModel.getParams());
	}
	
	/**
	 * 门店总销量走势-按员工(导出)
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
	@Path("/exportExcelBySRWeek") 
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response getReportSRWeekListByExcel(
			@QueryParam("companyId") String companyId,
			@QueryParam("brandCode") String brandCode,
			@QueryParam("week") String week,
			@QueryParam("modelCode") String modelCode,
			@QueryParam("countryName") String countryName,
			@QueryParam("cityName")String cityName,
			@QueryParam("shopCode")String shopCode,
			@QueryParam("gradeId") String gradeId,
			@QueryParam("userCode") String userCode,
			@QueryParam("empName") String empName
		) throws ServiceException,IOException {
		ReportSaleWeek reportSaleWeek = new ReportSaleWeek();
		if(!UtilHelper.isEmpty(companyId)){
			reportSaleWeek.setCompanyId(Long.parseLong(companyId));
		}
		reportSaleWeek.setBrandCode(brandCode);
		if(!UtilHelper.isEmpty(week)){
			reportSaleWeek.setWeek(Integer.parseInt(week));
		}
		reportSaleWeek.setModelCode(modelCode);
		reportSaleWeek.setCountryName(countryName);
		reportSaleWeek.setCityName(cityName);
		reportSaleWeek.setShopCode(shopCode);
		if(!UtilHelper.isEmpty(gradeId)){
			reportSaleWeek.setGradeId(Long.parseLong(gradeId));
		}
		reportSaleWeek.setUserCode(userCode);
		reportSaleWeek.setEmpName(empName);
		
		byte[] bytes = reportSaleWeekFacade.getReportSRWeekListByExcel(reportSaleWeek);
		InputStream inputStream = new ByteArrayInputStream(bytes);
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"重点机型销量统计报表.xlsx";
		response.header("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));   
		//根据自己文件类型修改
		response.header("ContentType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");  
		return response.build();
	}
	
	/**
	 * 重点机型销量走势(分页查询)
	 * @param requestModel
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/listPgSaleModel")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ReportSaleWeek4CityDto> listPaginationSaleModelByRange(RequestModel<ReportSaleWeek4CityDto> requestModel) throws ServiceException {

		Pagination<ReportSaleWeek4CityDto> pagination = new Pagination<ReportSaleWeek4CityDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());
		
		return reportSaleWeekFacade.listPaginationSaleModelByRange(pagination, requestModel.getParams());
	}
	
	/**
	 * 重点机型销量走势(导出)
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
	@Path("/exportExcelSaleModel") 
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response getReportSaleModelListByExcel(
			@QueryParam("companyId") String companyId,
			@QueryParam("brandCode") String brandCode,
			@QueryParam("areaId") String areaId,
			@QueryParam("regionType") String regionType,
			@QueryParam("regionId") String regionId,
			@QueryParam("year") String year,
			@QueryParam("week") String week
		) throws ServiceException,IOException {
		ReportSaleWeek reportSaleWeek = new ReportSaleWeek();
		if(!UtilHelper.isEmpty(companyId)){
			reportSaleWeek.setCompanyId(Long.parseLong(companyId));
		}
		reportSaleWeek.setBrandCode(brandCode);
		if(!UtilHelper.isEmpty(areaId)){
			reportSaleWeek.setAreaId(Long.parseLong(areaId));
		}
		if(!UtilHelper.isEmpty(regionType)){
			reportSaleWeek.setRegionType(Integer.parseInt(regionType));
		}
		if(!UtilHelper.isEmpty(regionId)){
			reportSaleWeek.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(year)){
			reportSaleWeek.setYear(Integer.parseInt(year));
		}
		if(!UtilHelper.isEmpty(week)){
			reportSaleWeek.setWeek(Integer.parseInt(week));
		}
		
		byte[] bytes = reportSaleWeekFacade.getReportSaleModelListByExcel(reportSaleWeek);
		InputStream inputStream = new ByteArrayInputStream(bytes);
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"重点机型销量走势报表.xlsx";
		response.header("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));   
		//根据自己文件类型修改
		response.header("ContentType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");  
		return response.build();
	}
}
