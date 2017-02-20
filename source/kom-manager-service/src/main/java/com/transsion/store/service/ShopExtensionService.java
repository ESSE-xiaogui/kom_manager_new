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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.ShopExtension;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.ShopExtensionMapper;

@Service("shopExtensionService")
public class ShopExtensionService {

	private ShopExtensionMapper	shopExtensionMapper;

	@Autowired
	public void setShopExtensionMapper(ShopExtensionMapper shopExtensionMapper)
	{
		this.shopExtensionMapper = shopExtensionMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ShopExtension getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopExtensionMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopExtension> list() throws ServiceException
	{
		return shopExtensionMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopExtension> listByProperty(ShopExtension shopExtension)
			throws ServiceException
	{
		return shopExtensionMapper.listByProperty(shopExtension);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopExtension> listPaginationByProperty(Pagination<ShopExtension> pagination, ShopExtension shopExtension)
			throws ServiceException
	{
		List<ShopExtension> list = shopExtensionMapper.listPaginationByProperty(pagination, shopExtension, pagination.getOrderBy());
		
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
		return shopExtensionMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		shopExtensionMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param shopExtension
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ShopExtension shopExtension) throws ServiceException
	{
		return shopExtensionMapper.deleteByProperty(shopExtension);
	}

	/**
	 * 保存记录
	 * @param shopExtension
	 * @return
	 * @throws ServiceException
	 */
	public void save(ShopExtension shopExtension) throws ServiceException
	{
		shopExtensionMapper.save(shopExtension);
	}

	/**
	 * 更新记录
	 * @param shopExtension
	 * @return
	 * @throws ServiceException
	 */
	public int update(ShopExtension shopExtension) throws ServiceException
	{
		return shopExtensionMapper.update(shopExtension);
	}

	/**
	 * 根据条件查询记录条数
	 * @param shopExtension
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ShopExtension shopExtension) throws ServiceException
	{
		return shopExtensionMapper.findByCount(shopExtension);
	}
	
	 public ShopExtension queryShopExtensionByShopId(Long shopId) throws ServiceException {
		 return shopExtensionMapper.queryShopExtensionByShopId(shopId);
	 }
}