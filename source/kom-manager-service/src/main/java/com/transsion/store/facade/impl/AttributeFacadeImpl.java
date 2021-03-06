package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Attribute;
import com.transsion.store.bo.Attribute.Type;
import com.transsion.store.facade.AttributeFacade;
import com.transsion.store.manager.AttributeManager;
import com.transsion.store.service.AttributeService;

@Component("attributeFacade")
public class AttributeFacadeImpl implements AttributeFacade{

	private AttributeService attributeService;
	
	@Autowired
	private AttributeManager attributeManager;
	
	@Autowired
	public void setAttributeService(AttributeService attributeService){
		this.attributeService = attributeService;
	}

	/**
	 * 根据类型获取属性列表
	 * @throws ServiceException 
	 */
	public List<Attribute> getAttributeListByType(int type, String token)throws ServiceException {
		Type newType = this.getTypeByValue(type);
		return attributeManager.getAttributeListByType(newType,token);
	}
	
	private Type getTypeByValue(int value)
	{
		Type[] types = Type.values();
		for( Type type :types)
		{
			if(type.getVal() == value)
			{
				return type;
			}
		}
		return null;
	}
	
	

}
