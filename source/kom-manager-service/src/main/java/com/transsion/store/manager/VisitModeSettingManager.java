package com.transsion.store.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.VisitModelSetting;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitModelSettingInfoDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.VisitModelSettingMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.service.VisitModelSettingService;
import com.transsion.store.utils.CacheUtils;

@Service("/visitModeSettingManager")
public class VisitModeSettingManager {
	
	@Autowired
	private VisitModelSettingService visitModelSettingService;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private VisitModelSettingMapper visitModelSettingMapper;
	
	public void save(VisitModelSetting visitModelSetting, String token) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(visitModelSetting)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		visitModelSetting.setCreateBy(userContext.getUser().getUserCode());
		visitModelSetting.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		visitModelSettingService.save(visitModelSetting);
	}
	/**
	 * @author guihua.zhang on 2017-02-24
	 * 重点机型修改
	 * */
	public int update(VisitModelSetting visitModelSetting, String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(visitModelSetting)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		visitModelSetting.setUpdateBy(userContext.getUser().getUserCode());
		visitModelSetting.setUpdateTime(systemDateService.getCurrentDate());
		return visitModelSettingService.update(visitModelSetting);
	}
	
	/**
	 * @author guihua.zhang on 2017-03-02
	 * 重点机型分页查询
	 * */
	public Pagination<VisitModelSettingInfoDto> listPaginationByProperty(String token,Pagination<VisitModelSettingInfoDto> pagination, VisitModelSettingInfoDto visitModelSettingInfoDto)
			throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		VisitModelSettingInfoDto vms = new VisitModelSettingInfoDto();
		if(!userContext.isAdmin()){
			vms.setCompanyId(userContext.getCompanyId());
		}else{
			BeanUtils.copyProperties(vms, visitModelSettingInfoDto);
		}
		List<VisitModelSettingInfoDto> list = visitModelSettingMapper.listPaginationByProperty(pagination, vms, pagination.getOrderBy());
		pagination.setResultList(list);
		
		return pagination;
	}
}
