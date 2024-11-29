package com.doza.util;

import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private PropertiesUtil() {
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    public static void loadProperties() {
        try(var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
