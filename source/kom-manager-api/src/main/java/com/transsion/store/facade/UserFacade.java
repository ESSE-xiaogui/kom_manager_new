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
package com.transsion.store.facade;

import java.util.List;

import com.transsion.store.bo.User;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.UserDto;
import com.transsion.store.dto.UserInfoDto;
import com.transsion.store.dto.UserListDto;
import com.transsion.store.dto.UserResponseDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface UserFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public UserInfoDto getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<User> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<User> listByProperty(User user)
			throws ServiceException;

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException;
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException;

	/**
	 * 根据传入参数删除记录
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(User user) throws ServiceException;

	/**
	 * 保存记录
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public void save(User user) throws ServiceException;

	/**
	 * 更新记录
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	//public int update(User user) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(User user) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<UserListDto> listPaginationByProperty(Pagination<UserListDto> pagination, UserListDto userListDto)
			throws ServiceException;

	/**
	 * 登录
	 * @return
	 * @throws ServiceException
	 */
	public UserContext executeLogin(String userCode, String password) throws ServiceException;
	
	/**
	 * 根据用户名查询用户信息
	 * */
	public UserDto findByName(String userCode) throws ServiceException;
	
	/**
	 * 用户冻结/解冻 
	 * @return
	 * @throws ServiceException
	 */
	public UserResponseDto updateUserStatus(String token, Long id, Integer isInactive) throws ServiceException;
	
	/**
	 * 重置密码
	 * @return
	 * @throws ServiceException
	 */
	public UserResponseDto modifyPassword(String token, Long id, String password) throws ServiceException;

	/**
	 * 根据条件查询用户信息
	 * @return
	 * @throws ServiceException
	 * */
	public UserInfoDto getUserInfo(String token, UserInfoDto userInfoDto) throws ServiceException;

	/**
	 * 更改账号信息
	 * @return
	 * @throws ServiceException
	 * */
	public UserResponseDto update(String token, User user)throws ServiceException;

}
