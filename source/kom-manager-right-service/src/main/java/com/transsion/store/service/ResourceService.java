package com.transsion.store.service;

import java.util.List;

import com.transsion.store.bo.SystemResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.context.UserContext;
import com.transsion.store.mapper.SystemResourceMapper;
import com.transsion.store.utils.CacheUtils;

/**
 * Created by liuzh on 16-6-1.
 */
@Service("resourceService")
public class ResourceService {
	
	@Autowired
	private SystemResourceMapper systemResourceMapper;
	 
    public List<String> getResources(String token) throws ServiceException {
    	UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
    	Long id = userContext.getUser().getId();
        return systemResourceMapper.getResourcesByUser(SystemResource.RESOURCE_TYPE_BACKEND, id);
    }
}
