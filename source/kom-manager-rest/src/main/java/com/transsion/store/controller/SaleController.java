/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:37
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.Sale;
import com.transsion.store.dto.SalesDto;
import com.transsion.store.dto.SalesUploadDto;
import com.transsion.store.dto.TShopSaleDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.SaleFacade;
import com.transsion.store.task.facade.SaleTaskFacade;
import com.transsion.store.utils.PropertiesUtils;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("sale")
public class SaleController extends AbstractController{

	@Autowired
	private SaleFacade saleFacade;
	
	@Autowired
	private SaleTaskFacade saleTaskFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public Sale getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return saleFacade.getByPK(primaryKey);
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
	public Pagination<Sale> listPgSale(RequestModel<Sale> requestModel) throws ServiceException
	{
		Pagination<Sale> pagination = new Pagination<Sale>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return saleFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(Sale sale) throws ServiceException
	{
		saleFacade.save(sale);
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
		saleFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(Sale sale) throws ServiceException
	{
		saleFacade.update(sale);
	}
	
	/**
	 * 销量上传[文件导入]
	 * */
	@PUT
	@Path("/saveSaleTask/{taskId}")
	@Consumes({MediaType.APPLICATION_JSON})
	public void saveSaleTask(@PathParam("taskId") Long taskId) throws ServiceException {
		saleTaskFacade.saveSaleTask(taskId);
	}
	/**
	 * @see 销量上报记录
	 * @author guihua.zhang
	 * @return list
	 * @throws ServiceException
	 * */
	@POST
	@Path("/saveSalesUpload")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<SalesUploadDto> saveSalesUpload (TShopSaleDto tshopSaleDto) throws ServiceException{
		String token = this.getAuthorization();
		long imeiCacheTimeOut = Long.valueOf(PropertiesUtils.readProperties("imei.cache.timeout"));
		logger.info("cache time out is:" + imeiCacheTimeOut);
		return saleFacade.saveSalesUpload(tshopSaleDto, token, imeiCacheTimeOut);
	}
	
	/**
	 * 销量上报记录查询
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/findSales")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<SalesDto> findPromoterSales(@QueryParam("startDate") java.lang.String startDate,
			@QueryParam("endDate") java.lang.String endDate, @QueryParam("model") String model)
			throws ServiceException {
		String token = this.getAuthorization();
		return saleFacade.findPromoterSales(token, startDate, endDate, model);
	}
	/**
	 * @see 用户销量数
	 * @author guihua.zhang
	 * @return
	 * @throws ServiceException
	 * */
	@GET
	@Path("findSaleQty")
	@Produces({MediaType.APPLICATION_JSON})
	public int findSaleQty(@QueryParam("startDate") java.lang.String startDate,@QueryParam("endDate") java.lang.String endDate) throws ServiceException{
		String token = this.getAuthorization();
		return saleFacade.findSaleQty(token,startDate,endDate);
	}
}
