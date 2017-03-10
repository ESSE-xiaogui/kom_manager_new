/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-9 15:06:14
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
import com.transsion.store.bo.ShopDamage;
import com.transsion.store.dto.ShopDamageDto;
import com.transsion.store.facade.ShopDamageFacade;

@Controller
@Path("shopDamage")
public class ShopDamageController extends AbstractController{

	@Autowired
	private ShopDamageFacade shopDamageFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public ShopDamage getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return shopDamageFacade.getByPK(primaryKey);
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
	public Pagination<ShopDamageDto> listPgShopDamage(RequestModel<ShopDamageDto> requestModel) throws ServiceException
	{
		Pagination<ShopDamageDto> pagination = new Pagination<ShopDamageDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return shopDamageFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(ShopDamage shopDamage) throws ServiceException
	{
		shopDamageFacade.save(shopDamage);
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
		shopDamageFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(ShopDamage shopDamage) throws ServiceException
	{
		shopDamageFacade.update(shopDamage);
	}
	
	@GET
	@Path("queryDetailById")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public ShopDamageDto queryDetailById(@QueryParam("damageId")Long damageId) throws ServiceException {
		return shopDamageFacade.queryDetailById(damageId);
	}
	
	/**
	 * 报修报损(导出Excel)
	 * @param damageStartDate
	 * @param damageEndDate
	 * @param createStartDate
	 * @param createEndDate
	 * @param regionId
	 * @param shopCode
	 * @param shopName
	 * @param createBy
	 * @param empName
	 * @param nameEn
	 * @param companyId
	 * @param damageId
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN}) 
	public Response getShopDamageListByExcel(
			@QueryParam("damageStartDate") String damageStartDate,
			@QueryParam("damageEndDate") String damageEndDate,
			@QueryParam("createStartDate") String createStartDate,
			@QueryParam("createEndDate") String createEndDate,
			@QueryParam("regionId") String regionId,
			@QueryParam("shopCode")String shopCode,
			@QueryParam("shopName")String shopName,
			@QueryParam("createBy") String createBy,
			@QueryParam("empName") String empName,
			@QueryParam("nameEn") String nameEn,
			@QueryParam("companyId") String companyId,
			@QueryParam("damageId") String damageId
			) throws ServiceException,IOException {

		ShopDamageDto shopDamageDto = new ShopDamageDto();
		shopDamageDto.setDamageStartDate(damageStartDate);
		shopDamageDto.setDamageEndDate(damageEndDate);
		shopDamageDto.setCreateStartDate(createStartDate);
		shopDamageDto.setCreateEndDate(createEndDate);
		if(!UtilHelper.isEmpty(regionId)){
			shopDamageDto.setRegionId(Long.parseLong(regionId));
		}
		shopDamageDto.setShopCode(shopCode);
		shopDamageDto.setShopName(shopName);
		shopDamageDto.setCreateBy(createBy);
		shopDamageDto.setEmpName(empName);
		shopDamageDto.setNameEn(nameEn);
		if(!UtilHelper.isEmpty(companyId)){
			shopDamageDto.setCompanyId(Long.parseLong(companyId));
		}
		if(!UtilHelper.isEmpty(damageId)){
			shopDamageDto.setDamageId(Long.parseLong(damageId));
		}
		
		
		byte[] bytes = shopDamageFacade.getShopDamageListByExcel(shopDamageDto);
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
}
