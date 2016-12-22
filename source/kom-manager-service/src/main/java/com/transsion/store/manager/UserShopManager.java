package com.transsion.store.manager;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.UserShop;
import com.transsion.store.dto.UserShopDto;
import com.transsion.store.mapper.UserShopMapper;
import com.transsion.store.resource.MessageStoreResource;
@Service("userShopManager")
public class UserShopManager {
	
	@Autowired
	private UserShopMapper userShopMapper;
	
	/**
	 * 门店授权管理:用户绑定门店
	 * */
	public void saveUserShop(UserShopDto userShopDto) throws ServiceException{
		if(UtilHelper.isEmpty(userShopDto) || UtilHelper.isEmpty(userShopDto.getUserId()) 
						|| UtilHelper.isEmpty(userShopDto.getShopId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		userShopMapper.deleteByUserId(userShopDto.getUserId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String date = sdf.format(new Date());
		for(Long shopId:userShopDto.getShopId()){
			
			UserShop userShop = new UserShop();
			userShop.setUserId(userShopDto.getUserId());
			userShop.setShopId(shopId);
			userShop.setCreateBy(userShopDto.getUserId().toString());
			userShop.setCreatedTime(date);
			userShopMapper.saveUserShop(userShop);
		}
		
	}
}
