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
package com.transsion.store.facade.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.FileTemplate;
import com.transsion.store.dto.FileTemplateDto;
import com.transsion.store.facade.FileTemplateFacade;
import com.transsion.store.manager.FileTemplateManager;
import com.transsion.store.service.FileTemplateService;

@Component("fileTemplateFacade")
public class FileTemplateFacadeImpl implements FileTemplateFacade {

	private FileTemplateService fileTemplateService;

	@Autowired
	private FileTemplateManager fileTemplateManager;
	
	@Autowired
	public void setFileTemplateService(FileTemplateService fileTemplateService)
	{
		this.fileTemplateService = fileTemplateService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public FileTemplate getByPK(Integer primaryKey) throws ServiceException
	{
		return fileTemplateService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<FileTemplate> list() throws ServiceException
	{
		return fileTemplateService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<FileTemplate> listByProperty(FileTemplate fileTemplate)
			throws ServiceException
	{
		return fileTemplateService.listByProperty(fileTemplate);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<FileTemplate> listPaginationByProperty(Pagination<FileTemplate> pagination, FileTemplate fileTemplate)
			throws ServiceException
	{
		return fileTemplateService.listPaginationByProperty(pagination, fileTemplate);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(Integer primaryKey) throws ServiceException
	{
		return fileTemplateService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<Integer> primaryKeys) throws ServiceException
	{
		fileTemplateService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param fileTemplate
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(FileTemplate fileTemplate) throws ServiceException
	{
		return fileTemplateService.deleteByProperty(fileTemplate);
	}

	/**
	 * 保存记录
	 *
	 * @param token
	 * @param fileTemplate
	 * @return
	 * @throws ServiceException
	 */
	public void save(String token, FileTemplate fileTemplate) throws ServiceException
	{
		fileTemplateManager.save(token, fileTemplate);
	}

	/**
	 * 更新记录
	 * @param fileTemplate
	 * @return
	 * @throws ServiceException
	 */
	public int update(FileTemplate fileTemplate) throws ServiceException
	{
		return fileTemplateService.update(fileTemplate);
	}

	/**
	 * 根据条件查询记录条数
	 * @param fileTemplate
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(FileTemplate fileTemplate) throws ServiceException
	{
		return fileTemplateService.findByCount(fileTemplate);
	}

	/**
	 * 取得业务类型
	 * @return
	 */
	@Override
	public Map<String, String> getBizType() {
		return fileTemplateService.getBizType();
	}

	/**
	 * 根据业务类型取得文件模板内容
	 * @param bizType
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public FileTemplateDto getFileTemplateDto(String bizType) throws ServiceException {
		return fileTemplateManager.getFileTemplateDto(bizType);
	}
}
