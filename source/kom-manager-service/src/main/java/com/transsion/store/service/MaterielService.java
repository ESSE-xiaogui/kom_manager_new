/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:35
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

import com.transsion.store.bo.Materiel;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.MaterielMapper;

@Service("materielService")
public class MaterielService {

	private MaterielMapper	materielMapper;

	@Autowired
	public void setMaterielMapper(MaterielMapper materielMapper)
	{
		this.materielMapper = materielMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Materiel getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return materielMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Materiel> list() throws ServiceException
	{
		return materielMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Materiel> listByProperty(Materiel materiel)
			throws ServiceException
	{
		return materielMapper.listByProperty(materiel);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Materiel> listPaginationByProperty(Pagination<Materiel> pagination, Materiel materiel)
			throws ServiceException
	{
		List<Materiel> list = materielMapper.listPaginationByProperty(pagination, materiel, pagination.getOrderBy());
		
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
		return materielMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		materielMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param materiel
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Materiel materiel) throws ServiceException
	{
		return materielMapper.deleteByProperty(materiel);
	}

	/**
	 * 保存记录
	 * @param materiel
	 * @return
	 * @throws ServiceException
	 */
	public void save(Materiel materiel) throws ServiceException
	{
		materielMapper.save(materiel);
	}

	/**
	 * 更新记录
	 * @param materiel
	 * @return
	 * @throws ServiceException
	 */
	public int update(Materiel materiel) throws ServiceException
	{
		return materielMapper.update(materiel);
	}

	/**
	 * 根据条件查询记录条数
	 * @param materiel
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Materiel materiel) throws ServiceException
	{
		return materielMapper.findByCount(materiel);
	}
}