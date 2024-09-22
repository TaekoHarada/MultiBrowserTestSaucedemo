package pages;

import org.openqa.selenium.WebDriver;

public class CheckoutStepOne extends LoadableComponent {

    public CheckoutStepOne(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {
        // Navigate to the page
        driver.get("https://www.saucedemo.com/checkout-step-one.html");

    }

    @Override
    protected boolean isLoaded() {
        return false;
    }
}
