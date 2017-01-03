package com.transsion.store.facace.impl;

import com.rest.service.security.AuthenticationForbiddenException;
import com.rest.service.security.simple.SimpleResource;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.service.ResourceService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.IUserContext;
import com.transsion.store.facade.ResourceFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liuzh on 16-5-25.
 */
@Component("simpleResource")
public class SimpleResourceImpl implements SimpleResource,ResourceFacade {

    @Autowired
    private ResourceService resourceService;

    @Override
    public List<String> listResourcesBySubject(String subject, String token) throws ServiceException {
        IUserContext uc = CacheUtils.getSupporter().get(token);

        if(uc == null) throw new AuthenticationForbiddenException("认证超时！");

        return resourceService.getResources(token);
    }
}
