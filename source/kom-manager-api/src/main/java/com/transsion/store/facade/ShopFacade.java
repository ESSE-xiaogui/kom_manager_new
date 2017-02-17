/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:38
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.facade;

import java.util.List;

import com.transsion.store.bo.Shop;
import com.transsion.store.dto.ShopDefinitionDto;
import com.transsion.store.dto.ShopDetailDto;
import com.transsion.store.dto.ShopInfoDto;
import com.transsion.store.dto.ShopUserDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface ShopFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Shop getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Shop> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Shop> listByProperty(Shop shop)
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
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Shop shop) throws ServiceException;

	/**
	 * 保存记录
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public void save(Shop shop) throws ServiceException;

	/**
	 * 更新记录
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public int update(Shop shop) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Shop shop) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Shop> listPaginationByProperty(Pagination<Shop> pagination, Shop shop)
			throws ServiceException;
	
	/**
	 * 用户已绑定的店铺
	 * */
	public List<ShopUserDto> findShopUser(String token) throws ServiceException;
	
	/**
	 * 查询店铺
	 * */
	public List<ShopUserDto> findShop(String token) throws ServiceException;
	
	/**
	 * 门店授权管理:获取此用户已绑定的所有店铺ID
	 * */
	public List<Long> findShopIds(String userName) throws ServiceException;

	/**
	 * 获取促销员店铺
	 * 
	 */
	public List<Shop> queryPromoterShop(String token)throws ServiceException;
	
	/*
	 * app add shop api
	 */
	public void addShop(String token, ShopDetailDto shopDetailDto) throws ServiceException;

	/*
	 * app shop list api
	 */
	public List<ShopDetailDto> queryManagedShopList(String token) throws ServiceException;

	/*
	 * app shop definition info api
	 */
	public ShopDefinitionDto queryShopDefitionDto(String token) throws ServiceException;
	
}
