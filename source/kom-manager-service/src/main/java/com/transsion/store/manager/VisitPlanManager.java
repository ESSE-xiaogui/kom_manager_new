package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.VisitPlan;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitPlanBriefSummaryDto;
import com.transsion.store.dto.VisitPlanDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.VisitPlanMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.DateConvertUtils;

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
		List<String> dateList = DateConvertUtils.getAllWeekDays(planDate);
		int sumQty = 0;
		for(String plansDate:dateList){
			visitPlan.setCompanyId(userContext.getCompanyId());
			visitPlan.setPlanner(userContext.getUserCode());
			visitPlan.setPlanDate(plansDate);
			int everydayQty = visitPlanMapper.findByCount(visitPlan);
			sumQty += everydayQty;
		}
		result.setWeekPlanQty(sumQty);
		return result;
	}

}
