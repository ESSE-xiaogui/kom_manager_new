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
import com.transsion.store.bo.VisitModelSetting;
import com.transsion.store.dto.VisitModelSettingInfoDto;
import com.transsion.store.dto.VisitModelSettingListDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.VisitModelSettingFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("visitModelSetting")
public class VisitModelSettingController extends AbstractController{

	@Autowired
	private VisitModelSettingFacade visitModelSettingFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public VisitModelSetting getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return visitModelSettingFacade.getByPK(primaryKey);
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
	public Pagination<VisitModelSettingInfoDto> listPgVisitModelSetting(RequestModel<VisitModelSettingInfoDto> requestModel) throws ServiceException
	{
		Pagination<VisitModelSettingInfoDto> pagination = new Pagination<VisitModelSettingInfoDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());
		String token = this.getAuthorization();
		return visitModelSettingFacade.listPaginationByProperty(token,pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(VisitModelSetting visitModelSetting) throws ServiceException
	{
		String token=this.getAuthorization();
		visitModelSettingFacade.save(visitModelSetting, token);
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
		visitModelSettingFacade.deleteByPKeys(primaryKeys);
	}

	/**
	 * @author guihua.zhang on 2017-02-24
	 * 重点机型修改
	 * */
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(VisitModelSetting visitModelSetting) throws ServiceException
	{
		String token = this.getAuthorization();
		visitModelSettingFacade.update(visitModelSetting,token);
	}
	
	/**
	 * app Sales Collecting 页面
	 * 根据城市ID和当月时间查询所有重点机型
	 * 入参:currentDate 日期格式:2017-03-01
	 * @author guihua.zhang on 2017-03-13
	 * */
	@GET
	@Path("findVisitModel")
	@Produces({MediaType.APPLICATION_JSON})
	public List<VisitModelSettingListDto> findVisitModel(@QueryParam("cityId")Long cityId,@QueryParam("currentDate")String currentDate) throws ServiceException{
		String token=this.getAuthorization();
		return visitModelSettingFacade.findVisitModel(token, cityId, currentDate);
	}
}
