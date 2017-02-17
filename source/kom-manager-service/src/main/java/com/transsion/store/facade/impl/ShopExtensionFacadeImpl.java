/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-2-17 11:25:38
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

import com.transsion.store.bo.ShopExtension;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.ShopExtensionFacade;
import com.transsion.store.service.ShopExtensionService;

@Component("shopExtensionFacade")
public class ShopExtensionFacadeImpl implements ShopExtensionFacade {

	private ShopExtensionService shopExtensionService;
	
	@Autowired
	public void setShopExtensionService(ShopExtensionService shopExtensionService)
	{
		this.shopExtensionService = shopExtensionService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ShopExtension getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopExtensionService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopExtension> list() throws ServiceException
	{
		return shopExtensionService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopExtension> listByProperty(ShopExtension shopExtension)
			throws ServiceException
	{
		return shopExtensionService.listByProperty(shopExtension);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopExtension> listPaginationByProperty(Pagination<ShopExtension> pagination, ShopExtension shopExtension)
			throws ServiceException
	{
		return shopExtensionService.listPaginationByProperty(pagination, shopExtension);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopExtensionService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		shopExtensionService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param shopExtension
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ShopExtension shopExtension) throws ServiceException
	{
		return shopExtensionService.deleteByProperty(shopExtension);
	}

	/**
	 * 保存记录
	 * @param shopExtension
	 * @return
	 * @throws ServiceException
	 */
	public void save(ShopExtension shopExtension) throws ServiceException
	{
		shopExtensionService.save(shopExtension);
	}

	/**
	 * 更新记录
	 * @param shopExtension
	 * @return
	 * @throws ServiceException
	 */
	public int update(ShopExtension shopExtension) throws ServiceException
	{
		return shopExtensionService.update(shopExtension);
	}

	/**
	 * 根据条件查询记录条数
	 * @param shopExtension
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ShopExtension shopExtension) throws ServiceException
	{
		return shopExtensionService.findByCount(shopExtension);
	}
}
