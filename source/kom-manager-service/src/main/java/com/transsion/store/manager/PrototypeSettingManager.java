package com.transsion.store.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.PrototypeSetting;
import com.transsion.store.bo.PrototypeSettingModel;
import com.transsion.store.bo.PrototypeSettingRegion;
import com.transsion.store.bo.PrototypeSettingTime;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.PrototypeDto;
import com.transsion.store.dto.PrototypeSettingDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.PrototypeSettingMapper;
import com.transsion.store.mapper.PrototypeSettingModelMapper;
import com.transsion.store.mapper.PrototypeSettingRegionMapper;
import com.transsion.store.mapper.PrototypeSettingTimeMapper;
import com.transsion.store.service.PrototypeSettingService;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("/prototypeSettingManager")
public class PrototypeSettingManager {

	@Autowired
	private SystemDateService systemDateService;
	@Autowired
	private PrototypeSettingMapper prototypeSettingMapper;
	@Autowired
	private PrototypeSettingModelMapper prototypeSettingModelMapper;
	@Autowired
	private PrototypeSettingRegionMapper prototypeSettingRegionMapper;
	@Autowired
	private PrototypeSettingTimeMapper prototypeSettingTimeMapper;
	@Autowired
	private PrototypeSettingService prototypeSettingService;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<PrototypeSettingDto> listPaginationByProperty(Pagination<PrototypeSettingDto> pagination, PrototypeSettingDto prototypeSettingDto, String token)
			throws ServiceException {
		
			UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
			Long companyId = userContext.isAdmin()?null:userContext.getCompanyId();
			
			if (pagination.getParams() == null) {
				
				prototypeSettingDto = new PrototypeSettingDto();
				
				prototypeSettingDto.setCompanyId(companyId);
				
				pagination.setParams(prototypeSettingDto);
			} 
		
			Pagination<PrototypeSettingDto> pagin = prototypeSettingService.listPaginationByProperty(pagination, prototypeSettingDto);
			
			List<PrototypeSettingDto> prototypeSettingDtos = pagin.getResultList();
			
			if (!prototypeSettingDtos.isEmpty()) {
				for (PrototypeSettingDto prototypeSettingDtoTemp: prototypeSettingDtos) {
					PrototypeSettingTime prototypeSettingTime =  new PrototypeSettingTime();
					List<PrototypeSettingTime> prototypeSettingTimes = new ArrayList<PrototypeSettingTime>();
					prototypeSettingTime.setSettingId(prototypeSettingDtoTemp.getId());
					prototypeSettingTimes = prototypeSettingTimeMapper.listByProperty(prototypeSettingTime);
					
					if (!prototypeSettingTimes.isEmpty()) {
						String str = "";
						
						for (PrototypeSettingTime prototypeSettingTimeTemp : prototypeSettingTimes) {
							str += prototypeSettingTimeTemp.getCountDate() + ",";
						}
						prototypeSettingDtoTemp.setCountDates(str.substring(0, str.length() - 1));
					}
				}
			}
			
			pagin.setResultList(prototypeSettingDtos);
			
			return pagin;
	}
	
	/**
	 * 新增盘点属性设置
	 * @param prototypeSettingDto
	 */
	public void savePrototypeSetting(PrototypeSettingDto prototypeSettingDto, String token) throws ServiceException {
		// 是否登录
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		// 登录信息是否为空
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		// 数据是否为空
		if(UtilHelper.isEmpty(prototypeSettingDto)){
			throw new ServiceException(ExceptionDef.ERROR_PROTOTYPESETTING_PARAM_NULL.getName());
		}
		
		PrototypeSetting prototypeSetting = new PrototypeSetting();
		
		prototypeSetting.setCompanyId(prototypeSettingDto.getCompanyId());
		prototypeSetting.setEffectiveMonth(formatDate(prototypeSettingDto));
		prototypeSetting.setIsInactive(prototypeSettingDto.getIsInactive());
		prototypeSetting.setRemark(prototypeSettingDto.getRemark());
		prototypeSetting.setVersion(prototypeSettingDto.getVersion());
		prototypeSetting.setCreateBy(userContext.getUserCode());
		prototypeSetting.setCreateDate(systemDateService.getCurrentDate());
		
		prototypeSettingMapper.save(prototypeSetting);
		
		if (prototypeSettingDto.getModelIds() != null && !prototypeSettingDto.getModelIds().isEmpty()) {
			for (Long modelId : prototypeSettingDto.getModelIds()) {
				PrototypeSettingModel prototypeSettingModel = new PrototypeSettingModel();
				
				prototypeSettingModel.setSettingId(prototypeSetting.getId());
				prototypeSettingModel.setCreateBy(userContext.getUserCode());
				prototypeSettingModel.setCreateTime(systemDateService.getCurrentDate());
				prototypeSettingModel.setModelId(modelId);
				
				prototypeSettingModelMapper.save(prototypeSettingModel);
			}
		}
		
		if (prototypeSettingDto.getRegionIds() != null && !prototypeSettingDto.getRegionIds().isEmpty()) {
			for (Long regionId : prototypeSettingDto.getRegionIds()) {
				PrototypeSettingRegion prototypeSettingRegion = new PrototypeSettingRegion();
				
				prototypeSettingRegion.setSettingId(prototypeSetting.getId());
				prototypeSettingRegion.setCreateBy(userContext.getUserCode());
				prototypeSettingRegion.setCreateTime(systemDateService.getCurrentDate());
				prototypeSettingRegion.setRegionId(regionId);;
				
				prototypeSettingRegionMapper.save(prototypeSettingRegion);
			}
		}
		
		String countDatesStr = prototypeSettingDto.getCountDates();
		String[] countDatesStrs = countDatesStr.split(",");
		
		if (countDatesStrs != null && countDatesStrs.length > 0) {
			for (String countDate : countDatesStrs) {
				PrototypeSettingTime prototypeSettingTime = new PrototypeSettingTime();
				
				prototypeSettingTime.setSettingId(prototypeSetting.getId());
				prototypeSettingTime.setCreateBy(userContext.getUserCode());
				prototypeSettingTime.setCreateTime(systemDateService.getCurrentDate());
				prototypeSettingTime.setCountDate(countDate);
				
				prototypeSettingTimeMapper.save(prototypeSettingTime);
			}
		}
	}
	
	/**
	 * 通过主键查询PrototypeSettingDto
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public PrototypeSettingDto getByPK(java.lang.Long primaryKey, String token) throws ServiceException {
		
		// 是否登录
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		// 登录信息是否为空
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		PrototypeSettingDto prototypeSettingDto = new PrototypeSettingDto();
		
		PrototypeSetting prototypeSetting = prototypeSettingMapper.getByPK(primaryKey);
		
		if (prototypeSetting != null) {
			prototypeSettingDto.setCompanyId(prototypeSetting.getCompanyId());
			prototypeSettingDto.setIsInactive(prototypeSetting.getIsInactive());
			prototypeSettingDto.setRemark(prototypeSetting.getRemark());
			prototypeSettingDto.setId(prototypeSetting.getId());
		}
		
		PrototypeSettingModel prototypeSettingModel =  new PrototypeSettingModel();
		List<PrototypeSettingModel> prototypeSettingModels = new ArrayList<PrototypeSettingModel>();
		prototypeSettingModel.setSettingId(prototypeSetting.getId());
		prototypeSettingModels = prototypeSettingModelMapper.listByProperty(prototypeSettingModel);
		
		if (!prototypeSettingModels.isEmpty()) {
			List<Long> modelIds = new ArrayList<Long>();
			for (PrototypeSettingModel prototypeSettingModelTemp : prototypeSettingModels) {
				modelIds.add(prototypeSettingModelTemp.getModelId());
			}
			
			prototypeSettingDto.setModelIds(modelIds);
		}
		
		PrototypeSettingRegion prototypeSettingRegion =  new PrototypeSettingRegion();
		List<PrototypeSettingRegion> prototypeSettingRegions = new ArrayList<PrototypeSettingRegion>();
		prototypeSettingRegion.setSettingId(prototypeSetting.getId());
		prototypeSettingRegions = prototypeSettingRegionMapper.listByProperty(prototypeSettingRegion);
		
		if (!prototypeSettingRegions.isEmpty()) {
			List<Long> regionIds = new ArrayList<Long>();
			for (PrototypeSettingRegion prototypeSettingRegionTemp : prototypeSettingRegions) {
				regionIds.add(prototypeSettingRegionTemp.getRegionId());
			}
			
			prototypeSettingDto.setRegionIds(regionIds);
		}
		
		PrototypeSettingTime prototypeSettingTime =  new PrototypeSettingTime();
		List<PrototypeSettingTime> prototypeSettingTimes = new ArrayList<PrototypeSettingTime>();
		prototypeSettingTime.setSettingId(prototypeSetting.getId());
		prototypeSettingTimes = prototypeSettingTimeMapper.listByProperty(prototypeSettingTime);
		
		if (!prototypeSettingTimes.isEmpty()) {
			String countDates = "";
			for (PrototypeSettingTime prototypeSettingTimeTemp : prototypeSettingTimes) {
				countDates += prototypeSettingTimeTemp.getCountDate() + ",";
			}
			
			countDates = countDates.substring(0, countDates.length() - 1);
			
			prototypeSettingDto.setCountDates(countDates);
		}
		
		return prototypeSettingDto;
	}
	
	/**
	 * 更新记录
	 * @param prototypeSettingDto
	 * @return
	 * @throws ServiceException
	 */
	public void update(PrototypeSettingDto prototypeSettingDto, String token) throws ServiceException {
		// 是否登录
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		// 登录信息是否为空
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		PrototypeSetting prototypeSettingTemp = prototypeSettingMapper.getByPK(prototypeSettingDto.getId());
		PrototypeSetting prototypeSetting = new PrototypeSetting();
		
		// 当月已生效的盘点日期，不能修改，只能改下个月或以后的
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		
		String countDatesStr = prototypeSettingDto.getCountDates();
		String[] countDatesStrs = countDatesStr.split(",");
		
		Date date = new Date();
		if (countDatesStrs != null && countDatesStrs.length > 0) {
			for (String countDate : countDatesStrs) {
				try {
					date = sdf.parse(countDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// 当前日期上一个月
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
		
        // 启用状态且当前日期上一个月时间小于计划日期，说明当前日期与计划日期同月或之前，则不能修改，抛出异常
		if (countDatesStrs != null && countDatesStrs.length > 0 && 
				"1".equals(prototypeSettingTemp.getIsInactive()) && calendar.getTime().getTime() < date.getTime()) {
			throw new ServiceException(ExceptionDef.ERROR_PROTOTYPESETTING_DATE_INVALID.getName());
		}
		
		prototypeSetting.setId(prototypeSettingDto.getId());
		prototypeSetting.setCompanyId(prototypeSettingDto.getCompanyId());
		prototypeSetting.setIsInactive(prototypeSettingDto.getIsInactive());
		prototypeSetting.setRemark(prototypeSettingDto.getRemark());
		prototypeSetting.setUpdateBy(userContext.getUserCode());
		prototypeSetting.setUpdateDate(systemDateService.getCurrentDate());
		prototypeSetting.setCreateBy(prototypeSettingTemp.getCreateBy());
		prototypeSetting.setCreateDate(prototypeSettingTemp.getCreateDate());
		prototypeSetting.setEffectiveMonth(formatDate(prototypeSettingDto));
		prototypeSetting.setVersion(prototypeSettingTemp.getVersion());
		
		prototypeSettingMapper.update(prototypeSetting);
		
		// 从表，先删除，后新增
		
		if (prototypeSettingDto.getModelIds() != null && !prototypeSettingDto.getModelIds().isEmpty()) {
			PrototypeSettingModel prototypeSettingModelTemp = new PrototypeSettingModel();
			prototypeSettingModelTemp.setSettingId(prototypeSettingDto.getId());
			
			prototypeSettingModelMapper.deleteByProperty(prototypeSettingModelTemp);
			
			for (Long modelId : prototypeSettingDto.getModelIds()) {
				PrototypeSettingModel prototypeSettingModel = new PrototypeSettingModel();
				
				prototypeSettingModel.setSettingId(prototypeSetting.getId());
				prototypeSettingModel.setCreateBy(userContext.getUserCode());
				prototypeSettingModel.setCreateTime(systemDateService.getCurrentDate());
				prototypeSettingModel.setModelId(modelId);
				
				prototypeSettingModelMapper.save(prototypeSettingModel);
			}
		}
		
		if (prototypeSettingDto.getRegionIds() != null && !prototypeSettingDto.getRegionIds().isEmpty()) {
			PrototypeSettingRegion prototypeSettingRegionTemp = new PrototypeSettingRegion();
			prototypeSettingRegionTemp.setSettingId(prototypeSettingDto.getId());
			
			prototypeSettingRegionMapper.deleteByProperty(prototypeSettingRegionTemp);
			
			for (Long regionId : prototypeSettingDto.getRegionIds()) {
				PrototypeSettingRegion prototypeSettingRegion = new PrototypeSettingRegion();
				
				prototypeSettingRegion.setSettingId(prototypeSetting.getId());
				prototypeSettingRegion.setCreateBy(userContext.getUserCode());
				prototypeSettingRegion.setCreateTime(systemDateService.getCurrentDate());
				prototypeSettingRegion.setRegionId(regionId);;
				
				prototypeSettingRegionMapper.save(prototypeSettingRegion);
			}
		}
		
		
		if (countDatesStrs != null && countDatesStrs.length > 0) {
			PrototypeSettingTime prototypeSettingTimeTemp = new PrototypeSettingTime();
			prototypeSettingTimeTemp.setSettingId(prototypeSettingDto.getId());
			
			prototypeSettingTimeMapper.deleteByProperty(prototypeSettingTimeTemp);
			
			for (String countDate : countDatesStrs) {
				PrototypeSettingTime prototypeSettingTime = new PrototypeSettingTime();
				
				prototypeSettingTime.setSettingId(prototypeSetting.getId());
				prototypeSettingTime.setCreateBy(userContext.getUserCode());
				prototypeSettingTime.setCreateTime(systemDateService.getCurrentDate());
				prototypeSettingTime.setCountDate(countDate);
				
				prototypeSettingTimeMapper.save(prototypeSettingTime);
			}
		}
	}
	
	/**
	 * 前端日期格式转换
	 * @param prototypeSettingDto
	 * @return
	 */
	private String formatDate(PrototypeSettingDto prototypeSettingDto) {
		String countDatesStr = prototypeSettingDto.getCountDates();
		String[] countDatesStrs = countDatesStr.split(",");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		SimpleDateFormat sdfTemp = new SimpleDateFormat("yyyy-MM"); // 设置时间格式
		String effectiveMonth = "";		// 存放前端转化的日期
		
		if (countDatesStrs != null && countDatesStrs.length > 0) {
			for (String countDate : countDatesStrs) {
				// 获取盘点月份
				try {
					Date date = sdf.parse(countDate);
					effectiveMonth = sdfTemp.format(date);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return effectiveMonth;
	}
}
