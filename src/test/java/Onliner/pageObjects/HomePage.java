package Onliner.pageObjects;

import framework.base.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public static final String category = "//h2//a[contains(text(), '%s')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToCategory(String category){
        Button btnCategory = new Button(By.xpath(category));
        btnCategory.clickAndWait();

    }
}
