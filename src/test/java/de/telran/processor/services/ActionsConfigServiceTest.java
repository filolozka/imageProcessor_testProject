package de.telran.processor.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ActionsConfigServiceTest {
    ActionsConfigService service = new ActionsConfigService();

    public ActionsConfigServiceTest() throws IOException {
    }

    @org.junit.Test
    public void getActionPackage() {
        String answer = service.getActionPackage();
        assertEquals("de.telran.processor.action", answer);
    }

    @org.junit.Test
    public void getActionClassNames() {
        List<String> listOfNames = service.getActionClassNames();
        assertEquals(Arrays.asList("GrayscaleImageAction", "DefaultImageAction", "PreviewImageAction", "NewImageAction"), listOfNames);
    }
}