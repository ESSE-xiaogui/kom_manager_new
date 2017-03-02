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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.PrototypeSettingTime;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.PrototypeSettingTimeMapper;

@Service("prototypeSettingTimeService")
public class PrototypeSettingTimeService {

	private PrototypeSettingTimeMapper	prototypeSettingTimeMapper;

	@Autowired
	public void setPrototypeSettingTimeMapper(PrototypeSettingTimeMapper prototypeSettingTimeMapper)
	{
		this.prototypeSettingTimeMapper = prototypeSettingTimeMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public PrototypeSettingTime getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeSettingTimeMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeSettingTime> list() throws ServiceException
	{
		return prototypeSettingTimeMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeSettingTime> listByProperty(PrototypeSettingTime prototypeSettingTime)
			throws ServiceException
	{
		return prototypeSettingTimeMapper.listByProperty(prototypeSettingTime);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<PrototypeSettingTime> listPaginationByProperty(Pagination<PrototypeSettingTime> pagination, PrototypeSettingTime prototypeSettingTime)
			throws ServiceException
	{
		List<PrototypeSettingTime> list = prototypeSettingTimeMapper.listPaginationByProperty(pagination, prototypeSettingTime, pagination.getOrderBy());
		
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
		return prototypeSettingTimeMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		prototypeSettingTimeMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param prototypeSettingTime
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(PrototypeSettingTime prototypeSettingTime) throws ServiceException
	{
		return prototypeSettingTimeMapper.deleteByProperty(prototypeSettingTime);
	}

	/**
	 * 保存记录
	 * @param prototypeSettingTime
	 * @return
	 * @throws ServiceException
	 */
	public void save(PrototypeSettingTime prototypeSettingTime) throws ServiceException
	{
		prototypeSettingTimeMapper.save(prototypeSettingTime);
	}

	/**
	 * 更新记录
	 * @param prototypeSettingTime
	 * @return
	 * @throws ServiceException
	 */
	public int update(PrototypeSettingTime prototypeSettingTime) throws ServiceException
	{
		return prototypeSettingTimeMapper.update(prototypeSettingTime);
	}

	/**
	 * 根据条件查询记录条数
	 * @param prototypeSettingTime
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(PrototypeSettingTime prototypeSettingTime) throws ServiceException
	{
		return prototypeSettingTimeMapper.findByCount(prototypeSettingTime);
	}
}