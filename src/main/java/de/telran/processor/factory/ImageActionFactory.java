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
    private ActionConfigServiceInt actionsConfigService;
    private Map<String, ImageAction> imageActionMap = new HashMap<>();

    public ImageActionFactory(ActionsConfigService configService) throws Exception {
        this.actionsConfigService = configService;

        List<String> actionClassNames = actionsConfigService.getActionClassNames();
        String actionPackage = actionsConfigService.getActionPackage();

        for (String actionClassName : actionClassNames) {
            ImageAction imageAction = (ImageAction) Class.forName(actionPackage + "."
                    + actionClassName).getConstructor().newInstance();
            imageActionMap.put(imageAction.getName(), imageAction);
        }
    }

    public ImageAction getAction(String actionName) {
        ImageAction imageAction = imageActionMap.get(actionName);
        if (imageAction == null){
            return  new DefaultImageAction();
        }
      return imageAction;
    }

    public static void main(String[] args) throws Exception {
        ImageActionFactory imageActionFactory = new ImageActionFactory(new ActionsConfigService());
        ImageAction preview = imageActionFactory.getAction("PREVIEW");
        preview.doAction(null);
    }
}



