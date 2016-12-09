package com.transsion.store.service;

import com.rest.service.utils.JsonMapper;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.common.Base64Util;
import com.transsion.store.common.Constants;
import com.transsion.store.common.HTTPUtil;
import com.transsion.store.common.MD5Util;
import com.transsion.store.dto.ScanValidateDto;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by pradmin on 2016/5/30.
 */
@Service("scanValidateService")
public class ScanValidateService {

    /**
     * 验证单个IMEI
     * @param imei
     * @return
     */
    public ScanValidateDto scanIMEI(String imei) {
        String md5 = MD5Util.MD5(imei);
        String result = HTTPUtil.sendPostRequest(Constants.IMEIAPI, "imei=" + imei + "&check=" + md5);
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
    public List<LinkedHashMap> scanIMEIs(String imeis){
        String IMEI_NO=imeis.substring(0,15);
        String md5 = MD5Util.MD5("md5");
        String result = HTTPUtil.sendPostRequest(Constants.BATCHIMEIAPI, "strs=" + imeis + "&check=" + md5);
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

        String result = HTTPUtil.sendPostRequest(Constants.QRCODEAPI,"base64="+ Base64Util.encode(qrCode));
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
