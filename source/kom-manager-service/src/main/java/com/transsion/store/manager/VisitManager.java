package com.transsion.store.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Visit;
import com.transsion.store.bo.VisitFeedback;
import com.transsion.store.bo.VisitScore;
import com.transsion.store.bo.VisitScoreItem;
import com.transsion.store.bo.VisitStock;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitDto;
import com.transsion.store.dto.VisitFeedbackDto;
import com.transsion.store.dto.VisitHistorySummaryDto;
import com.transsion.store.dto.VisitInfoDto;
import com.transsion.store.dto.VisitPlanParamDto;
import com.transsion.store.dto.VisitRecordDto;
import com.transsion.store.dto.VisitRecordInfoDto;
import com.transsion.store.dto.VisitScoreDto;
import com.transsion.store.dto.VisitScoreItemDto;
import com.transsion.store.dto.VisitScoreItemInfoDto;
import com.transsion.store.dto.VisitScoreSettingDto;
import com.transsion.store.dto.VisitSettingDto;
import com.transsion.store.dto.VisitShopDto;
import com.transsion.store.dto.VisitShopInfoDto;
import com.transsion.store.dto.VisitStockDto;
import com.transsion.store.dto.VisitStockInfoDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.SaleGoalMapper;
import com.transsion.store.mapper.VisitMapper;
import com.transsion.store.mapper.VisitScoreSettingMapper;
import com.transsion.store.service.VisitFeedbackService;
import com.transsion.store.service.VisitPlanService;
import com.transsion.store.service.VisitScoreItemService;
import com.transsion.store.service.VisitScoreService;
import com.transsion.store.service.VisitService;
import com.transsion.store.service.VisitStockService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.DateConvertUtils;

@Service("/visitManager")
public class VisitManager {
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private VisitScoreSettingMapper visitScoreSettingMapper;
	
	@Autowired
	private VisitPlanService visitPlanService;
	
	@Autowired
	private VisitMapper visitMapper;
	
	@Autowired
	private VisitStockService visitStockService;
	
	@Autowired
	private VisitScoreService visitScoreService;
	
	@Autowired
	private VisitScoreItemService visitScoreItemService;
	
	@Autowired
	private VisitFeedbackService visitFeedbackService;
	
	@Autowired
	private VisitPlanManager visitPlanManager;
	
	@Autowired
	private SaleGoalManager saleGoalManager;
	
	public List<VisitInfoDto> queryPlanedVisitList(String token, String planDate) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		VisitInfoDto visitInfoDto = new VisitInfoDto();
		visitInfoDto.setPlanDate(planDate);
		visitInfoDto.setPlanner(userContext.getUserCode());
		
		List<VisitInfoDto> list = visitPlanService.queryPlanedVisitList(visitInfoDto);
		
		List<VisitInfoDto> weekPlanCountList = null;
		String dateList = DateConvertUtils.getWeekDays(planDate);
		if(!UtilHelper.isEmpty(dateList)){
			String[] splitDate = dateList.split(",");
			String beginDate = splitDate[1];
			String endDate = splitDate[0];
			visitInfoDto.setBeginDate(beginDate);
			visitInfoDto.setEndDate(endDate);
			weekPlanCountList = visitPlanService.queryWeekPlanCount(visitInfoDto);
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getShopId().equals(weekPlanCountList.get(i).getShopId())) {
				list.get(i).setWeekPlanQty(weekPlanCountList.get(i).getWeekPlanQty());
			}
		}
		return list;
	}
	
	public List<VisitInfoDto> queryUnplanedVisitList(String token, String planDate) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		VisitInfoDto visitInfoDto = new VisitInfoDto();
		visitInfoDto.setPlanDate(planDate);
		visitInfoDto.setPlanner(userContext.getUserCode());
		
		
		List<VisitInfoDto> list = visitService.queryUnplanedVisitList(visitInfoDto);
		
		List<VisitInfoDto> weekPlanCountList = null;
		String dateList = DateConvertUtils.getWeekDays(planDate);
		if(!UtilHelper.isEmpty(dateList)){
			String[] splitDate = dateList.split(",");
			String beginDate = splitDate[1];
			String endDate = splitDate[0];
			visitInfoDto.setBeginDate(beginDate);
			visitInfoDto.setEndDate(endDate);
			weekPlanCountList = visitPlanService.queryWeekPlanCount(visitInfoDto);
		}
		
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getShopId().equals(weekPlanCountList.get(i).getShopId())) {
				list.get(i).setWeekPlanQty(weekPlanCountList.get(i).getWeekPlanQty());
			}
		}
		return list;
	}
	
	public VisitShopInfoDto queryVisitShopInfo(String token, java.lang.Long shopId, String planDate) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		return saleGoalManager.getShopSaleInfo(shopId, planDate);
	}
	
	public List<VisitStockInfoDto> queryVisitModelInfo(String token,java.lang.Long shopId, String planDate) throws ServiceException {
		 List<String> modelCodeList = new ArrayList<String>();
		return saleGoalManager.getShopModelSaleInfo(shopId, modelCodeList, planDate);
	}

	public VisitRecordInfoDto queryVisitRecordInfo(String token, String id) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		Long visitId = Long.valueOf(id);
		VisitShopDto visitShopDto = visitService.queryVisitByVisitId(visitId);
		List<VisitStockInfoDto> visitStockInfoDtoList = visitStockService.queryVisitStockByVisitId(visitId);
		VisitScoreDto visitScoreDto =  visitScoreService.queryVisitScoreByVisitId(visitId);
		List<VisitScoreItemInfoDto> visitScoreItemInfoDtoList = visitScoreItemService.queryVisitScoreItemByVisitId(visitId);
		VisitFeedbackDto visitFeedbackDto = visitFeedbackService.queryVisitFeedbackByVisitId(visitId);
		
		VisitRecordInfoDto visitRecordInfoDto = new VisitRecordInfoDto();
		visitRecordInfoDto.setVisitShopDto(visitShopDto);
		visitRecordInfoDto.setVisitStockInfoDtoList(visitStockInfoDtoList);
		visitRecordInfoDto.setVisitScoreDto(visitScoreDto);
		visitRecordInfoDto.setVisitScoreItemInfoDtoList(visitScoreItemInfoDtoList);
		visitRecordInfoDto.setVisitFeedbackDto(visitFeedbackDto);
		return visitRecordInfoDto;
	}
	
	public VisitSettingDto queryVisitSetting(String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())
						|| UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		List<VisitScoreSettingDto> visitScoreSettingDtoList = visitScoreSettingMapper.queryVisitScoreSettingList(userContext.getCompanyId());
		VisitSettingDto visitSettingDto = new VisitSettingDto();
		visitSettingDto.setVisitScoreSettingDtoList(visitScoreSettingDtoList);
		return visitSettingDto;
	}
	
	public void saveVisitRecord(String token, VisitRecordDto visitRecordDto) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		VisitDto visitDto = visitRecordDto.getVisitDto();
		
		Long visitId = null;
		if (visitDto != null) {
			Visit visit = visitDto.toModel();
			Long companyId = userContext.getCompanyId();
			visit.setCompanyId(companyId);
			visit.setCreateBy(userContext.getUserCode());
			visit.setCreateTime(currentDate);
			visit.setUpdateBy(userContext.getUserCode());
			visit.setUpdateTime(currentDate);
			
			visit.setVistor(userContext.getUserCode());
			visitService.save(visit);
			visitId = visit.getId();
		}
		
		Long shopId = userContext.getShop().getId();
		List<VisitStockDto> visitStockDtoList = visitRecordDto.getVisitStockDtoList();
		if (visitStockDtoList != null && visitStockDtoList.size() > 0) {
			for (VisitStockDto visitStockDto : visitStockDtoList) {
				if (visitStockDto != null) {
					VisitStock visitStock = visitStockDto.toModel();
					visitStock.setVisitId(visitId);
					visitStock.setShopId(shopId);
					visitStock.setCreateBy(userContext.getUserCode());
					visitStock.setCreateTime(currentDate);
					visitStock.setUpdateBy(userContext.getUserCode());
					visitStock.setUpdateTime(currentDate);
					visitStockService.save(visitStock);
				}
			}
		}
		
		VisitScoreDto visitScoreDto = visitRecordDto.getVisitScoreDto();
		if (visitScoreDto != null) {
			VisitScore visitScore = visitScoreDto.toModel();
			visitScore.setVisitId(visitId);
			visitScore.setShopId(Long.valueOf(1));
			visitScore.setCreateBy(userContext.getUserCode());
			visitScore.setCreateTime(currentDate);
			visitScore.setUpdateBy(userContext.getUserCode());
			visitScore.setUpdateTime(currentDate);
			visitScoreService.save(visitScore);
		}
		
		List<VisitScoreItemDto> visitScoreItemDtoList = visitRecordDto.getVisitScoreItemDtoList();
		if (visitScoreItemDtoList != null && visitScoreItemDtoList.size() > 0) {
			for (VisitScoreItemDto visitScoreItemDto : visitScoreItemDtoList) {
				VisitScoreItem visitScoreItem = visitScoreItemDto.toModel();
				visitScoreItem.setVisitId(visitId);
				visitScoreItem.setShopId(shopId);
				visitScoreItem.setCreateBy(userContext.getUserCode());
				visitScoreItem.setCreateTime(currentDate);
				visitScoreItem.setUpdateBy(userContext.getUserCode());
				visitScoreItem.setUpdateTime(currentDate);
				visitScoreItemService.save(visitScoreItem);
			}
		}
		
		VisitFeedbackDto visitFeedbackDto = visitRecordDto.getVisitFeedbackDto();
		if (visitFeedbackDto != null) {
			VisitFeedback visitFeedback = visitFeedbackDto.toModel();
			visitFeedback.setVisitId(visitId);
			visitFeedback.setShopId(shopId);
			visitFeedback.setCreateBy(userContext.getUserCode());
			visitFeedback.setCreateTime(currentDate);
			visitFeedback.setUpdateBy(userContext.getUserCode());
			visitFeedback.setUpdateTime(currentDate);
			visitFeedbackService.save(visitFeedback);
		}
	}
	
	/**
	 * app 历史巡店记录列表查询
	 * historyList页面 
	 * @author guihua.zhang on 2017-03-02
	 * @param startDate 前八周的第一天
	 * @param endDate 今日日期/后台去今日日期的前一天
	 */
	public List<VisitHistorySummaryDto> queryVisitSummaryHistory(String token, String startDate, String endDate)
					throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(startDate) || UtilHelper.isEmpty(endDate)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())
						|| UtilHelper.isEmpty(userContext.getCompanyId())) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		VisitPlanParamDto visit = new VisitPlanParamDto();
		visit.setCompanyId(userContext.getCompanyId());
		visit.setPlanner(userContext.getUserCode());
		visit.setBeginDate(startDate);
		visit.setEndDate(endDate);
		return visitMapper.queryVisitSummaryHistory(visit);
	}
}
