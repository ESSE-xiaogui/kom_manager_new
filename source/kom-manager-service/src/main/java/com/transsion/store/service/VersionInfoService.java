package com.transsion.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.VersionInfoDto;
import com.transsion.store.mapper.VersionInfoMapper;

@Service("versionInfoService")
public class VersionInfoService {
	private VersionInfoMapper versionInfoMapper;
	
	@Autowired
	public void setVersionInfoMapper(VersionInfoMapper versionInfoMapper){
		this.versionInfoMapper = versionInfoMapper;
	}

	/**
	 * 获取版本信息
	 * @param appName
	 * @return
	 * @throws ServiceException
	 */
	public VersionInfoDto getVersionInfo(String appName) throws ServiceException {
		return versionInfoMapper.getVersionInfo(appName);
	}
	
	
}
