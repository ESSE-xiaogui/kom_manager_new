package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.OrgBiz;
import com.transsion.store.facade.OrgBizFacade;
import com.transsion.store.service.OrgBizService;
@Component("orgBizFacade")
public class OrgBizFacadeImpl implements OrgBizFacade{
	
	@Autowired
	private OrgBizService orgBizService;
	/**
	 * 查询所有业务属性
	 * */
	public List<OrgBiz> findAll() throws ServiceException{
		return orgBizService.findAll();
	}
}
