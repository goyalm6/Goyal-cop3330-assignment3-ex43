package ex43;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CreateSiteStructureTest {
    private CreateSiteStructure createSiteStructure;

    @BeforeEach
    void setUp() {
        createSiteStructure = new CreateSiteStructure();
        createSiteStructure.websiteName = "mycoolestsite";
        createSiteStructure.author = "coolest author";
        createSiteStructure.js = 'y';
        createSiteStructure.css = 'y';
    }

    @AfterEach
    void tearDown() {
        createSiteStructure = null;
    }

    @Test
    void testCreateWebsiteStructure() {
        HashMap<String, Boolean> result = createSiteStructure.create();
        String currentDirectory = result.keySet().iterator().next();
        Boolean isSiteCreated = result.get(currentDirectory);

        Boolean isCssCreated = createSiteStructure.createCssDirectory(currentDirectory);
        Boolean isJsCreated = createSiteStructure.createJsDirectory(currentDirectory);

        assertNotEquals("", currentDirectory);
        assertEquals(1, result.size());
        assertEquals(true, isSiteCreated);
        assertEquals(true, isCssCreated);
        assertEquals(true, isJsCreated);
    }

    @Test
    void testCreateWebsiteNotCreated() {
        createSiteStructure.websiteName = "mycoolestsite";
        HashMap<String, Boolean> result = createSiteStructure.create();
        String currentDirectory = result.keySet().iterator().next();
        Boolean isSiteCreated = result.get(currentDirectory);

        Boolean isCssCreated = createSiteStructure.createCssDirectory(currentDirectory);
        Boolean isJsCreated = createSiteStructure.createJsDirectory(currentDirectory);

        assertNotEquals("", currentDirectory);
        assertEquals(1, result.size());
        assertEquals(false, isSiteCreated);
    }
}
