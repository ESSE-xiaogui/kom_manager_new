package com.transsion.store.support;

import org.apache.commons.jcs.JCS;
import org.apache.commons.jcs.access.CacheAccess;

/**
 * Created by liuzh on 16-12-31.
 */
public class JCSCacheSupporter implements ICacheSupporter {
    private CacheAccess<String, Object> cache = null;

    public JCSCacheSupporter() {
        this.cache = JCS.getInstance( "default" );
    }

    @Override
    public void remove(String... keys) {
        for (String key: keys){
            cache.remove(key);
        }
    }

    @Override
    public void removePattern(String pattern) {
        cache.remove(pattern);
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
    }

    @Override
    public boolean exists(String key) {
        return false;
    }

    @Override
    public  <T> T  get(String key) {
        return (T) cache.get(key);
    }

    @Override
    public boolean set(String key, Object value) {
        cache.put(key, value);

        return true;
    }

    @Override
    public boolean set(String key, Object value, Long expireTime) {
        cache.put(key, value);
        return true;
    }

    @Override
    public boolean putObject(String key, String hashKey, Object value) {
        cache.put(key + hashKey, value);
        return true;
    }

    @Override
    public boolean putObject(String key, String hashKey, Object value, Long expireTime) {
        cache.put(key + hashKey, value);
        return true;
    }

    @Override
    public <T> T getObject(String key, String hashKey) {
        return (T) cache.get(key + hashKey);
    }

    @Override
    public void removeObject(String key, String hashKey) {
        cache.remove(key + hashKey);
    }

    @Override
    public int getSize(String key) {
        return 0;
    }
}
