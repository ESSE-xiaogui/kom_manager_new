package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.OrgBiz;
import com.transsion.store.mapper.OrgBizMapper;

@Service("orgBizService")
public class OrgBizService {
	
	@Autowired
	private OrgBizMapper orgBizMapper;
	
	public List<OrgBiz> findAll() throws ServiceException{
		return orgBizMapper.findAll();
	}
}
