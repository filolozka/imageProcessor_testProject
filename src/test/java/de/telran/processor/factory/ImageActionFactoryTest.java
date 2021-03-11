package de.telran.processor.factory;

import de.telran.processor.action.ImageAction;
import de.telran.processor.services.ActionsConfigService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ImageActionFactoryTest {
    ActionsConfigService configService = mock(ActionsConfigService.class);

    @Test
    public void getAction() throws Exception {
        //configure mocks
        when(configService.getActionPackage()).thenReturn("de.telran.processor.action");
        when(configService.getActionClassNames()).thenReturn(getClassNames());

        //execute testing method
        ImageActionFactory testFactory = new ImageActionFactory(configService);
        ImageAction imageActionTest = testFactory.getAction("PREVIEW");

        //assert result
        assertNotNull(imageActionTest);
        assertEquals("PREVIEW", imageActionTest.getName());

        verify(configService, times(1)).getActionPackage();
        verify(configService, times(1)).getActionClassNames();
    }

    private static List<String> getClassNames(){
        return Arrays.asList("GrayscaleImageAction", "DefaultImageAction", "PreviewImageAction");
    }
}
