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

import com.transsion.store.bo.UserOption;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface UserOptionFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public UserOption getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<UserOption> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<UserOption> listByProperty(UserOption userOption)
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
	 * @param userOption
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(UserOption userOption) throws ServiceException;

	/**
	 * 保存记录
	 * @param userOption
	 * @return
	 * @throws ServiceException
	 */
	public void save(UserOption userOption) throws ServiceException;

	/**
	 * 更新记录
	 * @param userOption
	 * @return
	 * @throws ServiceException
	 */
	public int update(UserOption userOption) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param userOption
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(UserOption userOption) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<UserOption> listPaginationByProperty(Pagination<UserOption> pagination, UserOption userOption)
			throws ServiceException;

}
