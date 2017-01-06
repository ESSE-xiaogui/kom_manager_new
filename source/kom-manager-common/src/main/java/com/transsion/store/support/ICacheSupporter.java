package com.transsion.store.support;

/**
 * Created by liuzh on 16-12-31.
 */
public interface ICacheSupporter {
    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys);

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern);

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key);

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key);

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public <T> T get(final String key);

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value);

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime);

    /**
     * 写入缓存
     * @param key
     * @param hashKey
     * @param value
     * @return
     */
    public boolean putObject(final String key, final String hashKey, Object value);

    /**
     * 写入缓存
     * @param key
     * @param hashKey
     * @param value
     * @param expireTime
     * @return
     */
    public boolean putObject(final String key, final String hashKey, Object value, Long expireTime);

    /**
     * 读取缓存
     *
     * @param key
     * @param hashKey
     * @return
     */
    public <T> T getObject(final String key, final String hashKey);

    /**
     * 删除对应的value
     *
     * @param key
     * @param hashKey
     */
    public void removeObject(final String key, final String hashKey);

    /**
     * 获取size
     *
     * @param key
     * @return
     */
    public int getSize(final String key);


}
