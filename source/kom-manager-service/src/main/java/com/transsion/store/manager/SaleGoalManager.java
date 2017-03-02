package com.transsion.store.manager;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.SaleGoalDto;
import com.transsion.store.dto.StatShopModelSaleDto;
import com.transsion.store.dto.VisitShopInfoDto;
import com.transsion.store.dto.VisitStockInfoDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.SaleGoalMapper;
import com.transsion.store.mapper.SaleMapper;
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
	
	
	@Autowired
	private SalesMannager salesMannager;
	
	
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
	public VisitShopInfoDto getShopSaleInfo(long shopId, String saleDate) throws ServiceException {
		VisitShopInfoDto visitShopInfoDto = new VisitShopInfoDto();
		// 获取店铺信息

		// 获取绩效信息

		// 获取销量信息
		visitShopInfoDto.setCurrentSaleQty(salesMannager.calcShopSaleQty(shopId, saleDate, saleDate));
		return visitShopInfoDto;
	}

	/*
	 * 获取店铺机型月销量/前四周平均销量信息
	 */
	public List<VisitStockInfoDto> getShopModelSaleInfo(long shopId, List<String> modelCodeList, String saleDate)
			throws ServiceException {
		List<VisitStockInfoDto> visitStockInfoList = new ArrayList<VisitStockInfoDto>();

		// 获取店铺信息

		// 获取绩效信息

		// 获取月销量信息
		List<StatShopModelSaleDto> shopModelMonthSaleList = salesMannager.calcShopModelSaleQty(shopId, modelCodeList,
				saleDate, saleDate);
		storeShopModelMonthSale(visitStockInfoList, shopModelMonthSaleList);

		// 前四周平均销量信息
		List<StatShopModelSaleDto> shopModelWeekAvgSaleList = salesMannager.calcShopModelSaleQty(shopId, modelCodeList,
				saleDate, saleDate);
		storeShopModelWeekAvgSale(visitStockInfoList, shopModelWeekAvgSaleList);

		return visitStockInfoList;
	}
	
	
	private void storeShopModelMonthSale(List<VisitStockInfoDto> visitStockInfoList,
			List<StatShopModelSaleDto> statShopModelSaleList) {
		for(VisitStockInfoDto visitStockInfo:visitStockInfoList )
		{
			String modeCode = visitStockInfo.getModelCode();
			StatShopModelSaleDto statShopModelSaleDto = getStatShopModelSale(modeCode, statShopModelSaleList);
			if(statShopModelSaleDto!=null)
			{
				visitStockInfo.setCurrentSaleQty(new Long(statShopModelSaleDto.getSaleQty().longValue()));
			}
		}
	}

	private void storeShopModelWeekAvgSale(List<VisitStockInfoDto> visitStockInfoList,
			List<StatShopModelSaleDto> statShopModelSaleList) {
		for(VisitStockInfoDto visitStockInfo:visitStockInfoList )
		{
			String modeCode = visitStockInfo.getModelCode();
			StatShopModelSaleDto statShopModelSaleDto = getStatShopModelSale(modeCode, statShopModelSaleList);
			if(statShopModelSaleDto!=null)
			{
				visitStockInfo.setSaleAvg(statShopModelSaleDto.getSaleQty());
			}
		}
	}

	private StatShopModelSaleDto getStatShopModelSale(String modelCode,
			List<StatShopModelSaleDto> statShopModelSaleList) {
		if (modelCode != null && statShopModelSaleList != null) {
			for(StatShopModelSaleDto shopModelSale:statShopModelSaleList )
			{
				if(modelCode.equals(shopModelSale.getModelCode()))
				{
					return shopModelSale;
				}
				
			}
		}
		return null;
	}
}
