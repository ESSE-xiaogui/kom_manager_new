/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:36
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

import com.transsion.store.bo.Organization;
import com.transsion.store.dto.OrganizationDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.OrganizationMapper;

@Service("organizationService")
public class OrganizationService {

	private OrganizationMapper	organizationMapper;

	@Autowired
	public void setOrganizationMapper(OrganizationMapper organizationMapper)
	{
		this.organizationMapper = organizationMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public OrganizationDto getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return organizationMapper.getByPKs(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Organization> list() throws ServiceException
	{
		return organizationMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Organization> listByProperty(Organization organization)
			throws ServiceException
	{
		return organizationMapper.listByProperty(organization);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Organization> listPaginationByProperty(Pagination<Organization> pagination, Organization organization)
			throws ServiceException
	{
		List<Organization> list = organizationMapper.listPaginationByProperty(pagination, organization, pagination.getOrderBy());
		
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
		return organizationMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		organizationMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param organization
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Organization organization) throws ServiceException
	{
		return organizationMapper.deleteByProperty(organization);
	}

	/**
	 * 保存记录
	 * @param organization
	 * @return
	 * @throws ServiceException
	 */
	public void save(Organization organization) throws ServiceException
	{
		organizationMapper.save(organization);
	}

	/**
	 * 更新记录
	 * @param organization
	 * @return
	 * @throws ServiceException
	 */
	public int update(Organization organization) throws ServiceException
	{
		return organizationMapper.update(organization);
	}

	/**
	 * 根据条件查询记录条数
	 * @param organization
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Organization organization) throws ServiceException
	{
		return organizationMapper.findByCount(organization);
	}
}