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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
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
import com.transsion.store.bo.VisitScore;
import com.transsion.store.dto.VisitScoreDetailInfoDto;
import com.transsion.store.facade.VisitScoreFacade;

@Controller
@Path("visitScore")
public class VisitScoreController extends AbstractController{

	@Autowired
	private VisitScoreFacade visitScoreFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public VisitScore getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return visitScoreFacade.getByPK(primaryKey);
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
	public Pagination<VisitScoreDetailInfoDto> listPgVisitScore(RequestModel<VisitScoreDetailInfoDto> requestModel) throws ServiceException
	{
		Pagination<VisitScoreDetailInfoDto> pagination = new Pagination<VisitScoreDetailInfoDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return visitScoreFacade.listPaginationByProperty(pagination, requestModel.getParams(),this.getAuthorization());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(VisitScore visitScore) throws ServiceException
	{
		visitScoreFacade.save(visitScore);
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
		visitScoreFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(VisitScore visitScore) throws ServiceException
	{
		visitScoreFacade.update(visitScore);
	}
	
	/**
	 * 巡店打分导出Excel
	 * @param createTimeStart
	 * @param createTimeEnd
	 * @param visitId
	 * @param shopCode
	 * @param shopName
	 * @param regionId
	 * @param totalScoreStart
	 * @param totalScoreEnd
	 * @param createBy
	 * @param companyId
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getVisitScoreByExcel(@QueryParam("createTimeStart") String createTimeStart,
		@QueryParam("createTimeEnd") String createTimeEnd,@QueryParam("visitId") String visitId,
		@QueryParam("shopCode") String shopCode,@QueryParam("shopName") String shopName,
		@QueryParam("regionId")String regionId,@QueryParam("totalScoreStart")String totalScoreStart,
		@QueryParam("totalScoreEnd")String totalScoreEnd,@QueryParam("createBy") String createBy,
		@QueryParam("companyId") String companyId) throws ServiceException,IOException {
		
		VisitScoreDetailInfoDto visitScoreDetailInfoDto = new VisitScoreDetailInfoDto();
		visitScoreDetailInfoDto.setCreateTimeStart(createTimeStart);
		visitScoreDetailInfoDto.setCreateTimeEnd(createTimeEnd);
		visitScoreDetailInfoDto.setShopCode(shopCode);
		visitScoreDetailInfoDto.setShopName(shopName);
		visitScoreDetailInfoDto.setCreateBy(createBy);
		
		if(!UtilHelper.isEmpty(regionId)){
			visitScoreDetailInfoDto.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(companyId)){
			visitScoreDetailInfoDto.setCompanyId(Long.parseLong(companyId));
		}
		if(!UtilHelper.isEmpty(visitId)){
			visitScoreDetailInfoDto.setVisitId(Long.parseLong(visitId));
		}
		if(!UtilHelper.isEmpty(totalScoreStart)){
			visitScoreDetailInfoDto.setTotalScoreStart(BigDecimal.valueOf(Double.parseDouble(totalScoreStart)));
		}
		if(!UtilHelper.isEmpty(totalScoreEnd)){
			visitScoreDetailInfoDto.setTotalScoreEnd(BigDecimal.valueOf(Double.parseDouble(totalScoreEnd)));
		}
	
		byte[] bytes = visitScoreFacade.getVisitScoreByExcel(visitScoreDetailInfoDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"巡店打分报表.xlsx";
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
