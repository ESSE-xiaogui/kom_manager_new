package com.transsion.store.manager;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.dto.ScanValidateDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.service.ScanValidateService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by pradmin on 2016/5/27.
 */
@Service("scanValidateManager")
public class ScanValidateManager {
	Logger logger = LoggerFactory.getLogger(ScanValidateManager.class);

    @Autowired
    private ScanValidateService scanValidateService;
    /**
     * 扫描IMEI或二维码，返回实体对象
     * @param imeiNo
     * @param qrCode
     * @return
     * @throws ServiceException
     */
    public ScanValidateDto scanValidate(String imeiNo, String qrCode) throws ServiceException
    {
    	logger.debug(Thread.currentThread().getName()+"**********************调用验证iemi接口start："+imeiNo);
        ScanValidateDto scanValidateDto = new ScanValidateDto();
        if(!UtilHelper.isEmpty(imeiNo)) {
        	logger.debug(Thread.currentThread().getName()+"**********************调用单个验证iemi接口start："+imeiNo);
            scanValidateDto=scanValidateService.scanIMEI(imeiNo);
            logger.debug(Thread.currentThread().getName()+"**********************调用单个验证iemi接口end："+imeiNo);
        }else if(!UtilHelper.isEmpty(qrCode)) {
            scanValidateDto=scanValidateService.scanIMEI(qrCode);
        }else{
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
        }
        logger.debug(Thread.currentThread().getName()+"**********************调用验证iemi接口end："+scanValidateDto);
        return scanValidateDto;
    }

    public List<LinkedHashMap> scanValidateBatch(String imeis) throws ServiceException
    {
        if(!UtilHelper.isEmpty(imeis)) {
            return   scanValidateService.scanIMEIs(imeis);
        }else{
            throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
        }
    }
}
