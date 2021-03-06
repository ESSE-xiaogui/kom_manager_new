package com.transsion.store.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
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
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.mapper.VisitPlanMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.CalendarUtils;
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
	
	@Autowired
	private ShopMapper shopMapper;

	/**
	 * 巡店计划默认状态:1.未巡店
	 */
	private static final Integer undo = 1;
	
	/**
	 * 巡店计划默认状态:2.已巡店
	 */
	private static final Integer done = 2;

	/**
	 * @author guihua.zhang on 2017-02-28 巡店计划上传接口
	 */
	public int savePlan(String token, List<VisitPlanDto> visitPlanDtos)  throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(visitPlanDtos)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())
						|| UtilHelper.isEmpty(userContext.getCompanyId())) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		//删除根据日期加用户名删除数据,再添加.
		/*List<VisitPlan> visitPlans = new ArrayList<VisitPlan>();
		for(VisitPlanDto VisitPlanDto:visitPlanDtoList){
			if(UtilHelper.isEmpty(VisitPlanDto.getPlanDate())){
				throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
			}
			VisitPlan visitPlan = new VisitPlan();
			visitPlan.setPlanDate(VisitPlanDto.getPlanDate());
			visitPlan.setPlanner(userContext.getUserCode());
			visitPlans.add(visitPlan);
		}
		if(visitPlans.size()>0){
			visitPlanMapper.deleteVisitPlans(visitPlans);
		}
		List<VisitPlan> visitPlanList = new ArrayList<VisitPlan>();
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
			visitPlan.setCreateBy(userContext.getUserCode());
			visitPlan.setCreateTime(systemDateService.getCurrentDate());
			visitPlanList.add(visitPlan);
		}
		
		visitPlanMapper.saveVisitPlans(visitPlanList);*/
		
		List<VisitPlan> visitPlans = new ArrayList<VisitPlan>();
		
		for (VisitPlanDto visitPlanDto : visitPlanDtos) {
			
			List<Long> shopIds = visitPlanDto.getShopIds();
			// 根据日期计划删除原先数据库中的数据
			VisitPlan visitPlanExp = new VisitPlan();
			visitPlanExp.setPlanDate(visitPlanDto.getPlanDate());
			visitPlanExp.setPlanner(userContext.getUserCode());
			visitPlanMapper.deleteByProperty(visitPlanExp);
			// 保存
			if (shopIds.size() > 0) {
				for (Long shopId : shopIds) {
					VisitPlan visitPlan = new VisitPlan();
					
					visitPlan.setCompanyId(userContext.getCompanyId());
					visitPlan.setPlanDate(visitPlanDto.getPlanDate());
					visitPlan.setCompanyId(userContext.getCompanyId());
					visitPlan.setStatus(undo);
					visitPlan.setShopId(shopId);
					if (UtilHelper.isEmpty(visitPlanDto.getPlanner())) {
						visitPlan.setPlanner(userContext.getUserCode());
					} else {
						visitPlan.setPlanner(visitPlanDto.getPlanner());
					}
					visitPlan.setCreateBy(userContext.getUserCode());
					visitPlan.setCreateTime(systemDateService.getCurrentDate());
					visitPlans.add(visitPlan);
				}
			}
		}

		visitPlanMapper.batchSaveOrUpdate(visitPlans);
		
		int success = undo;
		return success;
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
	 * @throws ParseException 
	 * @throws throws ServiceException  
	 */
	public byte[] getVisitPlanByExcel(VisitPlanDetailInfoDto visitPlanDetailInfoDto) throws ServiceException, ParseException  {
		String[] headers = {"序号","事业部","周数","计划巡店日期","门店名称","门店等级","门店类型","国家","城市","状态","上传用户", "员工姓名",
		"巡店计划上传日期","巡店完成日期"};
		List<VisitPlanDetailInfoDto> list = visitPlanMapper.listVisitPlanByProperty(visitPlanDetailInfoDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(VisitPlanDetailInfoDto visitPlanDetailInfoDto1 :list){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
			String dstr = visitPlanDetailInfoDto1.getPlanDate();
			java.util.Date date=sdf.parse(dstr);
			int weekNo= CalendarUtils.getWeekOfYear(date);
			dataset.add(new Object[]{i++,visitPlanDetailInfoDto1.getCompanyCode(),weekNo,
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
	 * @author guihua.zhang on 2017-03-02
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
		List<String> result = DateConvertUtils.getSectionTime(startDate,endDate);
		List<VisitPlanDetailSummaryDto> visitList = new ArrayList<VisitPlanDetailSummaryDto>();
		if(!UtilHelper.isEmpty(result)){
			for(String visitPlanDate:result){
			VisitPlanDetailSummaryDto vp = new VisitPlanDetailSummaryDto();
			vp.setVisitPlanDate(visitPlanDate);
			vp.setVisitPlanQty(0);
			visitList.add(vp);
		}
		}
		VisitPlanParamDto visit = new VisitPlanParamDto();
		visit.setCompanyId(userContext.getCompanyId());
		visit.setPlanner(userContext.getUserCode());
		visit.setBeginDate(startDate);
		visit.setEndDate(endDate);
		List<VisitPlanDetailSummaryDto> visitLists = visitPlanMapper.findTwoWeekQty(visit);
		return convertMap(visitLists,visitList);
	}
	/**
	 * @author guihua.zhang on 2017-03-08
	 * */
	public static Map<String,Object> convertMap(List<Map<String,Object>> list,String key) {
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		if(UtilHelper.isEmpty(list)) {
			return null;
		}
		for(Map<String,Object> m:list){
			result.put(m.get(key) == null ?null:m.get(key).toString(),m);
		}
		return result;
	}
	/**
	 * @author guihua.zhang on 2017-03-08
	 * */
	public List<VisitPlanDetailSummaryDto> convertMap(List<VisitPlanDetailSummaryDto> v1,List<VisitPlanDetailSummaryDto> v2)throws ServiceException{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(VisitPlanDetailSummaryDto v1Dto:v2){
			Map<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("visitPlanDate", v1Dto.getVisitPlanDate());
			map.put("visitPlanQty",v1Dto.getVisitPlanQty());
			list.add(map);
		}
		for(VisitPlanDetailSummaryDto v1Dto:v1){
			Map<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("visitPlanDate", v1Dto.getVisitPlanDate());
			map.put("visitPlanQty",v1Dto.getVisitPlanQty());
			list.add(map);
		}
		Map<String,Object> map1 = convertMap(list,"visitPlanDate");
		List<VisitPlanDetailSummaryDto> result = new ArrayList<VisitPlanDetailSummaryDto>();
		Iterator<String> ite = map1.keySet().iterator();
		while(ite.hasNext()){
			String key = ite.next();
			Map<String,Object>  map = (Map<String, Object>) map1.get(key);
			VisitPlanDetailSummaryDto vpdsDto = new VisitPlanDetailSummaryDto();
			vpdsDto.setVisitPlanDate(map.get("visitPlanDate").toString());
			vpdsDto.setVisitPlanQty(Integer.parseInt(map.get("visitPlanQty").toString()));
			result.add(vpdsDto);
			}
		return result;
	}
	/**
	 * @author guihua.zhang on 2017-03-02
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
	
	/**
	 * make plan页面/selectshop_plan 页面
	 * 查询督导所有店铺某天巡店计划详情
	 * @author guihua.zhang on 2017-03-06
	 * */
	public List<VisitPlanInfoDto> querySelfShopPlanInfo(String token, String startDate, String endDate)
					throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(startDate) || UtilHelper.isEmpty(endDate)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())
						|| UtilHelper.isEmpty(userContext.getCompanyId()) 
						|| UtilHelper.isEmpty(userContext.getUser())
						|| UtilHelper.isEmpty(userContext.getUser().getId())) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		List<VisitPlanInfoDto> vpinfoList = new ArrayList<VisitPlanInfoDto>();
		VisitPlanParamDto visit = new VisitPlanParamDto();
		visit.setCompanyId(userContext.getCompanyId());
		visit.setPlanner(userContext.getUserCode());
		visit.setBeginDate(startDate);
		visit.setEndDate(endDate);
		List<VisitPlanInfoDto> list = visitPlanMapper.queryPlanInfo(visit);
		Long userId = userContext.getUser().getId();
		List<Long> shopIds = new ArrayList<Long>();
		if (!UtilHelper.isEmpty(list)) {
			for (VisitPlanInfoDto vpDto : list) {
				shopIds.add(vpDto.getShopId());
			}
			List<VisitPlanInfoDto> shopLists = shopMapper.findShopDetails(userId, shopIds);
			list.addAll(shopLists);
			// 设置未计划的状态为false
			if (!UtilHelper.isEmpty(list)) {
				for (VisitPlanInfoDto vv : list) {
					VisitPlanInfoDto vvDto = new VisitPlanInfoDto();
					BeanUtils.copyProperties(vv, vvDto);
					if (vv.getWeekPlansQty() == 0) {
						vvDto.setTheDayPlanned(false);
					}
					vpinfoList.add(vvDto);
				}
			}
		} else {
			List<VisitPlanInfoDto> shopList = shopMapper.findShops(userId);
			if (!UtilHelper.isEmpty(shopList)) {
				for (VisitPlanInfoDto vv : shopList) {
					VisitPlanInfoDto vvDto = new VisitPlanInfoDto();
					BeanUtils.copyProperties(vv, vvDto);
					vvDto.setTheDayPlanned(false);
					vpinfoList.add(vvDto);
				}
			}
		}
		return vpinfoList;
	}
	
	/**
	 * @author guihua.zhang on 2017-03-02
	 * 上传巡店记录后更新新巡店计划
	 */
	public void updatePlanByVisit(Visit visit) throws ServiceException{
		if(UtilHelper.isEmpty(visit) || UtilHelper.isEmpty(visit.getShopId()) 
						|| UtilHelper.isEmpty(visit.getVisitDate())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		VisitPlan visitPlan = new VisitPlan();
		visitPlan.setCompanyId(visit.getCompanyId());
		if (visit.getVisitDate() != null && !"".equals(visit.getVisitDate())) {
			visitPlan.setPlanDate(visit.getVisitDate().substring(0, 10));
		}
		visitPlan.setShopId(visit.getShopId());
		visitPlan.setVisitId(visit.getId());
		visitPlan.setVisitDate(visit.getVisitDate());
		visitPlan.setStatus(done);
		visitPlanMapper.updateStatusByShopIdAndPlanDate(visitPlan);
	}
	
	
	/**
	 * @author guihua.zhang on 2017-03-02
	 * 判断巡店是否在计划内
	 */
	public boolean isVisitPlanned(Visit visit) throws ServiceException{
		VisitPlan visitPlan = new VisitPlan();
		visitPlan.setCompanyId(visit.getCompanyId());
		visitPlan.setPlanDate(visit.getVisitDate());
		visitPlan.setShopId(visit.getShopId());
		int count = visitPlanMapper.findByCount(visitPlan);
		if(count > 0){
			return true;
		}
		return false;
	}

}
