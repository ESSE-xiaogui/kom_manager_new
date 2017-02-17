package com.transsion.store.facade;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.UserShopDto;

public interface UserShopFacade {
	

	/**
	 * 门店授权管理:用户绑定门店
	 * */
	public void saveUserShop(String token, UserShopDto userShopDto) throws ServiceException;
}
