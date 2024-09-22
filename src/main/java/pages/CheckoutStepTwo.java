package pages;

import org.openqa.selenium.WebDriver;

public class CheckoutStepTwo extends LoadableComponent {

    public CheckoutStepTwo(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {
        // Navigate to the page
        driver.get("https://www.saucedemo.com/checkout-step-two.html");

    }

    @Override
    protected boolean isLoaded() {
        return false;
    }
}
