package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPage;

import utils.WebDriverFactory;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LoginTest {
    WebDriver driver;
    String browser;

    LoginPage loginPage;

    private final WebDriverFactory webDriverFactory;

    // Dependency Injection
    public LoginTest() {
        this.webDriverFactory = new WebDriverFactory();
    }

    @BeforeEach
    public void setup()  throws MalformedURLException {

        // Get the browser name from a system property or environment variable
        // This can be passed when running tests, e.g., `gradle test -Dbrowser=chrome`
        browser = System.getProperty("browser", "chrome"); // Default to Chrome

        // Initialize RemoteWebDriver
        driver = webDriverFactory.createWebDriver(browser);

        // Initialize Page Object
        loginPage = (LoginPage) new LoginPage(driver).get();

    }

    // Login Successfully
    @Test
    public void testLoginSuccess() {
        // Standard user
        InventoryPage inventoryPage = loginPage.login("standard_user","secret_sauce");

        // Assertion:　navigated to the InventoryPage
        assertNotNull(inventoryPage,"InventoryPage should not be null after successful login");
    }

    // Login Failed
    @Test
    public void testLoginFailWithLockedUser() {
        // Locked user
        InventoryPage inventoryPage = loginPage.login("locked_out_user","secret_sauce");
        // Assertion:　Not navigated to the InventoryPage
        assertNull(inventoryPage,"InventoryPage should be null with locked out user");
    }

    // Login Failed
    @Test
    public void testLoginFailWithIncorrectPassword() {
        // Empty password
        InventoryPage inventoryPage = loginPage.login("locked_out_user","");
        // Assertion:　Not navigated to the InventoryPage
        assertNull(inventoryPage,"InventoryPage should be null with incorrect password");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
