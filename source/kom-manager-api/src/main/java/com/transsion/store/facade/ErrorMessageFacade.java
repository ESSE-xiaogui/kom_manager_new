package com.transsion.store.facade;

import java.util.List;

import com.transsion.store.exception.ExceptionDef;

public interface ErrorMessageFacade {

	public List<ExceptionDef> queryAllErrorMessage();
}

