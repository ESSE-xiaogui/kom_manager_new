package com.transsion.store.facace.impl;

import com.rest.service.security.simple.SimpleAnonResource;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.service.AnonResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Liuzh on 2016/5/25.
 */

@Component("defaultAnonResource")
public class DefaultAnonResource implements SimpleAnonResource {

    @Autowired
    private AnonResourceService anonResourceService;

    @Override
    public List<String> listResources() throws ServiceException {
        return anonResourceService.getResources();
    }
}
