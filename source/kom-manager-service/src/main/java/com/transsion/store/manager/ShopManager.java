package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Shop;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.ShopUserDto;
import com.transsion.store.dto.UserDto;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.mapper.UserMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.utils.CacheUtils;

@Service("shopManager")
public class ShopManager {
	@Autowired
	private ShopMapper shopMapper;
	
	@Autowired
	private UserMapper userMapper;
 
	/**
	 * 用户已绑定的店铺
	 * */
	public List<ShopUserDto> findShopUser(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser().getUserId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERID_IS_NULL);
		}
		return shopMapper.findShopUser(userContext.getUser().getUserId());
	}
	/**
	 * 查询店铺
	 * */
	public List<ShopUserDto> findShop(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser().getCompanyId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERID_IS_NULL);
		}
		return shopMapper.findShop(userContext.getUser().getCompanyId());
	}
	/**
	 * 门店授权管理:获取此用户已绑定的所有店铺ID
	 * */
	public List<Long> findShopIds(String userName) throws ServiceException{
		if(UtilHelper.isEmpty(userName)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserDto userDto = new UserDto();
		userDto =  userMapper.findByName(userName);
		if(UtilHelper.isEmpty(userDto)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		return shopMapper.findShopIds(userDto.getId());
	}
	
	/**
	 * 查询促销员的店铺
	 */
	public List<Shop> queryPromoterShop(String token) throws ServiceException {
		validateToken(token);
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_QUERY_ISNULL);
		}
		if (UtilHelper.isEmpty(userContext.getUser())) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_QUERY_USER_ISNULL);
		}
		// 获取token里的用户信息
		Integer userId = userContext.getUser().getUserId();
		Integer companyId = userContext.getUser().getCompanyId();
		if (UtilHelper.isEmpty(userId) || UtilHelper.isEmpty(companyId)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_SALESPARAM_IS_NULL);
		}
		return shopMapper.findByPromoter(userId, companyId);
	}
	
	public void validateToken(String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_INVALID);
		}
	}
}
