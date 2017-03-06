/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-1 16:31:41
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.PrototypeCounting;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.PrototypeCountingDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.PrototypeCountingFacade;
import com.transsion.store.utils.CacheUtils;
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
@Path("prototypeCounting")
public class PrototypeCountingController extends AbstractController{

	@Autowired
	private PrototypeCountingFacade prototypeCountingFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public PrototypeCounting getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeCountingFacade.getByPK(primaryKey);
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
	public Pagination<PrototypeCountingDto> listPgPrototypeCounting(RequestModel<PrototypeCountingDto> requestModel) throws ServiceException
	{
		Pagination<PrototypeCountingDto> pagination = new Pagination<PrototypeCountingDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return prototypeCountingFacade.listPaginationByProperty(pagination, requestModel.getParams(),this.getAuthorization());
	}

	/**
	* 新增样机盘点
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(PrototypeCounting prototypeCounting) throws ServiceException {
		String token = this.getAuthorization();
		prototypeCountingFacade.save(prototypeCounting, token);
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
		prototypeCountingFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(PrototypeCounting prototypeCounting) throws ServiceException
	{
		prototypeCountingFacade.update(prototypeCounting);
	}
	
	/**
	 * 样机盘点与追踪导出Excel
	 * @param createTimeStart
	 * @param createTimeEnd
	 * @param countingTimeStart
	 * @param countingTimeEnd
	 * @param brandId
	 * @param shopCode
	 * @param shopName
	 * @param regionId
	 * @param modelName
	 * @param createBy
	 * @param companyId
	 * @param status
	 * @param imeiNo
	 * @param prototypeId
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getPrototypeCountingByExcel(@QueryParam("createTimeStart") String createTimeStart,
		@QueryParam("createTimeEnd") String createTimeEnd,@QueryParam("countingTimeStart") String countingTimeStart,
		@QueryParam("countingTimeEnd") String countingTimeEnd,@QueryParam("brandId") String brandId,
		@QueryParam("shopCode") String shopCode,@QueryParam("shopName") String shopName,
		@QueryParam("regionId")String regionId,@QueryParam("modelName")String modelName,
		@QueryParam("createBy") String createBy,@QueryParam("companyId") String companyId,
		@QueryParam("status") String status,@QueryParam("imeiNo") String imeiNo,
		@QueryParam("prototypeId") String prototypeId) throws ServiceException,IOException {
		
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(this.getAuthorization());
		PrototypeCountingDto prototypeCountingDto = new PrototypeCountingDto();
		prototypeCountingDto.setCreateTimeStart(createTimeStart);
		prototypeCountingDto.setCreateTimeEnd(createTimeEnd);
		prototypeCountingDto.setShopCode(shopCode);
		prototypeCountingDto.setShopName(shopName);
		prototypeCountingDto.setCreateBy(createBy);
		prototypeCountingDto.setModelName(modelName);
		prototypeCountingDto.setImeiNo(imeiNo);
		prototypeCountingDto.setCountingTimeStart(countingTimeStart);
		prototypeCountingDto.setCountingTimeEnd(countingTimeEnd);
		if(!UtilHelper.isEmpty(regionId)){
			prototypeCountingDto.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(companyId)){
			prototypeCountingDto.setCompanyId(Long.parseLong(companyId));
		}else{
			prototypeCountingDto.setCompanyId(userContext.isAdmin()?null:userContext.getCompanyId());
		}
		if(!UtilHelper.isEmpty(brandId)){
			prototypeCountingDto.setBrandId(Long.parseLong(brandId));
		}
		if(!UtilHelper.isEmpty(status)){
			prototypeCountingDto.setStatus(Integer.valueOf(status));
		}
		if(!UtilHelper.isEmpty(prototypeId)){
			prototypeCountingDto.setBrandId(Long.parseLong(prototypeId));
		}
		byte[] bytes = prototypeCountingFacade.getPrototypeCountingByExcel(prototypeCountingDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"样机盘点计划与追踪报表.xlsx";
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
