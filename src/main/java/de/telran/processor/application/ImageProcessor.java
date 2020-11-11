package de.telran.processor.application;

import de.telran.processor.entity.ImageDescriptor;
import de.telran.processor.services.FileService;

import java.util.List;

public class ImageProcessor {
    private FileService fileService;

    public static void main(String[] args) {
        String csvFile = args[0];

        FileService fileService = new FileService();
        ImageProcessor processor = new ImageProcessor(fileService);
        processor.process(csvFile);
        //тут нужны mockito тесты

    }

    public ImageProcessor(FileService fileService){
        this.fileService = fileService;
    }

    public void process(String fileName){
        List<ImageDescriptor> imageDescriptors = fileService.readImageDescriptions(fileName);
    }
}
