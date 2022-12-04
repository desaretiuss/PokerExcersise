package org.verdiseno.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private PropertiesLoader() {
    }

    public static Properties loadProperties() {
        Properties configuration = new Properties();
        try {
            InputStream inputStream = PropertiesLoader.class
                    .getClassLoader()
                    .getResourceAsStream("application.properties");
            if (inputStream == null) {
                throw new IOException("Could not load resource file");
            }
            configuration.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Could not read from properties file");
        }
        return configuration;
    }
}