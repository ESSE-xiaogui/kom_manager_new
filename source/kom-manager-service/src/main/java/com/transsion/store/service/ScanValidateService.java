package com.transsion.store.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.service.utils.JsonMapper;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.common.Base64Util;
import com.transsion.store.common.HTTPUtil;
import com.transsion.store.common.MD5Util;
import com.transsion.store.dto.ScanValidateDto;

/**
 * Created by pradmin on 2016/5/30.
 */
@Service("scanValidateService")
public class ScanValidateService {
	
	public static final String SALE_IMEI_URL = "sale.imei.url";
	
	public static final String SALE_IMEIS_URL = "sale.imeis.url";
	
	public static final String RQ_CODE_URL = "rq.code.url";

	@Autowired
	private ConfigurationService configurationService;

    /**
     * 验证单个IMEI
     * @param imei
     * @return
     */
    public ScanValidateDto scanIMEI(String imei) {
        String md5 = MD5Util.MD5(imei);
        String saleImeiUrl = null;
        try {
        	saleImeiUrl = configurationService.getValueByName(SALE_IMEI_URL);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
//        String result = HTTPUtil.sendPostRequest(Constants.IMEIAPI, "imei=" + imei + "&check=" + md5);
        String result = HTTPUtil.sendPostRequest(saleImeiUrl, "imei=" + imei + "&check=" + md5);
        if (!result.equals("0`Failed`")) {
            JsonMapper mapper = new JsonMapper();
            ScanValidateDto scanResult =  mapper.fromJson(result,ScanValidateDto.class);
            if(!UtilHelper.isEmpty(scanResult)){//只返回品牌与机型
                ScanValidateDto scan = new ScanValidateDto();
                scan.setBrand(scanResult.getBrand());
                scan.setModel(scanResult.getModel());
                scan.setImei1(imei);
                scan.setImeis(scanResult.getImeis());
                return scan;
            }
            return null;
        }
        return null;
    }

    /**
     * 批量验证多个IMEI
     * @param imeis
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<LinkedHashMap> scanIMEIs(String imeis){
        String md5 = MD5Util.MD5("md5");
        String saleImeisUrl = null;
        try {
        	saleImeisUrl = configurationService.getValueByName(SALE_IMEIS_URL);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
//        String result = HTTPUtil.sendPostRequest(Constants.BATCHIMEIAPI, "strs=" + imeis + "&check=" + md5);
        String result = HTTPUtil.sendPostRequest(saleImeisUrl, "strs=" + imeis + "&check=" + md5);
        if (!result.equals("0`Failed`")) {
            JsonMapper mapper = new JsonMapper();
            List<LinkedHashMap> scanResult =  mapper.fromJson(result,List.class);
            return scanResult;
            }
            return null;
    }
    
    /**
     * 验证单个二维码
     * @param qrCode
     * @return
     */
    public ScanValidateDto scanQRCODE(String qrCode){
    	String rqCodeUrl = null;
	    try {
	    	rqCodeUrl = configurationService.getValueByName(RQ_CODE_URL);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
//        String result = HTTPUtil.sendPostRequest(Constants.QRCODEAPI,"base64="+ Base64Util.encode(qrCode));
        String result = HTTPUtil.sendPostRequest(rqCodeUrl,"base64="+ Base64Util.encode(qrCode));
        if (!result.equals("0`Failed`")) {
            JsonMapper mapper = new JsonMapper();
            ScanValidateDto scanResult =  mapper.fromJson(result,ScanValidateDto.class);
            if(!UtilHelper.isEmpty(scanResult)){//只返回品牌与机型
                ScanValidateDto scan = new ScanValidateDto();
                scan.setBrand(scanResult.getBrand());
                scan.setModel(scanResult.getModel());
                return scan;
          }
            return null;
        }
        return null;
    }
}
