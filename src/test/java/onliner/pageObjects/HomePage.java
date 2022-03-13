package onliner.pageObjects;

import framework.base.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class HomePage extends BasePage {
    public static final String CATEGORY = "//h2//a[contains(text(), '%s')]";
    static SoftAssert softAssert = new SoftAssert();

    public HomePage(){
        super(By.xpath("//div[contains(@class, 'b-top-logo')]"), "Home Page");
    }

    public void navigateToCategory(String category){
        Button btnCategory = new Button(By.xpath(category), "Каталог");
        btnCategory.scrollToElement();
        btnCategory.clickAndWait();

    }
    @Override
    public void isRightPageOpened(String homePageTitle){
        softAssert.assertEquals(getTitle(),homePageTitle);
    }
}
