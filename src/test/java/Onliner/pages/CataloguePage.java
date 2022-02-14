package Onliner.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Framework.Browser;


public class CataloguePage {
    private final WebDriver driver = Browser.driver;
    private WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
    private final String catalogMenu = "//span[text()='%s']";
    private final String catalogSubMenu = "//div[contains(@class, 'catalog-navigation-list__aside-title') and contains(text(), '%s')]";
    private final String catalogDropDown = "//span[contains(@class, 'catalog-navigation-list__dropdown-title') and contains(text(), '%s')]";

    public CataloguePage(WebDriver driver){
        Browser.driver = driver;
    }

    private WebElement catMenu(String text){
         return driver.findElement(By.xpath(String.format(catalogMenu, text)));
    }

    private WebElement catSubMenu(String text){
        return driver.findElement(By.xpath(String.format(catalogSubMenu, text)));
    }

    private WebElement catDropDownItem(String text){
        return driver.findElement(By.xpath(String.format(catalogDropDown, text)));
    }

    public void selectCatMenu(String category){
        wait.until(ExpectedConditions.elementToBeClickable(catMenu(category)));
        catMenu(category).click();
    }

    public void selectCatSubMenu(String subCategory){
        wait.until(ExpectedConditions.elementToBeClickable(catSubMenu(subCategory)));
        Actions action = new Actions(driver);
        action.moveToElement(catSubMenu(subCategory)).build().perform();
    }

    public void selectDropDownItem(String dropDownItem){
        wait.until(ExpectedConditions.elementToBeClickable(catDropDownItem(dropDownItem)));
        Actions action = new Actions(driver);
        action.moveToElement(catDropDownItem(dropDownItem)).click().build().perform();
    }
}




