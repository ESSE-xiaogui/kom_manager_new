package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Attribute;

public interface AttributeFacade {

	List<Attribute> getAttributeListByType(Integer type, String token)throws ServiceException;

}
