package com.transsion.store.manager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Currency;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.CurrencyDto;
import com.transsion.store.mapper.CurrencyMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("/currencyManager")
public class CurrencyManager {
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private CurrencyMapper currencyMapper;
	
	/**
	 * 保存汇率
	 * */
	public void saveCurrency(Currency currency,String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_ORG_ISINACTIVE);
		}
		if(UtilHelper.isEmpty(currency)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		currency.setCompanyId(userContext.getCompanyId());
		if(!UtilHelper.isEmpty(userContext.getUser())){
			currency.setCreatedBy(userContext.getUser().getId());
		}
		currency.setFindex(1);
		currency.setCreatedTime(systemDateService.getCurrentDate());
		currencyMapper.save(currency);
	}
	
	/**
	 * 更新汇率
	 * */
	public void updateCurrency(CurrencyDto currencyDto,String token) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_ORG_ISINACTIVE);
		}
		if(UtilHelper.isEmpty(currencyDto)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getCompanyId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Currency currency = new Currency();
		BeanUtils.copyProperties(currencyDto, currency);
		currency.setCompanyId(userContext.getCompanyId());
		if(!UtilHelper.isEmpty(userContext.getUser())){
			if(!UtilHelper.isEmpty(userContext.getUser().getUserId())){
				currency.setCreatedBy(new Long(userContext.getUser().getUserId()));
			}
		}
		currency.setCreatedTime(systemDateService.getCurrentDate());
		if(!UtilHelper.isEmpty(userContext.getUser())){
			if(!UtilHelper.isEmpty(userContext.getUser().getUserId())){
				currency.setUpdatedBy(new Long(userContext.getUser().getUserId()));
			}
		}
		currency.setUpdatedTime(systemDateService.getCurrentDate());
		currencyMapper.update(currency);
	}

}
