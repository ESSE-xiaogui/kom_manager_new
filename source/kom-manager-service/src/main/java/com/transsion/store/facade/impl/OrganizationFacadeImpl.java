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
package com.transsion.store.facade.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.transsion.store.bo.Organization;
import com.transsion.store.dto.OrganizationDto;
import com.transsion.store.dto.OrganizationResponseDto;
import com.transsion.store.dto.OrganizationTreeDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.OrganizationFacade;
import com.transsion.store.manager.OrganizationManager;
import com.transsion.store.service.OrganizationService;

@Component("organizationFacade")
public class OrganizationFacadeImpl implements OrganizationFacade {

	private OrganizationService organizationService;
	
	@Autowired
	private OrganizationManager organizationManager;
	
	@Autowired
	public void setOrganizationService(OrganizationService organizationService)
	{
		this.organizationService = organizationService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Organization getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return organizationService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Organization> list() throws ServiceException
	{
		return organizationService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Organization> listByProperty(Organization organization)
			throws ServiceException
	{
		return organizationService.listByProperty(organization);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Organization> listPaginationByProperty(Pagination<Organization> pagination, Organization organization)
			throws ServiceException
	{
		return organizationService.listPaginationByProperty(pagination, organization);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return organizationService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		organizationService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param organization
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Organization organization) throws ServiceException
	{
		return organizationService.deleteByProperty(organization);
	}

	/**
	 * 保存记录
	 * @param organization
	 * @return
	 * @throws ServiceException
	 */
	public void save(Organization organization) throws ServiceException
	{
		organizationService.save(organization);
	}

	/**
	 * 更新记录
	 * @param organization
	 * @return
	 * @throws ServiceException
	 */
	public int update(Organization organization) throws ServiceException
	{
		return organizationService.update(organization);
	}

	/**
	 * 根据条件查询记录条数
	 * @param organization
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Organization organization) throws ServiceException
	{
		return organizationService.findByCount(organization);
	}
	
	/**
	 * 新增组织机构
	 * @return
	 * @throws ServiceException
	 * */
	public OrganizationResponseDto saveOrg(String token,OrganizationDto organizationDto) throws ServiceException{
		return organizationManager.saveOrg(token, organizationDto);
	}
	
	/**
	 * 查询组织机构名称
	 * @return
	 * @throws ServiceException
	 * */
	public OrganizationResponseDto findOrgName(Integer orgId) throws ServiceException{
		return organizationManager.findOrgName(orgId);
	}
	
	/**
	 * 查询树形组织机构
	 * @return
	 * @throws serviceException
	 * */
	public List<OrganizationTreeDto> findOrg(String token) throws ServiceException{
		return organizationManager.findOrg(token);
	}
	/**
	 * 删除组织机构
	 * */
	public OrganizationResponseDto deleteOrg(Integer orgId) throws ServiceException{
		return organizationManager.deleteOrg(orgId);
	}
}
