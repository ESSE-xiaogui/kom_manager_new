/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:34
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.facade;

import java.util.List;

import com.transsion.store.bo.Brand;
import com.transsion.store.dto.BrandDto;
import com.transsion.store.dto.BrandModelListDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface BrandFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Brand getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Brand> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Brand> listByProperty(Brand brand)
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
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Brand brand) throws ServiceException;

	/**
	 * 保存记录
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public void save(Brand brand) throws ServiceException;

	/**
	 * 更新记录
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public void update(String token,Brand brand) throws ServiceException;

	/**
	 * 保存或更新记录
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(Brand brand) throws ServiceException;

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<Brand> list) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param brand
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Brand brand) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Brand> listPaginationByProperty(Pagination<Brand> pagination, Brand brand)
			throws ServiceException;
	
	/**
	 * 新增品牌
	 * @return
	 * @throws ServiceException
	 * */
	public void saveBrand(String token,BrandDto brandDto) throws ServiceException;
	
	/**
	 * 查询品牌
	 * @return
	 * @throws ServiceException
	 * */
	public List<BrandDto> findBrand(String token) throws ServiceException;
	
	/**
     * 获取所有品牌机型
	 * @param token 
     * @return
     * @throws ServiceException
     */
    public List<BrandModelListDto> queryBrandList(String token)throws ServiceException;
    
    public List<Brand> queryBrandListByCompanyId(Long companyId, String token) throws ServiceException;
}
