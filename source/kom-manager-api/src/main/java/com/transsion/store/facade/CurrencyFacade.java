package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Currency;
import com.transsion.store.dto.CurrencyDto;

public interface CurrencyFacade {

	/**
	 * 保存汇率
	 * */
	public void saveCurrency(Currency currency,String token) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<CurrencyDto> listPaginationByProperty(Pagination<CurrencyDto> pagination, CurrencyDto currencyDto)
			throws ServiceException;
	
	/**
	 * 更新汇率
	 * */
	public void updateCurrency(CurrencyDto currencyDto,String token) throws ServiceException;
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException;
	
}
