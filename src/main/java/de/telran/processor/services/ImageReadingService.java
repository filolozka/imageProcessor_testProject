package de.telran.processor.services;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageReadingService {
    public BufferedImage readImageFromUrl(URL url) throws IOException {
        return ImageIO.read(url);
    }
}
