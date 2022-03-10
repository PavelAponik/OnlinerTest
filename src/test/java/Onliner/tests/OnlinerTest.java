package Onliner.tests;

import framework.base.BaseTest;
import framework.PropertiesManager;
import Onliner.pageObjects.TVPage;
import Onliner.pageObjects.CataloguePage;
import Onliner.pageObjects.HomePage;
import Onliner.pageObjects.TVResultsPage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class OnlinerTest extends BaseTest{
    static HomePage homePage;
    static CataloguePage cataloguePage;
    static TVPage tvPage;
    static SoftAssert softAssert;
    static PropertiesManager propertiesManager;
    static TVResultsPage searchResult;

    @Test
    @Parameters({"Brand", "MaxPrice", "ScreenResolution", "ScreenDiagonalMin", "ScreenDiagonalMax"})
    public void TestOnliner(String Brand, String MaxPrice,
                                               String ScreenResolution, String ScreenDiagonalMin, String ScreenDiagonalMax) {
        softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Onliner");

        propertiesManager = new PropertiesManager();
        homePage = new HomePage(driver);
        homePage.clickOnElement(String.format(HomePage.category, "Каталог"));

        cataloguePage = new CataloguePage(driver);
        cataloguePage.clickOnElement(String.format(CataloguePage.catalogMenu, "Электроника"));
        cataloguePage.navigateTo(String.format(CataloguePage.catalogSubMenu, "Телевидение"));
        cataloguePage.navigateToDropDownItem(String.format(CataloguePage.catalogDropDown, "Телевизоры"));
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
