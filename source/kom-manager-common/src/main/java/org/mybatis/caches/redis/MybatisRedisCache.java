package org.mybatis.caches.redis;

import com.transsion.store.utils.CacheUtils;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by liuzh on 16-6-1.
 */
public class MybatisRedisCache implements Cache {

    private final static Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String id;

    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getSize() {
        return CacheUtils.getSupporter().getSize(id);
    }

    @Override
    public void putObject(final Object key, final Object value) {

        logger.debug("Put object by: " + id + "-->" + key);
        CacheUtils.getSupporter().putObject(id, key.toString(), value);
    }

    @Override
    public Object getObject(final Object key) {

        Object result = CacheUtils.getSupporter().getObject(id, key.toString());
        logger.debug("Get object by key: " + id + "-->" + key + ", the value is: " + result);
        return result;
    }

    @Override
    public Object removeObject(final Object key) {
        CacheUtils.getSupporter().removeObject(id, key.toString());

        logger.debug("Remove object by key: " + id + "-->" + key);

        return key;
    }

    @Override
    public void clear() {
        logger.debug("Clear object by key: " + id);
        CacheUtils.getSupporter().remove(id);
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    @Override
    public String toString() {
        return "Redis {" + id + "}";
    }
}
