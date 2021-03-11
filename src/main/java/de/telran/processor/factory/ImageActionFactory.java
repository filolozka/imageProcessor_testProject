package de.telran.processor.factory;

import de.telran.processor.action.DefaultImageAction;
import de.telran.processor.action.ImageAction;
import de.telran.processor.services.ActionConfigServiceInterface;
import de.telran.processor.services.ActionsConfigService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageActionFactory {
    private ActionConfigServiceInterface actionsConfigService;
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
}



