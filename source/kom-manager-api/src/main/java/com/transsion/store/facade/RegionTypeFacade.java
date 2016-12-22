package com.transsion.store.facade;

import java.util.List;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.RegionType;

public interface RegionTypeFacade {
	

	/**
	 * 查询所有业务属性
	 * */
	public List<RegionType> findAll() throws ServiceException;
}
