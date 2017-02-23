package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transsion.store.bo.Attribute;
import com.transsion.store.bo.Attribute.Type;
import com.transsion.store.mapper.AttributeMapper;


@Service("attributeService")
public class AttributeService {
	private AttributeMapper	attributeMapper;

	@Autowired
	public void setAttributeMapper(AttributeMapper	attributeMapper)
	{
		this.attributeMapper = attributeMapper;
	}

	public List<Attribute> getAttributeListByType(Type type,Integer companyId) {
		return attributeMapper.getAttributeListByType(type.getVal(),companyId);
	}

}
