package com.transsion.store.mapper;

import java.util.List;

import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.OrgBiz;

public interface OrgBizMapper extends GenericIBatisMapper<OrgBiz, java.lang.Long>{
	public List<OrgBiz> findAll() throws DataAccessFailureException;
}
