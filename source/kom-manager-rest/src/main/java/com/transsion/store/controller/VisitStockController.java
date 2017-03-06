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
import com.transsion.store.bo.VisitStock;
import com.transsion.store.dto.VisitStockDetailDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.VisitStockFacade;
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
@Path("visitStock")
public class VisitStockController extends AbstractController{

	@Autowired
	private VisitStockFacade visitStockFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public VisitStock getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return visitStockFacade.getByPK(primaryKey);
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
	public Pagination<VisitStockDetailDto> listPgVisitStock(RequestModel<VisitStockDetailDto> requestModel) throws ServiceException
	{
		Pagination<VisitStockDetailDto> pagination = new Pagination<VisitStockDetailDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return visitStockFacade.listPaginationByProperty(pagination, requestModel.getParams(),this.getAuthorization());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(VisitStock visitStock) throws ServiceException
	{
		visitStockFacade.save(visitStock);
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
		visitStockFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(VisitStock visitStock) throws ServiceException
	{
		visitStockFacade.update(visitStock);
	}
	
	@GET
	@Path("/queryVisitStockList")
	@Produces({MediaType.APPLICATION_JSON})
	public List<VisitStockDetailDto> queryVisitStockList() throws ServiceException {
		return visitStockFacade.queryVisitStockList();
	}
	
	/**
	 * 重点机型库存导出Excel
	 * @param createTimeStart
	 * @param createTimeEnd
	 * @param visitId
	 * @param shopCode
	 * @param shopName
	 * @param regionId
	 * @param modelId
	 * @param createBy
	 * @param companyId
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getVisitStockByExcel(@QueryParam("createTimeStart") String createTimeStart,
		@QueryParam("createTimeEnd") String createTimeEnd,@QueryParam("visitId") String visitId,
		@QueryParam("shopCode") String shopCode,@QueryParam("shopName") String shopName,
		@QueryParam("regionId")String regionId,@QueryParam("modelName")String modelName,
		@QueryParam("createBy") String createBy,@QueryParam("companyId") String companyId) throws ServiceException,IOException {
		
		VisitStockDetailDto visitStockDetailDto = new VisitStockDetailDto();
		visitStockDetailDto.setCreateTimeStart(createTimeStart);
		visitStockDetailDto.setCreateTimeEnd(createTimeEnd);
		visitStockDetailDto.setShopCode(shopCode);
		visitStockDetailDto.setShopName(shopName);
		visitStockDetailDto.setCreateBy(createBy);
		visitStockDetailDto.setModelName(modelName);
		if(!UtilHelper.isEmpty(regionId)){
			visitStockDetailDto.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(companyId)){
			visitStockDetailDto.setCompanyId(Long.parseLong(companyId));
		}
		if(!UtilHelper.isEmpty(visitId)){
			visitStockDetailDto.setVisitId(Long.parseLong(visitId));
		}
		byte[] bytes = visitStockFacade.getVisitStockByExcel(visitStockDetailDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"重点机型库存报表.xlsx";
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
