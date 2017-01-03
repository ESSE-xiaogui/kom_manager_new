package com.transsion.store.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liuzh on 16-12-31.
 */
public class CacheSupporterFactory {

    private static ICacheSupporter cacheSupporter;

    private final static Logger logger = LoggerFactory.getLogger(CacheSupporterFactory.class);

    public static ICacheSupporter getSingleton(ICacheSupporter iCacheSupporter)
    {
        if(cacheSupporter == null)
        {
            cacheSupporter = iCacheSupporter;
            logger.info("Init cacheSupporter instance:[{}]", iCacheSupporter.getClass());
        }
        return cacheSupporter;
    }

}
