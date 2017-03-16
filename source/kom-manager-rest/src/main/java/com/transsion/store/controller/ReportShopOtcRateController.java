/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-16 14:43:27
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.ReportShopOtcRate;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.ReportShopOtcRateFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("reportShopOtcRate")
public class ReportShopOtcRateController extends AbstractController{

	@Autowired
	private ReportShopOtcRateFacade reportShopOtcRateFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public ReportShopOtcRate getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return reportShopOtcRateFacade.getByPK(primaryKey);
	}

	/**
	* ITEL销售代表门店覆盖率监控分页查询
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/listPg")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ReportShopOtcRate> listPgReportShopOtcRate(RequestModel<ReportShopOtcRate> requestModel) throws ServiceException
	{
		Pagination<ReportShopOtcRate> pagination = new Pagination<ReportShopOtcRate>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return reportShopOtcRateFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(ReportShopOtcRate reportShopOtcRate) throws ServiceException
	{
		reportShopOtcRateFacade.save(reportShopOtcRate);
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
		reportShopOtcRateFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(ReportShopOtcRate reportShopOtcRate) throws ServiceException
	{
		reportShopOtcRateFacade.update(reportShopOtcRate);
	}
}
