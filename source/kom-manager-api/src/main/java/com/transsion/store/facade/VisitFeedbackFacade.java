/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-2-21 10:24:48
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.facade;

import java.util.List;

import com.transsion.store.bo.VisitFeedback;
import com.transsion.store.dto.VisitFeedBackInfoDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface VisitFeedbackFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitFeedback getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitFeedback> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitFeedback> listByProperty(VisitFeedback visitFeedback)
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
	 * @param visitFeedback
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitFeedback visitFeedback) throws ServiceException;

	/**
	 * 保存记录
	 * @param visitFeedback
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitFeedback visitFeedback) throws ServiceException;

	/**
	 * 更新记录
	 * @param visitFeedback
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitFeedback visitFeedback) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param visitFeedback
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitFeedback visitFeedback) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitFeedBackInfoDto> listPaginationByProperty(Pagination<VisitFeedBackInfoDto> pagination, VisitFeedBackInfoDto visitFeedBackInfoDto, String token)
			throws ServiceException;

	public byte[] getVisitFeedBackByExcel(VisitFeedBackInfoDto visitFeedBackInfoDto)throws ServiceException;

}
