package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.facade.ErrorMessageFacade;
import com.transsion.store.manager.ErrorMessageManager;

@Component("errorMessageFacade")
public class ErrorMessageFacadeImpl implements ErrorMessageFacade{

	@Autowired
	private ErrorMessageManager errorMessageManager;
	
	public List<ExceptionDef> queryAllErrorMessage(){
		return errorMessageManager.queryAllErrorMessage();
	}
}
