package com.transsion.store.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitDto;
import com.transsion.store.dto.VisitInfoDto;
import com.transsion.store.dto.VisitRecordDto;
import com.transsion.store.dto.VisitScoreSettingDto;
import com.transsion.store.dto.VisitSettingDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.VisitModelSettingMapper;
import com.transsion.store.mapper.VisitScoreSettingMapper;
import com.transsion.store.service.VisitPlanService;
import com.transsion.store.service.VisitService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.DateConvertUtils;

@Service("/visitManager")
public class VisitManager {
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private VisitModelSettingMapper visitModelSettingMapper;
	
	@Autowired
	private VisitScoreSettingMapper visitScoreSettingMapper;
	
	@Autowired
	private VisitPlanService visitPlanService;
	
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
	
	public VisitSettingDto queryVisitSetting(String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		//List<VisitModelSettingDto> visitModelSettingDtoList = visitModelSettingMapper.queryVisitModelSettingList();
		
		List<VisitScoreSettingDto> visitScoreSettingDtoList = visitScoreSettingMapper.queryVisitScoreSettingList();
		
		VisitSettingDto visitSettingDto = new VisitSettingDto();
		//visitSettingDto.setVisitModelSettingDtoList(visitModelSettingDtoList);
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
		
		VisitDto visitDto = visitRecordDto.getVisitDto();
		String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		visitDto.setCreateBy(userContext.getUserCode());
		visitDto.setCreateTime(currentDate);
		visitDto.setUpdateBy(userContext.getUserCode());
		visitDto.setUpdateTime(currentDate);
		visitService.saveVisitDto(visitDto);
	}
}
