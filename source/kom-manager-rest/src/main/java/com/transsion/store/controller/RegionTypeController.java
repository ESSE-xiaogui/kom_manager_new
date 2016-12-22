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
import com.transsion.store.bo.RegionType;
import com.transsion.store.facade.RegionTypeFacade;

@Controller
@Path("regionType")
public class RegionTypeController extends AbstractController{

	@Autowired
	private RegionTypeFacade regionTypeFacade;
	/**
	 * 查询所有区域类型
	 * */
	@GET
	@Path("/findAll")
	@Produces({MediaType.APPLICATION_JSON})
	public List<RegionType> findAll() throws ServiceException{
		return regionTypeFacade.findAll();
	}
}
