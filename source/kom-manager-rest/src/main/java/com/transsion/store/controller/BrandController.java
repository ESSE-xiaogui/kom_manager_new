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
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.Brand;
import com.transsion.store.dto.BrandDto;
import com.transsion.store.dto.BrandModelListDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.BrandFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("brand")
public class BrandController extends AbstractController{

	@Autowired
	private BrandFacade brandFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public Brand getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return brandFacade.getByPK(primaryKey);
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
	public Pagination<Brand> listPgBrand(RequestModel<Brand> requestModel) throws ServiceException
	{
		Pagination<Brand> pagination = new Pagination<Brand>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return brandFacade.listPaginationByProperty(pagination, requestModel.getParams());
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
		brandFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(Brand brand) throws ServiceException
	{
		String token = this.getAuthorization();
		brandFacade.update(token,brand);
	}
	/**
	 * 新增品牌
	 * @return
	 * @throws ServiceException
	 * */
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public void saveBrand(BrandDto brandDto) throws ServiceException{
		String token = this.getAuthorization();
		brandFacade.saveBrand(token,brandDto);
	}
	/**
	 * 查询品牌
	 * @return
	 * @throws ServiceException
	 * */
	@GET
	@Path("/findBrand")
	@Produces({MediaType.APPLICATION_JSON})
	public List<BrandDto> findBrand() throws ServiceException{
		String token = this.getAuthorization();
		return brandFacade.findBrand(token);
	}
	
	/**
	 * 获取所有品牌机型
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/brandList")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<BrandModelListDto> queryBrandList() throws ServiceException {
		return brandFacade.queryBrandList();
	}
}
