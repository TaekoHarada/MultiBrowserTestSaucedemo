package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public WebDriver createWebDriver(String browser) throws MalformedURLException {
        URL gridUrl = new URL("http://localhost:4444/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set the browser capabilities
        if (browser.equalsIgnoreCase("firefox")) {
            capabilities.setBrowserName("firefox");
        } else if (browser.equalsIgnoreCase("chrome")) {
            capabilities.setBrowserName("chrome");
        } else if (browser.equalsIgnoreCase("edge")) {
            capabilities.setBrowserName("MicrosoftEdge");
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Return the RemoteWebDriver instance
        return new RemoteWebDriver(gridUrl, capabilities);
    }
}
