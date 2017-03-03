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

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.VisitCompetitor;
import com.transsion.store.controller.VisitSaleController.BigFileOutputStream;
import com.transsion.store.dto.VisitCompetitorDetailDto;
import com.transsion.store.dto.VisitSaleInfoDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.VisitCompetitorFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@Path("visitCompetitor")
public class VisitCompetitorController extends AbstractController{

	@Autowired
	private VisitCompetitorFacade visitCompetitorFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public VisitCompetitor getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return visitCompetitorFacade.getByPK(primaryKey);
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
	public Pagination<VisitCompetitorDetailDto> listPgVisitCompetitor(RequestModel<VisitCompetitorDetailDto> requestModel) throws ServiceException
	{
 		Pagination<VisitCompetitorDetailDto> pagination = new Pagination<VisitCompetitorDetailDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return visitCompetitorFacade.listPaginationByProperty(pagination, requestModel.getParams(),this.getAuthorization());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(VisitCompetitor visitCompetitor) throws ServiceException
	{
		visitCompetitorFacade.save(visitCompetitor);
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
		visitCompetitorFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(VisitCompetitor visitCompetitor) throws ServiceException
	{
		visitCompetitorFacade.update(visitCompetitor);
	}
	
	/**
	 * 竞品销量导出Excel
	 * @param createTimeStart
	 * @param createTimeEnd
	 * @param visitId
	 * @param shopCode
	 * @param shopName
	 * @param regionId
	 * @param modelName
	 * @param createBy
	 * @param companyId
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getVisitCompetitorByExcel(@QueryParam("createTimeStart") String createTimeStart,
		@QueryParam("createTimeEnd") String createTimeEnd,@QueryParam("visitId") String visitId,
		@QueryParam("shopCode") String shopCode,@QueryParam("shopName") String shopName,
		@QueryParam("regionId")String regionId,@QueryParam("brandName")String brandName,
		@QueryParam("createBy") String createBy,@QueryParam("companyId") String companyId) throws ServiceException,IOException {
		VisitCompetitorDetailDto vCompetitorDetailDto = new VisitCompetitorDetailDto();
		vCompetitorDetailDto.setCreateTimeStart(createTimeStart);
		vCompetitorDetailDto.setCreateTimeEnd(createTimeEnd);
		vCompetitorDetailDto.setShopCode(shopCode);
		vCompetitorDetailDto.setShopName(shopName);
		vCompetitorDetailDto.setCreateBy(createBy);
		vCompetitorDetailDto.setBrandName(brandName);
		if(!UtilHelper.isEmpty(regionId)){
			vCompetitorDetailDto.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(companyId)){
			vCompetitorDetailDto.setCompanyId(Long.parseLong(companyId));
		}
		if(!UtilHelper.isEmpty(visitId)){
			vCompetitorDetailDto.setVisitId(Long.parseLong(visitId));
		}
		byte[] bytes = visitCompetitorFacade.getVisitCompetitorByExcel(vCompetitorDetailDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"竞品销量报表.xlsx";
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
