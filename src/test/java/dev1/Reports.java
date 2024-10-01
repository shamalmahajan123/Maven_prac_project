package dev1;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;


@Epic("Epic Name")
    @Feature("Feature Name")
    public class Reports {

    private byte[] screenshotBytes;

    @BeforeEach
        public void setUp() {
            // Setup code
        }

        @Test
        @Story("Story Name")
        @DisplayName("Test Case Name")
        public void testMethod() {
            // Test code
            Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(screenshotBytes), "png");
        }

        @AfterEach
        public void tearDown() {
            // Cleanup code
        }
    }


