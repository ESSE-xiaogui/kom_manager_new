package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.StockCurrent;
import com.transsion.store.dto.StockDto;

public interface TStockCurrentFacade {
	
	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<StockCurrent> queryByProperty(StockCurrent tCurrentStock)
			throws ServiceException;
	
	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<StockCurrent> listByProperty(StockCurrent tCurrentStock)
			throws ServiceException;
	
	public void saveTCurrentStockList(List<StockCurrent> list) throws ServiceException;
	
	public int updateByPorp(StockCurrent tCurrentStock) throws ServiceException;
	
	public List<StockDto> findCurrentStockByProp(String token, Integer dealerId) throws ServiceException;
}
