package de.telran.processor.services;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownloadService {
    private ImageReadingService imageReadingService;

    public DownloadService(ImageReadingService imageReadingService) {
        this.imageReadingService = imageReadingService;
    }

    public List<DownloadedImage> downloadImages(List<ImageDescriptor> imageDescriptors) {
        List<DownloadedImage> imageList = new ArrayList<>();
        for(ImageDescriptor descriptor: imageDescriptors) {
            try {
                URL url = new URL(descriptor.getImageURL());
                BufferedImage image = imageReadingService.readImageFromUrl(url);
                imageList.add(new DownloadedImage(image, true, descriptor));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                imageList.add(new DownloadedImage(null, false, descriptor));
            }
        }
        return imageList;
    }
}
