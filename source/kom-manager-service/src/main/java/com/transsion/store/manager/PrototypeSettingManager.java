package com.transsion.store.manager;

import java.util.ArrayList;
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
	public Pagination<PrototypeSettingDto> listPaginationByPropertySettingDto(Pagination<PrototypeSettingDto> pagination, PrototypeSettingDto prototypeSettingDto)
			throws ServiceException {
		return prototypeSettingService.listPaginationByPropertySettingDto(pagination, prototypeSettingDto);
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
		prototypeSetting.setEffectiveMonth(prototypeSettingDto.getEffectiveMonth());
		prototypeSetting.setIsInactive(prototypeSettingDto.getIsInactive());
		prototypeSetting.setRemark(prototypeSettingDto.getRemark());
		prototypeSetting.setVersion(prototypeSettingDto.getVersion());
		prototypeSetting.setCreateBy(userContext.getUserCode());
		prototypeSetting.setCreateDate(systemDateService.getCurrentDate());
		
		prototypeSettingMapper.save(prototypeSetting);
		
		List<PrototypeSettingRegion> prototypeSettingRegions = new ArrayList<PrototypeSettingRegion>();
		List<PrototypeSettingModel> prototypeSettingModels = new ArrayList<PrototypeSettingModel>();
		List<PrototypeSettingTime> prototypeSettingTimes = new ArrayList<PrototypeSettingTime>();
		
		prototypeSettingRegions = prototypeSettingDto.getPrototypeSettingRegions();
		prototypeSettingModels = prototypeSettingDto.getPrototypeSettingModels();
		prototypeSettingTimes = prototypeSettingDto.getPrototypeSettingTimes();
		
		for (PrototypeSettingRegion prototypeSettingRegion : prototypeSettingRegions) {
			prototypeSettingRegion.setSettingId(prototypeSetting.getId());
			prototypeSettingRegion.setCreateBy(userContext.getUserCode());
			prototypeSettingRegion.setCreateTime(systemDateService.getCurrentDate());
			
			prototypeSettingRegionMapper.save(prototypeSettingRegion);
		}
		
		for (PrototypeSettingModel prototypeSettingModel : prototypeSettingModels) {
			prototypeSettingModel.setSettingId(prototypeSetting.getId());
			prototypeSettingModel.setCreateBy(userContext.getUserCode());
			prototypeSettingModel.setCreateTime(systemDateService.getCurrentDate());
			
			prototypeSettingModelMapper.save(prototypeSettingModel);
		}
		
		for (PrototypeSettingTime prototypeSettingTime : prototypeSettingTimes) {
			prototypeSettingTime.setSettingId(prototypeSetting.getId());
			prototypeSettingTime.setCreateBy(userContext.getUserCode());
			prototypeSettingTime.setCreateTime(systemDateService.getCurrentDate());
			
			prototypeSettingTimeMapper.save(prototypeSettingTime);
		}
	}
}
