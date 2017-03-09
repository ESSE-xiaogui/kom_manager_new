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
import com.transsion.store.dto.GoalSupervisorInfoDto;
import com.transsion.store.dto.StatShopModelSaleDto;
import com.transsion.store.mapper.GoalModelMapper;
import com.transsion.store.mapper.GoalSupervisorMapper;
import com.transsion.store.mapper.SaleMapper;
import com.transsion.store.utils.CalendarUtils;
import com.transsion.store.utils.ExcelUtils;

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
//					if (list.get(i).getShopId().longValue() == goalSupervisorList.get(i).getShopId()) {
//						Long saleTarget = goalSupervisorList.get(i).getSaleTarget();
//						Long saleCurrent = list.get(i).getSaleQty().longValue();
//						BigDecimal achieved = null;
//						if (saleTarget != 0){
//							achieved = list.get(i).getSaleQty().divide(BigDecimal.valueOf(saleTarget)).setScale(2, BigDecimal.ROUND_HALF_UP);
//						}
//						goalSupervisorList.get(i).setSaleCurrent(saleCurrent);
//						goalSupervisorList.get(i).setAchieved(achieved);
//					}
					for (int j = 0; j < goalSupervisorList.size(); j++) {
						if (list.get(i).getShopId().longValue() == goalSupervisorList.get(j).getShopId()) {
							Long saleTarget = goalSupervisorList.get(j).getSaleTarget();
							Long saleCurrent = list.get(i).getSaleQty().longValue();
							BigDecimal achieved = null;
							if (saleTarget != 0){
								achieved = list.get(i).getSaleQty().divide(BigDecimal.valueOf(saleTarget)).setScale(2, BigDecimal.ROUND_HALF_UP);
							}
							goalSupervisorList.get(j).setSaleCurrent(saleCurrent);
							goalSupervisorList.get(j).setAchieved(achieved);
						}
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
//								if (list.get(j).getShopId() == goalModelList.get(j).getShopId() && list.get(j).getModelCode().equals(goalModelList.get(j).getModelCode())) {
//									Long saleCurrent = list.get(j).getSaleQty().longValue();
//									goalModelList.get(j).setSaleCurrent(saleCurrent);
//									BigDecimal achieved = null;
//									if (saleCurrent != 0) {
//										achieved = list.get(j).getSaleQty().divide(BigDecimal.valueOf(goalModelList.get(j).getSaleTarget())).setScale(2, BigDecimal.ROUND_HALF_UP);
//									}
//									goalModelList.get(j).setAchieved(achieved);
//								}
								
								for (int k = 0; k < goalModelList.size(); k++) {
									if (list.get(j).getShopId() == goalModelList.get(k).getShopId() && list.get(j).getModelCode().equals(goalModelList.get(k).getModelCode())) {
										Long saleCurrent = list.get(j).getSaleQty().longValue();
										goalModelList.get(k).setSaleCurrent(saleCurrent);
										BigDecimal achieved = null;
										if (saleCurrent != 0) {
											achieved = list.get(j).getSaleQty().divide(BigDecimal.valueOf(goalModelList.get(k).getSaleTarget())).setScale(2, BigDecimal.ROUND_HALF_UP);
										}
										goalModelList.get(k).setAchieved(achieved);
									}
								}
							}
						}
						
						List<StatShopModelSaleDto> shopModelWeekAvgSaleList = saleMapper.calcShopModelSaleQty(shopId, modelCodeList, fourWeekBefore, currentDate);
						if (shopModelWeekAvgSaleList != null && shopModelWeekAvgSaleList.size() > 0) {
							for (int j = 0; j < list.size(); j++) {
//								if (shopModelWeekAvgSaleList.get(j).getShopId() == goalModelList.get(j).getShopId() && shopModelWeekAvgSaleList.get(j).getModelCode().equals(goalModelList.get(j).getModelCode())) {
//									Long saleQty = shopModelWeekAvgSaleList.get(j).getSaleQty().longValue();
//									if (saleQty != 0) {
//										goalModelList.get(j).setSaleFourWeeks(saleQty / 4);
//									}
//								}
								for (int m = 0; m < shopModelWeekAvgSaleList.size(); m++) {
									if (shopModelWeekAvgSaleList.get(m).getShopId() == goalModelList.get(j).getShopId() && shopModelWeekAvgSaleList.get(m).getModelCode().equals(goalModelList.get(j).getModelCode())) {
										Long saleQty = shopModelWeekAvgSaleList.get(m).getSaleQty().longValue();
										if (saleQty != 0) {
											goalModelList.get(j).setSaleFourWeeks(saleQty / 4);
										}
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

	public byte[] getGoalSupervisorByExcel(GoalSupervisorInfoDto goalSupervisorInfoDto) {
		String[] headers = {"序号","事业部","国家","城市","年/月","用户名","员工姓名","职位","门店编码","门店名称","销售目标","实际销量"
						,"完成率","创建用户","创建用户姓名","创建时间"};
		List<GoalSupervisorInfoDto> list = goalSupervisorMapper.listGoalSupervisorByProperty(goalSupervisorInfoDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(GoalSupervisorInfoDto goalSupervisorInfoDto1 :list){
			dataset.add(new Object[]{i++,goalSupervisorInfoDto1.getCompanyCode(),
							goalSupervisorInfoDto1.getCountryName(),goalSupervisorInfoDto1.getCityName(),
							goalSupervisorInfoDto1.getGoalMonth(),goalSupervisorInfoDto1.getUserCode(),
							goalSupervisorInfoDto1.getEmpName(),goalSupervisorInfoDto1.getDutyName(),
							goalSupervisorInfoDto1.getShopCode(),goalSupervisorInfoDto1.getShopName(),
							goalSupervisorInfoDto1.getSaleTarget(),goalSupervisorInfoDto1.getSaleCurrent(),
							goalSupervisorInfoDto1.getAchieved(),goalSupervisorInfoDto1.getCreateBy(),
							goalSupervisorInfoDto1.getCreatorName(),goalSupervisorInfoDto1.getCreateTime()});
		}
		String title = "巡店员销量目标报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
}
