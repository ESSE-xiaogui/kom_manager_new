package com.transsion.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.Attribute;

public interface AttributeMapper extends GenericIBatisMapper<Attribute, java.lang.Long>{
	public List<Attribute> getAttributeListByType(@Param("type") Integer type,@Param("companyId") Integer companyId);

}
