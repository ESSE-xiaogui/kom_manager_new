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
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.Materiel;
import com.transsion.store.dto.MaterialInfoDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.MaterielFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("materiel")
public class MaterielController extends AbstractController{

	@Autowired
	private MaterielFacade materielFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public Materiel getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return materielFacade.getByPK(primaryKey);
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
	public Pagination<Materiel> listPgMateriel(RequestModel<Materiel> requestModel) throws ServiceException
	{
		Pagination<Materiel> pagination = new Pagination<Materiel>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return materielFacade.listPaginationByProperty(pagination, requestModel.getParams(),this.getAuthorization());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(Materiel materiel) throws ServiceException
	{
		String token = this.getAuthorization();
		materielFacade.save(materiel,token);
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
		materielFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(Materiel materiel) throws ServiceException
	{
		String token = this.getAuthorization();
		materielFacade.update(materiel,token);
	}
	
	/**
	 * 根据品牌查询道具列表(app)
	 * @param brandCode
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("getMaterielList")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Materiel> getMaterielListByBrandCode(@QueryParam("brandCode") String brandCode)
					throws ServiceException{
		String token = this.getAuthorization();
		return materielFacade.getMaterielListByBrandCode(brandCode,token);
	}
	
	/**
	 * app Promotion Materials 页面
	 * 查询所有物料和店铺绑定的物料
	 * @author guihua.zhang on 2017-03-13
	 * */
	@GET
	@Path("findMateriel")
	@Produces({MediaType.APPLICATION_JSON})
	public List<MaterialInfoDto> findMateriel() throws ServiceException{
		String token=this.getAuthorization();
		return materielFacade.findMateriel(token);
	}
}
