package onliner.pageObjects;

import framework.base.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public static final String CATEGORY = "//h2//a[contains(text(), '%s')]";

    public HomePage(){
        super(By.xpath("//div[contains(@class, 'b-top-logo')]"), "Home Page");
    }

    public void navigateToCategory(String categoryName){
        Button btnCategory = new Button(By.xpath(String.format(CATEGORY, categoryName)), categoryName);
        btnCategory.scrollToElement();
        btnCategory.clickAndWait();
    }
}
