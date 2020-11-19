package de.telran.processor.application;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;
import de.telran.processor.services.DownloadService;
import de.telran.processor.services.FileService;

import java.util.List;
import java.util.stream.Collectors;

public class ImageProcessor {
    private FileService fileService;
    private DownloadService downloadService;

    public static void main(String[] args) {
        String csvFile = args[0];

        FileService fileService = new FileService();
        DownloadService dlService = new DownloadService();
        ImageProcessor processor = new ImageProcessor(fileService, dlService);
        processor.getDownloadedImages(csvFile);
        //тут нужны mockito тесты

    }

    public ImageProcessor(FileService fileService, DownloadService downloadService){
        this.fileService = fileService;
        this.downloadService = downloadService;
    }

    public List<DownloadedImage> getDownloadedImages(String fileName){
        List<ImageDescriptor> imageDescriptors = fileService.readImageDescriptions(fileName);
        List<String> urlsList = imageDescriptors.stream().map(ImageDescriptor::getImageURL).collect(Collectors.toList());
        List<DownloadedImage> imageList = downloadService.downloadImages(urlsList);
        return imageList;
    }
}
