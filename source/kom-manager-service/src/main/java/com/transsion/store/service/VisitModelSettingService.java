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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.VisitModelSetting;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitModelSettingInfoDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.VisitModelSettingMapper;
import com.transsion.store.utils.CacheUtils;

@Service("visitModelSettingService")
public class VisitModelSettingService {

	private VisitModelSettingMapper	visitModelSettingMapper;

	@Autowired
	public void setVisitModelSettingMapper(VisitModelSettingMapper visitModelSettingMapper)
	{
		this.visitModelSettingMapper = visitModelSettingMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitModelSetting getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitModelSettingMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitModelSetting> list() throws ServiceException
	{
		return visitModelSettingMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitModelSetting> listByProperty(VisitModelSetting visitModelSetting)
			throws ServiceException
	{
		return visitModelSettingMapper.listByProperty(visitModelSetting);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitModelSettingInfoDto> listPaginationByProperty(String token, Pagination<VisitModelSettingInfoDto> pagination, VisitModelSettingInfoDto visitModelSettingInfoDto)
			throws ServiceException
	{
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		
		Long companyId = userContext.isAdmin()?null:userContext.getCompanyId();
		List<VisitModelSettingInfoDto> list = visitModelSettingMapper.listPaginationByProperty(pagination, visitModelSettingInfoDto, pagination.getOrderBy(),companyId);
		
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
		return visitModelSettingMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitModelSettingMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitModelSetting
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitModelSetting visitModelSetting) throws ServiceException
	{
		return visitModelSettingMapper.deleteByProperty(visitModelSetting);
	}

	/**
	 * 保存记录
	 * @param visitModelSetting
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitModelSetting visitModelSetting) throws ServiceException
	{
		visitModelSettingMapper.save(visitModelSetting);
	}

	/**
	 * 更新记录
	 * @param visitModelSetting
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitModelSetting visitModelSetting) throws ServiceException
	{
		return visitModelSettingMapper.update(visitModelSetting);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitModelSetting
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitModelSetting visitModelSetting) throws ServiceException
	{
		return visitModelSettingMapper.findByCount(visitModelSetting);
	}
	
	public List<String> queryModeCodeListByCompanyId(VisitModelSetting visitModelSetting) throws ServiceException {
		return visitModelSettingMapper.queryModeCodeListByCompanyId(visitModelSetting);
	}
}