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
        FileService fileService = new FileService(new FileConfigService());
        ImageDescriptor descriptor = mock(ImageDescriptor.class);
        when(descriptor.getActionName()).thenReturn("GRAYSCALING");
        when(descriptor.getImageURL()).thenReturn("https://images.app.goo.gl/pUw6ojBfrWBvsFh28.jpg");

        assertEquals("pUw6ojBfrWBvsFh28_GRAYSCALING.jpg", fileService.generateImageName(descriptor));
    }
}