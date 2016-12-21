package com.transsion.store.facade;

import java.util.List;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.OrgBiz;

public interface OrgBizFacade {
	

	/**
	 * 查询所有区域类型
	 * */
	public List<OrgBiz> findAll() throws ServiceException;
}
