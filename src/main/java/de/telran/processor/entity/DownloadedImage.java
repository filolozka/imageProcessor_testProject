package de.telran.processor.entity;

import java.awt.image.BufferedImage;

public class DownloadedImage {
    private BufferedImage image;
    private boolean isSuccessful;
    private ImageDescriptor descriptor;

    public DownloadedImage(BufferedImage image, boolean isSuccessful, ImageDescriptor descriptor){
        this.image = image;
        this.isSuccessful = isSuccessful;
        this.descriptor = descriptor;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSucсessful() {
        return isSuccessful;
    }

    public ImageDescriptor getDescriptor(){
        return descriptor;
    }
}
