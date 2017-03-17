/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-2-21 11:10:45
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

import com.transsion.store.bo.VisitMateriel;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.VisitMaterielMapper;

@Service("visitMaterielService")
public class VisitMaterielService {

	private VisitMaterielMapper	visitMaterielMapper;

	@Autowired
	public void setVisitMaterielMapper(VisitMaterielMapper visitMaterielMapper)
	{
		this.visitMaterielMapper = visitMaterielMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitMateriel getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return visitMaterielMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitMateriel> list() throws ServiceException
	{
		return visitMaterielMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitMateriel> listByProperty(VisitMateriel visitMateriel)
			throws ServiceException
	{
		return visitMaterielMapper.listByProperty(visitMateriel);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitMateriel> listPaginationByProperty(Pagination<VisitMateriel> pagination, VisitMateriel visitMateriel)
			throws ServiceException
	{
		List<VisitMateriel> list = visitMaterielMapper.listPaginationByProperty(pagination, visitMateriel, pagination.getOrderBy());
		
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
		return visitMaterielMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		visitMaterielMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param visitMateriel
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitMateriel visitMateriel) throws ServiceException
	{
		return visitMaterielMapper.deleteByProperty(visitMateriel);
	}

	/**
	 * 保存记录
	 * @param visitMateriel
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitMateriel visitMateriel) throws ServiceException
	{
		visitMaterielMapper.save(visitMateriel);
	}
	
	/**
	 * 批量保存更新
	 * @param visitMateriels
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<VisitMateriel> visitMateriels) throws ServiceException {
		return visitMaterielMapper.batchSaveOrUpdate(visitMateriels);
	}

	/**
	 * 更新记录
	 * @param visitMateriel
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitMateriel visitMateriel) throws ServiceException
	{
		return visitMaterielMapper.update(visitMateriel);
	}

	/**
	 * 根据条件查询记录条数
	 * @param visitMateriel
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitMateriel visitMateriel) throws ServiceException
	{
		return visitMaterielMapper.findByCount(visitMateriel);
	}
}