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
package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Duty;
import com.transsion.store.dto.DutyDto;
import com.transsion.store.dto.DutyResponseDto;
import com.transsion.store.facade.DutyFacade;
import com.transsion.store.manager.DutyManager;
import com.transsion.store.service.DutyService;

@Component("dutyFacade")
public class DutyFacadeImpl implements DutyFacade {

	private DutyService dutyService;
	
	@Autowired
	private DutyManager dutyManager;
	
	@Autowired
	public void setDutyService(DutyService dutyService)
	{
		this.dutyService = dutyService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Duty getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return dutyService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Duty> list() throws ServiceException
	{
		return dutyService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Duty> listByProperty(Duty duty)
			throws ServiceException
	{
		return dutyService.listByProperty(duty);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<DutyDto> listPaginationByProperty(Pagination<DutyDto> pagination, DutyDto dutyDto)
			throws ServiceException
	{
		return dutyService.listPaginationByProperty(pagination, dutyDto);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return dutyService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		dutyService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param duty
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Duty duty) throws ServiceException
	{
		return dutyService.deleteByProperty(duty);
	}

	/**
	 * 保存记录
	 * @param duty
	 * @return
	 * @throws ServiceException
	 */
	public void save(Duty duty,String token) throws ServiceException
	{
		dutyManager.save(duty,token);
	}

	/**
	 * 更新记录
	 * @param duty
	 * @return
	 * @throws ServiceException
	 */
	public int update(Duty duty,String token) throws ServiceException
	{
		return dutyManager.update(duty,token);
	}

	/**
	 * 根据条件查询记录条数
	 * @param duty
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Duty duty) throws ServiceException
	{
		return dutyService.findByCount(duty);
	}
	
	/**
	* 根据id查询职位名称
	* @return
	* @throws ServiceException
	*/
	public List<DutyResponseDto> findDutyName() throws ServiceException{
		return dutyManager.findDutyName();
	}
}
