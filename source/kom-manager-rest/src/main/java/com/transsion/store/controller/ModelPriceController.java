package com.transsion.store.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rest.service.controller.AbstractController;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ModelPrice;
import com.transsion.store.facade.ModelPriceFacde;

@Controller
@Path("modelPrice")
public class ModelPriceController extends AbstractController{
	
	@Autowired
	private ModelPriceFacde modelPriceFacde;
	
	@GET
	@Path("/findModelPrice")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ModelPrice> findModelPrice(@QueryParam("tableType") java.lang.String tableType) throws ServiceException{
		return modelPriceFacde.findModelPrice(tableType);
	}
}
