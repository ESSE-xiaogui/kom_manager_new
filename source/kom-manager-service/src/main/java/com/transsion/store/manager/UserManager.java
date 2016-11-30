package com.transsion.store.manager;

import com.rest.service.security.AuthKeyGenerator;
import com.rest.service.utils.JwtUtils;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.User;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.UserDto;
import com.transsion.store.dto.UserInfoDto;
import com.transsion.store.dto.UserResponseDto;
import com.transsion.store.mapper.UserMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;
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
	
	@Autowired
	private SystemDateService systemDateService;

	
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
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		
		User formerUser = userService.getByPK(id);
		formerUser.setIsInactive(isInactive);
		formerUser.setUpdatedBy(userContext.getUser().getUserCode());
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
	public UserResponseDto resetPassword(String token, Long id, String password) throws ServiceException {
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
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser().getUserId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERID_IS_NULL);
		}
		
		User formerUser = userService.getByPK(id);
		formerUser.setPassword(password);
		formerUser.setUpdatedBy(userContext.getUser().getUserCode());
		formerUser.setUpdatedTime(systemDateService.getCurrentDate());
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
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		
		userInfoDto.setCompanyId(userContext.getUser().getCompanyId());
		return userService.getUserInfo(userInfoDto);
	}

	/**
	 * 为员工分配账号
	 * @return
	 * @throws ServiceException
	 * */
	public UserResponseDto addUser(String token, User user) throws ServiceException{
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
		User tempUser = new User();
		tempUser.setUserCode(user.getUserCode());
		int count = userService.findByCount(tempUser);
		if(count>0){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_ALREADY_EXISTS);
		}else{
			user.setCompanyId(userContext.getUser().getCompanyId());
			user.setCreatedBy(userContext.getUser().getUserCode());
			user.setCreatedTime(systemDateService.getCurrentDate());
			userService.save(user);
			UserResponseDto urd = new UserResponseDto();
			urd.setStatus(1);
			return urd;
		}
	}

	/**
	 * 更改账号信息
	 * @return
	 * @throws ServiceException
	 * */
	public UserResponseDto updateUser(String token, User user) throws ServiceException{
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
		User tempUser = new User();
		tempUser.setUserCode(user.getUserCode());
		int count1 = userService.findByCount(tempUser);
		tempUser.setId(user.getId());
		int count2 = userService.findByCount(tempUser);
		if(count1>0 && count2<1){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_ALREADY_EXISTS);			
		}else{
			User formerUser = userService.getByPK(user.getId());
			formerUser.setUserCode(user.getUserCode());
			formerUser.setPassword(user.getPassword());
			formerUser.setEmpId(user.getEmpId());
			formerUser.setIsInactive(user.getIsInactive());
			formerUser.setUpdatedBy(userContext.getUser().getUserCode());
			formerUser.setUpdatedTime(systemDateService.getCurrentDate());
			userService.update(formerUser);
			UserResponseDto urd = new UserResponseDto();
			urd.setStatus(1);
			return urd;
		}
	}
}