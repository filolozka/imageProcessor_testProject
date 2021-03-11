package de.telran.processor.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileConfigService {
    private Properties property = new Properties();

    public FileConfigService() throws Exception {
        loadProperties();
    }

    public String getPathToSavedImages() {
        return property.getProperty("pathForSaveImages");
    }

    private void loadProperties() throws IOException {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream("application.properties");
            if (stream == null){
                System.out.println("Sorry, the file application.properties not found");
                return;
            }
            property.load(stream);
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
