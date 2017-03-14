package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.TStockCurrent;
import com.transsion.store.dto.StockDto;

public interface TStockCurrentFacade {
	
	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<TStockCurrent> queryByProperty(TStockCurrent tCurrentStock)
			throws ServiceException;
	
	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<TStockCurrent> listByProperty(TStockCurrent tCurrentStock)
			throws ServiceException;
	
	public void saveTCurrentStockList(List<TStockCurrent> list) throws ServiceException;
	
	public int updateByPorp(TStockCurrent tCurrentStock) throws ServiceException;
	
	public List<StockDto> findCurrentStockByProp(String token, Integer dealerId) throws ServiceException;
}
