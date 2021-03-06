/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-2-21 10:24:47
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.facade;

import java.util.List;

import com.transsion.store.bo.VisitCompetitor;
import com.transsion.store.dto.VisitCompetitorDetailDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface VisitCompetitorFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitCompetitor getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitCompetitor> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitCompetitor> listByProperty(VisitCompetitor visitCompetitor)
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
	 * @param visitCompetitor
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitCompetitor visitCompetitor) throws ServiceException;

	/**
	 * 保存记录
	 * @param visitCompetitor
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitCompetitor visitCompetitor) throws ServiceException;

	/**
	 * 更新记录
	 * @param visitCompetitor
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitCompetitor visitCompetitor) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param visitCompetitor
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitCompetitor visitCompetitor) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitCompetitorDetailDto> listPaginationByProperty(Pagination<VisitCompetitorDetailDto> pagination, VisitCompetitorDetailDto visitScoreDetailInfoDto, String token)
			throws ServiceException;

	public byte[] getVisitCompetitorByExcel(VisitCompetitorDetailDto vCompetitorDetailDto)throws ServiceException;

}
