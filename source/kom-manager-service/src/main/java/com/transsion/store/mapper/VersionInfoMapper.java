package com.transsion.store.mapper;

import org.apache.http.util.VersionInfo;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.dto.VersionInfoDto;


public interface VersionInfoMapper extends GenericIBatisMapper<VersionInfo, java.lang.Long>  {

	public VersionInfoDto getVersionInfo(String appName) throws DataAccessFailureException;

}
