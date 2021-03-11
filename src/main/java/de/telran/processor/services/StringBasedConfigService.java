package de.telran.processor.services;

import java.util.Arrays;
import java.util.List;

public class StringBasedConfigService implements ActionConfigServiceInterface {
    @Override
    public String getActionPackage() {
        return "de.telran.processor.action";
    }

    @Override
    public List<String> getActionClassNames() {
        return Arrays.asList("GrayscaleImageAction","DefaultImageAction","PreviewImageAction","NewImageAction");
    }
}
