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
package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transsion.store.bo.Brand;
import com.transsion.store.dto.BrandDto;
import com.transsion.store.dto.BrandModelListDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.BrandFacade;
import com.transsion.store.manager.BrandManager;
import com.transsion.store.service.BrandService;

@Component("brandFacade")
public class BrandFacadeImpl implements BrandFacade {

	private BrandService brandService;
	
	@Autowired
	public void setBrandService(BrandService brandService)
	{
		this.brandService = brandService;
	}
	
	@Autowired
	private BrandManager brandManager;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Brand getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return brandService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Brand> list() throws ServiceException
	{
		return brandService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Brand> listByProperty(Brand brand)
			throws ServiceException
	{
		return brandService.listByProperty(brand);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Brand> listPaginationByProperty(Pagination<Brand> pagination, Brand brand)
			throws ServiceException
	{
		return brandService.listPaginationByProperty(pagination, brand);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return brandService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		brandService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Brand brand) throws ServiceException
	{
		return brandService.deleteByProperty(brand);
	}

	/**
	 * 保存记录
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public void save(Brand brand) throws ServiceException
	{
		brandService.save(brand);
	}

	/**
	 * 更新记录
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public void update(String token,Brand brand) throws ServiceException
	{
		brandManager.update(token,brand);
	}

	/**
	 * 根据条件查询记录条数
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Brand brand) throws ServiceException
	{
		return brandService.findByCount(brand);
	}
	
	/**
	 * 新增品牌
	 * @return
	 * @throws ServiceException
	 * */
	public void saveBrand(String token,BrandDto brandDto) throws ServiceException{
		brandManager.saveBrand(token, brandDto);
	}
	/**
	 * 查询品牌
	 * @return
	 * @throws ServiceException
	 * */
	public List<BrandDto> findBrand(String token) throws ServiceException{
		return brandManager.findBrand(token);
	}
	/**
	 * 查询所有品牌
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public List<BrandModelListDto> queryBrandList() throws ServiceException {
		return brandService.queryBrandList();
	}

}
