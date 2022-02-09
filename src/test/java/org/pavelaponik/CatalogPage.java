package org.pavelaponik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class CatalogPage {
    static WebDriver driver = Browser.driver;
    private final String catalogMenu = "//span[text()='%s']";
    private final String catalogSubMenu = "//span[text()='%s']";

    public CatalogPage(WebDriver driver){
        Browser.driver = driver;
    }

    private WebElement catMenu(String text){
         return driver.findElement(By.xpath(String.format(catalogMenu, text)));
    }

    private WebElement catSubMenu(String text){
        return driver.findElement(By.xpath(String.format(catalogSubMenu, text)));
    }

    public void selectCatMenu(String text){
        catMenu(catalogMenu).click();
    }
    public void selectCatSubMenu(String text){
        catSubMenu(catalogSubMenu).click();
    }
}




