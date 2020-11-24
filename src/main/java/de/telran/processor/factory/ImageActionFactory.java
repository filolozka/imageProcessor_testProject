package de.telran.processor.factory;

import de.telran.processor.action.DefaultImageAction;
import de.telran.processor.action.GrayscaleImageAction;
import de.telran.processor.action.ImageAction;
import de.telran.processor.action.PreviewImageAction;
import de.telran.processor.services.ActionConfigServiceInt;
import de.telran.processor.services.ActionsConfigService;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ImageActionFactory {
    public ImageAction getAction(String actionName) {
        switch (actionName) {
            case "PREVIEW":
                return new PreviewImageAction();
            case "GRAYSCALE":
                return new GrayscaleImageAction();
            default:
                return new DefaultImageAction();
        }
    }
}



