package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.SystemMenu;
import com.transsion.store.bo.SystemResource;
import com.transsion.store.context.UserContext;
import com.transsion.store.mapper.SystemResourceMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;


@Service("systemResourceManager")
public class SystemResourceManager {
	@Autowired
	private SystemResourceMapper systemResourceMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	/**
	 * 获取所有资源
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemResource> getAllResource() throws ServiceException{
		return systemResourceMapper.getAllResource();
	}

	/**
	 * 添加资源
	 * @return
	 * @throws ServiceException
	 */
	public void save(String token,SystemResource systemResource) throws ServiceException{
		SystemResource tempRes = new SystemResource();
		tempRes.setResCode(systemResource.getResCode());
		int count = systemResourceMapper.findByCount(tempRes);
		if(count>0){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_RESCODE_IS_DUPLICATE);
		}else{
			UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
			systemResource.setCreatedBy(userContext.getUser().getUserCode());
			systemResource.setCreateTime(systemDateService.getCurrentDate());
			systemResourceMapper.save(systemResource);
		}
	}

	/**
	* 根据roleId查询资源
	* @return
	* @throws ServiceException
	*/
	public List<SystemResource> findResByRoleId(Long roleId) throws ServiceException{
		return systemResourceMapper.findResByRoleId(roleId);
	}
}
