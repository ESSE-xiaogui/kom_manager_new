package com.transsion.store.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.rest.service.controller.AbstractController;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.VersionInfoDto;
import com.transsion.store.facade.VersionInfoFacade;
import com.transsion.store.utils.PropertiesUtils;


@Controller
@Path("versionInfo")
public class VersionInfoController extends AbstractController{
	
	@Autowired
	private VersionInfoFacade versionInfoFacade;
	
	/**
	 * 获取版本信息
	 * @param appName
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getVersionInfo")
	@Produces({MediaType.APPLICATION_JSON})
	public VersionInfoDto getVersionInfo(@QueryParam("appName") java.lang.String appName) throws ServiceException
	{
		return versionInfoFacade.getVersionInfo(appName);
	}
}
