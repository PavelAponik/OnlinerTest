package framework.base;


import framework.webdriver.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest extends Browser {

    @BeforeClass
    public void before(){
        setUp();
    }

    @AfterClass
    public void after(){
        tearDown();
    }

}
