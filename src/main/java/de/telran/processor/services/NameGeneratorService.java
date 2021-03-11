package de.telran.processor.services;

import de.telran.processor.entity.ImageDescriptor;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class NameGeneratorService {
    public String generateImageName(ImageDescriptor descriptor) throws MalformedURLException {
        String imageURL = descriptor.getImageURL();
        String actionName = descriptor.getActionName();
        String path = new URL(imageURL).getPath();//
        File file = new File(path);
        String fileName = actionName + file.getAbsolutePath().replace("/", "_");
        return fileName;
    }
}
