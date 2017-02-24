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

import com.transsion.store.bo.ShopMateriel;
import com.transsion.store.dto.ShopMaterielDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.ShopMaterielFacade;
import com.transsion.store.service.ShopMaterielService;

@Component("shopMaterielFacade")
public class ShopMaterielFacadeImpl implements ShopMaterielFacade {

	private ShopMaterielService shopMaterielService;
	
	@Autowired
	public void setShopMaterielService(ShopMaterielService shopMaterielService)
	{
		this.shopMaterielService = shopMaterielService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ShopMateriel getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopMaterielService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopMateriel> list() throws ServiceException
	{
		return shopMaterielService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopMateriel> listByProperty(ShopMateriel shopMateriel)
			throws ServiceException
	{
		return shopMaterielService.listByProperty(shopMateriel);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopMaterielDto> listPaginationByProperty(Pagination<ShopMaterielDto> pagination, ShopMaterielDto shopMaterielDto,String token)
			throws ServiceException
	{
		return shopMaterielService.listPaginationByProperty(pagination, shopMaterielDto,token);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopMaterielService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		shopMaterielService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param shopMateriel
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ShopMateriel shopMateriel) throws ServiceException
	{
		return shopMaterielService.deleteByProperty(shopMateriel);
	}

	/**
	 * 保存记录
	 * @param shopMateriel
	 * @return
	 * @throws ServiceException
	 */
	public void save(ShopMateriel shopMateriel) throws ServiceException
	{
		shopMaterielService.save(shopMateriel);
	}

	/**
	 * 更新记录
	 * @param shopMateriel
	 * @return
	 * @throws ServiceException
	 */
	public int update(ShopMateriel shopMateriel) throws ServiceException
	{
		return shopMaterielService.update(shopMateriel);
	}

	/**
	 * 根据条件查询记录条数
	 * @param shopMateriel
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ShopMateriel shopMateriel) throws ServiceException
	{
		return shopMaterielService.findByCount(shopMateriel);
	}

	/**
	 * 物料统计导出Excel
	 */
	public byte[] getShopMaterielByExcel(ShopMaterielDto shopMaterielDto) throws ServiceException {
		return shopMaterielService.getShopMaterielByExcel(shopMaterielDto);
	}
}
