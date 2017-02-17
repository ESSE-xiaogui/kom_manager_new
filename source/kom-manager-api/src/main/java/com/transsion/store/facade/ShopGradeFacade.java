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

import com.transsion.store.bo.ShopGrade;
import com.transsion.store.dto.ShopGradeDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface ShopGradeFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public ShopGrade getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopGrade> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopGrade> listByProperty(ShopGrade shopGrade)
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
	 * @param shopGrade
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(ShopGrade shopGrade) throws ServiceException;

	/**
	 * 保存记录
	 * @param shopGrade
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public void save(ShopGrade shopGrade, String token) throws ServiceException;

	/**
	 * 更新记录
	 * @param shopGrade
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public int update(ShopGrade shopGrade, String token) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param shopGrade
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(ShopGrade shopGrade) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<ShopGradeDto> listPaginationByProperty(Pagination<ShopGradeDto> pagination, String token, ShopGradeDto shopGradeDto)
			throws ServiceException;

	/**
	 * 查询门店等级列表
	 * @param brandCode
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopGrade> getShopGradeList(String brandCode, String token)throws ServiceException;

	/**
	 * 查询已启用的门店等级
	 * @return
	 * @throws ServiceException
	 */
	public List<ShopGrade> findActiveShopGrade(String token)throws ServiceException;

}
