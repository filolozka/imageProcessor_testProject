package de.telran.processor.services;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {
    private FileConfigService fileConfigService;

    public FileService(FileConfigService fileConfigService) {
        this.fileConfigService = fileConfigService;
    }

    public List<ImageDescriptor> readImageDescriptions(String fileName) {
        List<String> listOfImageDescriptions = readFileToStringList(fileName);
        return listOfImageDescriptions.stream().map(this::convertStringToObject).collect(Collectors.toList());
    }
    private ImageDescriptor convertStringToObject(String line){
        return new ImageDescriptor(line.split("::")[0], line.split("::")[1]);
    }

    private List<String> readFileToStringList(String fileName) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            stringList = bufferedReader.lines().collect(Collectors.toList());
        } catch (Exception f) {
            System.out.println(f.getMessage());
        }
        System.out.println(stringList);
        return stringList;
    }

    public void saveImageAsFile (DownloadedImage image){
        try {
            ImageIO.write(image.getImage(),
                    "jpg",
                    new File(fileConfigService.getPathToSavedImages("pathForSaveImages"), generateImageName(image.getDescriptor())));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String generateImageName(ImageDescriptor imageDescriptor) throws Exception {
        String path = new URL(imageDescriptor.getImageURL()).getPath();
        File file = new File(path);
        String imageName = imageDescriptor.getActionName();

        String imageNameFin = file.getAbsolutePath().replaceAll("/", "_").replaceAll("C:\\\\", "").replace(".jpg", "_") + imageName + ".jpg";
        return imageNameFin;
    }

    public FileConfigService getFileConfigService() {
        return fileConfigService;
    }
    
}
