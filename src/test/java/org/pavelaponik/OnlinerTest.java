package org.pavelaponik;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.pavelaponik.Browser.driver;
import org.pavelaponik.MainPage;

public class OnlinerTest {
    static MainPage mainPage;
    static CatalogPage catalogPage;
    static SoftAssert softAssert;
    static ConfigProperties configProperties;

    @BeforeTest
    public void setUp(){
        Browser.browserSetUp();
    }

    @Test
    @Parameters ({"Directory", "Brand", "MaxPrice", "ScreenResolution", "ScreenDiagonalMin", "ScreenDiagonalMax"})
    public void TestOnliner(String Directory, String Brand, String MaxPrice,
                            String ScreenResolution, String ScreenDiagonalMin, String ScreenDiagonalMax){
        softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Onliner");

        configProperties = new ConfigProperties();
        mainPage = new MainPage(driver);
        mainPage.navigateTo(Directory);

        catalogPage = new CatalogPage(driver);
        catalogPage.selectCatMenu("Электроника");


    }

    @AfterTest
    public void tearDown(){
        Browser.browserQuit();
    }

}
