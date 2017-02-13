package com.transsion.store.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.ShopBiz;
import com.transsion.store.context.UserContext;
import com.transsion.store.mapper.ShopBizMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("/shopBizManager")
public class ShopBizManager {
	
	@Autowired
	private ShopBizMapper shopBizMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	/**
	 * 保存记录
	 * @param shopBiz
	 * @return
	 * @throws ServiceException
	 */
	public void save(ShopBiz shopBiz,String token) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(shopBiz)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext.getCompanyId()) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		shopBiz.setCompanyId(userContext.getCompanyId());
		shopBiz.setCreateBy(userContext.getUserCode());
		shopBiz.setCreateDate(systemDateService.getCurrentDate());
		shopBizMapper.save(shopBiz);
	}
	/**
	 * 更新记录
	 * @param shopBiz
	 * @return
	 * @throws ServiceException
	 */
	public int update(ShopBiz shopBiz,String token) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(shopBiz)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext.getCompanyId()) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		shopBiz.setCompanyId(userContext.getCompanyId());
		shopBiz.setCreateBy(userContext.getUserCode());
		shopBiz.setCreateDate(systemDateService.getCurrentDate());
		shopBiz.setUpdateBy(userContext.getUserCode());
		shopBiz.setUpdateDate(systemDateService.getCurrentDate());
		return shopBizMapper.update(shopBiz);
	}
}
