package fr.epita.quiz.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationService {

    private static final Logger LOGGER = LogManager.getLogger(ConfigurationService.class);
    private Properties properties;
    private static ConfigurationService instance;

    private ConfigurationService() throws IOException {
        properties = new Properties();
        properties.load(new FileReader("conf.properties"));
    }
    public static ConfigurationService getInstance() {
        if (instance == null) {
            try {
                instance = new ConfigurationService();
            }catch (IOException e) {
                LOGGER.error(e);
            }
        }
        return instance;
    }

    public String getConfEntry(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

}
