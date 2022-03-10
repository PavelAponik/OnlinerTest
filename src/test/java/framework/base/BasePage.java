package framework.base;


import framework.elements.Label;
import framework.webdriver.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver = Browser.driver;
    public WebDriverWait wait;
    public JavascriptExecutor javascriptExecutor;

    public BasePage(By locator, String pageTitle) {
        String title = pageTitle;
        Label lblPage = new Label(locator, pageTitle);
    }

    public WebElement waitUntilElementAvailable(final String locator) {
        wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        return element;
    }

    public WebElement scrollToElement(final String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        return element;
    }

    public WebElement navigateTo(final String locator) {
        WebElement element = waitUntilElementAvailable(locator);
        Actions actions = new Actions(driver);
        scrollToElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        actions.moveToElement(element).build().perform();
        return element;
    }

    public WebElement navigateToDropDownItem(final String locator){
        WebElement element = waitUntilElementAvailable(locator);
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        actions.moveToElement(element).click().build().perform();
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
