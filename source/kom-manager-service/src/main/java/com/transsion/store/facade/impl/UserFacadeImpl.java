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
package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transsion.store.bo.User;
import com.transsion.store.context.UserContext;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.UserFacade;
import com.transsion.store.manager.UserManager;
import com.transsion.store.service.UserService;

@Component("userFacade")
public class UserFacadeImpl implements UserFacade {

	private UserService userService;
	@Autowired
	private UserManager userManager;
	
	@Autowired
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public User getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return userService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<User> list() throws ServiceException
	{
		return userService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<User> listByProperty(User user)
			throws ServiceException
	{
		return userService.listByProperty(user);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<User> listPaginationByProperty(Pagination<User> pagination, User user)
			throws ServiceException
	{
		return userService.listPaginationByProperty(pagination, user);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return userService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		userService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(User user) throws ServiceException
	{
		return userService.deleteByProperty(user);
	}

	/**
	 * 保存记录
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public void save(User user) throws ServiceException
	{
		userService.save(user);
	}

	/**
	 * 更新记录
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public int update(User user) throws ServiceException
	{
		return userService.update(user);
	}

	/**
	 * 根据条件查询记录条数
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(User user) throws ServiceException
	{
		return userService.findByCount(user);
	}
	
	/**
	 * 登录
	 * @param userCode password
	 * @return
	 * @throws ServiceException 
	 */
	public UserContext validateLogin(String userCode,String password) throws ServiceException {
		UserContext userContext = userManager.validateLogin(userCode, password);
		return userContext;
	}
	
	/**
	 * @see 登出
	 * @author guihua.zhang
	 * @return
	 * @throws ServiceException
	 */
	public Boolean logOut(String token) throws ServiceException{
		return userManager.logOut(token);
	}

}
