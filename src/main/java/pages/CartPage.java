package pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends LoadableComponent {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {
        // Navigate to the page
        driver.get("https://www.saucedemo.com/cart.html");

    }

    @Override
    protected boolean isLoaded() {
        return false;
    }

}
