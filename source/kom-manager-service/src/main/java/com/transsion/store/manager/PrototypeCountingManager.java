package com.transsion.store.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.PrototypeCounting;
import com.transsion.store.context.UserContext;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.PrototypeCountingMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("/prototypeCountingManager")
public class PrototypeCountingManager {
	
	@Autowired
	private SystemDateService systemDateService;
	@Autowired
	private PrototypeCountingMapper prototypeCountingMapper; 
	
	
	/**
	 * 新增样机盘点计划
	 * @param prototypeCounting
	 * @param token
	 */
	public void savePrototypeCounting(PrototypeCounting prototypeCounting, String token) throws ServiceException {
		// 是否登录
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		// 登录信息是否为空
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		// 数据是否为空
		if(UtilHelper.isEmpty(prototypeCounting)){
			throw new ServiceException(ExceptionDef.ERROR_PROTOTYPECOUNTING_PARAM_NULL.getName());
		}
		
		prototypeCounting.setCoutingBy(userContext.getUserCode());
		prototypeCounting.setCompanyId(userContext.getCompanyId());
		prototypeCounting.setCreateBy(userContext.getUserCode());
		prototypeCounting.setCreateTime(systemDateService.getCurrentDate());
		
		prototypeCountingMapper.save(prototypeCounting);
	}
}
