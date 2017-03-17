package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.bo.Pagination;
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
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public StockCurrent getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return stockCurrentMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<StockCurrent> list() throws ServiceException
	{
		return stockCurrentMapper.list();
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<StockCurrent> listPaginationByProperty(Pagination<StockCurrent> pagination, StockCurrent stockCurrent)
			throws ServiceException
	{
		List<StockCurrent> list = stockCurrentMapper.listPaginationByProperty(pagination, stockCurrent, pagination.getOrderBy());
		
		pagination.setResultList(list);
		
		return pagination;
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return stockCurrentMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		stockCurrentMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param stockCurrent
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(StockCurrent stockCurrent) throws ServiceException
	{
		return stockCurrentMapper.deleteByProperty(stockCurrent);
	}

	/**
	 * 保存记录
	 * @param stockCurrent
	 * @return
	 * @throws ServiceException
	 */
	public void save(StockCurrent stockCurrent) throws ServiceException
	{
		stockCurrentMapper.save(stockCurrent);
	}

	/**
	 * 更新记录
	 * @param stockCurrent
	 * @return
	 * @throws ServiceException
	 */
	public int update(StockCurrent stockCurrent) throws ServiceException
	{
		return stockCurrentMapper.update(stockCurrent);
	}

	/**
	 * 保存或更新记录
	 * @param stockCurrent
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(StockCurrent stockCurrent) throws ServiceException {
		return stockCurrentMapper.saveOrUpdate(stockCurrent);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<StockCurrent> list) throws ServiceException {
		return stockCurrentMapper.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param stockCurrent
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(StockCurrent stockCurrent) throws ServiceException
	{
		return stockCurrentMapper.findByCount(stockCurrent);
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
	
	public List<StockDto> findCurrentStockByProp(Integer userId, Integer dealerId) throws ServiceException {
		return stockCurrentMapper.findCurrentStockByProp(userId, dealerId);
	}
	
	public List<StockCurrent> queryCurrentStockFromTShopStockDetail(String createTime) {
		return stockCurrentMapper.queryCurrentStockFromTShopStockDetail(createTime);
	}
}
