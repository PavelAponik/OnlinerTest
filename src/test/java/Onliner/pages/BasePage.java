package Onliner.pages;

import framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final Browser browser;

    public BasePage(final Browser browser) {
        this.browser = browser;
    }

    public WebElement waitUntilElementAvailable(final String locator) {
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), 10);
        WebElement element = browser.getDriver().findElement(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public WebElement scrollToElement(final String locator) {
        WebElement element = browser.getDriver().findElement(By.xpath(locator));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) browser.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public WebElement navigateTo(final String locator) {
        WebElement element = waitUntilElementAvailable(locator);
        scrollToElement(locator);
        browser.getActions().moveToElement(element).build().perform();
        return element;
    }

    public WebElement clickOnElement(final String locator){

    }
}
