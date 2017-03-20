/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-1 16:30:39
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
import com.transsion.store.dto.PrototypeDto;
import com.transsion.store.facade.PrototypeFacade;

@Controller
@Path("prototype")
public class PrototypeController extends AbstractController{

	@Autowired
	private PrototypeFacade prototypeFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public PrototypeDto getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeFacade.getByPK(primaryKey);
	}

	/**
	* 后台管理系统分页查询记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/listPg")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<PrototypeDto> listPgPrototype(RequestModel<PrototypeDto> requestModel) throws ServiceException
	{
		Pagination<PrototypeDto> pagination = new Pagination<PrototypeDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return prototypeFacade.listPaginationByPropertyDto(pagination, requestModel.getParams(), this.getAuthorization());
	}
	
	/**
	 * app端查询List
	 * @param requestModel
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/list")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<PrototypeDto> listPrototype(@QueryParam("shopId") Long shopId, 
			@QueryParam("countingTime") String countingTime) throws ServiceException {
		return prototypeFacade.listByProperty(shopId, countingTime);
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(PrototypeDto prototypeDto) throws ServiceException {
		String token = this.getAuthorization();
		prototypeFacade.save(prototypeDto, token);
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
		prototypeFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(PrototypeDto prototypeDto) throws ServiceException {
		String token = this.getAuthorization();
		prototypeFacade.update(prototypeDto, token);
	}
	
	
	/**
	 * 样机导出Excel
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportPrototypeExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response exportPrototypeExcel(@QueryParam("companyCode") String companyCode,
		@QueryParam("brandCode") String brandCode,@QueryParam("countryName") String countryName,
		@QueryParam("cityName") String cityName,@QueryParam("shopCode") String shopCode, @QueryParam("shopName") String shopName,
		@QueryParam("imeiNo")String imeiNo,@QueryParam("modelName") String modelName,
		@QueryParam("publishBy") String publishBy,@QueryParam("publishName") String publishName,@QueryParam("publishTime") String publishTime,
		@QueryParam("unpublishBy") String unpublishBy,@QueryParam("unpublishName") String unpublishName,@QueryParam("unpublishTime") String unpublishTime,
		@QueryParam("unpublishCause") String unpublishCause,@QueryParam("status") String status,
		@QueryParam("remark") String remark,@QueryParam("createTime") String createTime) throws ServiceException,IOException {
		
		PrototypeDto prototypeDto = new PrototypeDto();
		prototypeDto.setCompanyCode(companyCode);
		prototypeDto.setBrandCode(brandCode);
		prototypeDto.setCountryName(countryName);
		prototypeDto.setCityName(cityName);
		prototypeDto.setShopCode(shopCode);
		prototypeDto.setShopName(shopName);
		prototypeDto.setImeiNo(imeiNo);
		prototypeDto.setPublishBy(publishBy);
		prototypeDto.setPublishName(publishName);
		prototypeDto.setPublishTime(publishTime);
		prototypeDto.setUnpublishBy(unpublishBy);
		prototypeDto.setUnpublishName(unpublishName);
		prototypeDto.setUnpublishTime(unpublishTime);
		prototypeDto.setUnpublishCause(unpublishCause);
		prototypeDto.setStatusView(status);
		prototypeDto.setRemark(remark);
		prototypeDto.setCreateTime(createTime);
		
		
		byte[] bytes = prototypeFacade.getPrototypeByExcel(prototypeDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"样机汇总报表.xlsx";
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
