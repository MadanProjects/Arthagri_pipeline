package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    private ConfigReader() {
        // prevent object creation
    }

    private static void loadProperties() {
        try {
            properties = new Properties();

            InputStream inputStream = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config/config.properties");

            if (inputStream == null) {
                throw new RuntimeException(
                        "config/config.properties not found in classpath");
            }

            properties.load(inputStream);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            loadProperties();
        }
        return properties.getProperty(key);
    }
}
