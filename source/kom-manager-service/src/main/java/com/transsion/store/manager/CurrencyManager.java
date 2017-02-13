package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

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
import com.transsion.store.utils.ExcelUtils;

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
	public void updateCurrency(Currency currency,String token) throws ServiceException{
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
	
	/**
	 * 汇率导出Excel
	 * @param currencyDto
	 * @return
	 * @throws ServiceException
	 */
	public byte[] getCurrencyByExcel(CurrencyDto currencyDto) throws ServiceException {
		String[] headers = { "序号", "国家", "币别编码", "币别名称", "美元对外币汇率", "人民币对外币汇率", "生效日期", "失效日期", "是否停用" };
		List<CurrencyDto> list = currencyMapper.listCurrencyByProperty(currencyDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i = 1;
		for (CurrencyDto currencyDto1 : list) {
			dataset.add(new Object[] { i++, currencyDto1.getCountryName(),currencyDto1.getWerks(),currencyDto1.getCurrencyName(),
							currencyDto1.getExchangerate(),currencyDto1.getExchangerate2(),currencyDto1.getBeginTime(),
							currencyDto1.getEndTime(),currencyDto1.getIsInactive()});
		}
		String title = "汇率报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}

}
