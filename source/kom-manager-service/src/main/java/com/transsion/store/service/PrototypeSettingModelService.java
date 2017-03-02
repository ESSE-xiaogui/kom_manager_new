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

import com.transsion.store.bo.PrototypeSettingModel;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.PrototypeSettingModelMapper;

@Service("prototypeSettingModelService")
public class PrototypeSettingModelService {

	private PrototypeSettingModelMapper	prototypeSettingModelMapper;

	@Autowired
	public void setPrototypeSettingModelMapper(PrototypeSettingModelMapper prototypeSettingModelMapper)
	{
		this.prototypeSettingModelMapper = prototypeSettingModelMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public PrototypeSettingModel getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeSettingModelMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeSettingModel> list() throws ServiceException
	{
		return prototypeSettingModelMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeSettingModel> listByProperty(PrototypeSettingModel prototypeSettingModel)
			throws ServiceException
	{
		return prototypeSettingModelMapper.listByProperty(prototypeSettingModel);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<PrototypeSettingModel> listPaginationByProperty(Pagination<PrototypeSettingModel> pagination, PrototypeSettingModel prototypeSettingModel)
			throws ServiceException
	{
		List<PrototypeSettingModel> list = prototypeSettingModelMapper.listPaginationByProperty(pagination, prototypeSettingModel, pagination.getOrderBy());
		
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
		return prototypeSettingModelMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		prototypeSettingModelMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param prototypeSettingModel
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(PrototypeSettingModel prototypeSettingModel) throws ServiceException
	{
		return prototypeSettingModelMapper.deleteByProperty(prototypeSettingModel);
	}

	/**
	 * 保存记录
	 * @param prototypeSettingModel
	 * @return
	 * @throws ServiceException
	 */
	public void save(PrototypeSettingModel prototypeSettingModel) throws ServiceException
	{
		prototypeSettingModelMapper.save(prototypeSettingModel);
	}

	/**
	 * 更新记录
	 * @param prototypeSettingModel
	 * @return
	 * @throws ServiceException
	 */
	public int update(PrototypeSettingModel prototypeSettingModel) throws ServiceException
	{
		return prototypeSettingModelMapper.update(prototypeSettingModel);
	}

	/**
	 * 根据条件查询记录条数
	 * @param prototypeSettingModel
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(PrototypeSettingModel prototypeSettingModel) throws ServiceException
	{
		return prototypeSettingModelMapper.findByCount(prototypeSettingModel);
	}
}