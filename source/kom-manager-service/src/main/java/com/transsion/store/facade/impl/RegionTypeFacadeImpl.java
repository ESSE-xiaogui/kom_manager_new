package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.RegionType;
import com.transsion.store.facade.RegionTypeFacade;
import com.transsion.store.service.RegionTypeService;
@Component("regionTypeFacade")
public class RegionTypeFacadeImpl implements RegionTypeFacade{
	
	@Autowired
	private RegionTypeService regionTypeService;
	/**
	 * 查询所有区域类型
	 * */
	public List<RegionType> findAll() throws ServiceException{
		return regionTypeService.findAll();
	}
}
