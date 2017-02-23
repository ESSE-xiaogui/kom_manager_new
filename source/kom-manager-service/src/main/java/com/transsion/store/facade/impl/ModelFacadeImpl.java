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

import com.transsion.store.bo.Model;
import com.transsion.store.dto.ModelDto;
import com.transsion.store.dto.ModelListDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.ModelFacade;
import com.transsion.store.manager.ModelManager;
import com.transsion.store.service.ModelService;

@Component("modelFacade")
public class ModelFacadeImpl implements ModelFacade {

	private ModelService modelService;
	
	@Autowired
	public void setModelService(ModelService modelService)
	{
		this.modelService = modelService;
	}
	
	@Autowired
	private ModelManager modelManager;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Model getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return modelService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Model> list() throws ServiceException
	{
		return modelService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Model> listByProperty(Model model)
			throws ServiceException
	{
		return modelService.listByProperty(model);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ModelListDto> listPaginationByProperty(Pagination<ModelListDto> pagination, ModelListDto modelListDto)
			throws ServiceException
	{
		return modelService.listPaginationByProperty(pagination, modelListDto);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return modelService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		modelService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Model model) throws ServiceException
	{
		return modelService.deleteByProperty(model);
	}

	/**
	 * 保存记录
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public void save(Model model) throws ServiceException
	{
		modelService.save(model);
	}

	/**
	 * 更新记录
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public void update(String token,Model model) throws ServiceException
	{
		modelManager.update(token,model);
	}

	/**
	 * 根据条件查询记录条数
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Model model) throws ServiceException
	{
		return modelService.findByCount(model);
	}
	/**
	 * 新增机型
	 * @return
	 * @throws ServiceException
	 * */
	public void saveModel(String token,Model model) throws ServiceException{
		modelManager.saveModel(token, model);
	}
	/**
	 * 查询品牌产品系列机型
	 * @return
	 * @throws ServiceException
	 * */
	public List<ModelDto> findModel(ModelDto modelDto) throws ServiceException{
		return modelManager.findModel( modelDto);
	}
	/**
	 * 查询所有机型名称
	 * */
	public List<String> findModelName(String token) throws ServiceException{
		return modelManager.findModelName(token);
	}

	@Override
	public List<Model> queryModelListByBrandId(Long brandId) throws ServiceException {
		return modelService.queryModelListByBrandId(brandId);
	}
}
