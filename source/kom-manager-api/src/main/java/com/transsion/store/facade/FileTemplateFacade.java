/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-2-16 11:26:50
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.facade;

import java.util.List;
import java.util.Map;

import com.transsion.store.bo.FileTemplate;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.FileTemplateDto;

public interface FileTemplateFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public FileTemplate getByPK(Integer primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<FileTemplate> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<FileTemplate> listByProperty(FileTemplate fileTemplate)
			throws ServiceException;

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(Integer primaryKey) throws ServiceException;
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<Integer> primaryKeys) throws ServiceException;

	/**
	 * 根据传入参数删除记录
	 * @param fileTemplate
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(FileTemplate fileTemplate) throws ServiceException;

	/**
	 * 保存记录
	 *
     * @param token
     * @param fileTemplate
     * @return
	 * @throws ServiceException
	 */
	public void save(String token, FileTemplate fileTemplate) throws ServiceException;

	/**
	 * 更新记录
	 * @param fileTemplate
	 * @return
	 * @throws ServiceException
	 */
	public int update(FileTemplate fileTemplate) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param fileTemplate
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(FileTemplate fileTemplate) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<FileTemplate> listPaginationByProperty(Pagination<FileTemplate> pagination, FileTemplate fileTemplate)
			throws ServiceException;

	/**
	 * 取得业务类型
	 * @return
	 */
	Map<String, String> getBizType();

	/**
	 * 根据业务类型取得文件模板内容
	 * @param bizType
	 * @return
	 * @throws ServiceException
	 */
	FileTemplateDto getFileTemplateDto(String bizType) throws ServiceException;
}
