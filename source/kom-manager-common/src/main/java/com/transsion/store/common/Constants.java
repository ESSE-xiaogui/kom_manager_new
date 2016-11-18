package com.transsion.store.common;

/**
 * Created by pradmin on 2016/5/30.
 */
public class Constants {

    //二维码查询
    public static final String INTRANETQRCODEAPI = "http://172.17.10.10:8081/api/kom";//内网
    public static final String QRCODEAPI = "http://open.af1225.com/api/kom";//正式机
    public static final String TESTQRCODEAPI = "http://172.17.2.148/TecnoOpen/api/kom";//测试机

    //IMEI查询
    public static final String INTRANETIMEIAPI ="http://172.17.10.10:8081/api/komByImei1";//内网
    
//  public static final String IMEIAPI = "http://open.af1225.com/api/komByImei";//正式机
    public static final String IMEIAPI = "http://open.af1225.com/api/komByImei1";//正式机
    
    public static final String BATCHIMEIAPI = "http://open.af1225.com/api/checkBatchImei";//正式机
    public static final String TESIMEIAPI = "http://172.17.2.148:8080/TecnoOpen/api/komByImei";//测试机
    public static final String BATCHIMEIS = "http://52.16.235.130/transsion_imei_validation/imeiValidation";//海外机？
    
    //TAC查询
    public static final String TACAPI = "http://113.98.254.45:8080/FakeMidServer/configTable/newindex";
}
