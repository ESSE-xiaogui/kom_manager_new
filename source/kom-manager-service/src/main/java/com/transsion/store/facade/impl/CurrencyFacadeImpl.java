package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Currency;
import com.transsion.store.dto.CurrencyDto;
import com.transsion.store.facade.CurrencyFacade;
import com.transsion.store.manager.CurrencyManager;
import com.transsion.store.service.CurrencyService;

@Component("currencyFacade")
public class CurrencyFacadeImpl implements CurrencyFacade{
	
	@Autowired
	private CurrencyManager currencyManager;
	
	@Autowired
	private CurrencyService currencyService;
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Currency getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return currencyService.getByPK(primaryKey);
	}
	
	/**
	 * 保存汇率
	 * */
	public void saveCurrency(Currency currency,String token) throws ServiceException{
		currencyManager.saveCurrency(currency, token);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<CurrencyDto> listPaginationByProperty(Pagination<CurrencyDto> pagination, CurrencyDto currencyDto)
					throws ServiceException {
		return currencyService.listPaginationByProperty(pagination, currencyDto);
	}
	/**
	 * 更新汇率
	 * */
	public void updateCurrency(Currency currency,String token) throws ServiceException{
		currencyManager.updateCurrency(currency, token);
	}
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException{
		currencyService.deleteByPKeys(primaryKeys);
	}
}
