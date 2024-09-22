package pages;

import org.openqa.selenium.WebDriver;

public class InventoryPage extends LoadableComponent {
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {
        // Navigate to the page
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @Override
    protected boolean isLoaded() {
        return true;
    }

    // Optional: A method to retrieve the current instance of InventoryPage
    public InventoryPage get() {
        super.get(); // This will call load() and then check isLoaded()
        return this; // Return the current instance
    }

}
