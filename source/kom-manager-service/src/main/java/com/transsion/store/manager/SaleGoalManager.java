package com.transsion.store.manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.SaleGoalDto;
import com.transsion.store.mapper.SaleGoalMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.utils.CacheUtils;

/**
 * @author guihua.zhang
 * create time 2016/10/08
 * */
@Service("saleGoalManager")
public class SaleGoalManager {
	Logger logger = LoggerFactory.getLogger(SaleGoalManager.class);
	@Autowired
	private SaleGoalMapper saleGoalMapper;
	
	
	
	/**
	 * @see 用户查看绩效
	 * @author guihua.zhang
	 * @return
	 * @throws ServiceException
	 * */
	public int findMonthSaleAmount(String token,String goalMonth) throws ServiceException {
		logger.info("用户查看绩效 start:"+goalMonth+token);
		if(UtilHelper.isEmpty(token)||UtilHelper.isEmpty(goalMonth)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_LOGIN_FAIL);
		}
		Integer userId = userContext.getUser().getId().intValue();
		if(UtilHelper.isEmpty(userId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERID_IS_NULL);
		}
		SaleGoalDto  saleGoalDto = saleGoalMapper.findByQty(userId,goalMonth);
		int goalQty= 0;
		if(UtilHelper.isEmpty(saleGoalDto)){
			logger.info("1用户查看绩效end:"+goalQty);
			return goalQty;
		}else{
			goalQty = saleGoalDto.getGoalQty().intValue();
			logger.info("2用户查看绩效end:"+goalQty);
			return goalQty;
		}
	}
}
