package de.telran.processor.action;

import java.awt.image.BufferedImage;

public class PreviewImageAction implements ImageAction{
    @Override
    public String getName() {
        return "PREVIEW";
    }

    @Override
    public BufferedImage doAction(BufferedImage image) throws Exception {
        System.out.println("Generating an image");
        return image;
    }
}
