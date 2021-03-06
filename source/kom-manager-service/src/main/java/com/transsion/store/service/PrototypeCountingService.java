/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-1 16:31:41
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

import com.transsion.store.bo.PrototypeCounting;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.PrototypeCountingDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.PrototypeCountingMapper;
import com.transsion.store.utils.CacheUtils;

@Service("prototypeCountingService")
public class PrototypeCountingService {

	private PrototypeCountingMapper	prototypeCountingMapper;

	@Autowired
	public void setPrototypeCountingMapper(PrototypeCountingMapper prototypeCountingMapper)
	{
		this.prototypeCountingMapper = prototypeCountingMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public PrototypeCounting getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeCountingMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeCounting> list() throws ServiceException
	{
		return prototypeCountingMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeCounting> listByProperty(PrototypeCounting prototypeCounting)
			throws ServiceException
	{
		return prototypeCountingMapper.listByProperty(prototypeCounting);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<PrototypeCountingDto> listPaginationByProperty(Pagination<PrototypeCountingDto> pagination, PrototypeCountingDto prototypeCountingDto,String token)
			throws ServiceException
	{	
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
	
		Long companyId = userContext.isAdmin()?null:userContext.getCompanyId();
		List<PrototypeCountingDto> list = prototypeCountingMapper.listPaginationByProperty(pagination, prototypeCountingDto, pagination.getOrderBy(),companyId);
		
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
		return prototypeCountingMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		prototypeCountingMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param prototypeCounting
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(PrototypeCounting prototypeCounting) throws ServiceException
	{
		return prototypeCountingMapper.deleteByProperty(prototypeCounting);
	}

	/**
	 * 保存记录
	 * @param prototypeCounting
	 * @return
	 * @throws ServiceException
	 */
	public void save(PrototypeCounting prototypeCounting) throws ServiceException
	{
		prototypeCountingMapper.save(prototypeCounting);
	}

	/**
	 * 更新记录
	 * @param prototypeCounting
	 * @return
	 * @throws ServiceException
	 */
	public int update(PrototypeCounting prototypeCounting) throws ServiceException
	{
		return prototypeCountingMapper.update(prototypeCounting);
	}

	/**
	 * 根据条件查询记录条数
	 * @param prototypeCounting
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(PrototypeCounting prototypeCounting) throws ServiceException
	{
		return prototypeCountingMapper.findByCount(prototypeCounting);
	}

	public PrototypeCountingDto getByPKey(Long primaryKey) throws ServiceException{
		return prototypeCountingMapper.getByPKey(primaryKey);
	}
}