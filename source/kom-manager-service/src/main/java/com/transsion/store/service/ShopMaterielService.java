/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-2-17 11:25:38
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.ShopMateriel;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.SaleDailyDto;
import com.transsion.store.dto.ShopMaterielDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.ShopMaterielMapper;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.ExcelUtils;

@Service("shopMaterielService")
public class ShopMaterielService {

	private ShopMaterielMapper	shopMaterielMapper;

	@Autowired
	public void setShopMaterielMapper(ShopMaterielMapper shopMaterielMapper)
	{
		this.shopMaterielMapper = shopMaterielMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ShopMateriel getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return shopMaterielMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopMateriel> list() throws ServiceException
	{
		return shopMaterielMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopMateriel> listByProperty(ShopMateriel shopMateriel)
			throws ServiceException
	{
		return shopMaterielMapper.listByProperty(shopMateriel);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopMaterielDto> listPaginationByProperty(Pagination<ShopMaterielDto> pagination, ShopMaterielDto shopMaterielDto, String token)
			throws ServiceException
	{
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		
		Integer companyId = userContext.isAdmin()?null:userContext.getCompanyId().intValue();
		
		List<ShopMaterielDto> list = shopMaterielMapper.listPaginationByProperty(pagination, shopMaterielDto, pagination.getOrderBy(),companyId);
		
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
		return shopMaterielMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		shopMaterielMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param shopMateriel
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ShopMateriel shopMateriel) throws ServiceException
	{
		return shopMaterielMapper.deleteByProperty(shopMateriel);
	}

	/**
	 * 保存记录
	 * @param shopMateriel
	 * @return
	 * @throws ServiceException
	 */
	public void save(ShopMateriel shopMateriel) throws ServiceException
	{
		shopMaterielMapper.save(shopMateriel);
	}

	/**
	 * 更新记录
	 * @param shopMateriel
	 * @return
	 * @throws ServiceException
	 */
	public int update(ShopMateriel shopMateriel) throws ServiceException
	{
		return shopMaterielMapper.update(shopMateriel);
	}

	/**
	 * 根据条件查询记录条数
	 * @param shopMateriel
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ShopMateriel shopMateriel) throws ServiceException
	{
		return shopMaterielMapper.findByCount(shopMateriel);
	}
	
	public void saveShopMateriel(List<ShopMateriel> shopMateriel) throws ServiceException {
		shopMaterielMapper.saveShopMateriel(shopMateriel);
	}
	
	 public List<ShopMateriel> queryShopMaterielListByShopId(Long shopId) throws ServiceException {
		return shopMaterielMapper.queryShopMaterielListByShopId(shopId);
	 }

	 /**
	  * 物料统计导出Excel
	 * @param shopMaterielDto 
	  * @return
	 * @throws DataAccessFailureException 
	  */
	public byte[] getShopMaterielByExcel(ShopMaterielDto shopMaterielDto) throws ServiceException {
		String[] headers = {"序号","事业部","国家","城市","门店代码","门店名称","物料类型", "物料名称(CN)",
						"物料名称(EN)","物料数量","上传用户","上传日期","更新用户","更新时间"};
		List<ShopMaterielDto> list = shopMaterielMapper.listShopMaterielByProperty(shopMaterielDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(ShopMaterielDto shopMaterielDto1 :list){
			dataset.add(new Object[]{i++,shopMaterielDto1.getCompanyCode(),shopMaterielDto1.getCountryName(),
			shopMaterielDto1.getCityName(),shopMaterielDto1.getShopId(),shopMaterielDto1.getShopName(),
			shopMaterielDto1.getType(),shopMaterielDto1.getNameCN(),shopMaterielDto1.getNameEN(),
			shopMaterielDto1.getMaterielQty(),shopMaterielDto1.getCreateBy(),shopMaterielDto1.getCreateDate(),
			shopMaterielDto1.getUpdateBy(),shopMaterielDto1.getUpdateDate()});
		}
		String title = "物料统计报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
}