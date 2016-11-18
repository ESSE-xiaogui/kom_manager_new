package com.transsion.store.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    public static String md5(String str, String signType, String charset) {
        if (str == null) {
            return null;
        }

        str = str + "063c02f983da93704bab4280098e4c51";//加密码

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(signType);
            messageDigest.reset();
            messageDigest.update(str.getBytes(charset));
        } catch (UnsupportedEncodingException e) {
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

    public static String MD5(String str) {
        String key = md5(str, "MD5", "UTF-8");

        return key;
    }


   /* public static void main(String[] args) {
        String s = encrypt("1");
        System.out.println("encrypt:" + s);

        s = encrypt("123456");
        System.out.println("encrypt:" + s);
    }*/

    private static Integer getOffset(String s) {
        Integer i = 9;
        if (s.length() < 1) {
            return null;
        }
        for (int j = 0; j < s.length(); j++) {
            i = i + (int) s.charAt(j);
        }
        if (i >= 256) {
            i = i % 256;
        }
        if (i == 0) {
            i = 99;
        }
        return i;
    }

    public static String encrypt(String str) {
        return encrypt(str, "BallBill");
    }

    public static String encrypt(String str, String key) {
        String result = null;
        Integer iKeyLen = key.length();
        Integer ikeyPos = 0;
        Integer iSrcPos = 0;
        Integer iSrcAsc = 0;
        Integer iOffset = getOffset(str);
        String sDest = String.format("%02x", iOffset);
        for (iSrcPos = 0; iSrcPos < str.length(); iSrcPos++) {
            iSrcAsc = ((int) str.charAt(iSrcPos) + iOffset) % 255;
            if (ikeyPos < iKeyLen) {
                ikeyPos = ikeyPos + 1;
            } else {
                ikeyPos = 1;
            }
            iSrcAsc = iSrcAsc ^ (int) key.charAt(ikeyPos - 1);
            sDest = sDest + String.format("%02x", iSrcAsc);
            iOffset = iSrcAsc;
            result = sDest;
        }
        return result.toUpperCase();
    }
}
