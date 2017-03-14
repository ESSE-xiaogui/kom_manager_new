package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.StockCurrent;
import com.transsion.store.dto.StockDto;
import com.transsion.store.mapper.StockCurrentMapper;

@Service("tCurrentStockService")
public class StockCurrentService {
	private StockCurrentMapper	stockCurrentMapper;
	
	@Autowired
	public void settCurrentStockMapper(StockCurrentMapper tCurrentStockMapper) {
		this.stockCurrentMapper = tCurrentStockMapper;
	}
	
	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<StockCurrent> queryByProperty(StockCurrent tCurrentStock)
			throws ServiceException
	{
		return stockCurrentMapper.queryByProperty(tCurrentStock);
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<StockCurrent> listByProperty(StockCurrent tCurrentStock)
			throws ServiceException
	{
		return stockCurrentMapper.listByProperty(tCurrentStock);
	}
	
	
	public void saveTCurrentStockList(List<StockCurrent> list) throws ServiceException {
		stockCurrentMapper.saveTCurrentStockList(list);
	}
	
	public int updateByPorp(StockCurrent tCurrentStock) throws ServiceException
	{
		return stockCurrentMapper.updateByProp(tCurrentStock);
	}
	
	public List<StockDto> findCurrentStockByProp(Integer userId, Integer dealerId) throws ServiceException {
		return stockCurrentMapper.findCurrentStockByProp(userId, dealerId);
	}
	
	public List<StockCurrent> queryCurrentStockFromTShopStockDetail(String createTime) {
		return stockCurrentMapper.queryCurrentStockFromTShopStockDetail(createTime);
	}
}
