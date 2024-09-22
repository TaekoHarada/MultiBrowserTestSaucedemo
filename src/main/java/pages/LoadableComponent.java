package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

// Abstract class for Loadable Components
public abstract class LoadableComponent {

    protected WebDriver driver;

    // Constructor that receives the WebDriver instance
    public LoadableComponent(WebDriver driver) {
        this.driver = driver;
    }

    // Method to load the page (can be implemented differently in subclasses)
    protected abstract void load();

    // Method to check if the page is fully loaded
    protected abstract boolean isLoaded();

    // Wrapper method to load and verify the page
    public LoadableComponent get() {
        load();
        // Wait until the page is loaded, with a timeout of 10 seconds
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedCondition<Boolean>) driver -> isLoaded());
        return this;
    }
}
