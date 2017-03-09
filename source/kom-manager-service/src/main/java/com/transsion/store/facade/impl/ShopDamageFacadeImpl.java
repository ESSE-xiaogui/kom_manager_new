/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-9 15:06:14
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

import com.transsion.store.bo.ShopDamage;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.ShopDamageFacade;
import com.transsion.store.service.ShopDamageService;

@Component("shopDamageFacade")
public class ShopDamageFacadeImpl implements ShopDamageFacade {

	private ShopDamageService shopDamageService;
	
	@Autowired
	public void setShopDamageService(ShopDamageService shopDamageService)
	{
		this.shopDamageService = shopDamageService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ShopDamage getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopDamageService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopDamage> list() throws ServiceException
	{
		return shopDamageService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopDamage> listByProperty(ShopDamage shopDamage)
			throws ServiceException
	{
		return shopDamageService.listByProperty(shopDamage);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopDamage> listPaginationByProperty(Pagination<ShopDamage> pagination, ShopDamage shopDamage)
			throws ServiceException
	{
		return shopDamageService.listPaginationByProperty(pagination, shopDamage);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopDamageService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		shopDamageService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param shopDamage
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ShopDamage shopDamage) throws ServiceException
	{
		return shopDamageService.deleteByProperty(shopDamage);
	}

	/**
	 * 保存记录
	 * @param shopDamage
	 * @return
	 * @throws ServiceException
	 */
	public void save(ShopDamage shopDamage) throws ServiceException
	{
		shopDamageService.save(shopDamage);
	}

	/**
	 * 更新记录
	 * @param shopDamage
	 * @return
	 * @throws ServiceException
	 */
	public int update(ShopDamage shopDamage) throws ServiceException
	{
		return shopDamageService.update(shopDamage);
	}

	/**
	 * 保存或更新记录
	 * @param shopDamage
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(ShopDamage shopDamage) throws ServiceException {
		return shopDamageService.saveOrUpdate(shopDamage);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<ShopDamage> list) throws ServiceException {
		return shopDamageService.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param shopDamage
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ShopDamage shopDamage) throws ServiceException
	{
		return shopDamageService.findByCount(shopDamage);
	}
}
