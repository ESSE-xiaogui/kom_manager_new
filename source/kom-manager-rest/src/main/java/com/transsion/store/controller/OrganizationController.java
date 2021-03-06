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
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.Organization;
import com.transsion.store.dto.OrgInfoDto;
import com.transsion.store.dto.OrganizationDto;
import com.transsion.store.dto.OrganizationResponseDto;
import com.transsion.store.dto.OrganizationTreeDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.OrganizationFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author guihua.zhang
 * */
@Controller
@Path("organization")
public class OrganizationController extends AbstractController{

	@Autowired
	private OrganizationFacade organizationFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public OrganizationDto getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return organizationFacade.getByPK(primaryKey);
	}

	/**
	* 分页查询记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/listPg")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<OrgInfoDto> listPgOrganization(RequestModel<OrgInfoDto> requestModel) throws ServiceException
	{
		Pagination<OrgInfoDto> pagination = new Pagination<OrgInfoDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return organizationFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(Organization organization) throws ServiceException
	{
		organizationFacade.save(organization);
	}

	/**
	* 根据多条主键值删除记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/delete")
	public void delete(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		organizationFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(Organization organization) throws ServiceException
	{
		String token = this.getAuthorization();
		organizationFacade.update(token,organization);
	}
	/**
	 * 新增组织机构
	 * @return
	 * @throws ServiceException
	 * */
	@POST
	@Path("/saveOrg")
	@Consumes({MediaType.APPLICATION_JSON})
	public void saveOrg(OrganizationDto organizationDto) throws ServiceException{
		String token = this.getAuthorization();
		organizationFacade.saveOrg(token, organizationDto);
	}
	
	/**
	 * 查询组织机构名称
	 * @return
	 * @throws ServiceException
	 * */
	@GET
	@Path("/findOrgName")
	@Produces({MediaType.APPLICATION_JSON})
	public OrganizationResponseDto findOrgName(@QueryParam("orgId") java.lang.Integer orgId) throws ServiceException{
		return organizationFacade.findOrgName(orgId);
	}
	
	/**
	 * 查询树形组织机构
	 * @return
	 * @throws serviceException
	 * */
	@GET
	@Path("/findOrg")
	@Produces({MediaType.APPLICATION_JSON})
	public List<OrganizationTreeDto> findOrg() throws ServiceException{
		String token = this.getAuthorization();
		return organizationFacade.findOrg(token);
	}
	
	/**
	 * 删除组织机构
	 * */
	@POST
	@Path("/deleteOrg")
	public void deleteOrg(@QueryParam("orgId") Long orgId) throws ServiceException{
		organizationFacade.deleteOrg(orgId);
	}
	
}
