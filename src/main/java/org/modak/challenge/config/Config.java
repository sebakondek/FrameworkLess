package org.modak.challenge.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public abstract class Config {
    private static final PropertiesConfiguration CONFIG;

    static {
        CONFIG = loadConfig();
    }

    private static PropertiesConfiguration loadConfig() {
        PropertiesConfiguration config = new PropertiesConfiguration();

        try {
            config.load("application.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException("Error loading properties", e);
        }

        return config;
    }

    public static PropertiesConfiguration get() {
        return CONFIG;
    }
}
