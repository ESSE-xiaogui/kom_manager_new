package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Currency;
import com.transsion.store.dto.CurrencyDto;
import com.transsion.store.mapper.CurrencyMapper;

@Service("currencyService")
public class CurrencyService {
	
	@Autowired
	private CurrencyMapper currencyMapper;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Currency getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return currencyMapper.getByPK(primaryKey);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<CurrencyDto> listPaginationByProperty(Pagination<CurrencyDto> pagination, CurrencyDto currencyDto)
					throws ServiceException {
		List<CurrencyDto> list = currencyMapper.listPaginationByProperty(pagination, currencyDto, pagination.getOrderBy());
		System.out.println(list);
		pagination.setResultList(list);
		
		return pagination;
	}
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		currencyMapper.deleteByPKeys(primaryKeys);
	}
}
