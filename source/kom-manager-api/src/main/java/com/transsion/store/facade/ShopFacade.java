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

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Shop;
import com.transsion.store.dto.ShopDefinitionDto;
import com.transsion.store.dto.ShopDetailDto;
import com.transsion.store.dto.ShopInfoDto;
import com.transsion.store.dto.ShopLoginDto;
import com.transsion.store.dto.ShopParamDto;
import com.transsion.store.dto.ShopResponseDto;
import com.transsion.store.dto.ShopResponseInfoDto;
import com.transsion.store.dto.ShopUploadDto;
import com.transsion.store.dto.ShopUserDto;

public interface ShopFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ShopInfoDto getByPKey(java.lang.Long primaryKey) throws ServiceException;

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
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public int updateShopInfo(ShopInfoDto shopInfoDto, String token) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param shop
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Shop shop) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @param string 
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopInfoDto> listPaginationByProperty(Pagination<ShopInfoDto> pagination, ShopInfoDto shopInfoDto, String string)
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
	public ShopUploadDto createShop(String token, ShopDetailDto shopDetailDto) throws ServiceException;

	/*
	 * app shop list api
	 */
	public List<ShopDetailDto> queryManagedShopList(String token) throws ServiceException;

	/*
	 * app shop definition info api
	 */
	public ShopDefinitionDto queryShopDefitionDto(String token) throws ServiceException;
	
	
	/*
	 * app update shop api 
	 */
	public Integer updateShop(String token, ShopDetailDto shopDetailDto) throws ServiceException;

	/**
	 * 门店审核
	 * @param shop
	 * @param token
	 */
	public void updateShopStatus(Shop shop, String token)throws ServiceException;

	/**
	 * 门店导出Excel
	 * @param shopInfoDto
	 * @return
	 * @throws ServiceException
	 */
	public byte[] getShopByExcel(ShopInfoDto shopInfoDto)throws ServiceException;

	/**
	 * 查询用户绑定店铺
	 */
	public List<ShopLoginDto> findShopListByUser(String token)throws ServiceException;
	
	public ShopResponseDto saveShop(String token,ShopParamDto shopParamDto) throws ServiceException;
	public List<ShopResponseInfoDto> findShopList(String token) throws ServiceException;
	public ShopParamDto findShopDetails(String token,ShopParamDto shopParamDto) throws ServiceException;
}
