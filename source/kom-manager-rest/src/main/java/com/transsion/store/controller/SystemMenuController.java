/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-10-31 14:25:26
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
import com.transsion.store.bo.SystemMenu;
import com.transsion.store.dto.MenuDto;
import com.transsion.store.facade.SystemMenuFacade;

@Controller
@Path("systemMenu")
public class SystemMenuController extends AbstractController{

	@Autowired
	private SystemMenuFacade systemMenuFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public SystemMenu getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return systemMenuFacade.getByPK(primaryKey);
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
	public Pagination<SystemMenu> listPgSystemMenu(RequestModel<SystemMenu> requestModel) throws ServiceException
	{		Pagination<SystemMenu> pagination = new Pagination<SystemMenu>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return systemMenuFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(SystemMenu systemMenu) throws ServiceException
	{
		String token = this.getAuthorization();
		systemMenuFacade.save(token,systemMenu);
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
		systemMenuFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(SystemMenu systemMenu) throws ServiceException
	{
		String token = this.getAuthorization();
		systemMenuFacade.update(token,systemMenu);
	}
	
	/**
	* 获取菜单
	* @return
	* @throws ServiceException
	*/
	@GET
	@Path("/findMenuList")
	@Produces({MediaType.APPLICATION_JSON}) 
	public List<MenuDto> findMenuList() throws ServiceException {
		String token = this.getAuthorization();
		return systemMenuFacade.findMenuList(token);
	}
	
	/**
	* 根据parentMenuId查询菜单
	* @return
	* @throws ServiceException
	*/
	@GET
	@Path("/listByParentId")
	@Produces({MediaType.APPLICATION_JSON}) 
	public List<SystemMenu> listByParentId(@QueryParam("parentMenuId") java.lang.Long parentMenuId) throws ServiceException{
		return systemMenuFacade.listByParentId(parentMenuId);
	}

	/**
	* 树形显示所有菜单
	* @return
	* @throws ServiceException
	*/
	@GET
	@Path("/findAllMenu")
	@Produces({MediaType.APPLICATION_JSON}) 
	public List<MenuDto> findAllMenu() throws ServiceException {
		return systemMenuFacade.findAllMenu();
	}
	
	/**
	* 级联删除菜单
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/deleteByMenuId")
	@Consumes({MediaType.APPLICATION_JSON})
	public void deleteByMenuId(List<java.lang.Long> menuIdList) throws ServiceException
	{
		systemMenuFacade.deleteByMenuId(menuIdList);
	}
	
	/**
	* 查询菜单及其父菜单名称
	* @return
	* @throws ServiceException
	*/
	@GET
	@Path("/getOneMenu")
	@Produces({MediaType.APPLICATION_JSON}) 
	public MenuDto getOneMenu(@QueryParam("menuId") java.lang.Long menuId) throws ServiceException{
		return systemMenuFacade.getOneMenu(menuId);
	}
	
	/**
	* 根据roleId查询菜单
	* @return
	* @throws ServiceException
	*/
	@GET
	@Path("/findMenuByRoleId")
	@Produces({MediaType.APPLICATION_JSON}) 
	public List<MenuDto> findMenuByRoleId(@QueryParam("roleId") java.lang.Long roleId) throws ServiceException {
		return systemMenuFacade.findMenuByRoleId(roleId);
	}
}
