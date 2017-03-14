package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.TStockCurrent;
import com.transsion.store.dto.StockDto;
import com.transsion.store.mapper.TStockCurrentMapper;

@Service("tCurrentStockService")
public class TStockCurrentService {
	private TStockCurrentMapper	tCurrentStockMapper;
	
	@Autowired
	public void settCurrentStockMapper(TStockCurrentMapper tCurrentStockMapper) {
		this.tCurrentStockMapper = tCurrentStockMapper;
	}
	
	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<TStockCurrent> queryByProperty(TStockCurrent tCurrentStock)
			throws ServiceException
	{
		return tCurrentStockMapper.queryByProperty(tCurrentStock);
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<TStockCurrent> listByProperty(TStockCurrent tCurrentStock)
			throws ServiceException
	{
		return tCurrentStockMapper.listByProperty(tCurrentStock);
	}
	
	
	public void saveTCurrentStockList(List<TStockCurrent> list) throws ServiceException {
		tCurrentStockMapper.saveTCurrentStockList(list);
	}
	
	public int updateByPorp(TStockCurrent tCurrentStock) throws ServiceException
	{
		return tCurrentStockMapper.updateByProp(tCurrentStock);
	}
	
	public List<StockDto> findCurrentStockByProp(Integer userId, Integer dealerId) throws ServiceException {
		return tCurrentStockMapper.findCurrentStockByProp(userId, dealerId);
	}
	
	public List<TStockCurrent> queryCurrentStockFromTShopStockDetail(String createTime) {
		return tCurrentStockMapper.queryCurrentStockFromTShopStockDetail(createTime);
	}
}
