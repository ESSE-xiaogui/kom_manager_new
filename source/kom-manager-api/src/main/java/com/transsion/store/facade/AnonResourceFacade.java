package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.exception.ServiceException;

public interface AnonResourceFacade {
	public List<String> listResources() throws ServiceException;
}
