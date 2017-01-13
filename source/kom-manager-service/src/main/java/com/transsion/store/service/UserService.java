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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.User;
import com.transsion.store.dto.UserDto;
import com.transsion.store.dto.UserInfoDto;
import com.transsion.store.dto.UserListDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.UserMapper;

@Service("userService")
public class UserService {

	private UserMapper	userMapper;

	@Autowired
	public void setUserMapper(UserMapper userMapper)
	{
		this.userMapper = userMapper;
	}
	@Autowired
	private SystemDateService systemDateService;
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public UserInfoDto getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return userMapper.getByPKey(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<User> list() throws ServiceException
	{
		return userMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<User> listByProperty(User user)
			throws ServiceException
	{
		return userMapper.listByProperty(user);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<UserListDto> listPaginationByProperty(Pagination<UserListDto> pagination, UserListDto userListDto)
			throws ServiceException
	{
		List<UserListDto> list = userMapper.listPaginationByProperty(pagination, userListDto, pagination.getOrderBy());
		pagination.setResultList(list);
		return pagination;
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return userMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		userMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(User user) throws ServiceException
	{
		return userMapper.deleteByProperty(user);
	}

	/**
	 * 保存记录
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public void save(User user) throws ServiceException
	{
		user.setCreatedBy(user.getUserCode());
		user.setCreatedTime(systemDateService.getCurrentDate());
		user.setUpdatedBy(user.getUserCode());
		user.setUpdatedTime(systemDateService.getCurrentDate());
		userMapper.save(user);
	}

	/**
	 * 更新记录
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public int update(User user) throws ServiceException
	{
		return userMapper.update(user);
	}

	/**
	 * 根据条件查询记录条数
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(User user) throws ServiceException
	{
		return userMapper.findByCount(user);
	}

	/**
	 * 根据条件查询用户信息
	 * @return
	 * @throws ServiceException
	 * */
	public UserInfoDto getUserInfo(UserInfoDto userInfoDto) throws ServiceException{
		return userMapper.getUserInfo(userInfoDto);
	}

	/**
	 * 根据用户名查询用户信息
	 * @throws ServiceException 
	 * */
	public UserDto findByName(String userCode) throws ServiceException {
		return userMapper.findByName(userCode);
	}
}