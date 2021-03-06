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
package com.transsion.store.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.Region;
import com.transsion.store.dto.RegionDto;
import com.transsion.store.dto.RegionListDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.RegionMapper;

@Service("regionService")
public class RegionService {

	private RegionMapper	regionMapper;

	@Autowired
	public void setRegionMapper(RegionMapper regionMapper)
	{
		this.regionMapper = regionMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public RegionDto getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return regionMapper.getByPKs(primaryKey);
	}
	
	/**
	 * 根据国家ID查询所有城市
	 * */
	public List<Region> getCityAll(Long parentId) throws ServiceException{
		return regionMapper.getCityAll(parentId);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Region> list() throws ServiceException
	{
		return regionMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Region> listByProperty(Region region)
			throws ServiceException
	{
		return regionMapper.listByProperty(region);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<RegionListDto> listPaginationByProperty(Pagination<RegionListDto> pagination, RegionListDto regionListDto)
			throws ServiceException
	{
		List<RegionListDto> list = regionMapper.listPaginationByProperty(pagination, regionListDto, pagination.getOrderBy());
		
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
		return regionMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		regionMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param region
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Region region) throws ServiceException
	{
		return regionMapper.deleteByProperty(region);
	}

	/**
	 * 保存记录
	 * @param region
	 * @return
	 * @throws ServiceException
	 */
	public void save(Region region) throws ServiceException
	{
		regionMapper.save(region);
	}

	/**
	 * 更新记录
	 * @param region
	 * @return
	 * @throws ServiceException
	 */
	public int update(Region region) throws ServiceException
	{
		return regionMapper.update(region);
	}

	/**
	 * 根据条件查询记录条数
	 * @param region
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Region region) throws ServiceException
	{
		return regionMapper.findByCount(region);
	}

	public List<RegionDto> findRegionsList(Integer parentId) throws ServiceException {
		return regionMapper.findRegionsList(parentId);
	}

	/**
	 * 查询销售区域名称
	 * @return
	 * @throws ServiceException
	 */
	public String getRegionName(java.lang.Long id) throws ServiceException{
		return regionMapper.getRegionName(id);
	}

	public List<Region> findCountryList(Long userId) {
		return regionMapper.findCountryList(userId);
	}

	public List<Region> findCityListByParentRegionId(int parentId, Long userId) throws ServiceException{
		return regionMapper.findCityListByParentRegionId(parentId,userId);
	}

	public List<Region> findAllCountryList() throws ServiceException{
		return regionMapper.findAllCountryList();
	}

}