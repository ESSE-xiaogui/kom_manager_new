/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:39
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.Stock;
import com.transsion.store.dto.StockDto;
import com.transsion.store.dto.StockResponseDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.StockFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("stock")
public class StockController extends AbstractController{

	@Autowired
	private StockFacade stockFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public Stock getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return stockFacade.getByPK(primaryKey);
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
	public Pagination<Stock> listPgStock(RequestModel<Stock> requestModel) throws ServiceException
	{
		Pagination<Stock> pagination = new Pagination<Stock>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return stockFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(Stock stock) throws ServiceException
	{
		stockFacade.save(stock);
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
		stockFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(Stock stock) throws ServiceException
	{
		stockFacade.update(stock);
	}
	/**
	 * 库存上报记录
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/stocks")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public StockResponseDto saveStockUpload(List<StockDto> stockDtoList) throws ServiceException {
		String token = this.getAuthorization();
		return stockFacade.saveStockUpload(stockDtoList, token);
	}
	/**
	 * 库存上报记录查询
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/findStocks")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<StockDto> findPromoterStock(@QueryParam("startDate") java.lang.String startDate,
			@QueryParam("endDate") java.lang.String endDate, @QueryParam("model") java.lang.String model)
			throws ServiceException {
		String token = this.getAuthorization();
		return stockFacade.findPromoterStock(token, startDate, endDate, model);
	}
	
	@GET
	@Path("/findStocksByProp")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<StockDto> findStocksByProp(@QueryParam("shopId")Integer shopId,@QueryParam("startDate") java.lang.String startDate,
			@QueryParam("endDate") java.lang.String endDate, @QueryParam("model") java.lang.String model)
			throws ServiceException {
		String token = this.getAuthorization();
		return stockFacade.findStocksByProp(token, shopId, startDate, endDate, model);
	}
	
	/**
	 * 库存上报记录查询最新
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/findCurrentStock")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<StockDto> findPromoterCurrentStock() throws ServiceException {
		String token = this.getAuthorization();
		return stockFacade.findPromoterCurrentStock(token);
	}
	
	/**
	 * 查询单店铺最新库存上报记录
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/findCurrentStockByProp")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<StockDto> findCurrentStockByProp(@QueryParam("shopId")Integer shopId) throws ServiceException {
		String token = this.getAuthorization();
		return stockFacade.findCurrentStockByProp(token, shopId);
	}
}
