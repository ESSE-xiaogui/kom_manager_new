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
package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transsion.store.bo.Company;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.CompanyFacade;
import com.transsion.store.manager.CompanyManager;
import com.transsion.store.service.CompanyService;

@Component("companyFacade")
public class CompanyFacadeImpl implements CompanyFacade {

	private CompanyService companyService;
	
	@Autowired
	public void setCompanyService(CompanyService companyService)
	{
		this.companyService = companyService;
	}
	
	@Autowired
	private CompanyManager companyManager;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Company getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return companyService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Company> list() throws ServiceException
	{
		return companyService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Company> listByProperty(Company company)
			throws ServiceException
	{
		return companyService.listByProperty(company);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Company> listPaginationByProperty(Pagination<Company> pagination, Company company)
			throws ServiceException
	{
		return companyService.listPaginationByProperty(pagination, company);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return companyService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		companyService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param company
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Company company) throws ServiceException
	{
		return companyService.deleteByProperty(company);
	}

	/**
	 * 保存记录
	 * @param company
	 * @return
	 * @throws ServiceException
	 */
	public void save(Company company,String token) throws ServiceException
	{
		companyManager.save(company,token);
	}

	/**
	 * 更新记录
	 * @param company
	 * @return
	 * @throws ServiceException
	 */
	public int update(Company company,String token) throws ServiceException
	{
		return companyManager.update(company,token);
	}

	/**
	 * 根据条件查询记录条数
	 * @param company
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Company company) throws ServiceException
	{
		return companyService.findByCount(company);
	}
	public List<Company> findAll() throws ServiceException{
		return companyService.findAll();
	}
	public List<Company> findCompanyAll(String token) throws ServiceException{
		return companyManager.findCompanyAll(token);
	}
}
