package Onliner.base;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor javascriptExecutor;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }

    public WebElement waitUntilElementAvailable(final String locator) {
        wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return element;
    }

    public WebElement scrollToElement(final String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public WebElement navigateTo(final String locator) {
        WebElement element = waitUntilElementAvailable(locator);
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        scrollToElement(locator);
        actions.moveToElement(element).build().perform();
        return element;
    }

    public WebElement clickOnElement(final String locator){
        WebElement element = navigateTo(locator);
        navigateTo(locator).click();
        return element;
   }

    public void waitTillResults(final String locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(locator))));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(locator)));
    }

    public void setValue(final String locator, String value){
        WebElement element = driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys(value);
    }
}
