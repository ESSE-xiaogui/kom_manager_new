/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-14 13:59:40
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

import com.transsion.store.bo.AreaShop;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.AreaShopFacade;
import com.transsion.store.service.AreaShopService;

@Component("areaShopFacade")
public class AreaShopFacadeImpl implements AreaShopFacade {

	private AreaShopService areaShopService;
	
	@Autowired
	public void setAreaShopService(AreaShopService areaShopService)
	{
		this.areaShopService = areaShopService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public AreaShop getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return areaShopService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<AreaShop> list() throws ServiceException
	{
		return areaShopService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<AreaShop> listByProperty(AreaShop areaShop)
			throws ServiceException
	{
		return areaShopService.listByProperty(areaShop);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<AreaShop> listPaginationByProperty(Pagination<AreaShop> pagination, AreaShop areaShop)
			throws ServiceException
	{
		return areaShopService.listPaginationByProperty(pagination, areaShop);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return areaShopService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		areaShopService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param areaShop
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(AreaShop areaShop) throws ServiceException
	{
		return areaShopService.deleteByProperty(areaShop);
	}

	/**
	 * 保存记录
	 * @param areaShop
	 * @return
	 * @throws ServiceException
	 */
	public void save(AreaShop areaShop) throws ServiceException
	{
		areaShopService.save(areaShop);
	}

	/**
	 * 更新记录
	 * @param areaShop
	 * @return
	 * @throws ServiceException
	 */
	public int update(AreaShop areaShop) throws ServiceException
	{
		return areaShopService.update(areaShop);
	}

	/**
	 * 保存或更新记录
	 * @param areaShop
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(AreaShop areaShop) throws ServiceException {
		return areaShopService.saveOrUpdate(areaShop);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<AreaShop> list) throws ServiceException {
		return areaShopService.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param areaShop
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(AreaShop areaShop) throws ServiceException
	{
		return areaShopService.findByCount(areaShop);
	}
}
