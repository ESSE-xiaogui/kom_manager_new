/**
* COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2017-3-1 16:30:39
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Prototype;
import com.transsion.store.bo.PrototypeCounting;
import com.transsion.store.dto.PrototypeDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.PrototypeCountingMapper;
import com.transsion.store.mapper.PrototypeMapper;

@Service("prototypeService")
public class PrototypeService {

	private PrototypeMapper	prototypeMapper;
	@Autowired
	private PrototypeCountingMapper prototypeCountingMapper;

	@Autowired
	public void setPrototypeMapper(PrototypeMapper prototypeMapper)
	{
		this.prototypeMapper = prototypeMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public PrototypeDto getPrototypeDtoById(java.lang.Long primaryKey) throws ServiceException
	{
		return prototypeMapper.getPrototypeDtoById(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Prototype> list() throws ServiceException
	{
		return prototypeMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<PrototypeDto> listByProperty(Long shopId, String countingTime) throws ServiceException {
		PrototypeDto prototypeDto = new PrototypeDto();
		prototypeDto.setShopId(shopId);
		prototypeDto.setStatus(1);	// 上架样机
		// app端
		if (countingTime != null && countingTime != "") {
			prototypeDto.setCountingTime(countingTime);
			prototypeDto.setBeginCountingTime(prototypeDto.getCountingTime());
			prototypeDto.setEndCountingTime(getLatestDate(prototypeDto));
		}
		
		return prototypeMapper.listByProperty(prototypeDto);
	}
	
	/**
	 * 根据prototypeDto获取盘点参数中的最近的日期
	 * @return
	 */
	private String getLatestDate(PrototypeDto prototypeDto) {

		// 临时存储盘点日期
		String countingTime = "";
		String latestDate = "";
		
		if (prototypeDto != null) {
			countingTime = prototypeDto.getCountingTime();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
			SimpleDateFormat sdfTemp=new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				prototypeDto.setCountingTime(sdf.format(sdf.parse(prototypeDto.getCountingTime())));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			List<PrototypeCounting> prototypeCountings = new ArrayList<PrototypeCounting>();
			
			prototypeCountings = prototypeCountingMapper.listPrototypeCountingByPrototypeDto(prototypeDto);
			
			if (prototypeCountings != null && !prototypeCountings.isEmpty()) {
				int i ;
				List<Date> countingTimes = new ArrayList<Date>();
				for (PrototypeCounting prototypeCounting : prototypeCountings) {
					try {
						i = sdfTemp.parse(countingTime).compareTo(sdfTemp.parse(prototypeCounting.getCountingTime()));
						// 样机当前盘点时间大于等于盘点参数设置时间
						if (i >= 0) {
							countingTimes.add(sdfTemp.parse(prototypeCounting.getCountingTime()));
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (!countingTimes.isEmpty() && countingTimes.size() == 1) {
					latestDate = sdf.format(countingTimes.get(0));
				} else {
					ComparatorDate c = new ComparatorDate(); 
					Collections.sort(countingTimes,c);
					latestDate = sdfTemp.format(countingTimes.get(0));
				}
			}

			prototypeDto.setCountingTime(countingTime);
		}
		
		return latestDate;
	}
	
	class ComparatorDate implements Comparator {
	    public int compare(Object obj1, Object obj2) {
	        Date begin = (Date) obj1;
	        Date end = (Date) obj2;  
	        if (begin.before(end)) {  
	            return 1;
	        } else {
	            return -1;  
	        }
	    }
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<PrototypeDto> listPaginationByPropertyDto(Pagination<PrototypeDto> pagination, PrototypeDto prototypeDto)
			throws ServiceException
	{
		List<PrototypeDto> list = prototypeMapper.listPaginationByPropertyDto(pagination, prototypeDto, pagination.getOrderBy());
		
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
		return prototypeMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		prototypeMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param prototype
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Prototype prototype) throws ServiceException
	{
		return prototypeMapper.deleteByProperty(prototype);
	}

	/**
	 * 保存记录
	 * @param prototype
	 * @return
	 * @throws ServiceException
	 */
	public void save(Prototype prototype) throws ServiceException
	{
		// 检测IMEI是否和IMEI库一致
		// throw new ServiceException(ExceptionDef.ERROR_PROTOTYPE_IMEI_INVALID.getName());
		// 
		
		// 检测IMEI是否已录入数据库
		Prototype prototypeCon = new Prototype();
		prototypeCon.setImeiNo(prototype.getImeiNo());
		
		int proCount = prototypeMapper.findByCount(prototypeCon);
		
		if (proCount > 0) {
			throw new ServiceException(ExceptionDef.ERROR_PROTOTYPE_TOO_MANY_RESULTS.getName());
		}
		
		prototypeMapper.save(prototype);
	}

	/**
	 * 更新记录
	 * @param prototype
	 * @return
	 * @throws ServiceException
	 */
	public int update(Prototype prototype) throws ServiceException
	{
		return prototypeMapper.update(prototype);
	}

	/**
	 * 根据条件查询记录条数
	 * @param prototype
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Prototype prototype) throws ServiceException
	{
		return prototypeMapper.findByCount(prototype);
	}
}