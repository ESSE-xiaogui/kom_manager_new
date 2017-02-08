package com.transsion.store.manager;

import com.rest.service.security.AuthKeyGenerator;
import com.rest.service.utils.JwtUtils;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Shop;
import com.transsion.store.bo.User;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.UserInfoDto;
import com.transsion.store.dto.UserResponseDto;
import com.transsion.store.mapper.UserMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.ShopService;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.service.UserService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.MD5Utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tony on 2016/9/20.
 */
@Service("userManager")
public class UserManager {

	@Autowired
	private AuthKeyGenerator authKeyGenerator;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private ShopService shopService;
	
	
	/**
	 * 通过用户名密码查询实体对象
	 *
	 * @param userCode
	 * @return
	 * @throws ServiceException
	 */
	public UserContext executeLogin(String userCode, String password) throws ServiceException {
		if(UtilHelper.isEmpty(userCode)||UtilHelper.isEmpty(password))
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		User user = new User();
		user.setUserCode(userCode);
		user.setPassword(password);
		user.setLastLogin(systemDateService.getCurrentDate());
		userMapper.updateLastLogin(user);
		UserResponseDto urd = userMapper.getUser(user);
		if (UtilHelper.isEmpty(urd) ||UtilHelper.isEmpty(urd.getId()) || UtilHelper.isEmpty(urd.getCompanyId())
						|| UtilHelper.isEmpty(urd.getBrandCode())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_LOGIN_FAIL);
		}
		if(urd.getIsInactive().intValue() == 2){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_INACTIVE_USER);
		}
		List<Shop> shops = shopService.queryPromoterShop(urd.getUserId(), urd.getCompanyId().intValue());
		UserContext userContext = new UserContext();
		long exp = 3600 * 24;
	    String token = JwtUtils.tokenBuilder(authKeyGenerator.generateAuthKey(), userCode, 3600 * 24);
		userContext.setDutyName(urd.getDutyName());
		//TODO:调用查询国家区域表接口
	    if(!UtilHelper.isEmpty(token)) {
	    	userContext.setUserCode(userCode);
			userContext.setPassword(password);
			userContext.setCompanyId(urd.getCompanyId());
			userContext.setToken(token);
			user.setId(urd.getId());
			userContext.setBrandCode(urd.getBrandCode());
			if(!UtilHelper.isEmpty(urd.getUserId())){
				user.setUserId(urd.getUserId().intValue());
			}
			user.setLastLogin(urd.getLastLogin());
			user.setCompanyId(urd.getCompanyId().intValue());
			user.setUserName(urd.getUserName());
			userContext.setUser(user);
	    } else {
	    	throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
	    }
		if(!UtilHelper.isEmpty(shops)){
			userContext.setCityName(shops.get(0).getCityName());
			userContext.setShopName(shops.get(0).getShopName());
			Shop shop = new Shop();
			shop.setShopId(shops.get(0).getShopId());
			shop.setWerks(shops.get(0).getWerks());
			shop.setCityName(shops.get(0).getCityName());
			shop.setShopName(shops.get(0).getShopName());
			userContext.setShop(shop);
			userContext.setShopList(shops);
		}
		CacheUtils.getSupporter().set(token, userContext, exp);
		return userContext;
	}
	

	/**
	 * 用户冻结/解冻 
	 * @return
	 * @throws ServiceException
	 */
	public UserResponseDto updateUserStatus(String token, Long id, Integer isInactive) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(id)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		User formerUser = userMapper.getByPK(id);
		formerUser.setIsInactive(isInactive);
		formerUser.setUpdatedBy(userContext.getUserCode());
		formerUser.setUpdatedTime(systemDateService.getCurrentDate());
		userService.update(formerUser);
		UserResponseDto urd = new UserResponseDto();
		urd.setStatus(1);
		return urd;
	}

	/**
	 * 重置密码
	 * @return
	 * @throws ServiceException
	 */
	public UserResponseDto modifyPassword(String token, Long id, String password) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(id)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		User formerUser = userMapper.getByPK(id);
		formerUser.setPassword(password);
		formerUser.setUpdatedBy(userContext.getUserCode());
		formerUser.setUpdatedTime(systemDateService.getCurrentDate());
		formerUser.setPwdUpdated(systemDateService.getCurrentDate());
		userService.update(formerUser);
		UserResponseDto urd = new UserResponseDto();
		urd.setStatus(1);
		return urd;
	}

	/**
	 * 根据条件查询用户信息
	 * @return
	 * @throws ServiceException
	 * */
	public UserInfoDto getUserInfo(String token, UserInfoDto userInfoDto) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		userInfoDto.setCompanyId(userContext.getCompanyId().intValue());
		return userMapper.getUserInfo(userInfoDto);
	}

	/**
	 * 更改账号信息
	 * @return
	 * @throws ServiceException
	 * */
	public UserResponseDto update(String token, User user) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		User tempUser = new User();
		tempUser.setUserCode(user.getUserCode());
		int count1 = userService.findByCount(tempUser);
		tempUser.setId(user.getId());
		int count2 = userService.findByCount(tempUser);
		if(count1>0 && count2<1){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_ALREADY_EXISTS);			
		}else{
			User formerUser = userMapper.getByPK(user.getId());
			formerUser.setUserCode(user.getUserCode());
			formerUser.setPassword(user.getPassword());
			formerUser.setIsInactive(user.getIsInactive());
			formerUser.setUpdatedBy(userContext.getUserCode());
			formerUser.setUpdatedTime(systemDateService.getCurrentDate());
			userService.update(formerUser);
			UserResponseDto urd = new UserResponseDto();
			urd.setStatus(1);
			return urd;
		}
	}
	

	/**
	 * 新建用户
	 * @throws ServiceException 
	 * */
	public void save(String token, User user) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		String userCode = user.getUserCode();
		String password = user.getPassword();
		if(UtilHelper.isEmpty(userCode)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERCODE_IS_NULL);
		}
		if(UtilHelper.isEmpty(password)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PASSWORD_IS_NULL);
		}
		User u = new User();
		u.setUserCode(userCode);
		int countUser = userService.findByCount(u);
		if(countUser>0){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_ALREADY_EXISTS);
		}
		
		user.setCompanyId(userContext.getUser().getCompanyId());
		user.setPassword(MD5Utils.encrypt(password));
		user.setIsInactive(user.getIsInactive());
		user.setCreatedBy(userContext.getUser().getUserCode());
		user.setCreatedTime(systemDateService.getCurrentDate());
		userService.save(user);
	}


	/**
	 * @see 通过token退出登录
	 * @author guihua.zhang
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public Boolean logOut(String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		CacheUtils.getSupporter().remove(token);
		return Boolean.TRUE;
	}
}