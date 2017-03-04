package com.transsion.store.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Tac;
import com.transsion.store.facade.TacFacade;

@Controller
@Path("tac")
public class TacController {
	
	@Autowired
	private TacFacade tacFacade;
	
	/**
	 * 扫描验证
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/tac")
	@Produces({ MediaType.APPLICATION_JSON })
	public Tac queryTacInfoByImei(@QueryParam("imei") java.lang.String imei) throws ServiceException {
		return tacFacade.queryTacInfoByImei(imei);
	}
	
	/**
	 * 扫描验证
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/tacList")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Tac> queryAllTacInfo() throws ServiceException {
		return tacFacade.queryAllTacInfo();
	}
}
