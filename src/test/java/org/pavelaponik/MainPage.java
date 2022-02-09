package org.pavelaponik;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    static WebDriver driver = Browser.driver;
    private final String category = "//span[text()='%s']";
    private JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Browser.driver;

    public MainPage(WebDriver driver){
        Browser.driver = driver;
    }

    public WebElement selectElement(String text){
        return driver.findElement(By.xpath(String.format(category, text)));
    }

    public void navigateTo(String section){
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", selectElement(section));
        selectElement(section).click();
    }
}
