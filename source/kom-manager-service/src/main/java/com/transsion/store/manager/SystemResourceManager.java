package com.transsion.store.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shangkang.tools.UtilHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.SystemResource;
import com.transsion.store.context.UserContext;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.SystemResourceMapper;
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
			throw new ServiceException(ExceptionDef.ERROR_SYSTEM_RESOURCE_ALREADY_EXIST.getName());
		}else{
			UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
			systemResource.setCreatedBy(userContext.getUser().getUserCode());
			systemResource.setCreateTime(systemDateService.getCurrentDate());
			systemResource.setUpdatedBy(userContext.getUserCode());
			systemResource.setUpdateTime(systemDateService.getCurrentDate());
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

	/**
	* 修改资源
	* @return
	* @throws ServiceException
	*/
	public int update(String token,SystemResource systemResource) throws ServiceException{
		SystemResource tempRes = new SystemResource();
		tempRes.setResCode(systemResource.getResCode());
		int count1 = systemResourceMapper.findByCount(tempRes);
		tempRes.setResId(systemResource.getResId());
		int count2 = systemResourceMapper.findByCount(tempRes);
		if(count1>0 && count2<1){
			throw new ServiceException(ExceptionDef.ERROR_SYSTEM_RESOURCE_ALREADY_EXIST.getName());			
		}
		
		SystemResource formerRes = systemResourceMapper.getByPK(systemResource.getResId());
		formerRes.setResType(systemResource.getResType());
		formerRes.setResCode(systemResource.getResCode());
		formerRes.setResName(systemResource.getResName());
		formerRes.setResUrl(systemResource.getResUrl());
		formerRes.setRemark(systemResource.getRemark());
		formerRes.setIsAnonAccess(systemResource.getIsAnonAccess());
		formerRes.setShowIndex(systemResource.getShowIndex());
		formerRes.setVersion(systemResource.getVersion());
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		formerRes.setUpdatedBy(userContext.getUser().getUserCode());
		formerRes.setUpdateTime(systemDateService.getCurrentDate());
		return systemResourceMapper.update(formerRes);
	}

	/**
	 * 根据资源类型及用户token获取用户拥有的资源列表
	 * @param type
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public List<String> getResourcesByUser(String type, String token) throws ServiceException {
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);

		if(UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}

		return systemResourceMapper.getResourcesByUser(type, userContext.getUser().getId());
	}

}
