package de.telran.processor.services;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {
    private static  String CSV_SEPARATOR=";";
    private FileConfigService fileConfigService;
    private NameGeneratorService nameGeneratorService;

    public FileService(FileConfigService fileConfigService, NameGeneratorService nameGeneratorService) {
        this.fileConfigService = fileConfigService;
        this.nameGeneratorService = nameGeneratorService;
    }

    public List<ImageDescriptor> readImageDescriptors(String fileName) {
        try {
            return Files
                    .lines(Paths.get(fileName))
                    .map(FileService::stringToImageDescriptor)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return Collections.EMPTY_LIST;
        }
    }

    public void saveImageAsFile(DownloadedImage imageToSave) {
        try {
            File fileToSave = new File(fileConfigService.getPathToSavedImages(),
                    nameGeneratorService.generateImageName(imageToSave.getDescriptor()));
            ImageIO.write(imageToSave.getImage(),
                    "jpg", fileToSave);
        } catch (Exception ex) {
            ex.printStackTrace();
            //logger
        }
    }


    private static ImageDescriptor stringToImageDescriptor(String string) {
        String[] split = string.split(CSV_SEPARATOR);
        return new ImageDescriptor(split[0], split[1]);
    }
}
