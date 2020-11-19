package de.telran.processor.application;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;
import de.telran.processor.services.DownloadService;
import de.telran.processor.services.FileService;

import java.io.IOException;
import java.util.List;

public class ImageProcessor {
    private FileService fileService;
    private DownloadService downloadService;

    public static void main(String[] args) {

        String csvFile = args[0];

        FileService fileService = new FileService();

        DownloadService dlService = new DownloadService();
        ImageProcessor processor = new ImageProcessor(fileService, dlService);
        processor.process(csvFile);
        //тут нужны mockito тесты

        try {
            processor.process(csvFile);
        }
        catch (IOException ex){
            System.out.println(ex);
        }
    }

    public ImageProcessor(FileService fileService, DownloadService downloadService){
        this.fileService = fileService;
        this.downloadService = downloadService;
    }


    public void process(String fileName){
        List<ImageDescriptor> imageDescriptors = fileService.readImageDescriptions(fileName);
        List<DownloadedImage> imageList = downloadService.downloadImagesWithDescriptors(imageDescriptors);
    }
}
