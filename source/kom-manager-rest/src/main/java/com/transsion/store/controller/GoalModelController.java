/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-7 16:29:09
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
import com.transsion.store.bo.GoalModel;
import com.transsion.store.dto.GoalModelInfoDto;
import com.transsion.store.facade.GoalModelFacade;

@Controller
@Path("goalModel")
public class GoalModelController extends AbstractController{

	@Autowired
	private GoalModelFacade goalModelFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public GoalModel getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return goalModelFacade.getByPK(primaryKey);
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
	public Pagination<GoalModelInfoDto> listPgGoalModel(RequestModel<GoalModelInfoDto> requestModel) throws ServiceException
	{
		Pagination<GoalModelInfoDto> pagination = new Pagination<GoalModelInfoDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return goalModelFacade.listPaginationByProperty(pagination, requestModel.getParams(),this.getAuthorization());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(GoalModel goalModel) throws ServiceException
	{
		goalModelFacade.save(goalModel);
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
		goalModelFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(GoalModel goalModel) throws ServiceException
	{
		goalModelFacade.update(goalModel);
	}
	
	@GET
	@Path("calcShopModelSaleQty")
	public void calcShopModelSaleQty() throws ServiceException {
		goalModelFacade.calcShopModelSaleQty();
	}
	
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getGoalModelByExcel (@QueryParam("goalMonthStart") String goalMonthStart,
		@QueryParam("goalMonthEnd") String goalMonthEnd,@QueryParam("shopCode") String shopCode,
		@QueryParam("shopName") String shopName,@QueryParam("regionId")String regionId,
		@QueryParam("modelCode")String modelCode,@QueryParam("createBy") String createBy,
		@QueryParam("companyId") String companyId,@QueryParam("creatorName") String creatorName) throws ServiceException,IOException {
		
		GoalModelInfoDto goalModelInfoDto = new GoalModelInfoDto();
		goalModelInfoDto.setGoalMonthStart(goalMonthStart);
		goalModelInfoDto.setGoalMonthEnd(goalMonthEnd);
		goalModelInfoDto.setShopCode(shopCode);
		goalModelInfoDto.setShopName(shopName);
		goalModelInfoDto.setModelCode(modelCode);
		goalModelInfoDto.setCreateBy(createBy);
		goalModelInfoDto.setCreatorName(creatorName);
		if(!UtilHelper.isEmpty(regionId)){
			goalModelInfoDto.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(companyId)){
			goalModelInfoDto.setCompanyId(Long.parseLong(companyId));
		}
		byte[] bytes = goalModelFacade.getGoalModelByExcel(goalModelInfoDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"重点机型销售目标设定报表.xlsx";
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
