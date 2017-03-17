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
package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.PrototypeSetting;
import com.transsion.store.dto.PrototypeSettingDto;
import com.transsion.store.facade.PrototypeSettingFacade;
import com.transsion.store.manager.PrototypeSettingManager;
import com.transsion.store.service.PrototypeSettingService;

@Component("prototypeSettingFacade")
public class PrototypeSettingFacadeImpl implements PrototypeSettingFacade {

	@Autowired
	private PrototypeSettingManager prototypeSettingManager;
	
	private PrototypeSettingService prototypeSettingService;
	
	@Autowired
	public void setPrototypeSettingService(PrototypeSettingService prototypeSettingService)
	{
		this.prototypeSettingService = prototypeSettingService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public PrototypeSettingDto getByPK(java.lang.Long primaryKey, String token) throws ServiceException {
		return prototypeSettingManager.getByPK(primaryKey, token);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeSetting> list() throws ServiceException
	{
		return prototypeSettingService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeSetting> listByProperty(PrototypeSetting prototypeSetting)
			throws ServiceException
	{
		return prototypeSettingService.listByProperty(prototypeSetting);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<PrototypeSettingDto> listPaginationByProperty(Pagination<PrototypeSettingDto> pagination, PrototypeSettingDto prototypeSettingDto, String token)
			throws ServiceException {
		return prototypeSettingManager.listPaginationByProperty(pagination, prototypeSettingDto, token);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeSettingManager.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		prototypeSettingService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param prototypeSetting
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(PrototypeSetting prototypeSetting) throws ServiceException
	{
		return prototypeSettingService.deleteByProperty(prototypeSetting);
	}

	/**
	 * 保存记录
	 * @param prototypeSettingDto
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public void save(PrototypeSettingDto prototypeSettingDto, String token) throws ServiceException
	{
		prototypeSettingManager.savePrototypeSetting(prototypeSettingDto, token);
	}

	/**
	 * 更新记录
	 * @param prototypeSettingDto
	 * @return
	 * @throws ServiceException
	 */
	public void update(PrototypeSettingDto prototypeSettingDto, String token) throws ServiceException
	{
		prototypeSettingManager.update(prototypeSettingDto, token);
	}

	/**
	 * 根据条件查询记录条数
	 * @param prototypeSetting
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(PrototypeSetting prototypeSetting) throws ServiceException
	{
		return prototypeSettingService.findByCount(prototypeSetting);
	}
}
