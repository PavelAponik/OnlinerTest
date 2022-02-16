package Onliner.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.Browser;

public class TVPage extends BasePage {

    private final WebDriver driver = Browser.driver;
    private WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
    private JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Browser.driver;

    private final String checkboxLocator = "//li/label[@class='schema-filter__checkbox-item']/span[text()='%s']";
    private final String maxPriceLocator = "//input[contains(@class, 'schema-filter-control__item schema-filter__number-input schema-filter__number-input_price')][@placeholder='до']";
    private final String  productTitle = "//div[@class='schema-product__title']";


    public TVPage(WebDriver driver){
        Browser.driver = driver;
    }

    public WebElement checkbox(String text){
        return driver.findElement(By.xpath(String.format(checkboxLocator,text)));
    }

    public WebElement maxPrice(String text){
        return driver.findElement(By.xpath(String.format(maxPriceLocator, text)));
    }

    public void selectCheckbox(String checkboxName){
        wait.until(ExpectedConditions.elementToBeClickable(checkbox(checkboxName)));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", checkbox(checkboxName));
        Actions action = new Actions(driver);
        action.moveToElement(checkbox(checkboxName)).click().build().perform();
    }

    public void setMaxPrice(String price){
        wait.until(ExpectedConditions.elementToBeClickable(maxPrice(price)));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", maxPrice(price));
        maxPrice(price).sendKeys(price);
    }

    public void waitTillResults(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTitle)));
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(productTitle))));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(productTitle)));
    }

}
