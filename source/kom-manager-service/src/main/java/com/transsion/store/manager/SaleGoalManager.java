package com.transsion.store.manager;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.GoalSupervisor;
import com.transsion.store.bo.Model;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.GoalModelDto;
import com.transsion.store.dto.SaleGoalDto;
import com.transsion.store.dto.ShopInfoDto;
import com.transsion.store.dto.StatShopModelSaleDto;
import com.transsion.store.dto.VisitShopInfoDto;
import com.transsion.store.dto.VisitStockInfoDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.GoalModelMapper;
import com.transsion.store.mapper.GoalSupervisorMapper;
import com.transsion.store.mapper.ModelMapper;
import com.transsion.store.mapper.SaleGoalMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.CalendarUtils;

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
	private SalesManager salesMannager;
	
	@Autowired
	private ShopMapper shopMapper;
	
	@Autowired
	private GoalSupervisorMapper goalSupervisorMapper;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private GoalModelMapper goalModelMapper;
	
	
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
		ShopInfoDto shopInfoDto =  shopMapper.queryShopInfoByShopId(shopId);
		visitShopInfoDto.setShopId(shopId);
		visitShopInfoDto.setShopName(shopInfoDto.getShopName());
		visitShopInfoDto.setGradeId(shopInfoDto.getGradeId());
		visitShopInfoDto.setGradeName(shopInfoDto.getGradeName());
		visitShopInfoDto.setCityName(shopInfoDto.getCityName());

		// 获取绩效信息
		GoalSupervisor goalSupervisor = new GoalSupervisor();
		goalSupervisor.setShopId(shopId);
		goalSupervisor.setGoalMonth(saleDate.substring(0, 7));
		Long saleTarget = goalSupervisorMapper.querySaleTargetByShopId(goalSupervisor);
		visitShopInfoDto.setTargetSaleQty(saleTarget);
		visitShopInfoDto.setPlanDate(saleDate);
		
		// 获取销量信息
		long currentSaleQty = salesMannager.calcShopSaleQty(shopId, (new SimpleDateFormat("yyyy-MM-dd").format(CalendarUtils.getFirstDayOfMonth(saleDate))), saleDate);
		visitShopInfoDto.setCurrentSaleQty(currentSaleQty);
		return visitShopInfoDto;
	}

	/*
	 * 获取店铺机型月销量/前四周平均销量信息
	 */
	public List<VisitStockInfoDto> getShopModelSaleInfo(long shopId, List<String> modelCodeList, String saleDate)
			throws ServiceException {
		List<VisitStockInfoDto> visitStockInfoList = new ArrayList<VisitStockInfoDto>();

		// 获取店铺信息
		ShopInfoDto shopInfoDto =  shopMapper.queryShopInfoByShopId(shopId);
		
		List<Model> modelList = modelMapper.queryModelListByModelCode(modelCodeList);
		for (Model model : modelList) {
			VisitStockInfoDto visitStockInfoDto = new VisitStockInfoDto();
			visitStockInfoDto.setShopId(shopId);
			visitStockInfoDto.setShopName(shopInfoDto.getShopName());
			visitStockInfoDto.setGradeId(shopInfoDto.getGradeId());
			visitStockInfoDto.setGradeName(shopInfoDto.getGradeName());
			visitStockInfoDto.setCityName(shopInfoDto.getCityName());
			
			visitStockInfoDto.setBrandId(model.getBrandId());
			visitStockInfoDto.setModelId(model.getId());
			visitStockInfoDto.setModelCode(model.getModelCode());
			visitStockInfoDto.setModelName(model.getModelName());
			visitStockInfoList.add(visitStockInfoDto);
		}
		
		// 获取绩效信息
		GoalModelDto goalModelDto = new GoalModelDto();
		goalModelDto.setShopId(shopId);
		goalModelDto.setGoalMonth(saleDate.substring(1, 7));
		goalModelDto.setModelCodeList(modelCodeList);
		List<StatShopModelSaleDto> saleTargetList = goalModelMapper.queryModelSaleTargetByShopId(goalModelDto);
		storeShopModelTargetSaleQty(visitStockInfoList, saleTargetList);

		// 获取月销量信息
		List<StatShopModelSaleDto> shopModelMonthSaleList = salesMannager.calcShopModelSaleQty(shopId, modelCodeList,
				(new SimpleDateFormat("yyyy-MM-dd").format(CalendarUtils.getFirstDayOfMonth(saleDate))), saleDate);
		storeShopModelMonthSale(visitStockInfoList, shopModelMonthSaleList);

		// 前四周平均销量信息
		List<StatShopModelSaleDto> shopModelWeekAvgSaleList = salesMannager.calcShopModelSaleQty(shopId, modelCodeList,
				new SimpleDateFormat("yyyy-MM-dd").format(CalendarUtils.getDayBeforeNDate(saleDate, 28)), saleDate);
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
				visitStockInfo.setSaleAvg((new BigDecimal(statShopModelSaleDto.getSaleQty().longValue() / 4)));
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
	
	private void storeShopModelTargetSaleQty(List<VisitStockInfoDto> visitStockInfoList,
			List<StatShopModelSaleDto> saleTargetList) {
		for(VisitStockInfoDto visitStockInfo:visitStockInfoList )
		{
			String modeCode = visitStockInfo.getModelCode();
			StatShopModelSaleDto statShopModelSaleDto = getStatShopModelSale(modeCode, saleTargetList);
			if(statShopModelSaleDto!=null)
			{
				visitStockInfo.setTargetSaleQty(statShopModelSaleDto.getTargetSaleQty());
			}
		}
	}
}
