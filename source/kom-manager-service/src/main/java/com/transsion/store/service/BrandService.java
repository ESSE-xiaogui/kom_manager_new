/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:34
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

import com.transsion.store.bo.Brand;
import com.transsion.store.dto.BrandModelListDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.BrandMapper;

@Service("brandService")
public class BrandService {

	private BrandMapper	brandMapper;

	@Autowired
	public void setBrandMapper(BrandMapper brandMapper)
	{
		this.brandMapper = brandMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Brand getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return brandMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Brand> list() throws ServiceException
	{
		return brandMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Brand> listByProperty(Brand brand)
			throws ServiceException
	{
		return brandMapper.listByProperty(brand);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Brand> listPaginationByProperty(Pagination<Brand> pagination, Brand brand)
			throws ServiceException
	{
		List<Brand> list = brandMapper.listPaginationByProperty(pagination, brand, pagination.getOrderBy());
		
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
		return brandMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		brandMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Brand brand) throws ServiceException
	{
		return brandMapper.deleteByProperty(brand);
	}

	/**
	 * 保存记录
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public void save(Brand brand) throws ServiceException
	{
		brandMapper.save(brand);
	}

	/**
	 * 更新记录
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public int update(Brand brand) throws ServiceException
	{
		return brandMapper.update(brand);
	}

	/**
	 * 根据条件查询记录条数
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Brand brand) throws ServiceException
	{
		return brandMapper.findByCount(brand);
	}
	public List<BrandModelListDto> queryBrandList() throws ServiceException {
		return brandMapper.queryBrandList();
	}
	
	public List<Brand> queryBrandListByRole(Integer companyId) throws ServiceException {
		return brandMapper.queryBrandListByRole(companyId);
	}
}