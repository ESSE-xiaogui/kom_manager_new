package com.transsion.store.facade.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.UserShopDto;
import com.transsion.store.facade.UserShopFacade;
import com.transsion.store.manager.UserShopManager;
@Component("userShopFacade")
public class UserShopFacadeImpl implements UserShopFacade{
	
	@Autowired
	private UserShopManager userShopManager;
	/**
	 * 门店授权管理:用户绑定门店
	 * */
	public void saveUserShop(String token, UserShopDto userShopDto) throws ServiceException{
		userShopManager.saveUserShop(token, userShopDto);
	}
}
