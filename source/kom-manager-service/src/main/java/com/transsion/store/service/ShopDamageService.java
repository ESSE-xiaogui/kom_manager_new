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
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.ShopDamage;
import com.transsion.store.dto.ShopDamageDto;
import com.transsion.store.dto.ShopDamageInfoDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.ShopDamageMapper;

@Service("shopDamageService")
public class ShopDamageService {

	private ShopDamageMapper	shopDamageMapper;

	@Autowired
	public void setShopDamageMapper(ShopDamageMapper shopDamageMapper)
	{
		this.shopDamageMapper = shopDamageMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ShopDamage getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopDamageMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopDamage> list() throws ServiceException
	{
		return shopDamageMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopDamage> listByProperty(ShopDamage shopDamage)
			throws ServiceException
	{
		return shopDamageMapper.listByProperty(shopDamage);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopDamageDto> listPaginationByProperty(Pagination<ShopDamageDto> pagination, ShopDamageDto shopDamageDto)
			throws ServiceException
	{
		List<ShopDamageDto> list = shopDamageMapper.listPaginationByProperty(pagination, shopDamageDto, pagination.getOrderBy());
		
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
		return shopDamageMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		shopDamageMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param shopDamage
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ShopDamage shopDamage) throws ServiceException
	{
		return shopDamageMapper.deleteByProperty(shopDamage);
	}

	/**
	 * 保存记录
	 * @param shopDamage
	 * @return
	 * @throws ServiceException
	 */
	public void save(ShopDamage shopDamage) throws ServiceException
	{
		shopDamageMapper.save(shopDamage);
	}

	/**
	 * 更新记录
	 * @param shopDamage
	 * @return
	 * @throws ServiceException
	 */
	public int update(ShopDamage shopDamage) throws ServiceException
	{
		return shopDamageMapper.update(shopDamage);
	}

	/**
	 * 保存或更新记录
	 * @param shopDamage
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(ShopDamage shopDamage) throws ServiceException {
		return shopDamageMapper.saveOrUpdate(shopDamage);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<ShopDamage> list) throws ServiceException {
		return shopDamageMapper.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param shopDamage
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ShopDamage shopDamage) throws ServiceException
	{
		return shopDamageMapper.findByCount(shopDamage);
	}
	
	public ShopDamageDto queryDetailById(Long damageId) throws ServiceException {
		return shopDamageMapper.queryDetailById(damageId);
	}
	
	public List<ShopDamageInfoDto> queryShopDamageList(Long shopId) throws ServiceException {
		return shopDamageMapper.queryShopDamageList(shopId);
	}
}