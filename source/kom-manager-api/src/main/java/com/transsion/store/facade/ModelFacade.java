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
package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Model;
import com.transsion.store.dto.ModelDto;
import com.transsion.store.dto.ModelInfoDto;
import com.transsion.store.dto.ModelListDto;

public interface ModelFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Model getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Model> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Model> listByProperty(Model model)
			throws ServiceException;

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException;
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException;

	/**
	 * 根据传入参数删除记录
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Model model) throws ServiceException;

	/**
	 * 保存记录
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public void save(Model model) throws ServiceException;

	/**
	 * 更新记录
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public void update(String token,Model model) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Model model) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ModelListDto> listPaginationByProperty(Pagination<ModelListDto> pagination, ModelListDto modelListDto)
			throws ServiceException;
	
	/**
	 * 新增机型
	 * @return
	 * @throws ServiceException
	 * */
	public void saveModel(String token,Model model) throws ServiceException;
	
	/**
	 * 查询品牌产品系列机型
	 * @return
	 * @throws ServiceException
	 * */
	public List<ModelDto> findModel(ModelDto modelDto) throws ServiceException;
	
	/**
	 * 查询所有机型名称
	 * */
	public List<String> findModelName(String token) throws ServiceException;

	public List<Model> queryModelListByBrandId(Long brandId) throws ServiceException;
	
	/**
	 * 根据BrandCode获取机型
	 * @param brandCode
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public List<Model> queryModelListByBrandCode(String brandCode, String token) throws ServiceException;
	
	/**
	 * 查询机型和已绑定的机型
	 * @author guihua.zhang on 2017-03-14
	 * */
	public List<ModelInfoDto> findModelList(String token) throws ServiceException;
	
}
