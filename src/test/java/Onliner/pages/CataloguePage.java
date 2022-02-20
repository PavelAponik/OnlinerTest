package Onliner.pages;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;


public class CataloguePage extends BasePage {
    public static final String catalogMenu = "//span[text()='%s']";
    public static final String catalogSubMenu = "//div[contains(@class, 'catalog-navigation-list__aside-title') and contains(text(), '%s')]";
    public static final String catalogDropDown = "//span[contains(@class, 'catalog-navigation-list__dropdown-title') and contains(text(), '%s')]";

    public CataloguePage(WebDriver driver){
        super(driver);
    }
}




