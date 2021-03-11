package de.telran.processor.application;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;
import de.telran.processor.factory.ImageActionFactory;
import de.telran.processor.services.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ImageProcessor {
    private FileService fileService;
    private DownloadService downloadService;
    private ImageService imageService;

    public ImageProcessor(FileService fileService, DownloadService downloadService, ImageService imageService) {
        this.fileService = fileService;
        this.downloadService = downloadService;
        this.imageService = imageService;
    }

    public static void main(String[] args) throws Exception {
        //String csvFile = args[0];
        String csvFile = "C:/Users/Veronika/Projects/Edu/ImageReaderProject/src/main/resources/csvFile.csv";

        FileService fileService = new FileService(new FileConfigService(), new NameGeneratorService());
        DownloadService dlService = new DownloadService(new ImageReadingService());
        ImageService imageService = new ImageService(new ImageActionFactory(new ActionsConfigService()));
        ImageProcessor processor = new ImageProcessor(fileService, dlService, imageService);
        processor.process(csvFile);
    }

    public void process(String fileName) {
        //main logic is here

        // reading CSV file to get image data like URLS and actions
        List<ImageDescriptor> imageDescriptors = fileService.readImageDescriptors(fileName);
        // download images
        List<DownloadedImage> imageList = downloadService.downloadImages(imageDescriptors);

        //filter successfully downloaded images
        List<DownloadedImage> successfulDownloadedImages = imageList
                .stream()
                .filter(DownloadedImage::isSucсessful)
                .collect(Collectors.toList());

        //apply action to every image
        List<DownloadedImage> processedImages = successfulDownloadedImages
                .stream()
                .map(di -> imageService.processImage(di))
                .collect(Collectors.toList());

        //save transformed images to disk
                processedImages
                .forEach(f -> fileService.saveImageAsFile(f));
        //image saved at the directory wrote in application.properties
        //to get the path for saving pictures use FileConfigService
    }
}
