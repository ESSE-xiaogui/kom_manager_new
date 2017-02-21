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

import com.transsion.store.bo.VisitScoreSetting;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.VisitScoreSettingMapper;

@Service("visitScoreSettingService")
public class VisitScoreSettingService {

	private VisitScoreSettingMapper	visitScoreSettingMapper;

	@Autowired
	public void setVisitScoreSettingMapper(VisitScoreSettingMapper visitScoreSettingMapper)
	{
		this.visitScoreSettingMapper = visitScoreSettingMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitScoreSetting getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitScoreSettingMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitScoreSetting> list() throws ServiceException
	{
		return visitScoreSettingMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitScoreSetting> listByProperty(VisitScoreSetting visitScoreSetting)
			throws ServiceException
	{
		return visitScoreSettingMapper.listByProperty(visitScoreSetting);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitScoreSetting> listPaginationByProperty(Pagination<VisitScoreSetting> pagination, VisitScoreSetting visitScoreSetting)
			throws ServiceException
	{
		List<VisitScoreSetting> list = visitScoreSettingMapper.listPaginationByProperty(pagination, visitScoreSetting, pagination.getOrderBy());
		
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
		return visitScoreSettingMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitScoreSettingMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitScoreSetting
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitScoreSetting visitScoreSetting) throws ServiceException
	{
		return visitScoreSettingMapper.deleteByProperty(visitScoreSetting);
	}

	/**
	 * 保存记录
	 * @param visitScoreSetting
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitScoreSetting visitScoreSetting) throws ServiceException
	{
		visitScoreSettingMapper.save(visitScoreSetting);
	}

	/**
	 * 更新记录
	 * @param visitScoreSetting
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitScoreSetting visitScoreSetting) throws ServiceException
	{
		return visitScoreSettingMapper.update(visitScoreSetting);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitScoreSetting
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitScoreSetting visitScoreSetting) throws ServiceException
	{
		return visitScoreSettingMapper.findByCount(visitScoreSetting);
	}
}