package com.transsion.store.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rest.service.controller.AbstractController;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.OrgBiz;
import com.transsion.store.facade.OrgBizFacade;

@Controller
@Path("orgBiz")
public class OrgBizController extends AbstractController{

	@Autowired
	private OrgBizFacade orgBizFacade;
	/**
	 * 查询所有业务属性
	 * */
	@GET
	@Path("/findAll")
	@Produces({MediaType.APPLICATION_JSON})
	public List<OrgBiz> findAll() throws ServiceException{
		return orgBizFacade.findAll();
	}
}
