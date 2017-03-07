/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-1 16:30:39
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

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.PrototypeSetting;
import com.transsion.store.dto.PrototypeSettingDto;
import com.transsion.store.mapper.PrototypeSettingMapper;

@Service("prototypeSettingService")
public class PrototypeSettingService {

	private PrototypeSettingMapper	prototypeSettingMapper;

	@Autowired
	public void setPrototypeSettingMapper(PrototypeSettingMapper prototypeSettingMapper)
	{
		this.prototypeSettingMapper = prototypeSettingMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public PrototypeSetting getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeSettingMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeSetting> list() throws ServiceException
	{
		return prototypeSettingMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeSetting> listByProperty(PrototypeSetting prototypeSetting)
			throws ServiceException
	{
		return prototypeSettingMapper.listByProperty(prototypeSetting);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<PrototypeSettingDto> listPaginationByProperty(Pagination<PrototypeSettingDto> pagination, PrototypeSettingDto prototypeSettingDto)
			throws ServiceException{
		
		List<PrototypeSettingDto> list = prototypeSettingMapper.listPaginationByProperty(pagination, prototypeSettingDto, pagination.getOrderBy());
		
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
		return prototypeSettingMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		prototypeSettingMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param prototypeSetting
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(PrototypeSetting prototypeSetting) throws ServiceException
	{
		return prototypeSettingMapper.deleteByProperty(prototypeSetting);
	}

	/**
	 * 保存记录
	 * @param prototypeSetting
	 * @return
	 * @throws ServiceException
	 */
	public void save(PrototypeSetting prototypeSetting) throws ServiceException
	{
		prototypeSettingMapper.save(prototypeSetting);
	}

	/**
	 * 更新记录
	 * @param prototypeSetting
	 * @return
	 * @throws ServiceException
	 */
	public int update(PrototypeSetting prototypeSetting) throws ServiceException
	{
		return prototypeSettingMapper.update(prototypeSetting);
	}

	/**
	 * 根据条件查询记录条数
	 * @param prototypeSetting
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(PrototypeSetting prototypeSetting) throws ServiceException
	{
		return prototypeSettingMapper.findByCount(prototypeSetting);
	}
}