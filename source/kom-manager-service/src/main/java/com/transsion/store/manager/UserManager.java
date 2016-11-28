package com.transsion.store.manager;

import com.rest.service.security.AuthKeyGenerator;
import com.rest.service.utils.JwtUtils;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.User;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.UserDto;
import com.transsion.store.mapper.UserMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.UserService;
import com.transsion.store.utils.CacheUtils;
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

	
	/**
	 * 通过用户名密码查询实体对象
	 *
	 * @param userCode
	 * @return
	 * @throws ServiceException
	 */
	public UserContext validateLogin(String userCode, String password) throws ServiceException {
		if(UtilHelper.isEmpty(userCode)||UtilHelper.isEmpty(password))
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		User user = new User();
		user.setUserCode(userCode);
		user.setPassword(password);
		List<User> list = userService.listByProperty(user);
		if (UtilHelper.isEmpty(list)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_LOGIN_FAIL);
		}
		UserContext userContext = new UserContext();
		long exp = 3600 * 24;
	    String token = JwtUtils.tokenBuilder(authKeyGenerator.generateAuthKey(), userCode, 3600 * 24);
		//TODO:调用查询国家区域表接口
	    if(!UtilHelper.isEmpty(token)) {
	    	userContext.setUserCode(userCode);
			userContext.setPassword(password);
			userContext.setToken(token);
			user.setUserId(list.get(0).getUserId());
			user.setDutyId(list.get(0).getDutyId());
			user.setCompanyId(list.get(0).getCompanyId());
			user.setUserName(list.get(0).getUserName());
			userContext.setUser(user);
			CacheUtils.getSupporter().set(token, userContext, exp);
	    } else {
	    	throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
	    }
		return userContext;
	}
	
     /**
	 * @see 登出
	 * @author guihua.zhang
	 * @return
	 * @throws ServiceException
	 */
	public Boolean logOut(String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		CacheUtils.getSupporter().remove(token);
		return Boolean.TRUE;
	}
	
	/**
	 * 根据用户名查询用户信息
	 * */
	public UserDto findByName(String token,String userCode) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(userCode)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
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
		Integer userId = userContext.getUser().getUserId();
		return userMapper.findByName(userCode, userId);
	}
}