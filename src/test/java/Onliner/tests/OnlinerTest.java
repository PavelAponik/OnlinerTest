package Onliner.tests;

import Onliner.base.BaseTest;
import framework.ConfigProperties;
import Onliner.pages.TVPage;
import Onliner.pages.CataloguePage;
import Onliner.pages.HomePage;
import Onliner.pages.TVResultsPage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class OnlinerTest extends BaseTest{
    static HomePage homePage;
    static CataloguePage cataloguePage;
    static TVPage tvPage;
    static SoftAssert softAssert;
    static ConfigProperties configProperties;
    static TVResultsPage searchResult;

    @Test
    @Parameters({"Brand", "MaxPrice", "ScreenResolution", "ScreenDiagonalMin", "ScreenDiagonalMax"})
    public void TestOnliner(String Brand, String MaxPrice,
                                               String ScreenResolution, String ScreenDiagonalMin, String ScreenDiagonalMax) {
        softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Onliner");

        configProperties = new ConfigProperties();
        homePage = new HomePage(driver);
        homePage.clickOnElement(String.format(HomePage.category, "Каталог"));

        cataloguePage = new CataloguePage(driver);
        cataloguePage.clickOnElement(String.format(CataloguePage.catalogMenu, "Электроника"));
        cataloguePage.navigateTo(String.format(CataloguePage.catalogSubMenu, "Телевидение"));
        cataloguePage.clickOnElement(String.format(CataloguePage.catalogDropDown, "Телевизоры"));
        softAssert.assertEquals(driver.getTitle(), "Телевизор купить в Минске");

        tvPage = new TVPage(driver);
        tvPage.clickOnElement(String.format(TVPage.checkboxLocator, Brand));
        tvPage.setValue(TVPage.maxPriceLocator, MaxPrice);
        tvPage.clickOnElement(String.format(TVPage.checkboxLocator, ScreenDiagonalMin));
        tvPage.clickOnElement(String.format(TVPage.checkboxLocator, ScreenDiagonalMax));
        tvPage.clickOnElement(String.format(TVPage.checkboxLocator, ScreenResolution));
        tvPage.waitTillResults(String.format(TVPage.productTitle));
        softAssert.assertEquals(driver.getTitle(), "Товары в каталоге Onlíner");

        searchResult = new TVResultsPage(driver);
        searchResult.checkSearchList(searchResult.titleResult, Brand);
        searchResult.checkSearchList(searchResult.descriptionResult, ScreenResolution);
        searchResult.checkDiagonal(searchResult.descriptionResult, ScreenDiagonalMin, ScreenDiagonalMax);
        searchResult.checkPrice(searchResult.priceResult, MaxPrice);
        softAssert.assertAll();
    }
}
