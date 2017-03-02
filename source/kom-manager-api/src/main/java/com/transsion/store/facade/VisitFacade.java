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

import com.transsion.store.bo.Visit;
import com.transsion.store.dto.VisitHistorySummaryDto;
import com.transsion.store.dto.VisitInfoDto;
import com.transsion.store.dto.VisitModelInfoDto;
import com.transsion.store.dto.VisitRecordDto;
import com.transsion.store.dto.VisitRecordInfoDto;
import com.transsion.store.dto.VisitSettingDto;
import com.transsion.store.dto.VisitShopInfoDto;
import com.transsion.store.dto.VisitStockInfoDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface VisitFacade {

	/**
	 * 通过主键查询实体对象
	 * 
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Visit getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<Visit> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<Visit> listByProperty(Visit visit) throws ServiceException;

	/**
	 * 根据主键删除记录
	 * 
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 根据多个主键删除记录
	 * 
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException;

	/**
	 * 根据传入参数删除记录
	 * 
	 * @param visit
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Visit visit) throws ServiceException;

	/**
	 * 保存记录
	 * 
	 * @param visit
	 * @return
	 * @throws ServiceException
	 */
	public void save(Visit visit) throws ServiceException;

	/**
	 * 更新记录
	 * 
	 * @param visit
	 * @return
	 * @throws ServiceException
	 */
	public int update(Visit visit) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * 
	 * @param visit
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Visit visit) throws ServiceException;

	/**
	 * 根据查询条件查询分页记录
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Visit> listPaginationByProperty(Pagination<Visit> pagination, Visit visit)
			throws ServiceException;

	/*********************************
	 * web api
	 **********************************/

	/*********************************
	 * app api
	 **********************************/

	/**
	 * today shop list page
	 * today's visiting 页面
	 * visited shops页面
	 * 查询周计划巡店记录
	 * app入参 计划时间
	 * 返回周计划巡店详情
	 * @author guihua.zhang
	 **/
	public List<VisitInfoDto> queryPlanedVisitList(String token, String planDate) throws ServiceException;


	/**
	 * key model psi页面
	 * @author guihua.zhang
	 * 
	 */
	public List<VisitStockInfoDto> queryVisitModelInfo(String token, java.lang.Long shopId, String planDate) throws ServiceException;
	
	/**
	 * @author guihua.zhang
	 * shopscore页面
	 * score setting...
	 */
	public VisitSettingDto queryVisitSetting(String token) throws ServiceException;
	
	
	

	public List<VisitInfoDto> queryUnplanedVisitList(String token, String planDate) throws ServiceException;

	/*
	 * visit page
	 */
	public VisitShopInfoDto queryVisitShopInfo(String token, java.lang.Long shopId, String planDate) throws ServiceException;

	


	/*
	 * 
	 */
	public void saveVisitRecord(String token, VisitRecordDto visitRecordDto) throws ServiceException;

	/*
	 * history
	 */
	public List<VisitHistorySummaryDto> queryVisitSummaryHistory(String token, String startDate, String endDate)
			throws ServiceException;

	public VisitRecordInfoDto queryVisitRecordInfo(String token, String visitId) throws ServiceException;
}
