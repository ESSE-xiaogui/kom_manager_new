package com.transsion.store.utils;
/**
 * Created by liuzh on 16-5-31.
 */
public class CacheUtils {


    public CacheUtils() {

    }

    /**
     * 获取cacheManager
     * @return
     */
    public static RedisCacheSupporter getSupporter() {
        return RedisCacheSupporter.getSingleton();
    }
}
