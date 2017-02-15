package com.transsion.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.ModelPrice;

public interface ModelPriceMapper extends GenericIBatisMapper<ModelPrice, java.lang.Long>{
	public List<ModelPrice> findModelPrice(@Param("tableType")String tableType) throws DataAccessFailureException;
}
