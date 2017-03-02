/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:37
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
import com.transsion.store.bo.SaleGoal;
import com.transsion.store.facade.SaleGoalFacade;
import com.transsion.store.manager.SaleGoalManager;
import com.transsion.store.service.SaleGoalService;

@Component("saleGoalFacade")
public class SaleGoalFacadeImpl implements SaleGoalFacade {

	private SaleGoalService saleGoalService;
	
	@Autowired
	public void setSaleGoalService(SaleGoalService saleGoalService)
	{
		this.saleGoalService = saleGoalService;
	}
	
	@Autowired
	private SaleGoalManager saleGoalManager;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public SaleGoal getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return saleGoalService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SaleGoal> list() throws ServiceException
	{
		return saleGoalService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SaleGoal> listByProperty(SaleGoal saleGoal)
			throws ServiceException
	{
		return saleGoalService.listByProperty(saleGoal);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<SaleGoal> listPaginationByProperty(Pagination<SaleGoal> pagination, SaleGoal saleGoal)
			throws ServiceException
	{
		return saleGoalService.listPaginationByProperty(pagination, saleGoal);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return saleGoalService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		saleGoalService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param saleGoal
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(SaleGoal saleGoal) throws ServiceException
	{
		return saleGoalService.deleteByProperty(saleGoal);
	}

	/**
	 * 保存记录
	 * @param saleGoal
	 * @return
	 * @throws ServiceException
	 */
	public void save(SaleGoal saleGoal) throws ServiceException
	{
		saleGoalService.save(saleGoal);
	}

	/**
	 * 更新记录
	 * @param saleGoal
	 * @return
	 * @throws ServiceException
	 */
	public int update(SaleGoal saleGoal) throws ServiceException
	{
		return saleGoalService.update(saleGoal);
	}

	/**
	 * 根据条件查询记录条数
	 * @param saleGoal
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(SaleGoal saleGoal) throws ServiceException
	{
		return saleGoalService.findByCount(saleGoal);
	}
	/**
	 *  用户查看绩效
	 * @author guihua.zhang
	 * @return
	 * @throws ServiceException
	 * */
	@Override
	public int findMonthSaleAmount(String token, String goalMonth) throws ServiceException {
		return saleGoalManager.findMonthSaleAmount(token,goalMonth);
	}
}
