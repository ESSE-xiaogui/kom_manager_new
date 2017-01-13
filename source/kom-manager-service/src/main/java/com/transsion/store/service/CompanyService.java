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

import com.transsion.store.bo.Company;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.CompanyMapper;

@Service("companyService")
public class CompanyService {

	private CompanyMapper	companyMapper;

	@Autowired
	public void setCompanyMapper(CompanyMapper companyMapper)
	{
		this.companyMapper = companyMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Company getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return companyMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Company> list() throws ServiceException
	{
		return companyMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Company> listByProperty(Company company)
			throws ServiceException
	{
		return companyMapper.listByProperty(company);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Company> listPaginationByProperty(Pagination<Company> pagination, Company company)
			throws ServiceException
	{
		List<Company> list = companyMapper.listPaginationByProperty(pagination, company, pagination.getOrderBy());
		
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
		return companyMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		companyMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param company
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Company company) throws ServiceException
	{
		return companyMapper.deleteByProperty(company);
	}

	/**
	 * 保存记录
	 * @param company
	 * @return
	 * @throws ServiceException
	 */
	public void save(Company company) throws ServiceException
	{
		companyMapper.save(company);
	}

	/**
	 * 更新记录
	 * @param company
	 * @return
	 * @throws ServiceException
	 */
	public int update(Company company) throws ServiceException
	{
		return companyMapper.update(company);
	}

	/**
	 * 根据条件查询记录条数
	 * @param company
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Company company) throws ServiceException
	{
		return companyMapper.findByCount(company);
	}
	public List<Company> findAll() throws ServiceException{
		return companyMapper.findAll();
	}
}