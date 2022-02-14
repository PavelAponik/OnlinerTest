package Onliner.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Framework.Browser;

public class HomePage {
    private final WebDriver driver = Browser.driver;
    private final String category = "//h2//a[contains(text(), '%s')]";
    private JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Browser.driver;
    private WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
    Actions actionProvider = new Actions(driver);

    public HomePage(WebDriver driver){
        Browser.driver = driver;
    }

    public WebElement selectElement(String text){
        return driver.findElement(By.xpath(String.format(category, text)));
    }

    public void navigateTo(String section){
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(selectElement(section)));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", selectElement(section));
        action.moveToElement(selectElement(section)).click().build().perform();
    }
}
