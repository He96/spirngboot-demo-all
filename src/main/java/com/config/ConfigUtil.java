package com.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 * 配置文件读取
 */
public class ConfigUtil {
    public static final String fileName = "application.properties";
    private static PropertiesConfiguration config;

    static {
        try {
            config = new PropertiesConfiguration(fileName);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        config.setReloadingStrategy(new FileChangedReloadingStrategy());
    }

    public static String productName = config.getString("project_name");

    public static String MONGODB_URLS =  config.getString("spring.data.mongodb.uris");
    public static String MONGODB_DATABASE =  config.getString("spring.data.mongodb.database");
    public static String MONGODB_HOST =  config.getString("spring.data.mongodb.host");
    public static int MONGODB_PORT =  config.getInt("spring.data.mongodb.port");
    public static String MONGODB_USERNAME =  config.getString("spring.data.mongodb.username");
    public static String MONGODB_PASSWORD =  config.getString("spring.data.mongodb.password");
    public static Boolean MONGODB_ISONLY = config.getBoolean("spring.data.mongodb.isOnly");
}
