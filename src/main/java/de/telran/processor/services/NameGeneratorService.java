package de.telran.processor.services;

import de.telran.processor.entity.ImageDescriptor;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class NameGeneratorService {
    public String generateImageName(ImageDescriptor descriptor) throws MalformedURLException {
        String imageURL = descriptor.getImageURL();
        String actionName = descriptor.getActionName();
        String path = new URL(imageURL).getPath();
        String fileName = path.replaceAll("/", "_")
                .replace(".jpg", "_") + actionName + ".jpg";
        return fileName;
    }
}
