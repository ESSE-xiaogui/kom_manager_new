/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:36
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

import com.transsion.store.bo.Region;
import com.transsion.store.dto.OrganizationResponseDto;
import com.transsion.store.dto.RegionDto;
import com.transsion.store.dto.RegionResponseDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.facade.RegionFacade;
import com.transsion.store.manager.RegionManager;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.RegionService;

@Component("regionFacade")
public class RegionFacadeImpl implements RegionFacade {

	private RegionService regionService;
	
	@Autowired
	private RegionManager regionManager;
	
	@Autowired
	public void setRegionService(RegionService regionService)
	{
		this.regionService = regionService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Region getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return regionService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Region> list() throws ServiceException
	{
		return regionService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Region> listByProperty(Region region)
			throws ServiceException
	{
		return regionService.listByProperty(region);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Region> listPaginationByProperty(Pagination<Region> pagination, Region region)
			throws ServiceException
	{
		return regionService.listPaginationByProperty(pagination, region);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return regionService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		regionManager.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param region
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Region region) throws ServiceException
	{
		return regionService.deleteByProperty(region);
	}

	/**
	 * 保存记录
	 * @param region
	 * @return
	 * @throws ServiceException
	 */
	public void save(Region region) throws ServiceException
	{
		regionService.save(region);
	}

	/**
	 * 更新记录
	 * @param region
	 * @return
	 * @throws ServiceException
	 */
	public int update(Region region) throws ServiceException
	{
		return regionService.update(region);
	}

	/**
	 * 根据条件查询记录条数
	 * @param region
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Region region) throws ServiceException
	{
		return regionService.findByCount(region);
	}
	
	/**
	 * 查询销售区域
	 * @return
	 * @throws ServiceException
	 */
	public List<RegionDto> findRegionsList(String token) throws ServiceException
	{
		return regionManager.findRegionsList(token);
	}
	
	/**
	 * 查询销售区域名称
	 * @return
	 * @throws ServiceException
	 */
	public Region findRegionName(java.lang.Long id) throws ServiceException{
		return regionManager.findRegionName(id);
	}

	/**
	 * 新增销售区域
	 * @return
	 * @throws ServiceException
	 * */
	public RegionResponseDto saveRegion(String token,RegionDto regionDto) throws ServiceException{
		return regionManager.saveRegion(token,regionDto);
	}
}
