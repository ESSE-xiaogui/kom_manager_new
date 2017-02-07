package com.transsion.store.facade.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.ScanValidateDto;
import com.transsion.store.facade.ScanValidateFacade;
import com.transsion.store.manager.ScanValidateManager;
import com.transsion.store.service.ScanValidateService;

@Component("scanValidateFacade")
public class ScanValidateFacadeImpl implements ScanValidateFacade {

	private ScanValidateService scanValidateService;
	@Autowired
	private ScanValidateManager scanValidateManager;
	
	@Autowired
	public void setScanValidateService(ScanValidateService scanValidateService) {
		this.scanValidateService = scanValidateService;
	}
	
	public ScanValidateDto queryScanValidate(String imei, String qrcode) throws ServiceException {
		return scanValidateManager.scanValidate(imei, qrcode);
	}

	public List<LinkedHashMap> queryScanValidateBatch(String imeis) throws ServiceException {
		return scanValidateManager.scanValidateBatch(imeis);
	}

}
