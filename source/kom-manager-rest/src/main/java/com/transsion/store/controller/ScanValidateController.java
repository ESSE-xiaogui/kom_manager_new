package com.transsion.store.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.rest.service.controller.AbstractController;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.ScanValidateDto;
import com.transsion.store.facade.ScanValidateFacade;

@Controller
@Path("scanValidate")
public class ScanValidateController extends AbstractController{

	@Autowired
	private ScanValidateFacade scanValidateFacade;
	
	/**
	 * 扫描验证
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/scan")
	@Produces({ MediaType.APPLICATION_JSON })
	public ScanValidateDto queryScanValidate(@QueryParam("imei") java.lang.String imei,
			@QueryParam("qrcode") java.lang.String qrcode) throws ServiceException {
		return scanValidateFacade.queryScanValidate(imei, qrcode);
	}

	/**
	 * 批量扫描验证
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/scanbatch")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<LinkedHashMap> queryScanValidateBatch(@QueryParam("imeis") java.lang.String imeis)
			throws ServiceException {
		return scanValidateFacade.queryScanValidateBatch(imeis);
	}
}
