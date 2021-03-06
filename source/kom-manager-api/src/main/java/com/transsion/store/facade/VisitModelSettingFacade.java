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

import com.transsion.store.bo.VisitModelSetting;
import com.transsion.store.dto.VisitModelSettingInfoDto;
import com.transsion.store.dto.VisitModelSettingListDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface VisitModelSettingFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public VisitModelSetting getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitModelSetting> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<VisitModelSetting> listByProperty(VisitModelSetting visitModelSetting)
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
	 * @param visitModelSetting
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(VisitModelSetting visitModelSetting) throws ServiceException;

	/**
	 * 保存记录
	 * @param visitModelSetting
	 * @return
	 * @throws ServiceException
	 */
	public void save(VisitModelSetting visitModelSetting, String token) throws ServiceException;

	/**
	 * 更新记录
	 * @param visitModelSetting
	 * @return
	 * @throws ServiceException
	 */
	public int update(VisitModelSetting visitModelSetting, String token) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param visitModelSetting
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(VisitModelSetting visitModelSetting) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @param token 
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<VisitModelSettingInfoDto> listPaginationByProperty(String token,Pagination<VisitModelSettingInfoDto> pagination, VisitModelSettingInfoDto visitModelSettingInfoDto)
			throws ServiceException;
	/**
	 * 根据城市ID和当月时间查询所有重点机型
	 * @author guihua.zhang on 2017-03-14
	 * */
	public List<VisitModelSettingListDto> findVisitModel(String token,Long cityId,String currentDate) throws ServiceException;
	
	/**
	 * 根据品牌获取重点机型列表
	 * @param brandCode
	 * @return
	 * @throws ServiceException
	 */
	public List<String> queryModelSettingListByBrandCode(String brandCode) throws ServiceException;
}
