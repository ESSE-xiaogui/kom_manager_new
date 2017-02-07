/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:37
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

import com.transsion.store.bo.Sale;
import com.transsion.store.dto.SalesDto;
import com.transsion.store.dto.SalesUploadDto;
import com.transsion.store.dto.TShopSaleDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.SaleFacade;
import com.transsion.store.manager.SalesMannager;
import com.transsion.store.service.SaleService;

@Component("saleFacade")
public class SaleFacadeImpl implements SaleFacade {

	private SaleService saleService;
	
	@Autowired
	public void setSaleService(SaleService saleService)
	{
		this.saleService = saleService;
	}
	
	@Autowired
	private SalesMannager salesMannager;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Sale getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return saleService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Sale> list() throws ServiceException
	{
		return saleService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Sale> listByProperty(Sale sale)
			throws ServiceException
	{
		return saleService.listByProperty(sale);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Sale> listPaginationByProperty(Pagination<Sale> pagination, Sale sale)
			throws ServiceException
	{
		return saleService.listPaginationByProperty(pagination, sale);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return saleService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		saleService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param sale
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Sale sale) throws ServiceException
	{
		return saleService.deleteByProperty(sale);
	}

	/**
	 * 保存记录
	 * @param sale
	 * @return
	 * @throws ServiceException
	 */
	public void save(Sale sale) throws ServiceException
	{
		saleService.save(sale);
	}

	/**
	 * 更新记录
	 * @param sale
	 * @return
	 * @throws ServiceException
	 */
	public int update(Sale sale) throws ServiceException
	{
		return saleService.update(sale);
	}

	/**
	 * 根据条件查询记录条数
	 * @param sale
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Sale sale) throws ServiceException
	{
		return saleService.findByCount(sale);
	}
	/**
	 * @see 销量上报记录
	 * @return list
	 * @throws ServiceException
	 */
	public List<SalesUploadDto> saveSalesUpload(TShopSaleDto tshopSaleDto, String token, long imeiCacheTimeOut) throws ServiceException {
		return salesMannager.saveSalesUpload(tshopSaleDto, token, imeiCacheTimeOut);
	}
	/**
	 * 查询促销员的销售记录
	 * 
	 * @param token
	 * @param startDate
	 * @param endDate
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	@Override
	public List<SalesDto> findPromoterSales(String token, String startDate, String endDate, String model)
			throws ServiceException {
		return salesMannager.findPromoterSales(token, startDate, endDate, model);
	}
	/**
	 * @see 用户销量数
	 * @author guihua.zhang
	 * @return
	 * @throws ServiceException
	 * */
	public int findSaleQty(String token,String startDate,String endDate) throws ServiceException{
		return salesMannager.findSaleQty(token,startDate,endDate);
	}
	
	/**
	* 根据订单号删除记录
	* @return
	* @throws ServiceException
	*/
	public void deleteByBillNo(String billNo,String token) throws ServiceException
	{
		salesMannager.deleteByBillNo(billNo,token);
	}
}
