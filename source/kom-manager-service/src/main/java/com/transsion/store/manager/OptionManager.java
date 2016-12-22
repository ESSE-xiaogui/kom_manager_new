package com.transsion.store.manager;

import java.util.List;

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
	public void saveShopOption(Long userId,List<Long> shopIds,List<Long> optionIds,List<Long> userOptionIds) throws ServiceException{
		if(UtilHelper.isEmpty(userId) || UtilHelper.isEmpty(shopIds) || UtilHelper.isEmpty(optionIds) || UtilHelper.isEmpty(userOptionIds)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		for(Long userOptionId:userOptionIds){
			userOptionMapper.deleteByPK(userOptionId);
		}
		for(Long optionId:optionIds){
			for(Long shopId:shopIds){
				optionMapper.saveShopOption(shopId,optionId);
				continue;
			}
			userOptionMapper.saveUserShop(optionId, userId);
		}
		
	}
}
