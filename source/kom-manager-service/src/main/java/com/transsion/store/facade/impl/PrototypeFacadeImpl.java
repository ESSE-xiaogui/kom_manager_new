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
import com.transsion.store.bo.Prototype;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.PrototypeDto;
import com.transsion.store.facade.PrototypeFacade;
import com.transsion.store.manager.PrototypeManager;
import com.transsion.store.service.PrototypeService;
import com.transsion.store.utils.CacheUtils;

@Component("prototypeFacade")
public class PrototypeFacadeImpl implements PrototypeFacade {

	private PrototypeService prototypeService;
	@Autowired
	private PrototypeManager prototypeManager;
	
	@Autowired
	public void setPrototypeService(PrototypeService prototypeService)
	{
		this.prototypeService = prototypeService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public PrototypeDto getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeService.getPrototypeDtoById(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Prototype> list() throws ServiceException
	{
		return prototypeService.list();
	}

	/**
	 * 根据查询条件查询
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeDto> listByProperty(PrototypeDto prototypeDto)
			throws ServiceException
	{
		return prototypeService.listByProperty(prototypeDto);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<PrototypeDto> listPaginationByPropertyDto(Pagination<PrototypeDto> pagination, PrototypeDto prototypeDto, String token)
			throws ServiceException {
		
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		Long companyId = userContext.isAdmin()?null:userContext.getCompanyId();
		
		if (pagination.getParams() == null) {
			
			prototypeDto = new PrototypeDto();
			
			prototypeDto.setCompanyId(companyId);
			
			pagination.setParams(prototypeDto);
		} 
		
		
		return prototypeService.listPaginationByPropertyDto(pagination, prototypeDto);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		prototypeService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param prototype
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Prototype prototype) throws ServiceException
	{
		return prototypeService.deleteByProperty(prototype);
	}

	/**
	 * 保存记录
	 * @param prototypeDto
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public void save(PrototypeDto prototypeDto, String token) throws ServiceException
	{
		prototypeManager.savePrototype(prototypeDto, token);
	}

	/**
	 * 更新记录
	 * @param prototype
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public int update(PrototypeDto prototypeDto, String token) throws ServiceException
	{
		return prototypeManager.updatePrototype(prototypeDto, token);
	}

	/**
	 * 根据条件查询记录条数
	 * @param prototype
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Prototype prototype) throws ServiceException
	{
		return prototypeService.findByCount(prototype);
	}
}
