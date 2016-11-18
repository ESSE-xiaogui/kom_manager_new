package com.transsion.store.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
