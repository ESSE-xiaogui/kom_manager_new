package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Tac;
import com.transsion.store.facade.TacFacade;
import com.transsion.store.service.TacService;

@Component("tacFacade")
public class TacFacadeImpl implements TacFacade{
	
	@Autowired
	private TacService tacService;
	
	public List<Tac> queryAllTacInfo() throws ServiceException {
		return tacService.queryAllTacInfo();
	}
}
