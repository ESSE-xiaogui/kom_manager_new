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
package com.transsion.store.facade;

import java.util.List;

import com.transsion.store.bo.SystemResource;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface SystemResourceFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public SystemResource getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemResource> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemResource> listByProperty(SystemResource systemResource)
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
	 * @param systemResource
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(SystemResource systemResource) throws ServiceException;

	/**
	 * 保存记录
	 * @param token 
	 * @param systemResource
	 * @return
	 * @throws ServiceException
	 */
	public void save(String token, SystemResource systemResource) throws ServiceException;

	/**
	 * 更新记录
	 * @param systemResource
	 * @return
	 * @throws ServiceException
	 */
	public int update(String token,SystemResource systemResource) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param systemResource
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(SystemResource systemResource) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<SystemResource> listPaginationByProperty(Pagination<SystemResource> pagination, SystemResource systemResource)
			throws ServiceException;

	/**
	 * 获取所有资源
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemResource> getAllResource()throws ServiceException;

	/**
	* 根据roleId查询资源
	* @return
	* @throws ServiceException
	*/
	public List<SystemResource> findResByRoleId(Long roleId)throws ServiceException;

	/**
	 * 根据资源类型及用户token获取用户拥有的资源列表
	 * @param type
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	List<String> getResourcesByUser(String type, String token) throws ServiceException;
}
