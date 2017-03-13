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
import com.transsion.store.bo.Model;
import com.transsion.store.dto.ModelDto;
import com.transsion.store.dto.ModelInfoDto;
import com.transsion.store.dto.ModelListDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.ModelFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("model")
public class ModelController extends AbstractController{

	@Autowired
	private ModelFacade modelFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public Model getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return modelFacade.getByPK(primaryKey);
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
	public Pagination<ModelListDto> listPgModel(RequestModel<ModelListDto> requestModel) throws ServiceException
	{
		Pagination<ModelListDto> pagination = new Pagination<ModelListDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return modelFacade.listPaginationByProperty(pagination, requestModel.getParams());
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
		modelFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(Model model) throws ServiceException
	{
		String token = this.getAuthorization();
		modelFacade.update(token,model);
	}
	
	/**
	 * 新增机型
	 * @return
	 * @throws ServiceException
	 * */
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void saveModel(Model model) throws ServiceException{
		String token = this.getAuthorization();
		modelFacade.saveModel(token, model);
	}
	
	/**
	 * 查询品牌产品系列机型
	 * @return
	 * @throws ServiceException
	 * */
	@POST
	@Path("/findModel")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<ModelDto> findModel(ModelDto modelDto) throws ServiceException{
		return modelFacade.findModel(modelDto);
	}
	
	/**
	 * 查询所有机型名称
	 * */
	@GET
	@Path("/findModelName")
	@Produces({MediaType.APPLICATION_JSON})
	public List<String> findModelName() throws ServiceException{
		String token = this.getAuthorization();
		return modelFacade.findModelName(token);
	}
	
	@GET
	@Path("/queryModelListByBrandId")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Model> queryModelListByBrandId(@QueryParam("brandId")Long brandId) throws ServiceException{
		return modelFacade.queryModelListByBrandId(brandId);
	}
	
	@GET
	@Path("/queryModelListByBrandCode")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Model> queryModelListByBrandCode(@QueryParam("brandCode")String brandCode) throws ServiceException{
		return modelFacade.queryModelListByBrandCode(brandCode);
	}
	
	@GET
	@Path("/findModelListByCompanyId")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Model> findModelListByCompanyId(@QueryParam("companyId")Long companyId) throws ServiceException{
		Model model = new Model();
		model.setCompanyId(Integer.parseInt(companyId.toString()));
		return modelFacade.listByProperty(model);
	}
	
	/**
	 * app Models Displayed 页面
	 * 查询机型和已绑定的机型
	 * @author guihua.zhang on 2017-03-13
	 * */
	@GET
	@Path("/findModelList")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ModelInfoDto> findModelList() throws ServiceException{
		return null;
	}
	
	
	/**
	 * app Sales Collecting 页面
	 * 根据城市ID和当月时间查询所有重点机型
	 * @author guihua.zhang on 2017-03-13
	 * */
	@GET
	@Path("findVisitModel")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ModelInfoDto> findVisitModel(@QueryParam("cityId")Long cityId,@QueryParam("currencyDate")String currencyDate) throws ServiceException{
		return null;
	}
	
}
