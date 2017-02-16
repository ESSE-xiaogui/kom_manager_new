package com.transsion.store.mapper;

import java.util.List;
import java.util.Map;

import javax.ws.rs.QueryParam;

import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.Attribute;
import org.apache.ibatis.annotations.Param;

public interface AttributeMapper extends GenericIBatisMapper<Attribute, java.lang.Long>{
	public List<Attribute> getAttributeListByType(@QueryParam("type") Integer type);

}
