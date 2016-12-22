package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.context.UserContext;
import com.transsion.store.mapper.SystemResourceMapper;
import com.transsion.store.utils.CacheUtils;

/**
 */
public class AnonResourceService {
	@Autowired
    private SystemResourceMapper systemResourceMapper;
	 
    private List<String> anonList;

    public void setAnonList(List<String> anonList) {
        this.anonList = anonList;
    }

    public List<String> getResources() throws ServiceException {
        return systemResourceMapper.getAnonResources();
    }
}
