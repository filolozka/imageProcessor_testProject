package de.telran.processor.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileConfigService {
    private Properties property = new Properties();

    public FileConfigService() throws Exception {
        loadProperties();
    }

    public String getPathToSavedImages(String pathForSaveImages) {
        return property.getProperty("pathForSaveImages");
    }

    private void loadProperties() throws IOException {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream("application.properties");
            property.load(stream);
    }
}

