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
import com.transsion.store.bo.VisitFeedback;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitFeedBackInfoDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.VisitFeedbackFacade;
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
@Path("visitFeedback")
public class VisitFeedbackController extends AbstractController{

	@Autowired
	private VisitFeedbackFacade visitFeedbackFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public VisitFeedback getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return visitFeedbackFacade.getByPK(primaryKey);
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
	public Pagination<VisitFeedBackInfoDto> listPgVisitFeedback(RequestModel<VisitFeedBackInfoDto> requestModel) throws ServiceException
	{
		Pagination<VisitFeedBackInfoDto> pagination = new Pagination<VisitFeedBackInfoDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return visitFeedbackFacade.listPaginationByProperty(pagination, requestModel.getParams(),this.getAuthorization());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(VisitFeedback visitFeedback) throws ServiceException
	{
		visitFeedbackFacade.save(visitFeedback);
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
		visitFeedbackFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(VisitFeedback visitFeedback) throws ServiceException
	{
		visitFeedbackFacade.update(visitFeedback);
	}

	/**
	 * 问题反馈导出Excel
	 * @param createTimeStart
	 * @param createTimeEnd
	 * @param visitNo
	 * @param regionId
	 * @param shopCode
	 * @param createBy
	 * @param companyId
	 * @param shopName
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getVisitFeedBackByExcel(@QueryParam("createTimeStart") String createTimeStart,
		@QueryParam("createTimeEnd") String createTimeEnd,@QueryParam("visitNo") String visitNo,
		@QueryParam("regionId")String regionId,@QueryParam("shopCode")String shopCode,
		@QueryParam("createBy") String createBy,@QueryParam("companyId") String companyId,
		@QueryParam("shopName") String shopName) throws ServiceException,IOException {
		
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(this.getAuthorization());
		VisitFeedBackInfoDto visitFeedBackInfoDto = new VisitFeedBackInfoDto();
		visitFeedBackInfoDto.setCreateTimeStart(createTimeStart);
		visitFeedBackInfoDto.setCreateTimeEnd(createTimeEnd);
		visitFeedBackInfoDto.setVisitNo(visitNo);
		visitFeedBackInfoDto.setShopCode(shopCode);
		visitFeedBackInfoDto.setCreateBy(createBy);
		visitFeedBackInfoDto.setShopName(shopName);
		if(!UtilHelper.isEmpty(regionId)){
			visitFeedBackInfoDto.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(companyId)){
			visitFeedBackInfoDto.setCompanyId(Integer.valueOf(companyId));
		}else{
			visitFeedBackInfoDto.setCompanyId(userContext.isAdmin()?null:userContext.getCompanyId().intValue());
		}
		byte[] bytes = visitFeedbackFacade.getVisitFeedBackByExcel(visitFeedBackInfoDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"问题反馈报表.xlsx";
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
