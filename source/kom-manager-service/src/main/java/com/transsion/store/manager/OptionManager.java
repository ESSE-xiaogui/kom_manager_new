package com.transsion.store.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.mapper.OptionMapper;
import com.transsion.store.mapper.UserOptionMapper;
import com.transsion.store.resource.MessageStoreResource;

@Service("optionManager")
public class OptionManager {
	@Autowired
	private OptionMapper optionMapper;
	
	@Autowired
	private UserOptionMapper userOptionMapper;
	/**
	 * 门店授权管理 给用户绑定店铺
	 * */
	public void saveShopOption(Long userId,Long shopId,Long optionId) throws ServiceException{
		if(UtilHelper.isEmpty(userId) || UtilHelper.isEmpty(shopId) || UtilHelper.isEmpty(optionId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		optionMapper.saveShopOption(shopId,optionId);
		userOptionMapper.saveUserShop(optionId, userId);
	}
}
