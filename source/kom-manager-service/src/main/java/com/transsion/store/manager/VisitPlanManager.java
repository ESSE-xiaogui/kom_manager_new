package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Visit;
import com.transsion.store.bo.VisitPlan;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitPlanBriefSummaryDto;
import com.transsion.store.dto.VisitPlanDetailInfoDto;
import com.transsion.store.dto.VisitPlanDetailSummaryDto;
import com.transsion.store.dto.VisitPlanDto;
import com.transsion.store.dto.VisitPlanInfoDto;
import com.transsion.store.dto.VisitPlanParamDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.VisitPlanMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.DateConvertUtils;
import com.transsion.store.utils.ExcelUtils;

/**
 * @author guihua.zhang on 2017-02-28 巡店计划功能逻辑实现
 */
@Service("visitPlanManager")
public class VisitPlanManager {

	@Autowired
	private VisitPlanMapper visitPlanMapper;

	@Autowired
	private SystemDateService systemDateService;

	/**
	 * 巡店计划默认状态:1.未巡店
	 */
	private static final Integer undo = 1;

	/**
	 * @author guihua.zhang on 2017-02-28 巡店计划上传接口
	 */
	public void savePlan(String token, List<VisitPlanDto> visitPlanDtoList) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(visitPlanDtoList)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())
						|| UtilHelper.isEmpty(userContext.getCompanyId())) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}

		for (VisitPlanDto visitPlanDto : visitPlanDtoList) {
			VisitPlan visitPlan = new VisitPlan();
			visitPlan.setCompanyId(userContext.getCompanyId());
			visitPlan.setPlanDate(visitPlanDto.getPlanDate());
			visitPlan.setShopId(visitPlanDto.getShopId());
			visitPlan.setStatus(undo);
			if (UtilHelper.isEmpty(visitPlanDto.getPlanner())) {
				visitPlan.setPlanner(userContext.getUserCode());
			} else {
				visitPlan.setPlanner(visitPlanDto.getPlanner());
			}
			if (!UtilHelper.isEmpty(visitPlanDto.getIsDelete())) {
				visitPlanMapper.deleteByPK(visitPlanDto.getId());
			}
			visitPlan.setCreateBy(userContext.getUserCode());
			visitPlan.setCreateTime(systemDateService.getCurrentDate());
			visitPlanMapper.save(visitPlan);
		}
	}

	/**
	 * @author guihua.zhang on 2017-02-28 巡店计划查询周计划数和天计划数
	 */
	public VisitPlanBriefSummaryDto queryPlanBriefSummary(String token, String planDate) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(planDate)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())
						|| UtilHelper.isEmpty(userContext.getCompanyId())) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		VisitPlanBriefSummaryDto result = new VisitPlanBriefSummaryDto();
		/**
		 * 1.根据app传入日期查询所需一天的巡店计划数
		 */
		VisitPlan visitPlan = new VisitPlan();
		visitPlan.setCompanyId(userContext.getCompanyId());
		visitPlan.setPlanner(userContext.getUserCode());
		visitPlan.setPlanDate(planDate);
		int todayPlanQty = visitPlanMapper.findByCount(visitPlan);
		result.setTodayPlanQty(todayPlanQty);
		
		/**
		 * 2.根据app传入日期查询一周巡店计划数
		 * */
		String dateList = DateConvertUtils.getWeekDays(planDate);
		if(!UtilHelper.isEmpty(dateList)){
			String[] splitDate = dateList.split(",");
			String beginDate = splitDate[1];
			String endDate = splitDate[0];
			VisitPlanParamDto visit = new VisitPlanParamDto();
			visit.setCompanyId(userContext.getCompanyId());
			visit.setPlanner(userContext.getUserCode());
			visit.setBeginDate(beginDate);
			visit.setEndDate(endDate);
			int weekPlanQty = visitPlanMapper.findWeekQtry(visit);
			result.setWeekPlanQty(weekPlanQty);
		}
		return result;
	}

	/**
	 * 巡店计划导出Excel
	 * @param visitPlanDetailInfoDto
	 * @return
	 * @throws throws ServiceException  
	 */
	public byte[] getVisitPlanByExcel(VisitPlanDetailInfoDto visitPlanDetailInfoDto) throws ServiceException  {
		String[] headers = {"序号","事业部","周数","计划巡店日期","门店名称","门店等级","门店类型","国家","城市","状态","上传用户", "员工姓名",
		"巡店计划上传日期","巡店完成日期"};
		List<VisitPlanDetailInfoDto> list = visitPlanMapper.listVisitPlanByProperty(visitPlanDetailInfoDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(VisitPlanDetailInfoDto visitPlanDetailInfoDto1 :list){
			dataset.add(new Object[]{i++,visitPlanDetailInfoDto1.getCompanyCode(),visitPlanDetailInfoDto1.getWeekNo(),
							visitPlanDetailInfoDto1.getPlanDate(),visitPlanDetailInfoDto1.getShopName(),
							visitPlanDetailInfoDto1.getGradeName(),visitPlanDetailInfoDto1.getBizName(),
							visitPlanDetailInfoDto1.getCountryName(),visitPlanDetailInfoDto1.getCityName(),
							visitPlanDetailInfoDto1.getStatus()==1?"未完成":"已完成",visitPlanDetailInfoDto1.getCreateBy(),
							visitPlanDetailInfoDto1.getEmpName(),visitPlanDetailInfoDto1.getCreateTime(),
							visitPlanDetailInfoDto1.getVisitDate()});
		}
		String title = "巡店计划报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	/**
	 * 查询每天多少店铺数 和 时间
	 */
	public List<VisitPlanDetailSummaryDto> queryPlanDetailSummary(String token, String startDate, String endDate)
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
		return visitPlanMapper.findTwoWeekQty(visit);
	}
	/**
	 * 查询巡店计划详情信息
	 * */
	public List<VisitPlanInfoDto> queryPlanInfo(String token, String startDate, String endDate)
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
		return visitPlanMapper.queryPlanInfo(visit);
	}
	/*
	 * 上传巡店记录后跟新巡店计划
	 */
	public void updatePlanByVisit(Visit visit)
	{
		
	}
	
	
	/*
	 * 判断巡店是否在计划内
	 */
	public boolean isVisitPlanned(Visit visit)
	{
		return false;
	}

}
