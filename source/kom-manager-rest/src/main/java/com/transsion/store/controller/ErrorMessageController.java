package com.transsion.store.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.facade.ErrorMessageFacade;
@Controller
@Path("errorMessage")
public class ErrorMessageController extends AbstractController{
	
	
	@Autowired
	private ErrorMessageFacade errorMessageFacade;
	
	@GET
	@Path("queryAllErrorMessage")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ExceptionDef> queryAllErrorMessage(){
		return errorMessageFacade.queryAllErrorMessage();
	}

}
