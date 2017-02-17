/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-16 11:36:58
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.dto.RequestModel;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.FileTemplate;
import com.transsion.store.dto.FileTemplateDto;
import com.transsion.store.facade.FileTemplateFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller
@Path("fileTemplate")
public class FileTemplateController extends AbstractController{

	@Autowired
	private FileTemplateFacade fileTemplateFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public FileTemplate getByPK(@QueryParam("key") Integer primaryKey) throws ServiceException
	{
		return fileTemplateFacade.getByPK(primaryKey);
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
	public Pagination<FileTemplate> listPgFileTemplate(RequestModel<FileTemplate> requestModel) throws ServiceException
	{
		Pagination<FileTemplate> pagination = new Pagination<FileTemplate>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return fileTemplateFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(FileTemplate fileTemplate) throws ServiceException
	{
		String token = this.getAuthorization();
		fileTemplateFacade.save(token, fileTemplate);
	}

	/**
	* 根据多条主键值删除记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/delete")
	@Consumes({MediaType.APPLICATION_JSON})
	public void delete(List<Integer> primaryKeys) throws ServiceException
	{
		fileTemplateFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void update(FileTemplate fileTemplate) throws ServiceException
	{
		fileTemplateFacade.update(fileTemplate);
	}

	/**
	 * 取得业务类型
	 * @return
	 */
	@GET
	@Path("/bizType")
	@Produces({MediaType.APPLICATION_JSON})
	public Map<String, String> getBizType() throws ServiceException
	{
		return fileTemplateFacade.getBizType();
	}

	@GET
	@Path("/exportTemplate/{bizType}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response exportTemplate(@PathParam("bizType") String bizType) throws ServiceException {

		FileTemplateDto fileTemplateDto = fileTemplateFacade.getFileTemplateDto(bizType);

		Response.ResponseBuilder response = Response.ok(fileTemplateDto.getInputStream());

		logger.debug("file name = [{}]", fileTemplateDto.getTemplateName());

		try {
			response.header("Content-Disposition", "attachment; filename=\"" + new String((fileTemplateDto.getTemplateName() + fileTemplateDto.getFileSuffix()).getBytes("gbk"), "iso-8859-1") + "\"");
			response.header("ContentType", "application/octet-stream;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}

		return response.build();
	}
}
