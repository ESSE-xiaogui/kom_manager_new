/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-1 16:31:42
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

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.PrototypeSettingTime;
import com.transsion.store.facade.PrototypeSettingTimeFacade;
import com.transsion.store.service.PrototypeSettingTimeService;

@Component("prototypeSettingTimeFacade")
public class PrototypeSettingTimeFacadeImpl implements PrototypeSettingTimeFacade {

	private PrototypeSettingTimeService prototypeSettingTimeService;
	
	@Autowired
	public void setPrototypeSettingTimeService(PrototypeSettingTimeService prototypeSettingTimeService)
	{
		this.prototypeSettingTimeService = prototypeSettingTimeService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public PrototypeSettingTime getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeSettingTimeService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeSettingTime> list() throws ServiceException
	{
		return prototypeSettingTimeService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeSettingTime> listByProperty(PrototypeSettingTime prototypeSettingTime)
			throws ServiceException
	{
		return prototypeSettingTimeService.listByProperty(prototypeSettingTime);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<PrototypeSettingTime> listPaginationByProperty(Pagination<PrototypeSettingTime> pagination, PrototypeSettingTime prototypeSettingTime)
			throws ServiceException
	{
		return prototypeSettingTimeService.listPaginationByProperty(pagination, prototypeSettingTime);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeSettingTimeService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		prototypeSettingTimeService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param prototypeSettingTime
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(PrototypeSettingTime prototypeSettingTime) throws ServiceException
	{
		return prototypeSettingTimeService.deleteByProperty(prototypeSettingTime);
	}

	/**
	 * 保存记录
	 * @param prototypeSettingTime
	 * @return
	 * @throws ServiceException
	 */
	public void save(PrototypeSettingTime prototypeSettingTime) throws ServiceException
	{
		prototypeSettingTimeService.save(prototypeSettingTime);
	}

	/**
	 * 更新记录
	 * @param prototypeSettingTime
	 * @return
	 * @throws ServiceException
	 */
	public int update(PrototypeSettingTime prototypeSettingTime) throws ServiceException
	{
		return prototypeSettingTimeService.update(prototypeSettingTime);
	}

	/**
	 * 根据条件查询记录条数
	 * @param prototypeSettingTime
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(PrototypeSettingTime prototypeSettingTime) throws ServiceException
	{
		return prototypeSettingTimeService.findByCount(prototypeSettingTime);
	}
}
