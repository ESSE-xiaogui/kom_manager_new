package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Tac;
import com.transsion.store.dto.TacDto;

public interface TacFacade {
	/**
     * 根据IMEI查询品牌机型
     * @param imei
     * @return
     * @throws ServiceException
     */
    public List<Tac> queryAllTacInfo()throws ServiceException;

	public Tac queryTacInfoByImei(String imei) throws ServiceException;
}
