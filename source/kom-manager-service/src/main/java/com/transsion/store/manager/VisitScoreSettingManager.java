package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.VisitScoreSetting;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.VisitScoreSettingDetailDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.VisitScoreSettingMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;


@Service("visitScoreSettingManager")
public class VisitScoreSettingManager {
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private VisitScoreSettingMapper visitScoreSettingMapper;
	
	
	/**
	 * @author guihua.zhang on 2017-02-23
	 * 新增打分项设置
	 * @throws ServiceException
	 * */
	public void save(VisitScoreSetting visitScoreSetting,String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(visitScoreSetting)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		visitScoreSetting.setCreateBy(userContext.getUserCode());
		visitScoreSetting.setCreateTime(systemDateService.getCurrentDate());
		visitScoreSetting.setVersion(0);
		visitScoreSettingMapper.save(visitScoreSetting);
	} 
	
	/**
	 * @author guihua.zhang on 2017-02-23
	 * 更新打分项设置
	 * @throws ServiceException
	 * */
	public int update(VisitScoreSetting visitScoreSetting,String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(visitScoreSetting)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		visitScoreSetting.setUpdateBy(userContext.getUserCode());
		visitScoreSetting.setUpdateTime(systemDateService.getCurrentDate());
		visitScoreSetting.setVersion(0);
		return visitScoreSettingMapper.update(visitScoreSetting);
	}
	
	/**
	 * @author guihua.zhang on 2017-02-23
	 * 分页查询打分项设置
	 * @return
	 * @throws ServiceException
	 * */
	public Pagination<VisitScoreSettingDetailDto> listPaginationByProperty(
					Pagination<VisitScoreSettingDetailDto> pagination, VisitScoreSettingDetailDto visitScoreSettingDetailDto,String token)
					throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		VisitScoreSettingDetailDto vss = new VisitScoreSettingDetailDto();
		if(!UtilHelper.isEmpty(visitScoreSettingDetailDto)){
			BeanUtils.copyProperties(vss, visitScoreSettingDetailDto);
		}
		if(!userContext.isAdmin()){
			vss.setCompanyId(userContext.getCompanyId());
		}
		List<VisitScoreSettingDetailDto> list = visitScoreSettingMapper.listPaginationByProperty(pagination, vss, pagination.getOrderBy());
		pagination.setResultList(list);
		return pagination;
	}

}
