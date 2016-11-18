package com.transsion.store.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pradmin on 2016/5/30.
 */
public class MD5Util {

    public static String md5(String str, String signType, String charset)
    {
        if (str == null)
        {
            return null;
        }

           str = str + "063c02f983da93704bab4280098e4c51";//加密码

        MessageDigest messageDigest = null;
        try
        {
            messageDigest = MessageDigest.getInstance(signType);
            messageDigest.reset();
            messageDigest.update(str.getBytes(charset));
        }catch (UnsupportedEncodingException e)
        {
            return str;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; ++i)
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(
                        Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));

        return md5StrBuff.toString();
    }

    public static String MD5(String str)
    {
        String key = md5(str, "MD5", "UTF-8");

        return key;
    }

    
    
    
    public static void main(String[] args) {
    	String[] imeilIst = {"357262073018868", "357274078876885", "357357070031722"};
    	for (int i = 0; i < imeilIst.length; i++) {
    		String imei = imeilIst[i];
    		String md5 = MD5Util.MD5(imei);
//    		String result = HTTPUtil.sendPostRequest("http://open.af1225.com/api/komByImei", "imei="+imei+"&check="+md5);
    		String result = HTTPUtil.sendPostRequest("http://open.af1225.com/api/komByImei1", "imei="+imei+"&check="+md5);
            System.out.println(result);
    	}
    }
    
    
}
