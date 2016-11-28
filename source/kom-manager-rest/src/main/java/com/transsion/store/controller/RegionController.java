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
import com.transsion.store.bo.Region;
import com.transsion.store.dto.RegionDto;
import com.transsion.store.dto.RegionResponseDto;
import com.transsion.store.dto.RegionShopDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.RegionFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("region")
public class RegionController extends AbstractController{

	@Autowired
	private RegionFacade regionFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public Region getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return regionFacade.getByPK(primaryKey);
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
	public Pagination<Region> listPgRegion(RequestModel<Region> requestModel) throws ServiceException
	{
		Pagination<Region> pagination = new Pagination<Region>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return regionFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(Region region) throws ServiceException
	{
		regionFacade.save(region);
	}

	/**
	* 根据多条主键值删除记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/delete")
	@Consumes({MediaType.APPLICATION_JSON})
	public void delete(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		regionFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(Region region) throws ServiceException
	{
		regionFacade.update(region);
	}
	
	/**
	 * 新增销售区域
	 * @return
	 * @throws ServiceException
	 * */
	@POST
	@Path("/saveRegion")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public RegionResponseDto saveRegion(RegionDto regionDto) throws ServiceException{
		String token = this.getAuthorization();
		return regionFacade.saveRegion(token,regionDto);
	}
	
	/**
	 * 查询销售区域名称
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/findRegionName")
	@Produces({MediaType.APPLICATION_JSON})
	public Region findRegionName(@QueryParam("id") java.lang.Long id) throws ServiceException{
		return regionFacade.findRegionName(id);
	}
	
	/**
	 * 查询销售区域
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/findRegionsList")
	@Produces({MediaType.APPLICATION_JSON})
	public List<RegionDto> findRegionsList() throws ServiceException
	{
		String token = this.getAuthorization();
		return regionFacade.findRegionsList(token);
	}
	
	/**
	 * 查询销售区域已绑定店铺
	 * @return
	 * @throws ServiceException
	 * */
	@GET
	@Path("/findRegionShop")
	@Produces({MediaType.APPLICATION_JSON})
	public List<RegionShopDto> findRegionShop() throws ServiceException{
		String token = this.getAuthorization();
		return regionFacade.findRegionShop(token);
	}
	
	
}
