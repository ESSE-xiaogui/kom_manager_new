package com.transsion.store.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.VersionInfoDto;
import com.transsion.store.facade.VersionInfoFacade;
import com.transsion.store.service.VersionInfoService;

@Component("versionInfoFacade")
public class VersionInfoFacadeImpl implements VersionInfoFacade {
	
	private VersionInfoService versionInfoService;
	
	@Autowired
	public void setVersionInfoService(VersionInfoService versionInfoService){
		this.versionInfoService = versionInfoService;
	}
	
	/**
	 * 获取版本信息
	 */
	public VersionInfoDto getVersionInfo(String appName) throws ServiceException {
		return versionInfoService.getVersionInfo(appName);
	}

}
