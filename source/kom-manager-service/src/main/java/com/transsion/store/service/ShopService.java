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
import com.transsion.store.bo.Shop;
import com.transsion.store.dto.ShopInfoDto;
import com.transsion.store.dto.ShopLoginDto;
import com.transsion.store.exception.ExceptionDef;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.mapper.ShopMapper;

@Service("shopService")
public class ShopService {

	private ShopMapper	shopMapper;

	@Autowired
	public void setShopMapper(ShopMapper shopMapper)
	{
		this.shopMapper = shopMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Shop getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Shop> list() throws ServiceException
	{
		return shopMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Shop> listByProperty(Shop shop)
			throws ServiceException
	{
		return shopMapper.listByProperty(shop);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopInfoDto> listPaginationByProperty(Pagination<ShopInfoDto> pagination, ShopInfoDto shopInfoDto)
			throws ServiceException
	{
		List<ShopInfoDto> list = shopMapper.listPaginationByProperty(pagination, shopInfoDto, pagination.getOrderBy());
		
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
		return shopMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		shopMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Shop shop) throws ServiceException
	{
		return shopMapper.deleteByProperty(shop);
	}

	/**
	 * 保存记录
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public void save(Shop shop) throws ServiceException
	{
		shopMapper.save(shop);
	}

	/**
	 * 更新记录
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public int update(Shop shop) throws ServiceException
	{
		return shopMapper.update(shop);
	}

	/**
	 * 根据条件查询记录条数
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Shop shop) throws ServiceException
	{
		return shopMapper.findByCount(shop);
	}

	/**
	 * 查询促销员店铺
	 * @param userId
	 * @return
	 * @throws DataAccessFailureException 
	 * @throws ServiceException
     */
	public List<ShopLoginDto> queryPromoterShop(Long userId, Long companyId) throws ServiceException {
		if(UtilHelper.isEmpty(userId))
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());

		return shopMapper.findByPromoters(userId,companyId);
	}
}