/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 10:24:48
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.VisitScoreSetting;
import com.transsion.store.dto.VisitScoreSettingDetailDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.VisitScoreSettingFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("visitScoreSetting")
public class VisitScoreSettingController extends AbstractController{

	@Autowired
	private VisitScoreSettingFacade visitScoreSettingFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public VisitScoreSetting getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return visitScoreSettingFacade.getByPK(primaryKey);
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
	public Pagination<VisitScoreSettingDetailDto> listPgVisitScoreSetting(RequestModel<VisitScoreSettingDetailDto> requestModel) throws ServiceException
	{
		Pagination<VisitScoreSettingDetailDto> pagination = new Pagination<VisitScoreSettingDetailDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());
		String token = this.getAuthorization();
		return visitScoreSettingFacade.listPaginationByProperty(pagination, requestModel.getParams(),token);
	}

	/**
	 * @author guihua.zhang on 2017-2-23
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(VisitScoreSetting visitScoreSetting) throws ServiceException
	{
		String token = this.getAuthorization();
		visitScoreSettingFacade.save(visitScoreSetting,token);
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
		visitScoreSettingFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(VisitScoreSetting visitScoreSetting) throws ServiceException
	{
		String token = this.getAuthorization();
		visitScoreSettingFacade.update(visitScoreSetting,token);
	}
}
