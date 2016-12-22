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
package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transsion.store.bo.Option;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.OptionFacade;
import com.transsion.store.manager.OptionManager;
import com.transsion.store.service.OptionService;

@Component("optionFacade")
public class OptionFacadeImpl implements OptionFacade {

	private OptionService optionService;
	
	@Autowired
	public void setOptionService(OptionService optionService)
	{
		this.optionService = optionService;
	}
	
	@Autowired
	private OptionManager optionManager;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Option getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return optionService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Option> list() throws ServiceException
	{
		return optionService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Option> listByProperty(Option option)
			throws ServiceException
	{
		return optionService.listByProperty(option);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Option> listPaginationByProperty(Pagination<Option> pagination, Option option)
			throws ServiceException
	{
		return optionService.listPaginationByProperty(pagination, option);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return optionService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		optionService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param option
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Option option) throws ServiceException
	{
		return optionService.deleteByProperty(option);
	}

	/**
	 * 保存记录
	 * @param option
	 * @return
	 * @throws ServiceException
	 */
	public void save(Option option) throws ServiceException
	{
		optionService.save(option);
	}

	/**
	 * 更新记录
	 * @param option
	 * @return
	 * @throws ServiceException
	 */
	public int update(Option option) throws ServiceException
	{
		return optionService.update(option);
	}

	/**
	 * 根据条件查询记录条数
	 * @param option
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Option option) throws ServiceException
	{
		return optionService.findByCount(option);
	}
	/**
	 * 门店授权管理 给用户绑定店铺
	 * */
	public void saveShopOption(Long userId,List<Long> shopIds,List<Long> optionIds,List<Long> userOptionIds) throws ServiceException{
		optionManager.saveShopOption(userId, shopIds, optionIds,userOptionIds);
	}
}
