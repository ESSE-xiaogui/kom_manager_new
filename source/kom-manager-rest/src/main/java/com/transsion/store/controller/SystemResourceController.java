/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:40
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.SystemResource;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.SystemResourceFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("systemResource")
public class SystemResourceController extends AbstractController{

	@Autowired
	private SystemResourceFacade systemResourceFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public SystemResource getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return systemResourceFacade.getByPK(primaryKey);
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
	public Pagination<SystemResource> listPgSystemResource(RequestModel<SystemResource> requestModel) throws ServiceException
	{
		Pagination<SystemResource> pagination = new Pagination<SystemResource>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return systemResourceFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(SystemResource systemResource) throws ServiceException
	{
		systemResourceFacade.save(this.getAuthorization(),systemResource);
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
		systemResourceFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(SystemResource systemResource) throws ServiceException
	{
		systemResourceFacade.update(systemResource);
	}
	
	/**
	 * 获取所有资源
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getAllResource")
	@Produces({MediaType.APPLICATION_JSON})
	public List<SystemResource> getAllResource() throws ServiceException{
		return systemResourceFacade.getAllResource();
	}	
	
	/**
	* 根据roleId查询资源
	* @return
	* @throws ServiceException
	*/
	@GET
	@Path("/findResByRoleId")
	@Produces({MediaType.APPLICATION_JSON}) 
	public List<SystemResource> findResByRoleId(@QueryParam("roleId") java.lang.Long roleId) throws ServiceException {
		return systemResourceFacade.findResByRoleId(roleId);
	}
}
