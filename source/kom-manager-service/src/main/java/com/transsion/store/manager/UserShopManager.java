package com.transsion.store.manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.UserShop;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.UserShopDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.UserShopMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;
@Service("userShopManager")
public class UserShopManager {
	
	@Autowired
	private UserShopMapper userShopMapper;
	@Autowired
	private SystemDateService systemDateService;
	
	/**
	 * 门店授权管理:用户绑定门店
	 * */
	public void saveUserShop(String token, UserShopDto userShopDto) throws ServiceException{
		if(UtilHelper.isEmpty(userShopDto) && UtilHelper.isEmpty(userShopDto.getUserId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		userShopMapper.deleteByUserId(userShopDto.getUserId());
		if(!UtilHelper.isEmpty(userShopDto.getShopId())){
			for(Long shopId:userShopDto.getShopId()){
			UserShop userShop = new UserShop();
			userShop.setUserId(userShopDto.getUserId());
			userShop.setShopId(shopId);
			userShop.setCreateBy(userContext.getUserCode());
			userShop.setCreatedTime(systemDateService.getCurrentDate());
			userShop.setUpdatedBy(userContext.getUserCode());
			userShop.setUpdatedTime(systemDateService.getCurrentDate());
			userShopMapper.saveUserShop(userShop);
		}
		}
	}
}
