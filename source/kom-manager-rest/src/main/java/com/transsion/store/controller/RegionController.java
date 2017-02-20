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
import com.transsion.store.dto.RegionListDto;
import com.transsion.store.dto.RegionResponseDto;
import com.transsion.store.dto.RegionShopDto;
import com.transsion.store.dto.ShopBindRegionDto;
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
	public RegionDto getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return regionFacade.getByPK(primaryKey);
	}
	
	/**
	 * 根据国家ID查询所有城市
	 * */
	@GET
	@Path("getCityAll")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Region> getCityAll(@QueryParam("parentId") java.lang.Long parentId) throws ServiceException{
		return regionFacade.getCityAll(parentId);
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
	public Pagination<RegionListDto> listPgRegion(RequestModel<RegionListDto> requestModel) throws ServiceException
	{
		Pagination<RegionListDto> pagination = new Pagination<RegionListDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return regionFacade.listPaginationByProperty(pagination, requestModel.getParams());
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
	public RegionResponseDto update(Region region) throws ServiceException
	{
		String token = this.getAuthorization();
		return regionFacade.update(token,region);
	}
	
	/**
	 * 新增销售区域
	 * @return
	 * @throws ServiceException
	 * */
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public RegionResponseDto saveRegion(Region region) throws ServiceException{
		String token = this.getAuthorization();
		return regionFacade.saveRegion(token,region);
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
	
	/**
	 *  1 门店授权管理:门店绑定区域查询 用户名称为空
	 *  2 门店授权管理:用户已有门店查询 用户名称不为空
	 * @return
	 * @throws ServiceException
	 * 	 
	 * */
	@GET
	@Path("/findShopBindRegion")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ShopBindRegionDto> findShopBindRegion(@QueryParam("userName") String userName) throws ServiceException{
		String token = this.getAuthorization();
		List<ShopBindRegionDto> list = regionFacade.findShopBindRegion(token,userName);
		return list;
		
	}
	
}
