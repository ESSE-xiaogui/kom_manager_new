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
package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Stock;
import com.transsion.store.dto.StockDto;
import com.transsion.store.dto.StockInfoDto;
import com.transsion.store.dto.StockResponseDto;

public interface StockFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public StockInfoDto getByPKey(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Stock> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Stock> listByProperty(Stock stock)
			throws ServiceException;

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException;
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException;

	/**
	 * 根据传入参数删除记录
	 * @param stock
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Stock stock) throws ServiceException;

	/**
	 * 保存记录
	 * @param stock
	 * @return
	 * @throws ServiceException
	 */
	public void save(Stock stock) throws ServiceException;

	/**
	 * 更新记录
	 * @param stock
	 * @return
	 * @throws ServiceException
	 */
	public int update(Stock stock) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param stock
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Stock stock) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<StockInfoDto> listPaginationByProperty(Pagination<StockInfoDto> pagination, StockInfoDto stockInfoDto,String token)
			throws ServiceException;
    /**
     * 库存上报
     * @param promoterStockDto
     * @return 
     * @throws ServiceException
     */
    public StockResponseDto saveStockUpload(List<StockDto> stockDtoList,String token) throws ServiceException;
    /**
     * 库存上报记录
     * @return
     * @throws ServiceException
     */
    public List<StockDto> findPromoterStock(String token, String startDate, String endDate, String model)throws ServiceException;

    /**
     * @author guihua.zhang
     * 查询库存上报最新记录
     * @return
     * @throws ServiceException
     */
    public List<StockDto> findPromoterCurrentStock(String token)throws ServiceException;

	public List<StockDto> findStocksByProp(String token, Integer shopId, String startDate, String endDate,String model)throws ServiceException;

	public List<StockDto> findCurrentStockByProp(String token, Integer shopId)throws ServiceException;

	public byte[] getStockByExcel(StockInfoDto stockInfoDto)throws ServiceException;
	
	/**
	 * 根据销量减库存
	 * @param saleDtoJson
	 * @return
	 * @throws ServiceException
	 */
	public void updateCurStockBySale(String saleDtoJson) throws ServiceException;
	
	/**
	 * 保存stock,stockItem
	 * @param stockSpeDtoJson
	 * @throws ServiceException
	 */
	public void saveStockSpeDto(String stockSpeDtoJson) throws ServiceException;
}
