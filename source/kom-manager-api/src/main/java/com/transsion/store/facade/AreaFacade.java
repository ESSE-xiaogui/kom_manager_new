/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-9 15:06:13
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.facade;

import java.util.List;

import com.transsion.store.bo.Area;
import com.transsion.store.dto.AreaDto;
import com.transsion.store.dto.AreaShopDto;
import com.transsion.store.dto.ShopAreaDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface AreaFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Area getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Area> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Area> listByProperty(Area area)
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
	public void deleteByPKeys(List<java.lang.Long> primaryKeys,String token) throws ServiceException;

	/**
	 * 根据传入参数删除记录
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Area area) throws ServiceException;

	/**
	 * 保存记录
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public void save(AreaDto areaDto,String token) throws ServiceException;

	/**
	 * 更新记录
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public int update(AreaDto areaDto,String token) throws ServiceException;

	/**
	 * 保存或更新记录
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(Area area) throws ServiceException;

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<Area> list) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param area
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Area area) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<AreaDto> listPaginationByProperty(Pagination<AreaDto> pagination, AreaDto areaDto)
			throws ServiceException;

	/**
	 * 查询销售大区树
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public List<AreaDto> findAreaTreeList(String token)throws ServiceException;

	public AreaDto getByPKey(Long primaryKey)throws ServiceException;

	public List<AreaShopDto> findAreaShopList(String token)throws ServiceException;

	public void saveShopArea(ShopAreaDto shopAreaDto, String token)throws ServiceException;

}
