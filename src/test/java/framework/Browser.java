package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Browser {

    private final WebDriver driver;
    private final String browserName;
    private final Actions actions;


    public Browser(final WebDriver driver, final String browserName) {
        this.driver = driver;
        this.browserName = browserName;
        this.actions = new Actions(driver);
        this.browserSetUp();
    }

    private void browserSetUp() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getProperty("url"));
    }

    public void browserQuit(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getBrowserName() {
        return browserName;
    }

    public Actions getActions() {
        return actions;
    }
}
