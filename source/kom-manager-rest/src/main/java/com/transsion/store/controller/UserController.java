/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:41
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.User;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.UserDto;
import com.transsion.store.dto.UserInfoDto;
import com.transsion.store.dto.UserResponseDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.UserFacade;
import com.transsion.store.utils.MD5Utils;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("user")
public class UserController extends AbstractController{

	@Autowired
	private UserFacade userFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public User getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return userFacade.getByPK(primaryKey);
	}
	
	/**登录
	 * @param userCode password
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/login")
	@Produces({ MediaType.APPLICATION_JSON })
	public UserContext login(@QueryParam("userCode") java.lang.String userCode,
			@QueryParam("password") java.lang.String password) throws ServiceException {
		UserContext userContext = userFacade.validateLogin(userCode, password);
		return userContext;
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
	public Pagination<User> listPgUser(RequestModel<User> requestModel) throws ServiceException
	{
		Pagination<User> pagination = new Pagination<User>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return userFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(User user) throws ServiceException
	{
		userFacade.save(user);
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
		userFacade.deleteByPKeys(primaryKeys);
	}
	
	@GET
	@Path("/encrypt")
	@Produces({ MediaType.APPLICATION_JSON })
	public String getEncrypt(@QueryParam("key") String str) throws ServiceException{
		return MD5Utils.encrypt(str);
	}
	
	/**
	 * 根据用户名查询用户信息
	 * */
	@GET
	@Path("/findByName")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON })
	public UserDto findByName(@QueryParam("userCode")String userCode) throws ServiceException{
		return userFacade.findByName(userCode);
	}
	
	/**
	 * 用户冻结/解冻 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/updateUserStatus")
	@Produces({MediaType.APPLICATION_JSON})
	public UserResponseDto updateUserStatus(@QueryParam("id") java.lang.Long id,
			@QueryParam("isInactive") java.lang.Integer isInactive) throws ServiceException{
		String token = this.getAuthorization();
		return userFacade.updateUserStatus(token, id, isInactive);
	}
	
	/**
	 * 重置密码
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/modifyPassword")
	@Produces({MediaType.APPLICATION_JSON})
	public UserResponseDto modifyPassword(@QueryParam("id") java.lang.Long id,
			@QueryParam("password") java.lang.String password) throws ServiceException{
		String token = this.getAuthorization();
		return userFacade.modifyPassword(token, id, password);
	}
	
	/**
	 * 根据条件查询用户信息
	 * @return
	 * @throws ServiceException
	 * */
	@POST
	@Path("/getUserInfo")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public UserInfoDto getUserInfo(UserInfoDto userInfoDto) throws ServiceException{
		String token = this.getAuthorization();
		return userFacade.getUserInfo(token,userInfoDto);
	}	
	
	/**
	 * 更改账号信息
	 * @return
	 * @throws ServiceException
	 * */
	@PUT
	@Path("/update")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public UserResponseDto update(User user) throws ServiceException{
		String token = this.getAuthorization();
		return userFacade.update(token,user);
	}
	
}
