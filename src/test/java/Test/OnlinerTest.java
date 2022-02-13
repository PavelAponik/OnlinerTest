package Test;

import Framework.Browser;
import Framework.ConfigProperties;
import Onliner.MenuNavigation;
import Onliner.CatalogPage;
import Onliner.MainPage;
import Onliner.SearchResultPage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static Framework.Browser.driver;

public class OnlinerTest {
    static MainPage mainPage;
    static CatalogPage catalogPage;
    static MenuNavigation menu;
    static SoftAssert softAssert;
    static ConfigProperties configProperties;
    static SearchResultPage searchResult;

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
        catalogPage.selectCatSubMenu("Телевидение");
        catalogPage.selectDropDownItem("Телевизоры");
        softAssert.assertEquals(driver.getTitle(),"Телевизор купить в Минске");

        menu = new MenuNavigation(driver);
        menu.selectCheckbox(Brand);
        menu.setMaxPrice(MaxPrice);
        menu.selectCheckbox(ScreenDiagonalMin);
        menu.selectCheckbox(ScreenDiagonalMax);
        menu.selectCheckbox(ScreenResolution);
        menu.waitTillResults();
        softAssert.assertEquals(driver.getTitle(),"Товары в каталоге Onlíner");

        searchResult = new SearchResultPage(driver);
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
