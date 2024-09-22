package pages;

import org.openqa.selenium.WebDriver;

public class CheckoutComplete extends LoadableComponent {

    public CheckoutComplete(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {
        // Navigate to the page
        driver.get("https://www.saucedemo.com/checkout-complete.html");

    }

    @Override
    protected boolean isLoaded() {
        return false;
    }
}
