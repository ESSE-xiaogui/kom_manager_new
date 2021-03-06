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
import com.transsion.store.bo.SystemRole;
import com.transsion.store.dto.SystemRoleResponseDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.SystemRoleFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("systemRole")
public class SystemRoleController extends AbstractController{

	@Autowired
	private SystemRoleFacade systemRoleFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public SystemRole getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return systemRoleFacade.getByPK(primaryKey);
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
	public Pagination<SystemRole> listPgSystemRole(RequestModel<SystemRole> requestModel) throws ServiceException
	{
		Pagination<SystemRole> pagination = new Pagination<SystemRole>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return systemRoleFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增角色
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public SystemRoleResponseDto add(SystemRole systemRole) throws ServiceException
	{
		String token = this.getAuthorization();
		return systemRoleFacade.save(token,systemRole);
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
		systemRoleFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改角色
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public SystemRoleResponseDto update(SystemRole systemRole) throws ServiceException
	{
		String token = this.getAuthorization();
		return systemRoleFacade.update(token,systemRole);
	}
	
	/**
	 * 查询用户角色
	 * */
	@GET
	@Path("/findSystemRoleByUser")
	@Produces({MediaType.APPLICATION_JSON})
	public List<SystemRoleResponseDto> findSystemRoleByUser(@QueryParam("userId") java.lang.Integer userId) throws ServiceException{
		return systemRoleFacade.findSystemRoleByUser(userId);
	}
	
	/**
	 * 查询所有角色
	 * */
	@GET
	@Path("/findSystemRole")
	@Produces({MediaType.APPLICATION_JSON})
	public List<SystemRoleResponseDto> findSystemRole() throws ServiceException{
		return systemRoleFacade.findSystemRole();
	}
	
	/**
	 * 根据条件查询所有角色
	 * */
	@POST
	@Path("/findRole")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<SystemRoleResponseDto> findRole(SystemRole systemRole) throws ServiceException{
		return systemRoleFacade.findRole(systemRole);
	}
	
	/**
	 * 用户角色权限停用/启用
	 * */
	@GET
	@Path("/updateRoleStatus")
	@Produces({MediaType.APPLICATION_JSON})
	public SystemRoleResponseDto updateRoleStatus(@QueryParam("roleId") java.lang.Long roleId,
			@QueryParam("isInactive") java.lang.Integer isInactive) throws ServiceException{
		String token = this.getAuthorization();
		return systemRoleFacade.updateRoleStatus(token, roleId, isInactive);
	}
	
}
