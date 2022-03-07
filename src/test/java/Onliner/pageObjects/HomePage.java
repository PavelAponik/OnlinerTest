package Onliner.pageObjects;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public static final String category = "//h2//a[contains(text(), '%s')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

}
