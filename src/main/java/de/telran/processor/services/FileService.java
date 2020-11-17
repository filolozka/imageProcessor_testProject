package de.telran.processor.services;

import de.telran.processor.entity.ImageDescriptor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {
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

    public static void main(String[] args) {
        FileService fs = new FileService();
        fs.readImageDescriptions("images.csv");
        List<ImageDescriptor> descriptors = new ArrayList<>(fs.readImageDescriptions("images.csv"));
        System.out.println(descriptors.toString());
    }
}
