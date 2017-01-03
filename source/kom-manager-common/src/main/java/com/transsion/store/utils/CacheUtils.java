package com.transsion.store.utils;

import com.transsion.store.support.CacheSupporterFactory;
import com.transsion.store.support.ICacheSupporter;
import com.transsion.store.support.JCSCacheSupporter;
import com.transsion.store.support.RedisCacheSupporter;

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
    public static ICacheSupporter getSupporter() {
        return CacheSupporterFactory.getSingleton(new RedisCacheSupporter());
    }
}
