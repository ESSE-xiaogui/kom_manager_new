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

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.GoalPromoter;
import com.transsion.store.controller.GoalSupervisorController.BigFileOutputStream;
import com.transsion.store.dto.GoalPromoterInfoDto;
import com.transsion.store.dto.GoalSupervisorInfoDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.GoalPromoterFacade;
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
@Path("goalPromoter")
public class GoalPromoterController extends AbstractController{

	@Autowired
	private GoalPromoterFacade goalPromoterFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public GoalPromoter getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return goalPromoterFacade.getByPK(primaryKey);
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
	public Pagination<GoalPromoterInfoDto> listPgGoalPromoter(RequestModel<GoalPromoterInfoDto> requestModel) throws ServiceException
	{
		Pagination<GoalPromoterInfoDto> pagination = new Pagination<GoalPromoterInfoDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return goalPromoterFacade.listPaginationByProperty(pagination, requestModel.getParams(),this.getAuthorization());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(GoalPromoter goalPromoter) throws ServiceException
	{
		goalPromoterFacade.save(goalPromoter);
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
		goalPromoterFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(GoalPromoter goalPromoter) throws ServiceException
	{
		goalPromoterFacade.update(goalPromoter);
	}
	
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getGoalPromoterByExcel (@QueryParam("goalMonthStart") String goalMonthStart,
		@QueryParam("goalMonthEnd") String goalMonthEnd,@QueryParam("empName") String empName,
		@QueryParam("shopCode") String shopCode,@QueryParam("shopName") String shopName,
		@QueryParam("regionId")String regionId,@QueryParam("userCode")String userCode,
		@QueryParam("createBy") String createBy,@QueryParam("companyId") String companyId,
		@QueryParam("creatorName") String creatorName) throws ServiceException,IOException {
		
		GoalPromoterInfoDto goalPromoterInfoDto = new GoalPromoterInfoDto();
		goalPromoterInfoDto.setGoalMonthStart(goalMonthStart);
		goalPromoterInfoDto.setGoalMonthEnd(goalMonthEnd);
		goalPromoterInfoDto.setShopCode(shopCode);
		goalPromoterInfoDto.setShopName(shopName);
		goalPromoterInfoDto.setCreateBy(createBy);
		goalPromoterInfoDto.setEmpName(empName);
		goalPromoterInfoDto.setUserCode(userCode);
		goalPromoterInfoDto.setCreatorName(creatorName);
		if(!UtilHelper.isEmpty(regionId)){
			goalPromoterInfoDto.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(companyId)){
			goalPromoterInfoDto.setCompanyId(Long.parseLong(companyId));
		}
		byte[] bytes = goalPromoterFacade.getGoalPromoterByExcel(goalPromoterInfoDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"巡店员销售目标设定报表.xlsx";
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
