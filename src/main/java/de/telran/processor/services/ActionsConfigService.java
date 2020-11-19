package de.telran.processor.services;

import java.util.Properties;

public class ActionsConfigService {
    private Properties prop = new Properties();

    public ActionsConfigService() {
        loadProperties();
    }

    public void loadProperties(){

    }

    public String getActionPackage() {
        return (String) prop.get("action.package");
    }
}
