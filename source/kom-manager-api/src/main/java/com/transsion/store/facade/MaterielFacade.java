/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:35
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.facade;

import java.util.List;

import com.transsion.store.bo.Materiel;
import com.transsion.store.dto.MaterialInfoDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface MaterielFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Materiel getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Materiel> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Materiel> listByProperty(Materiel materiel)
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
	 * @param materiel
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Materiel materiel) throws ServiceException;

	/**
	 * 保存记录
	 * @param materiel
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public void save(Materiel materiel, String token) throws ServiceException;

	/**
	 * 更新记录
	 * @param materiel
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public int update(Materiel materiel, String token) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param materiel
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Materiel materiel) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Materiel> listPaginationByProperty(Pagination<Materiel> pagination, Materiel materiel, String token)
			throws ServiceException;

	/**
	 * 根据品牌查询道具列表(app)
	 * @param brandCode
	 * @param token
	 * @return
	 */
	public List<Materiel> getMaterielListByBrandCode(String brandCode, String token)throws ServiceException;

	/**
	 * 查询所有物料和店铺绑定的物料
	 * @author guihua.zhang on 2017-03-15
	 * */
	public List<MaterialInfoDto> findMateriel(String token) throws ServiceException;
}
