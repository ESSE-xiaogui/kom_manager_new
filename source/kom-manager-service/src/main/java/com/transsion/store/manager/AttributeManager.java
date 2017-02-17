package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Attribute;
import com.transsion.store.context.UserContext;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.AttributeService;
import com.transsion.store.utils.CacheUtils;

@Service("attributeManager")
public class AttributeManager {
	@Autowired
	private AttributeService attributeService;

	public List<Attribute> getAttributeListByType(Integer type, String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Integer companyId = userContext.getCompanyId().intValue();
		if(UtilHelper.isEmpty(companyId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		return attributeService.getAttributeListByType(type, companyId);
	}

}
