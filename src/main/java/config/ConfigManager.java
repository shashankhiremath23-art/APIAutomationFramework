package config;

import java.util.Properties;
import java.io.FileInputStream;

public class ConfigManager {

    private static Properties properties = new Properties();

    static {
        try {
            String env = System.getProperty("env", "dev");
            FileInputStream fis = new FileInputStream(
                    "src/test/resources/config/" + env + ".properties"
            );
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
