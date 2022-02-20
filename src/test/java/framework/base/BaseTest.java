package framework.base;


import framework.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    public WebDriver driver;
    public static String browser;

    @BeforeTest
    public void driverSetUp(){
        browser = ConfigProperties.getProperty("browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getProperty("url"));
    }

    @AfterTest
    public void driverTearDown(){
        driver.quit();
    }
}

