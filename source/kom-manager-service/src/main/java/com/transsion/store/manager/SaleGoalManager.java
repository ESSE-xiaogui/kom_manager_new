package com.transsion.store.manager;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.SaleGoalDto;
import com.transsion.store.dto.VisitShopInfoDto;
import com.transsion.store.dto.VisitStockInfoDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.SaleGoalMapper;
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
	 *  用户查看绩效
	 * @author guihua.zhang
	 * @return
	 * @throws ServiceException
	 * */
	public int findMonthSaleAmount(String token,String goalMonth) throws ServiceException {
		logger.info("用户查看绩效 start:"+goalMonth+token);
		if(UtilHelper.isEmpty(token)||UtilHelper.isEmpty(goalMonth)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		Integer userId = userContext.getUser().getId().intValue();
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
	
	/*
	 * 获取店铺月销量信息
	 */
	public  VisitShopInfoDto getShopSaleInfo(long shopId,String saleDate)
	{
		return null;
	}
	
	
	/*
	 *  获取店铺机型月销量信息
	 */
	public  List<VisitStockInfoDto> getShopModelSaleInfo(long shopId,List<String> modelList, String saleDate)
	{
		return null;
	}
	
}
