package Onliner.tests;

import Framework.Browser;
import Framework.ConfigProperties;
import Onliner.pages.TVPage;
import Onliner.pages.CataloguePage;
import Onliner.pages.HomePage;
import Onliner.pages.TVResultsPage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static Framework.Browser.driver;

public class OnlinerTest {
    static HomePage homePage;
    static CataloguePage cataloguePage;
    static TVPage tvPage;
    static SoftAssert softAssert;
    static ConfigProperties configProperties;
    static TVResultsPage searchResult;

    @BeforeTest
    public void setUp(){
        Browser.browserSetUp();
    }

    @Test
    @Parameters ({"Brand", "MaxPrice", "ScreenResolution", "ScreenDiagonalMin", "ScreenDiagonalMax"})
    public void TestOnliner(String Brand, String MaxPrice,
                            String ScreenResolution, String ScreenDiagonalMin, String ScreenDiagonalMax){
        softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Onliner");

        configProperties = new ConfigProperties();
        homePage = new HomePage(driver);
        homePage.navigateTo("Каталог");

        cataloguePage = new CataloguePage(driver);
        cataloguePage.selectCatMenu("Электроника");
        cataloguePage.selectCatSubMenu("Телевидение");
        cataloguePage.selectDropDownItem("Телевизоры");
        softAssert.assertEquals(driver.getTitle(),"Телевизор купить в Минске");

        tvPage = new TVPage(driver);
        tvPage.selectCheckbox(Brand);
        tvPage.setMaxPrice(MaxPrice);
        tvPage.selectCheckbox(ScreenDiagonalMin);
        tvPage.selectCheckbox(ScreenDiagonalMax);
        tvPage.selectCheckbox(ScreenResolution);
        tvPage.waitTillResults();
        softAssert.assertEquals(driver.getTitle(),"Товары в каталоге Onlíner");

        searchResult = new TVResultsPage(driver);
        searchResult.checkSearchList(searchResult.titleResult, Brand);
        searchResult.checkSearchList(searchResult.descriptionResult, ScreenResolution);
        searchResult.checkDiagonal(searchResult.descriptionResult, ScreenDiagonalMin, ScreenDiagonalMax);
        searchResult.checkPrice(searchResult.priceResult, MaxPrice);
    }

    @AfterTest
    public void tearDown(){
        softAssert.assertAll();
        Browser.browserQuit();
    }

}
