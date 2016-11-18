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

import com.transsion.store.bo.ShopGrade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.ShopGradeMapper;

@Service("shopGradeService")
public class ShopGradeService {

	private ShopGradeMapper	shopGradeMapper;

	@Autowired
	public void setShopGradeMapper(ShopGradeMapper shopGradeMapper)
	{
		this.shopGradeMapper = shopGradeMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ShopGrade getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopGradeMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopGrade> list() throws ServiceException
	{
		return shopGradeMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopGrade> listByProperty(ShopGrade shopGrade)
			throws ServiceException
	{
		return shopGradeMapper.listByProperty(shopGrade);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopGrade> listPaginationByProperty(Pagination<ShopGrade> pagination, ShopGrade shopGrade)
			throws ServiceException
	{
		List<ShopGrade> list = shopGradeMapper.listPaginationByProperty(pagination, shopGrade, pagination.getOrderBy());
		
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
		return shopGradeMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		shopGradeMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param shopGrade
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ShopGrade shopGrade) throws ServiceException
	{
		return shopGradeMapper.deleteByProperty(shopGrade);
	}

	/**
	 * 保存记录
	 * @param shopGrade
	 * @return
	 * @throws ServiceException
	 */
	public void save(ShopGrade shopGrade) throws ServiceException
	{
		shopGradeMapper.save(shopGrade);
	}

	/**
	 * 更新记录
	 * @param shopGrade
	 * @return
	 * @throws ServiceException
	 */
	public int update(ShopGrade shopGrade) throws ServiceException
	{
		return shopGradeMapper.update(shopGrade);
	}

	/**
	 * 根据条件查询记录条数
	 * @param shopGrade
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ShopGrade shopGrade) throws ServiceException
	{
		return shopGradeMapper.findByCount(shopGrade);
	}
}