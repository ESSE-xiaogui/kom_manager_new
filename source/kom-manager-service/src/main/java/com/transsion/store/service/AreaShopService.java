/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-14 13:59:40
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

import com.transsion.store.bo.AreaShop;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.AreaShopMapper;

@Service("areaShopService")
public class AreaShopService {

	private AreaShopMapper	areaShopMapper;

	@Autowired
	public void setAreaShopMapper(AreaShopMapper areaShopMapper)
	{
		this.areaShopMapper = areaShopMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public AreaShop getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return areaShopMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<AreaShop> list() throws ServiceException
	{
		return areaShopMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<AreaShop> listByProperty(AreaShop areaShop)
			throws ServiceException
	{
		return areaShopMapper.listByProperty(areaShop);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<AreaShop> listPaginationByProperty(Pagination<AreaShop> pagination, AreaShop areaShop)
			throws ServiceException
	{
		List<AreaShop> list = areaShopMapper.listPaginationByProperty(pagination, areaShop, pagination.getOrderBy());
		
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
		return areaShopMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		areaShopMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param areaShop
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(AreaShop areaShop) throws ServiceException
	{
		return areaShopMapper.deleteByProperty(areaShop);
	}

	/**
	 * 保存记录
	 * @param areaShop
	 * @return
	 * @throws ServiceException
	 */
	public void save(AreaShop areaShop) throws ServiceException
	{
		areaShopMapper.save(areaShop);
	}

	/**
	 * 更新记录
	 * @param areaShop
	 * @return
	 * @throws ServiceException
	 */
	public int update(AreaShop areaShop) throws ServiceException
	{
		return areaShopMapper.update(areaShop);
	}

	/**
	 * 保存或更新记录
	 * @param areaShop
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(AreaShop areaShop) throws ServiceException {
		return areaShopMapper.saveOrUpdate(areaShop);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<AreaShop> list) throws ServiceException {
		return areaShopMapper.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param areaShop
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(AreaShop areaShop) throws ServiceException
	{
		return areaShopMapper.findByCount(areaShop);
	}
}