package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.exception.ServiceException;

public interface ResourceFacade {
	 public List<String> listResourcesBySubject(String subject, String token) throws ServiceException;
}
