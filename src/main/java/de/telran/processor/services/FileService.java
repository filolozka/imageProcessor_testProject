package de.telran.processor.services;

import de.telran.processor.entity.ImageDescriptor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

public class FileService {
    public List<ImageDescriptor> readImageDescriptions(String fileName) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null)
                System.out.println(line);
        } catch (Exception f) {
            System.out.println(f.getMessage());
        }
        return Collections.EMPTY_LIST;
    }

    public static void main(String[] args) {
        FileService fs = new FileService();
        fs.readImageDescriptions("images.csv");
    }
}
