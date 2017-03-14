package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.TStockCurrent;
import com.transsion.store.dto.StockDto;
import com.transsion.store.facade.TStockCurrentFacade;
import com.transsion.store.manager.StockManager;
import com.transsion.store.service.TStockCurrentService;


@Component("tCurrentStockFacade")
public class TStockCurrentFacadeImpl implements TStockCurrentFacade {
	
	@Autowired
	private StockManager stockManager;
	
	private TStockCurrentService tStockCurrentService;
	
	@Autowired
	public void settCurrentStockService(TStockCurrentService tStockCurrentService) {
		this.tStockCurrentService = tStockCurrentService;
	}
	
	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<TStockCurrent> queryByProperty(TStockCurrent tCurrentStock)
			throws ServiceException
	{
		return tStockCurrentService.queryByProperty(tCurrentStock);
	}
	
	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<TStockCurrent> listByProperty(TStockCurrent tCurrentStock)
			throws ServiceException
	{
		return tStockCurrentService.listByProperty(tCurrentStock);
	}
	
	@Override
	public void saveTCurrentStockList(List<TStockCurrent> list) throws ServiceException {
		tStockCurrentService.saveTCurrentStockList(list);
	}

	@Override
	public int updateByPorp(TStockCurrent tCurrentStock) throws ServiceException {
		return tStockCurrentService.updateByPorp(tCurrentStock);
	}

	@Override
	public List<StockDto> findCurrentStockByProp(String token, Integer dealerId) throws ServiceException {
		return stockManager.findCurrentStockByProp(token, dealerId);
	}
}
