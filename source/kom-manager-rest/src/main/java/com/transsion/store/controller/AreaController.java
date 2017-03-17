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

import com.rest.service.controller.AbstractController;
import com.transsion.store.dto.AreaDto;
import com.transsion.store.dto.AreaShopDto;
import com.transsion.store.dto.ShopAreaDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.AreaFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
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
@Path("area")
public class AreaController extends AbstractController{

	@Autowired
	private AreaFacade areaFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public AreaDto getByPKey(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return areaFacade.getByPKey(primaryKey);
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
	public Pagination<AreaDto> listPgArea(RequestModel<AreaDto> requestModel) throws ServiceException
	{
		Pagination<AreaDto> pagination = new Pagination<AreaDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return areaFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(AreaDto areaDto) throws ServiceException
	
	{
		areaFacade.save(areaDto,this.getAuthorization());
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
		areaFacade.deleteByPKeys(primaryKeys,this.getAuthorization());
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(AreaDto areaDto) throws ServiceException
	{
		areaFacade.update(areaDto,this.getAuthorization());
	}
	
	/**
	 * 查询销售大区树
	 * @throws ServiceException
	 */
	@GET
	@Path("/findAreaTreeList")
	@Produces({MediaType.APPLICATION_JSON})
	public List<AreaDto> findAreaTreeList()throws ServiceException{
		return areaFacade.findAreaTreeList(this.getAuthorization());
	}
	
	/**
	 * 查询销售区域下所有店铺
	 * @param areaId
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/findAreaShopList")
	@Produces({MediaType.APPLICATION_JSON})
	public List<AreaShopDto> findAreaShopList()throws ServiceException{
		return areaFacade.findAreaShopList(this.getAuthorization());
	}
	
	/**
	 * 销售大区门店绑定
	 * @param shopAreaDto
	 * @throws ServiceException
	 */
	@POST
	@Path("/saveShopArea")
	@Consumes({MediaType.APPLICATION_JSON})
	public void saveShopArea(ShopAreaDto shopAreaDto)throws ServiceException{
		 areaFacade.saveShopArea(shopAreaDto,this.getAuthorization());
	}
	
	/**
	 * 门店销售区域关联导出Excel
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getAreaShopByExcel(@QueryParam("companyId") Long companyId) throws ServiceException,IOException {
		
		byte[] bytes = areaFacade.getAreaShopByExcel(companyId);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"门店销售区域关联报表.xlsx";
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
