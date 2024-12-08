package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private Properties properties;

    public ConfigManager() {
        String configFilePath = "./Configuration/config.properties"; // Corrected path
        try {
            File configFile = new File(configFilePath);
            if (!configFile.exists()) {
                throw new FileNotFoundException("Configuration file not found at: " + configFilePath);
            }

            FileInputStream fileInputStream = new FileInputStream(configFile);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: Configuration file missing. " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error: Failed to load configuration properties. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return properties.getProperty("browser", "chrome"); // Default to Chrome if not specified
    }

    public String getUrl() {
        return properties.getProperty("url", "http://localhost"); // Default to localhost if not specified
    }

    public String getProperty(String key) {
        return properties.getProperty(key, ""); // Retrieve any property with a default empty string
    }
}
