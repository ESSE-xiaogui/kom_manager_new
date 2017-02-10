package com.transsion.store.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rest.service.controller.AbstractController;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.dto.RequestModel;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Currency;
import com.transsion.store.dto.CurrencyDto;
import com.transsion.store.facade.CurrencyFacade;
@Controller
@Path("currency")
public class CurrencyController extends AbstractController{
	
	@Autowired
	private CurrencyFacade currencyFacade;
	
	/**
	 * 新增汇率
	 * @return
	 * @throws ServiceException
	 * */
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public void saveCurrency(Currency currency) throws ServiceException{
		String token = this.getAuthorization();
		currencyFacade.saveCurrency(currency,token);
	}
	
	/**
	 * 查询汇率
	 * */
	@POST
	@Path("/listPg")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<CurrencyDto> listPgCurrency(RequestModel<CurrencyDto> requestModel) throws ServiceException{
		Pagination<CurrencyDto> pagination = new Pagination<CurrencyDto>();
		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());
		return currencyFacade.listPaginationByProperty(pagination, pagination.getParams());
	}
	
	/**
	 * 更新汇率
	 * */
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateCurrency(CurrencyDto currencyDto) throws ServiceException{
		String token=this.getAuthorization();
		currencyFacade.updateCurrency(currencyDto,token);
	}
	
	/**
	 * 删除汇率
	 * */
	@POST
	@Path("/delete")
	@Consumes({MediaType.APPLICATION_JSON})
	public void delete(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		currencyFacade.deleteByPKeys(primaryKeys);
	}
	
}
