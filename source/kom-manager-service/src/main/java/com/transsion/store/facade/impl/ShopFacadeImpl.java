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
package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Shop;
import com.transsion.store.dto.ShopDefinitionDto;
import com.transsion.store.dto.ShopDetailDto;
import com.transsion.store.dto.ShopInfoDto;
import com.transsion.store.dto.ShopUserDto;
import com.transsion.store.facade.ShopFacade;
import com.transsion.store.manager.ShopManager;
import com.transsion.store.service.ShopService;

@Component("shopFacade")
public class ShopFacadeImpl implements ShopFacade {

	private ShopService shopService;
	
	@Autowired
	public void setShopService(ShopService shopService)
	{
		this.shopService = shopService;
	}
	
	@Autowired
	private ShopManager shopManager;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Shop getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Shop> list() throws ServiceException
	{
		return shopService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Shop> listByProperty(Shop shop)
			throws ServiceException
	{
		return shopService.listByProperty(shop);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopInfoDto> listPaginationByProperty(Pagination<ShopInfoDto> pagination, ShopInfoDto shopInfoDto)
			throws ServiceException
	{
		return shopService.listPaginationByProperty(pagination, shopInfoDto);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		shopService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Shop shop) throws ServiceException
	{
		return shopService.deleteByProperty(shop);
	}

	/**
	 * 保存记录
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public void save(Shop shop) throws ServiceException
	{
		shopService.save(shop);
	}

	/**
	 * 更新记录
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public int update(Shop shop) throws ServiceException
	{
		return shopService.update(shop);
	}

	/**
	 * 根据条件查询记录条数
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Shop shop) throws ServiceException
	{
		return shopService.findByCount(shop);
	}
	/**
	 * 用户已绑定的店铺
	 * */
	public List<ShopUserDto> findShopUser(String token) throws ServiceException{
		return shopManager.findShopUser(token);
	}
	/**
	 * 查询店铺
	 * */
	public List<ShopUserDto> findShop(String token) throws ServiceException{
		return shopManager.findShop(token);
	}
	/**
	 * 门店授权管理:获取此用户已绑定的所有店铺ID
	 * */
	public List<Long> findShopIds(String userName) throws ServiceException{
		return shopManager.findShopIds(userName);
	}
	
	/**
	 * 查询促销员的店铺
	 */
	@Override
	public List<Shop> queryPromoterShop(String token) throws ServiceException {
		return shopManager.queryPromoterShop(token);
	}

	@Override
	public void createShop(String token, ShopDetailDto shopDetailDto) throws ServiceException {
		shopManager.createShop(token, shopDetailDto);
	}

	@Override
	public List<ShopDetailDto> queryManagedShopList(String token) throws ServiceException {
		return shopManager.queryManagedShopList(token);
	}

	@Override
	public ShopDefinitionDto queryShopDefitionDto(String token) throws ServiceException {
		// TODO Auto-generated method stub
		return shopManager.queryShopDefitionDto(token);
	}

	@Override
	public void updateShop(String token, ShopDetailDto shopDetailDto) throws ServiceException {
		shopManager.updateShop(token, shopDetailDto);
	}
	
	/**
	 * 门店审核
	 */
	public void updateShopStatus(Shop shop, String token) throws ServiceException {
		shopManager.updateShopStatus(shop,token);
	}
}
