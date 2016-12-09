package com.transsion.store.common;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by pradmin on 2016/5/30.
 */
public class Base64Util {

    /**
     * 将一个字符串进行BASE64编码
     * @param s
     * @return
     */
    public static String encode(String s) {
        if(s == null) {
            return null;
        }else {
            return new BASE64Encoder().encode(s.getBytes());
        }
    }

    /**
     * 将一个采用BASE64编码的字符串进行解码
     * @param s
     * @return
     */
    public static String decode(String s) {
        if(s == null) {
            return null;
        }else {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            try {
                byte[] bytes = base64Decoder.decodeBuffer(s);
                return new String(bytes);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
