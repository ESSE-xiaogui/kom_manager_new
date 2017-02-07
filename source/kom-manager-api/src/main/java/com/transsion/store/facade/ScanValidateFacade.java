package com.transsion.store.facade;

import java.util.LinkedHashMap;
import java.util.List;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.ScanValidateDto;


public interface ScanValidateFacade {

	/**
	 * 扫描验证
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public ScanValidateDto queryScanValidate(java.lang.String imei, java.lang.String qrcode) throws ServiceException;

	/**
	 * 批量扫描验证
	 * 
	 * @param imeis
	 * @return
	 * @throws ServiceException
	 */
	public List<LinkedHashMap> queryScanValidateBatch(String imeis) throws ServiceException;

}
