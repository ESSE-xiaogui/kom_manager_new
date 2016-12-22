package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.RegionType;
import com.transsion.store.mapper.RegionTypeMapper;

@Service("regionTypeService")
public class RegionTypeService {
	
	@Autowired
	private RegionTypeMapper regionTypeMapper;
	
	public List<RegionType> findAll() throws ServiceException{
		return regionTypeMapper.findAll();
	}
}
