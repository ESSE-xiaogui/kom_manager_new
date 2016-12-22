package com.transsion.store.mapper;

import java.util.List;

import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.RegionType;

public interface RegionTypeMapper extends GenericIBatisMapper<RegionType, java.lang.Long>{
	public List<RegionType> findAll() throws DataAccessFailureException;
}
