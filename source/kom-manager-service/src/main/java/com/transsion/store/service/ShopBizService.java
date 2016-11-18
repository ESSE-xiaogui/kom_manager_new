/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:39
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

import com.transsion.store.bo.ShopBiz;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.ShopBizMapper;

@Service("shopBizService")
public class ShopBizService {

	private ShopBizMapper	shopBizMapper;

	@Autowired
	public void setShopBizMapper(ShopBizMapper shopBizMapper)
	{
		this.shopBizMapper = shopBizMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ShopBiz getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopBizMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopBiz> list() throws ServiceException
	{
		return shopBizMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopBiz> listByProperty(ShopBiz shopBiz)
			throws ServiceException
	{
		return shopBizMapper.listByProperty(shopBiz);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopBiz> listPaginationByProperty(Pagination<ShopBiz> pagination, ShopBiz shopBiz)
			throws ServiceException
	{
		List<ShopBiz> list = shopBizMapper.listPaginationByProperty(pagination, shopBiz, pagination.getOrderBy());
		
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
		return shopBizMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		shopBizMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param shopBiz
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ShopBiz shopBiz) throws ServiceException
	{
		return shopBizMapper.deleteByProperty(shopBiz);
	}

	/**
	 * 保存记录
	 * @param shopBiz
	 * @return
	 * @throws ServiceException
	 */
	public void save(ShopBiz shopBiz) throws ServiceException
	{
		shopBizMapper.save(shopBiz);
	}

	/**
	 * 更新记录
	 * @param shopBiz
	 * @return
	 * @throws ServiceException
	 */
	public int update(ShopBiz shopBiz) throws ServiceException
	{
		return shopBizMapper.update(shopBiz);
	}

	/**
	 * 根据条件查询记录条数
	 * @param shopBiz
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ShopBiz shopBiz) throws ServiceException
	{
		return shopBizMapper.findByCount(shopBiz);
	}
}