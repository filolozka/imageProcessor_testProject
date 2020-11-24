package de.telran.processor.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public interface ActionConfigServiceInt {
    String getActionPackage();
    List<String> getActionClassNames();
}
