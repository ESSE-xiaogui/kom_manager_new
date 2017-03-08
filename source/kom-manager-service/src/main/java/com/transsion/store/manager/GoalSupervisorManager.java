package com.transsion.store.manager;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.GoalModel;
import com.transsion.store.bo.GoalSupervisor;
import com.transsion.store.bo.Sale;
import com.transsion.store.dto.StatShopModelSaleDto;
import com.transsion.store.mapper.GoalModelMapper;
import com.transsion.store.mapper.GoalSupervisorMapper;
import com.transsion.store.mapper.SaleMapper;
import com.transsion.store.utils.CalendarUtils;

@Service("goalSupervisorManager")
public class GoalSupervisorManager {
	
	@Autowired
	private GoalSupervisorMapper goalSupervisorMapper;
	
	@Autowired
	private SaleMapper saleMapper;
	
	@Autowired
	private GoalModelMapper goalModelMapper;
	
	public void calcShopSaleQty() throws ServiceException {
		Date date = new Date();
		String currentMonth = new SimpleDateFormat("yyyy-MM").format(date);
		List<GoalSupervisor> goalSupervisorList = goalSupervisorMapper.queryShopIdListByGoalMonth(currentMonth);
		if (goalSupervisorList != null && goalSupervisorList.size() > 0) {
			List<Long> shopIdList = new ArrayList<Long>();
			for (GoalSupervisor goalSupervisor : goalSupervisorList) {
				shopIdList.add(goalSupervisor.getShopId());
			}
			String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
			String firstDayOfMonth = new SimpleDateFormat("yyyy-MM-dd").format(CalendarUtils.getFirstDayOfMonth(currentDate));
			List<Sale> list = saleMapper.calcShopSaleQty(shopIdList, firstDayOfMonth, currentDate);
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getShopId().longValue() == goalSupervisorList.get(i).getShopId()) {
						Long saleTarget = goalSupervisorList.get(i).getSaleTarget();
						Long saleCurrent = list.get(i).getSaleQty().longValue();
						BigDecimal achieved = null;
						if (saleTarget != 0){
							achieved = list.get(i).getSaleQty().divide(BigDecimal.valueOf(saleTarget)).setScale(2, BigDecimal.ROUND_HALF_UP);
						}
						goalSupervisorList.get(i).setSaleCurrent(saleCurrent);
						goalSupervisorList.get(i).setAchieved(achieved);
					}
				}
				
				for (GoalSupervisor goalSupervisor : goalSupervisorList) {
					goalSupervisorMapper.updateGoalSupervisorByShopId(goalSupervisor);
				}
			}
		}
	}
	
	public void calcShopModelSaleQty() throws ServiceException {
		Date date = new Date();
		String currentMonth = new SimpleDateFormat("yyyy-MM").format(date);
		List<Long> shopIdList = goalModelMapper.queryShopIdListByGoalMonth(currentMonth);
		if (shopIdList != null && shopIdList.size() > 0) {
			String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
			String firstDayOfMonth = new SimpleDateFormat("yyyy-MM-dd").format(CalendarUtils.getFirstDayOfMonth(currentDate));
			String fourWeekBefore = new SimpleDateFormat("yyyy-MM-dd").format(CalendarUtils.getDayBeforeNDate(currentDate, 28));
			for (int i = 0; i < shopIdList.size(); i++) {
				Long shopId = shopIdList.get(i);
				List<GoalModel> goalModelList = goalModelMapper.queryModelCodeListByShopId(shopId);
				List<String> modelCodeList = new ArrayList<String>();
				if (goalModelList != null && goalModelList.size() > 0) {
					for (GoalModel goalModel : goalModelList) {
						modelCodeList.add(goalModel.getModelCode());
					}
					
					if (modelCodeList != null && modelCodeList.size() > 0) {
						List<StatShopModelSaleDto> list = saleMapper.calcShopModelSaleQty(shopId, modelCodeList, firstDayOfMonth, currentDate);
						
						if (list != null && list.size() > 0) {
							for (int j = 0; j < list.size(); j++) {
								if (list.get(j).getShopId() == goalModelList.get(j).getShopId() && list.get(j).getModelCode().equals(goalModelList.get(j).getModelCode())) {
									Long saleCurrent = list.get(j).getSaleQty().longValue();
									goalModelList.get(j).setSaleCurrent(saleCurrent);
									BigDecimal achieved = null;
									if (saleCurrent != 0) {
										achieved = list.get(j).getSaleQty().divide(BigDecimal.valueOf(goalModelList.get(j).getSaleTarget())).setScale(2, BigDecimal.ROUND_HALF_UP);
									}
									goalModelList.get(j).setAchieved(achieved);
								}
							}
						}
						
						List<StatShopModelSaleDto> shopModelWeekAvgSaleList = saleMapper.calcShopModelSaleQty(shopId, modelCodeList, fourWeekBefore, currentDate);
						if (shopModelWeekAvgSaleList != null && shopModelWeekAvgSaleList.size() > 0) {
							for (int j = 0; j < list.size(); j++) {
								if (shopModelWeekAvgSaleList.get(j).getShopId() == goalModelList.get(j).getShopId() && shopModelWeekAvgSaleList.get(j).getModelCode().equals(goalModelList.get(j).getModelCode())) {
									Long saleQty = shopModelWeekAvgSaleList.get(j).getSaleQty().longValue();
									if (saleQty != 0) {
										goalModelList.get(j).setSaleFourWeeks(saleQty / 4);
									}
								}
							}
						}
					}
				}
				
				if (goalModelList != null && goalModelList.size() > 0) {
					for (GoalModel goalModel : goalModelList) {
						goalModelMapper.updateGoalModelByShopId(goalModel);
					}
				}
			}
		}
	}
}
