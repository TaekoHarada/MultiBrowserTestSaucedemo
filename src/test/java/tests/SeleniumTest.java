package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {
    @Test
    public void testGoogleHomePage() {

        // Set ChromeOptions (optional)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode (no GUI)

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to Google's homepage
            driver.get("https://www.google.com");

            // Get the title of the page
            String title = driver.getTitle();

            // Check if the title contains "Google"
            assertTrue(title.contains("Google"), "Title does not contain 'Google'");
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
