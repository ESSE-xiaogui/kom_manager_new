package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Tac;

public interface TacFacade {
	/**
     * 根据IMEI查询品牌机型
     * @param imei
     * @return
     * @throws ServiceException
     */
    public List<Tac> queryAllTacInfo()throws ServiceException;
}
