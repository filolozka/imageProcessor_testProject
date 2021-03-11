package de.telran.processor.services;

import de.telran.processor.factory.ImageActionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ActionsConfigService implements ActionConfigServiceInterface {
    private Properties prop = new Properties();

    public ActionsConfigService() throws IOException {
        loadProperties();
    }

    private void loadProperties() throws IOException {
        try (
                InputStream input = ImageActionFactory.class
                        .getClassLoader()
                        .getResourceAsStream("action.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find action.properties");
                return;
            }
            //load a properties file from class path, inside static method
            prop.load(input);

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getActionPackage() {
        return (String) prop.get("action.package");
    } //getter for first key from properties

    public List<String> getActionClassNames(){
        return Arrays.asList(((String) prop.get("action.names")).split(",")); //getter for second key from properties
    }
}
