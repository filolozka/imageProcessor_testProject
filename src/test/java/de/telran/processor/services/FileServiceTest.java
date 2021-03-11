package de.telran.processor.services;

import de.telran.processor.entity.DownloadedImage;
import de.telran.processor.entity.ImageDescriptor;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileServiceTest {

    @Test
    public void generateImageName() throws Exception {
        NameGeneratorService nameGeneratorService = new NameGeneratorService();
        FileService fileService = new FileService(new FileConfigService(), nameGeneratorService);
        ImageDescriptor descriptor = new ImageDescriptor("https://images.app.goo.gl/7Qiqcx17wSjKZ8Fr9", "GRAYSCALE");

        String expected = "7Qiqcx17wSjKZ8Fr9GRAYSCALE.jpg";
        String actual = nameGeneratorService.generateImageName(descriptor);

        assertEquals(expected, actual);
    }
}
