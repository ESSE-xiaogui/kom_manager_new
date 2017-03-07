package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Duty;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.DutyResponseDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.DutyMapper;
import com.transsion.store.service.DutyService;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("dutyManager")
public class DutyManager {
	@Autowired
	private DutyService dutyService;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private DutyMapper dutyMapper;
	
	/**
	 * 查询职位
	 * @return
	 * @throws ServiceException
	 */
	public List<DutyResponseDto> findDutyName() throws ServiceException{
		return dutyService.getDutyName();
	}
	
	/**
	 * 保存职位
	 * */
	public void save(Duty duty, String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(duty)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Duty existDuty = new Duty();
		if (UtilHelper.isEmpty(duty.getCompanyId())) {
			existDuty.setCompanyId(userContext.getCompanyId().intValue());
		} else {
			existDuty.setCompanyId(duty.getCompanyId());
		}
		existDuty.setDutyName(duty.getDutyName());
		int count = dutyMapper.findByCount(existDuty);
		if (count > 0) {
			throw new ServiceException(ExceptionDef.ERROR_DUTY_IS_EXIST.getName());
		}
		if (!UtilHelper.isEmpty(userContext.getUserCode())) {
			duty.setCreatedBy(userContext.getUserCode());
		}
		duty.setCreatedTime(systemDateService.getCurrentDate());
		dutyMapper.save(duty);
	}
	
	/**
	 * 更新职位
	 * */
	public int update(Duty duty,String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(duty)) {
					throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if(!UtilHelper.isEmpty(userContext.getUserCode())){
			duty.setCreatedBy(userContext.getUserCode());
		}
		duty.setCreatedTime(systemDateService.getCurrentDate());
		if(!UtilHelper.isEmpty(userContext.getUserCode())){
			duty.setUpdatedBy(userContext.getUserCode());
		}
		duty.setUpdatedTime(systemDateService.getCurrentDate());
		return dutyMapper.update(duty);
	}
	
}
