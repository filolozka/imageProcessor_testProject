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
    public List<DownloadedImage> downloadImages(List<ImageDescriptor> imageDescriptors) {
        List<String> urlsList = imageDescriptors.stream().map(ImageDescriptor::getImageURL).collect(Collectors.toList());
        List<DownloadedImage> imageList = new ArrayList<>();

        for (String urlName : urlsList) {
            try {
                URL url = new URL(urlName);
                BufferedImage image = ImageIO.read(url);
                imageList.add(new DownloadedImage(image, true));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                imageList.add(new DownloadedImage(null, false));
            }
        }
        return imageList;
    }

    public List<DownloadedImage> downloadImagesWithDescriptors(List<ImageDescriptor> imageDescriptors) {
        Map<String, ImageDescriptor> mapOfUrlsAndDescriptors = imageDescriptors.stream()
                .collect(Collectors.toMap(ImageDescriptor::getImageURL, imageDescriptor -> imageDescriptor));
        List<DownloadedImage> imageList = new ArrayList<>();

        for (String urlName : mapOfUrlsAndDescriptors.keySet()) {
            try {
                URL url = new URL(urlName);
                BufferedImage image = ImageIO.read(url);
                imageList.add(new DownloadedImage(image, true, mapOfUrlsAndDescriptors.get(urlName)));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                imageList.add(new DownloadedImage(null, false, mapOfUrlsAndDescriptors.get(urlName)));
            }
        }
        return imageList;
    }
}
