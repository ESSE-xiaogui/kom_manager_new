package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Attribute;
import com.transsion.store.bo.Attribute.Type;

public interface AttributeFacade {

	List<Attribute> getAttributeListByType(int type, String token)throws ServiceException;

}
