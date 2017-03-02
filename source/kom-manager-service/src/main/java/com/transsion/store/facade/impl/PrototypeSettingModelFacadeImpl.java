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
package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.PrototypeSettingModel;
import com.transsion.store.facade.PrototypeSettingModelFacade;
import com.transsion.store.service.PrototypeSettingModelService;

@Component("prototypeSettingModelFacade")
public class PrototypeSettingModelFacadeImpl implements PrototypeSettingModelFacade {

	private PrototypeSettingModelService prototypeSettingModelService;
	
	@Autowired
	public void setPrototypeSettingModelService(PrototypeSettingModelService prototypeSettingModelService)
	{
		this.prototypeSettingModelService = prototypeSettingModelService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public PrototypeSettingModel getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeSettingModelService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeSettingModel> list() throws ServiceException
	{
		return prototypeSettingModelService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeSettingModel> listByProperty(PrototypeSettingModel prototypeSettingModel)
			throws ServiceException
	{
		return prototypeSettingModelService.listByProperty(prototypeSettingModel);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<PrototypeSettingModel> listPaginationByProperty(Pagination<PrototypeSettingModel> pagination, PrototypeSettingModel prototypeSettingModel)
			throws ServiceException
	{
		return prototypeSettingModelService.listPaginationByProperty(pagination, prototypeSettingModel);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeSettingModelService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		prototypeSettingModelService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param prototypeSettingModel
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(PrototypeSettingModel prototypeSettingModel) throws ServiceException
	{
		return prototypeSettingModelService.deleteByProperty(prototypeSettingModel);
	}

	/**
	 * 保存记录
	 * @param prototypeSettingModel
	 * @return
	 * @throws ServiceException
	 */
	public void save(PrototypeSettingModel prototypeSettingModel) throws ServiceException
	{
		prototypeSettingModelService.save(prototypeSettingModel);
	}

	/**
	 * 更新记录
	 * @param prototypeSettingModel
	 * @return
	 * @throws ServiceException
	 */
	public int update(PrototypeSettingModel prototypeSettingModel) throws ServiceException
	{
		return prototypeSettingModelService.update(prototypeSettingModel);
	}

	/**
	 * 根据条件查询记录条数
	 * @param prototypeSettingModel
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(PrototypeSettingModel prototypeSettingModel) throws ServiceException
	{
		return prototypeSettingModelService.findByCount(prototypeSettingModel);
	}
}
