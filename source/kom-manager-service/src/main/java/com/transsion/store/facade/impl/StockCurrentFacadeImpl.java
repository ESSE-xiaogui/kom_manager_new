package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.StockCurrent;
import com.transsion.store.dto.StockDto;
import com.transsion.store.facade.TStockCurrentFacade;
import com.transsion.store.manager.StockManager;
import com.transsion.store.service.StockCurrentService;


@Component("tCurrentStockFacade")
public class StockCurrentFacadeImpl implements TStockCurrentFacade {
	
	@Autowired
	private StockManager stockManager;
	
	private StockCurrentService tStockCurrentService;
	
	@Autowired
	public void settCurrentStockService(StockCurrentService tStockCurrentService) {
		this.tStockCurrentService = tStockCurrentService;
	}
	
	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<StockCurrent> queryByProperty(StockCurrent tCurrentStock)
			throws ServiceException
	{
		return tStockCurrentService.queryByProperty(tCurrentStock);
	}
	
	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<StockCurrent> listByProperty(StockCurrent tCurrentStock)
			throws ServiceException
	{
		return tStockCurrentService.listByProperty(tCurrentStock);
	}
	
	@Override
	public void saveTCurrentStockList(List<StockCurrent> list) throws ServiceException {
		tStockCurrentService.saveTCurrentStockList(list);
	}

	@Override
	public int updateByPorp(StockCurrent tCurrentStock) throws ServiceException {
		return tStockCurrentService.updateByPorp(tCurrentStock);
	}

	@Override
	public List<StockDto> findCurrentStockByProp(String token, Integer dealerId) throws ServiceException {
		return stockManager.findCurrentStockByProp(token, dealerId);
	}
}
