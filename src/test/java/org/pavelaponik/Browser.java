package org.pavelaponik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    public static WebDriver driver;
    public static String browser;


    public static void browserSetUp() {
        browser = ConfigProperties.getProperty("browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigProperties.getProperty("url"));
    }

    public static void browserQuit(){
        driver.quit();
    }
}
