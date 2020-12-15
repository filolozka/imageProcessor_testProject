package de.telran.processor.factory;

import de.telran.processor.action.DefaultImageAction;
import de.telran.processor.action.ImageAction;
import de.telran.processor.services.ActionsConfigService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ImageActionFactoryTest {
    ActionsConfigService testConfigS = mock(ActionsConfigService.class);


    @Test
    public void getAction() throws Exception {
       // List<String> listOfNames = Arrays.asList("GrayscaleImageAction", "DefaultImageAction", "PreviewImageAction");
        when(testConfigS.getActionPackage()).thenReturn("de.telran.processor.action");
        when(testConfigS.getActionClassNames()).thenReturn(getClassNames());

        ImageActionFactory testFactory = new ImageActionFactory(testConfigS);
        ImageAction imageActionTest = testFactory.getAction("DEFAULT");
        assertEquals("DEFAULT", imageActionTest.getName());

        verify(testConfigS, times(1)).getActionPackage();
        verify(testConfigS, times(1)).getActionClassNames();
    }

    private static List<String> getClassNames(){
        return Arrays.asList("GrayscaleImageAction", "DefaultImageAction", "PreviewImageAction");
    }
}