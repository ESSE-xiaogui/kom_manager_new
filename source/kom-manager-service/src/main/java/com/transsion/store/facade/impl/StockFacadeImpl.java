/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:39
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Stock;
import com.transsion.store.dto.SaleDto;
import com.transsion.store.dto.StockDto;
import com.transsion.store.dto.StockInfoDto;
import com.transsion.store.dto.StockResponseDto;
import com.transsion.store.facade.StockFacade;
import com.transsion.store.manager.StockManager;
import com.transsion.store.service.StockService;

@Component("stockFacade")
public class StockFacadeImpl implements StockFacade {

	private StockService stockService;
	
	@Autowired
	public void setStockService(StockService stockService)
	{
		this.stockService = stockService;
	}
	
	@Autowired
	private StockManager stockManager;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public StockInfoDto getByPKey(java.lang.Long primaryKey) throws ServiceException
	{
		return stockService.getByPKey(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Stock> list() throws ServiceException
	{
		return stockService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Stock> listByProperty(Stock stock)
			throws ServiceException
	{
		return stockService.listByProperty(stock);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<StockInfoDto> listPaginationByProperty(Pagination<StockInfoDto> pagination, StockInfoDto stockInfoDto,String token)
			throws ServiceException
	{
		return stockService.listPaginationByProperty(pagination, stockInfoDto,token);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return stockService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		stockService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param stock
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Stock stock) throws ServiceException
	{
		return stockService.deleteByProperty(stock);
	}

	/**
	 * 保存记录
	 * @param stock
	 * @return
	 * @throws ServiceException
	 */
	public void save(Stock stock) throws ServiceException
	{
		stockService.save(stock);
	}

	/**
	 * 更新记录
	 * @param stock
	 * @return
	 * @throws ServiceException
	 */
	public int update(Stock stock) throws ServiceException
	{
		return stockService.update(stock);
	}

	/**
	 * 根据条件查询记录条数
	 * @param stock
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Stock stock) throws ServiceException
	{
		return stockService.findByCount(stock);
	}
	/**
	 * 保存库存上报记录
	 * 
	 * @param promoterStockDto
	 * @throws ServiceException
	 */
	public StockResponseDto saveStockUpload(List<StockDto> stockDtoList, String token) throws ServiceException {
		return stockManager.saveStockUpload(stockDtoList, token);
	}
	/**
	 * 查询库存上报记录
	 * 
	 * @param token
	 * @param startDate
	 * @param endDate
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public List<StockDto> findPromoterStock(String token, String startDate, String endDate, String model)
			throws ServiceException {
		return stockManager.findPromoterStock(token, startDate, endDate, model);
	}

	/**
	 * @author guihua.zhang 查询库存上报最新记录
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public List<StockDto> findPromoterCurrentStock(String token) throws ServiceException {
		return stockManager.findPromoterCurrentStock(token);
	}

	@Override
	public List<StockDto> findStocksByProp(String token, Integer shopId, String startDate, String endDate, String model)
			throws ServiceException {
		return stockManager.findStocksByProp(token, shopId, startDate, endDate, model);
	}
	
	@Override
	public List<StockDto> findCurrentStockByProp(String token, Integer shopId) throws ServiceException {
		return stockManager.findCurrentStockByProp(token, shopId);
	}

	@Override
	public byte[] getStockByExcel(StockInfoDto stockInfoDto) throws ServiceException {
		return stockManager.getStockByExcel(stockInfoDto);
	}
	
	/**
	 * 根据销量减库存
	 * @param tshopSaleDto
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public void updateCurStockBySale(SaleDto saleDto, String token) throws ServiceException {
		stockManager.updateCurStockBySale(saleDto, token);
	}
	
}
