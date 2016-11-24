package com.transsion.store.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Controller;
import com.rest.service.controller.AbstractController;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.VersionInfoDto;
import com.transsion.store.utils.PropertiesUtils;


@Controller
@Path("versionInfo")
public class VersionInfoController extends AbstractController{
	/**
	 * 获取版本信息
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getVersionInfo")
	@Produces({MediaType.APPLICATION_JSON})
	public VersionInfoDto getVersionInfo() throws ServiceException
	{
		VersionInfoDto versionInfoDto = new VersionInfoDto();
		versionInfoDto.setVersion(PropertiesUtils.rtReadProperties("version","rest.cfg"));
		versionInfoDto.setUrl(PropertiesUtils.rtReadProperties("url","rest.cfg"));
		versionInfoDto.setDownLoad_flag(PropertiesUtils.rtReadProperties("download_flag","rest.cfg"));
		versionInfoDto.setDonwLoad_hint(PropertiesUtils.rtReadProperties("donwload_hint","rest.cfg"));
		return versionInfoDto;
	}
}
