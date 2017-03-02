package com.transsion.store.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Prototype;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.PrototypeDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.PrototypeMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("/prototypeManager")
public class PrototypeManager {
	
	@Autowired
	private SystemDateService systemDateService;
	@Autowired
	private PrototypeMapper	prototypeMapper;
	
	public void savePrototype(PrototypeDto prototypeDto,String token) throws ServiceException {
		
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
		if(UtilHelper.isEmpty(prototypeDto)){
			throw new ServiceException(ExceptionDef.ERROR_PROTOTYPE_PARAM_NULL.getName());
		}
		
		// 校验IMEI是否唯一
		
		
		Prototype prototype = new Prototype();
		
		prototype.setBrandId(prototypeDto.getBrandId());
		prototype.setBrandCode(userContext.getBrandCode());
		prototype.setCompanyId(userContext.getCompanyId());
		prototype.setImeiList(prototypeDto.getImeiList());
		prototype.setImeiNo(prototypeDto.getImeiNo());
		prototype.setImgImeiUrl(prototypeDto.getImgImeiUrl());
		prototype.setImgPrototypeUrl(prototypeDto.getImgPrototypeUrl());
		prototype.setImgShopUrl(prototypeDto.getImgShopUrl());
		prototype.setModelId(prototypeDto.getModelId());
		prototype.setModelCode(prototypeDto.getModelCode());
		prototype.setRemark(prototypeDto.getRemark());
		prototype.setShopId(userContext.getShop().getId());
		prototype.setStatus(prototypeDto.getStatus());
		prototype.setPublishTime(userContext.getUserCode());
		prototype.setPublishTime(systemDateService.getCurrentDate());
		prototype.setCreateBy(userContext.getUserCode());
		prototype.setCreateTime(systemDateService.getCurrentDate());
		
		
		prototypeMapper.save(prototype);
		
	}

}

