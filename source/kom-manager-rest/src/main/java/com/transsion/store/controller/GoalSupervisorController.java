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
import com.transsion.store.bo.GoalSupervisor;
import com.transsion.store.dto.GoalSupervisorInfoDto;
import com.transsion.store.facade.GoalSupervisorFacade;

@Controller
@Path("goalSupervisor")
public class GoalSupervisorController extends AbstractController{

	@Autowired
	private GoalSupervisorFacade goalSupervisorFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public GoalSupervisor getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return goalSupervisorFacade.getByPK(primaryKey);
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
	public Pagination<GoalSupervisorInfoDto> listPgGoalSupervisor(RequestModel<GoalSupervisorInfoDto> requestModel) throws ServiceException
	{
		Pagination<GoalSupervisorInfoDto> pagination = new Pagination<GoalSupervisorInfoDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return goalSupervisorFacade.listPaginationByProperty(pagination, requestModel.getParams(),this.getAuthorization());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(GoalSupervisor goalSupervisor) throws ServiceException
	{
		goalSupervisorFacade.save(goalSupervisor);
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
		goalSupervisorFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(GoalSupervisor goalSupervisor) throws ServiceException
	{
		goalSupervisorFacade.update(goalSupervisor);
	}
	
	/**
	 * 店铺月销量统计
	 * @throws ServiceException
	 */
	@GET
	@Path("/calcShopSaleQty")
	public void calcShopSaleQty() throws ServiceException {
		goalSupervisorFacade.calcShopSaleQty();
	}
	
	/**
	 * 巡店员销售目标导出Excel
	 * @param goalMonthStart
	 * @param goalMonthEnd
	 * @param empName
	 * @param shopCode
	 * @param shopName
	 * @param regionId
	 * @param userCode
	 * @param createBy
	 * @param companyId
	 * @param creatorName
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getGoalSupervisorByExcel (@QueryParam("goalMonthStart") String goalMonthStart,
		@QueryParam("goalMonthEnd") String goalMonthEnd,@QueryParam("empName") String empName,
		@QueryParam("shopCode") String shopCode,@QueryParam("shopName") String shopName,
		@QueryParam("regionId")String regionId,@QueryParam("userCode")String userCode,
		@QueryParam("createBy") String createBy,@QueryParam("companyId") String companyId,
		@QueryParam("creatorName") String creatorName) throws ServiceException,IOException {
		
		GoalSupervisorInfoDto goalSupervisorInfoDto = new GoalSupervisorInfoDto();
		goalSupervisorInfoDto.setGoalMonthStart(goalMonthStart);
		goalSupervisorInfoDto.setGoalMonthEnd(goalMonthEnd);
		goalSupervisorInfoDto.setShopCode(shopCode);
		goalSupervisorInfoDto.setShopName(shopName);
		goalSupervisorInfoDto.setCreateBy(createBy);
		goalSupervisorInfoDto.setEmpName(empName);
		goalSupervisorInfoDto.setUserCode(userCode);
		goalSupervisorInfoDto.setCreatorName(creatorName);
		if(!UtilHelper.isEmpty(regionId)){
			goalSupervisorInfoDto.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(companyId)){
			goalSupervisorInfoDto.setCompanyId(Long.parseLong(companyId));
		}
		byte[] bytes = goalSupervisorFacade.getGoalSupervisorByExcel(goalSupervisorInfoDto);       
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
