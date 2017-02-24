/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-2-21 10:24:48
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
import com.transsion.store.bo.VisitModelSetting;
import com.transsion.store.dto.VisitModelSettingInfoDto;
import com.transsion.store.facade.VisitModelSettingFacade;
import com.transsion.store.manager.VisitModeSettingManager;
import com.transsion.store.service.VisitModelSettingService;

@Component("visitModelSettingFacade")
public class VisitModelSettingFacadeImpl implements VisitModelSettingFacade {

	private VisitModelSettingService visitModelSettingService;
	
	@Autowired
	private VisitModeSettingManager visitModeSettingManager;
	
	@Autowired
	public void setVisitModelSettingService(VisitModelSettingService visitModelSettingService)
	{
		this.visitModelSettingService = visitModelSettingService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitModelSetting getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitModelSettingService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitModelSetting> list() throws ServiceException
	{
		return visitModelSettingService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitModelSetting> listByProperty(VisitModelSetting visitModelSetting)
			throws ServiceException
	{
		return visitModelSettingService.listByProperty(visitModelSetting);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitModelSettingInfoDto> listPaginationByProperty(Pagination<VisitModelSettingInfoDto> pagination, VisitModelSettingInfoDto visitModelSettingInfoDto)
			throws ServiceException
	{
		return visitModelSettingService.listPaginationByProperty(pagination, visitModelSettingInfoDto);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitModelSettingService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitModelSettingService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitModelSetting
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitModelSetting visitModelSetting) throws ServiceException
	{
		return visitModelSettingService.deleteByProperty(visitModelSetting);
	}

	/**
	 * 保存记录
	 * @param visitModelSetting
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitModelSetting visitModelSetting, String token) throws ServiceException
	{
		visitModeSettingManager.save(visitModelSetting, token);
	}

	/**
	 * 更新记录
	 * @param visitModelSetting
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitModelSetting visitModelSetting, String token) throws ServiceException
	{
		return visitModeSettingManager.update(visitModelSetting,token);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitModelSetting
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitModelSetting visitModelSetting) throws ServiceException
	{
		return visitModelSettingService.findByCount(visitModelSetting);
	}
}
