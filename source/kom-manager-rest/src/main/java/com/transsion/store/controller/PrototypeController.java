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

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
	@POST
	@Path("/list")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<PrototypeDto> listPrototype(PrototypeDto prototypeDto) throws ServiceException {
		return prototypeFacade.listByProperty(prototypeDto);
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
}
