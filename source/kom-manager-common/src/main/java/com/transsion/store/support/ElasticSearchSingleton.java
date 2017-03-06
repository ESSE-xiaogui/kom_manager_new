package com.transsion.store.support;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.util.Assert;

import java.net.InetAddress;

/**
 * Created by liuzh on 17-2-24.
 */
public class ElasticSearchSingleton {
    private static final String configFile = "es.properties";

    private static PropertiesConfiguration config;

    private static TransportClient transportClient;

    private static ElasticSearchSingleton singleton;

    public static ElasticSearchSingleton getSingleton() {
        if(singleton == null)
            singleton = new ElasticSearchSingleton();

        return singleton;
    }

    private ElasticSearchSingleton(){
        if(transportClient == null) {

            try {
                config = new PropertiesConfiguration(configFile);

                String clusterName = config.getString("cluster.name", "");
                boolean sniff = config.getBoolean("client.transport.sniff", false);
                String host = config.getString("host");
                int port = config.getInt("port", 9300);

                Assert.notNull(host, "The ElasticSearch host must not set!");

                Settings.Builder builder = Settings.builder();

                if(!clusterName.trim().isEmpty()) {
                    builder.put("cluster.name", clusterName);
                }
                builder.put("client.transport.sniff", sniff);

                transportClient = new PreBuiltTransportClient(builder.build());

                transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public TransportClient getClient() {
        return transportClient;
    }

    public void closeClient() {
        if(transportClient != null) {
            transportClient.close();
        }
    }
}
