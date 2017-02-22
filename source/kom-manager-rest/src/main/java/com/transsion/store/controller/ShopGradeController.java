/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:39
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.ShopGrade;
import com.transsion.store.dto.ShopGradeDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.ShopGradeFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("shopGrade")
public class ShopGradeController extends AbstractController{

	@Autowired
	private ShopGradeFacade shopGradeFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public ShopGrade getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return shopGradeFacade.getByPK(primaryKey);
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
	public Pagination<ShopGradeDto> listPgShopGrade(RequestModel<ShopGradeDto> requestModel) throws ServiceException
	{
		String token = this.getAuthorization();
		Pagination<ShopGradeDto> pagination = new Pagination<ShopGradeDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return shopGradeFacade.listPaginationByProperty(pagination, token,requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(ShopGrade shopGrade) throws ServiceException
	{
		String token = this.getAuthorization();
		shopGradeFacade.save(shopGrade,token);
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
		shopGradeFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(ShopGrade shopGrade) throws ServiceException
	{
		String token = this.getAuthorization();
		shopGradeFacade.update(shopGrade,token);
	}
	
	/**
	 * 查询门店等级列表(app)
	 * @param brandCode
	 * @param isInactive
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("getShopGradeList")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ShopGrade> getShopGradeList( ) throws ServiceException{
		String token = this.getAuthorization();
		return shopGradeFacade.getShopGradeList(token);	
	}
	
	/**
	 * 查询已启用的门店等级
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("findActiveShopGrade")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ShopGrade> findActiveShopGrade() throws ServiceException{
		String token = this.getAuthorization();
		return shopGradeFacade.findActiveShopGrade(token);	
	}
}
