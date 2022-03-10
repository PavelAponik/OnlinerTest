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
        homePage = new HomePage();
        homePage.clickOnElement(String.format(HomePage.CATEGORY, "Каталог"));

        cataloguePage = new CataloguePage();
        cataloguePage.clickOnElement(String.format(CataloguePage.CATALOGUE_MENU, "Электроника"));
        cataloguePage.navigateTo(String.format(CataloguePage.CATALOGUE_SUB_MENU, "Телевидение"));
        cataloguePage.navigateToDropDownItem(String.format(CataloguePage.CATALOGUE_DROP_DOWN, "Телевизоры"));
        softAssert.assertEquals(driver.getTitle(), "Телевизор купить в Минске");

        tvPage = new TVPage();
        tvPage.clickOnElement(String.format(TVPage.CHECKBOX_LOCATOR, Brand));
        tvPage.setValue(TVPage.MAX_PRICE_LOCATOR, MaxPrice);
        tvPage.clickOnElement(String.format(TVPage.CHECKBOX_LOCATOR, ScreenDiagonalMin));
        tvPage.clickOnElement(String.format(TVPage.CHECKBOX_LOCATOR, ScreenDiagonalMax));
        tvPage.clickOnElement(String.format(TVPage.CHECKBOX_LOCATOR, ScreenResolution));
        tvPage.waitTillResults(String.format(TVPage.PRODUCT_TITLE));
        softAssert.assertEquals(driver.getTitle(), "Товары в каталоге Onlíner");

        searchResult = new TVResultsPage();
        searchResult.checkSearchList(searchResult.titleResult, Brand);
        searchResult.checkSearchList(searchResult.descriptionResult, ScreenResolution);
        searchResult.checkDiagonal(searchResult.descriptionResult, ScreenDiagonalMin, ScreenDiagonalMax);
        searchResult.checkPrice(searchResult.priceResult, MaxPrice);
        softAssert.assertAll();
    }
}
