package de.telran.processor.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public interface ActionConfigServiceInterface {
    String getActionPackage();
    List<String> getActionClassNames();
}
