package com.transsion.store.utils;

import com.shangkang.core.util.SpringBeanHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuzh on 16-5-31.
 */
public class RedisCacheSupporter {
    private static RedisCacheSupporter factory;

    private final static Logger logger = LoggerFactory.getLogger(RedisCacheSupporter.class);

    private RedisTemplate redisTemplate;

    public static RedisCacheSupporter getSingleton()
    {
        if(factory == null)
        {
            factory = new RedisCacheSupporter();
        }
        return factory;
    }

    public RedisCacheSupporter() {
        redisTemplate = (RedisTemplate) SpringBeanHelper.getBean("redisTemplate");
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            result = operations.get(key);
        }catch (Exception e)
        {
            logger.error("Err: " + e);
        }

        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            logger.error("Err: " + e);
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.error("Err: " + e);
        }
        return result;
    }

    /**
     * 写入缓存
     * @param key
     * @param hashKey
     * @param value
     * @return
     */
    public boolean putObject(final String key, final String hashKey, Object value) {
        boolean result = false;

        try {
            HashOperations hashOperations = redisTemplate.opsForHash();

            hashOperations.put(key, hashKey, value);
            result = true;
        }catch (Exception e){
            logger.error("Err: " + e);
        }
        return result;
    }

    /**
     * 写入缓存
     * @param key
     * @param hashKey
     * @param value
     * @param expireTime
     * @return
     */
    public boolean putObject(final String key, final String hashKey, Object value, Long expireTime) {
        boolean result = false;
        try {
            HashOperations hashOperations = redisTemplate.opsForHash();
            hashOperations.put(key, hashKey, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.error("Err: " + e);
        }

        return result;
    }

    /**
     * 读取缓存
     *
     * @param key
     * @param hashKey
     * @return
     */
    public Object getObject(final String key, final String hashKey) {
        Object result = null;

        try {
            HashOperations operations = redisTemplate.opsForHash();
            result = operations.get(key, hashKey);
        }catch (Exception e)
        {
            logger.error("Err: " + e);
        }

        return result;
    }

    /**
     * 删除对应的value
     *
     * @param key
     * @param hashKey
     */
    public void removeObject(final String key, final String hashKey) {

        HashOperations operations = redisTemplate.opsForHash();

        operations.delete(key, hashKey);
    }

    /**
     * 获取size
     *
     * @param key
     * @return
     */
    public int getSize(final String key) {
        int size = 0;

        HashOperations operations = redisTemplate.opsForHash();

        Map map = operations.entries(key);

        if(map != null && !map.isEmpty())
            size = map.size();

        return size;
    }
}
