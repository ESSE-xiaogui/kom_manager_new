/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:36
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

import com.transsion.store.bo.Model;
import com.transsion.store.dto.ModelListDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.mapper.ModelMapper;

@Service("modelService")
public class ModelService {

	private ModelMapper	modelMapper;

	@Autowired
	public void setModelMapper(ModelMapper modelMapper)
	{
		this.modelMapper = modelMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Model getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return modelMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Model> list() throws ServiceException
	{
		return modelMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Model> listByProperty(Model model)
			throws ServiceException
	{
		return modelMapper.listByProperty(model);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ModelListDto> listPaginationByProperty(Pagination<ModelListDto> pagination, ModelListDto modelListDto)
			throws ServiceException
	{
		if(!UtilHelper.isEmpty(modelListDto) && !UtilHelper.isEmpty(modelListDto.getSeriesCode())){
			if(modelListDto.getSeriesCode().equals("1")){
				modelListDto.setSeriesCode("Smart");
			}else if(modelListDto.getSeriesCode().equals("2")){
				modelListDto.setSeriesCode("Feature");
			}else if(modelListDto.getSeriesCode().equals("0")){
				modelListDto.setSeriesCode(null);
			}
		}
		
		List<ModelListDto> list = modelMapper.listPaginationByProperty(pagination, modelListDto, pagination.getOrderBy());
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
		return modelMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		modelMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Model model) throws ServiceException
	{
		return modelMapper.deleteByProperty(model);
	}

	/**
	 * 保存记录
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public void save(Model model) throws ServiceException
	{
		modelMapper.save(model);
	}

	/**
	 * 更新记录
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public int update(Model model) throws ServiceException
	{
		return modelMapper.update(model);
	}

	/**
	 * 根据条件查询记录条数
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Model model) throws ServiceException
	{
		return modelMapper.findByCount(model);
	}
	
	public List<Model> queryModelListByBrandId(Long brandId) throws ServiceException {
		return modelMapper.queryModelListByBrandId(brandId);
	}
	
	public List<Model> queryModelListByBrandCode(String brandCode) throws ServiceException {
		return modelMapper.queryModelListByBrandCode(brandCode);
	}
}