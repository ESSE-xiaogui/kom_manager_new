package com.transsion.store.support;

import net.mikesu.fastdfs.FastdfsClient;
import net.mikesu.fastdfs.FastdfsClientFactory;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * Created by liuzh on 17-2-16.
 */
public class FastdfsClientSingleton {
    private static final String configFile = "FastdfsClient.properties";
    private static PropertiesConfiguration config;
    private static FastdfsClientSingleton singleton;

    public static FastdfsClientSingleton getSingleton() {

        if(singleton == null) {
            singleton = new  FastdfsClientSingleton();
        }

        return singleton;
    }

    private FastdfsClientSingleton() {
        initConfig();
    }

    public String getDownloadServer() {
        return config.getString("download_server");
    }

    public FastdfsClient getFastdfsClient() {
        return FastdfsClientFactory.getFastdfsClient();
    }

    private static void initConfig() {
        try {
            if(config == null) {
                config = new PropertiesConfiguration(configFile);
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
