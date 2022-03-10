package framework.base;


import framework.webdriver.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest extends Browser {

    public WebDriver driver;

    @BeforeClass
    public void before(){
        Browser.setUp();
    }

    @AfterClass
    public void after(){
        Browser.tearDown();
    }

}
