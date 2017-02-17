/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-2-16 11:36:58
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.service;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.FileTemplate;
import com.transsion.store.mapper.FileTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("fileTemplateService")
public class FileTemplateService {

	private FileTemplateMapper	fileTemplateMapper;

	@Autowired
	public void setFileTemplateMapper(FileTemplateMapper fileTemplateMapper)
	{
		this.fileTemplateMapper = fileTemplateMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public FileTemplate getByPK(Integer primaryKey) throws ServiceException
	{
		return fileTemplateMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<FileTemplate> list() throws ServiceException
	{
		return fileTemplateMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<FileTemplate> listByProperty(FileTemplate fileTemplate)
			throws ServiceException
	{
		return fileTemplateMapper.listByProperty(fileTemplate);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<FileTemplate> listPaginationByProperty(Pagination<FileTemplate> pagination, FileTemplate fileTemplate)
			throws ServiceException
	{
		List<FileTemplate> list = fileTemplateMapper.listPaginationByProperty(pagination, fileTemplate, pagination.getOrderBy());
		
		pagination.setResultList(list);
		
		return pagination;
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(Integer primaryKey) throws ServiceException
	{
		return fileTemplateMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<Integer> primaryKeys) throws ServiceException
	{
		fileTemplateMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param fileTemplate
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(FileTemplate fileTemplate) throws ServiceException
	{
		return fileTemplateMapper.deleteByProperty(fileTemplate);
	}

	/**
	 * 保存记录
	 * @param fileTemplate
	 * @return
	 * @throws ServiceException
	 */
	public void save(FileTemplate fileTemplate) throws ServiceException
	{
		fileTemplateMapper.save(fileTemplate);
	}

	/**
	 * 更新记录
	 * @param fileTemplate
	 * @return
	 * @throws ServiceException
	 */
	public int update(FileTemplate fileTemplate) throws ServiceException
	{
		return fileTemplateMapper.update(fileTemplate);
	}

	/**
	 * 根据条件查询记录条数
	 * @param fileTemplate
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(FileTemplate fileTemplate) throws ServiceException
	{
		return fileTemplateMapper.findByCount(fileTemplate);
	}

	public Map<String, String> getBizType() {

		Map<String, String> map = new HashMap<>();
		for (FileTemplate.BizType type : FileTemplate.BizType.values()){
			map.put(type.getKey(), type.getValue());
		}

		return map;
	}
}