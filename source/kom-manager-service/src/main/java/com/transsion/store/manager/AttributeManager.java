package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Attribute;
import com.transsion.store.bo.Attribute.Type;
import com.transsion.store.context.UserContext;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.service.AttributeService;
import com.transsion.store.utils.CacheUtils;

@Service("attributeManager")
public class AttributeManager {
	@Autowired
	private AttributeService attributeService;

	public List<Attribute> getAttributeListByType(Type type, String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Integer companyId = null;
		if(!userContext.isAdmin()){
			companyId = userContext.getCompanyId().intValue();
		}
		//Integer companyId = userContext.isAdmin()?null:userContext.getCompanyId().intValue();
		return attributeService.getAttributeListByType(type, companyId);
	}
	
	public Attribute getAttribute(Type type, int seq, String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}

		Integer companyId = userContext.isAdmin() ? null : userContext.getCompanyId().intValue();

		List<Attribute> attributes = attributeService.getAttributeListByType(type, companyId);

		if (attributes != null) {
			for (Attribute attribute : attributes) {
				if (seq == attribute.getSqe()) {
					return attribute;
				}
			}
		}

		return null;
	}

}
