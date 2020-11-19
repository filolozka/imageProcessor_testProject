package de.telran.processor.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

//Create ActionsConfigService, which encapsulates a java property file "actions.properties" and has 2 public methods:
//String getActionPackage()
//List<String> getActionClassNames()

public class ActionsConfigService implements ActionConfigServiceInt {
    private Properties prop = new Properties();

    public ActionsConfigService() throws IOException {
        loadProperties();
    }

    private void loadProperties() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("action.properties");
        prop.load(stream);
    }

    public String getActionPackage() {
        return (String) prop.get("action.package");
    } //getter for first key from properties

    public List<String> getActionClassNames(){
        return Arrays.asList(((String) prop.get("action.names")).split(",")); //getter for second key from properties
    }
}
