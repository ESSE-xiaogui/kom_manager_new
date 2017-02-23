package com.transsion.store.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.VisitModelSetting;
import com.transsion.store.context.UserContext;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.service.VisitModelSettingService;
import com.transsion.store.utils.CacheUtils;

@Service("/visitModeSettingManager")
public class VisitModeSettingManager {
	
	@Autowired
	private VisitModelSettingService visitModelSettingService;
	
	public void save(VisitModelSetting visitModelSetting, String token) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(visitModelSetting)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext.getCompanyId()) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		visitModelSetting.setCreateBy(userContext.getUser().getId().toString());
		visitModelSetting.setCreateTime(visitModelSetting.getActionDate());
		visitModelSettingService.save(visitModelSetting);
	}
}
