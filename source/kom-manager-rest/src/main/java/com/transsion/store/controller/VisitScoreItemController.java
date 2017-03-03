/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 14:48:56
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.VisitScoreItem;
import com.transsion.store.dto.VisitScoreItemDetailDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.VisitScoreItemFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("visitScoreItem")
public class VisitScoreItemController extends AbstractController{

	@Autowired
	private VisitScoreItemFacade visitScoreItemFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public VisitScoreItem getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return visitScoreItemFacade.getByPK(primaryKey);
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
	public Pagination<VisitScoreItem> listPgVisitScoreItem(RequestModel<VisitScoreItem> requestModel) throws ServiceException
	{
		Pagination<VisitScoreItem> pagination = new Pagination<VisitScoreItem>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return visitScoreItemFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(VisitScoreItem visitScoreItem) throws ServiceException
	{
		visitScoreItemFacade.save(visitScoreItem);
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
		visitScoreItemFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(VisitScoreItem visitScoreItem) throws ServiceException
	{
		visitScoreItemFacade.update(visitScoreItem);
	}
	
	@GET
	@Path("/queryVisitHistoryDataByVisitId")
	@Produces({MediaType.APPLICATION_JSON})
	public List<VisitScoreItemDetailDto> queryVisitHistoryDataByVisitId(@QueryParam("visitId")Long visitId) throws ServiceException {
		return visitScoreItemFacade.queryVisitHistoryDataByVisitId(visitId);
	}
}
