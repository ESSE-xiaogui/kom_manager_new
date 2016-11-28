package com.transsion.store.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.OptionDto;
import com.transsion.store.mapper.OptionMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.utils.CacheUtils;

@Service("optionManager")
public class OptionManager {
	@Autowired
	private OptionMapper optionMapper;
	/**
	 * 修改用户店铺权限
	 * @return
	 * @throws ServiceException
	 * */
	public OptionDto updateShopOption(String token, Integer isInactive,Integer shopId) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(isInactive) || UtilHelper.isEmpty(shopId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		Integer userId = userContext.getUser().getUserId();
		Integer companyId = userContext.getUser().getCompanyId();
		if(UtilHelper.isEmpty(userId) || UtilHelper.isEmpty(companyId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERID_IS_NULL);
		}		
		optionMapper.updateShopOption(userId, companyId, isInactive, shopId);
		OptionDto optionDto = new OptionDto();
		optionDto.setStatus(1);
		return optionDto;
	}
}
