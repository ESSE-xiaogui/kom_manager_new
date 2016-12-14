/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:35
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

import com.transsion.store.bo.Duty;
import com.transsion.store.dto.DutyResponseDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.DutyMapper;

@Service("dutyService")
public class DutyService {

	private DutyMapper	dutyMapper;

	@Autowired
	public void setDutyMapper(DutyMapper dutyMapper)
	{
		this.dutyMapper = dutyMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Duty getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return dutyMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Duty> list() throws ServiceException
	{
		return dutyMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Duty> listByProperty(Duty duty)
			throws ServiceException
	{
		return dutyMapper.listByProperty(duty);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Duty> listPaginationByProperty(Pagination<Duty> pagination, Duty duty)
			throws ServiceException
	{
		List<Duty> list = dutyMapper.listPaginationByProperty(pagination, duty, pagination.getOrderBy());
		
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
		return dutyMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		dutyMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param duty
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Duty duty) throws ServiceException
	{
		return dutyMapper.deleteByProperty(duty);
	}

	/**
	 * 保存记录
	 * @param duty
	 * @return
	 * @throws ServiceException
	 */
	public void save(Duty duty) throws ServiceException
	{
		dutyMapper.save(duty);
	}

	/**
	 * 更新记录
	 * @param duty
	 * @return
	 * @throws ServiceException
	 */
	public int update(Duty duty) throws ServiceException
	{
		return dutyMapper.update(duty);
	}

	/**
	 * 根据条件查询记录条数
	 * @param duty
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Duty duty) throws ServiceException
	{
		return dutyMapper.findByCount(duty);
	}

	/**
	 * 查询销售区域名称
	 * @return
	 * @throws ServiceException
	 */
	public List<DutyResponseDto> getDutyName() throws ServiceException{
		return dutyMapper.getDutyName();
	}
}