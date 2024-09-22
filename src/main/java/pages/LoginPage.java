package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends LoadableComponent {

    // Using @FindBy annotation
    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        // Initialize the WebElements using PageFactory
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        // Navigate to the page
        driver.get("https://www.saucedemo.com/");
    }

    @Override
    protected boolean isLoaded() {
        try {
            return loginButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Action (login)
    public InventoryPage login(String username, String password) {

        if(isLoaded()) {
            // Fill in the username and password fields with the provided data
            usernameField.sendKeys(username);
            passwordField.sendKeys(password);

            // Click the login button to submit the form
            loginButton.click();

// Wait for the Inventory Page to load or for an error message
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                // Wait for the inventory page's specific element (e.g., a unique item)
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_container")));

                // Return the InventoryPage object if successfully loaded
                return new InventoryPage(driver).get();
            } catch (TimeoutException e) {
                // If an error message is present, return null
                return null;
            }        }
        return null;
    }

}
