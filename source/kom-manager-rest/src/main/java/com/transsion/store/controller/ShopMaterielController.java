/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-17 11:25:38
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.ShopMateriel;
import com.transsion.store.controller.SaleController.BigFileOutputStream;
import com.transsion.store.dto.SaleDailyDto;
import com.transsion.store.dto.ShopMaterielDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.ShopMaterielFacade;
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
@Path("shopMateriel")
public class ShopMaterielController extends AbstractController{

	@Autowired
	private ShopMaterielFacade shopMaterielFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public ShopMateriel getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return shopMaterielFacade.getByPK(primaryKey);
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
	public Pagination<ShopMaterielDto> listPgShopMateriel(RequestModel<ShopMaterielDto> requestModel) throws ServiceException
	{
		Pagination<ShopMaterielDto> pagination = new Pagination<ShopMaterielDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return shopMaterielFacade.listPaginationByProperty(pagination, requestModel.getParams(),this.getAuthorization());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(ShopMateriel shopMateriel) throws ServiceException
	{
		shopMaterielFacade.save(shopMateriel);
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
		shopMaterielFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(ShopMateriel shopMateriel) throws ServiceException
	{
		shopMaterielFacade.update(shopMateriel);
	}
	
	/**
	 * 物料统计导出Excel
	 * 
	 * @return
	 */
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getShopMaterielByExcel(@QueryParam("createDateStart") String createDateStart,
		@QueryParam("createDateEnd") String createDateEnd,@QueryParam("updateDateStart") String updateDateStart,
		@QueryParam("updateDateEnd") String updateDateEnd,@QueryParam("companyId") String companyId,
		@QueryParam("createBy") String createBy,@QueryParam("regionId") String regionId,
		@QueryParam("shopCode") String shopCode,@QueryParam("shopName") String shopName) throws ServiceException,IOException {
		ShopMaterielDto shopMaterielDto = new ShopMaterielDto();
		shopMaterielDto.setCreateDateStart(createDateStart);
		shopMaterielDto.setCreateDateEnd(createDateEnd);
		shopMaterielDto.setUpdateDateStart(updateDateStart);
		shopMaterielDto.setUpdateDateEnd(updateDateEnd);
		shopMaterielDto.setCreateBy(createBy);
		shopMaterielDto.setShopName(shopName);
		shopMaterielDto.setShopCode(shopCode);
		if(!UtilHelper.isEmpty(companyId)){
			shopMaterielDto.setCompanyId(Integer.valueOf(companyId));
		}
		if(!UtilHelper.isEmpty(regionId)){
			shopMaterielDto.setRegionId(Integer.valueOf(companyId));
		}
		byte[] bytes = shopMaterielFacade.getShopMaterielByExcel(shopMaterielDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"物料统计报表.xlsx";
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
