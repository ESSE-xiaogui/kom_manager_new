package com.transsion.store.facade;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.VersionInfoDto;

public interface VersionInfoFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VersionInfoDto getVersionInfo(String appName) throws ServiceException;
}
