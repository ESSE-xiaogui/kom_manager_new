package com.transsion.store.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.SystemResourceMapper;

/**
 */
public class AnonResourceService {
	@Autowired
    private SystemResourceMapper systemResourceMapper;

    public List<String> getResources() throws ServiceException {
        return systemResourceMapper.getAnonResources();
    }
}
