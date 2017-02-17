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

import com.transsion.store.bo.ShopGrade;
import com.transsion.store.dto.ShopGradeDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.ShopGradeFacade;
import com.transsion.store.manager.ShopGradeManager;
import com.transsion.store.service.ShopGradeService;

@Component("shopGradeFacade")
public class ShopGradeFacadeImpl implements ShopGradeFacade {

	private ShopGradeService shopGradeService;
	@Autowired
	private ShopGradeManager shopGradeManager;
	
	@Autowired
	public void setShopGradeService(ShopGradeService shopGradeService)
	{
		this.shopGradeService = shopGradeService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ShopGrade getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopGradeService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopGrade> list() throws ServiceException
	{
		return shopGradeService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopGrade> listByProperty(ShopGrade shopGrade)
			throws ServiceException
	{
		return shopGradeService.listByProperty(shopGrade);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopGradeDto> listPaginationByProperty(Pagination<ShopGradeDto> pagination, String token,ShopGradeDto shopGradeDto)
			throws ServiceException
	{
		return shopGradeService.listPaginationByProperty(pagination,token,shopGradeDto);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopGradeService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		shopGradeManager.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param shopGrade
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ShopGrade shopGrade) throws ServiceException
	{
		return shopGradeService.deleteByProperty(shopGrade);
	}

	/**
	 * 保存记录
	 * @param shopGrade
	 * @return
	 * @throws ServiceException
	 */
	public void save(ShopGrade shopGrade,String token) throws ServiceException
	{
		shopGradeManager.save(shopGrade,token);
	}

	/**
	 * 更新记录
	 * @param shopGrade
	 * @return
	 * @throws ServiceException
	 */
	public int update(ShopGrade shopGrade,String token) throws ServiceException
	{
		return shopGradeManager.update(shopGrade,token);
	}

	/**
	 * 根据条件查询记录条数
	 * @param shopGrade
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ShopGrade shopGrade) throws ServiceException
	{
		return shopGradeService.findByCount(shopGrade);
	}

	/**
	 * 查询门店等级列表
	 * @param brandCode
	 * @param isInactive
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopGrade> getShopGradeList(String brandCode,String token)throws ServiceException {
		return shopGradeManager.getShopGradeList(brandCode,token);
	}

	/**
	 * 查询已启用的门店等级
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopGrade> findActiveShopGrade(String token) throws ServiceException {
		return shopGradeManager.findActiveShopGrade(token);
	}
		
}
