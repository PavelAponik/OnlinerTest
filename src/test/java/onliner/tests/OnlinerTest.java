package onliner.tests;

import framework.base.BaseTest;
import framework.PropertiesManager;
import onliner.pageObjects.TVPage;
import onliner.pageObjects.CataloguePage;
import onliner.pageObjects.HomePage;
import onliner.pageObjects.TVResultsPage;
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
    @Parameters({"brand", "price", "resolution", "diagonalMin", "diagonalMax"})
    public void TestOnliner(String brand, String price,
                                               String resolution, String diagonalMin, String diagonalMax) {
        softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "onliner");

        propertiesManager = new PropertiesManager();
        homePage = new HomePage();
        homePage.clickOnElement(String.format(HomePage.CATEGORY, "Каталог"));

        cataloguePage = new CataloguePage();
        cataloguePage.clickOnElement(String.format(CataloguePage.CATALOGUE_MENU, "Электроника"));
        cataloguePage.navigateTo(String.format(CataloguePage.CATALOGUE_SUB_MENU, "Телевидение"));
        cataloguePage.navigateToDropDownItem(String.format(CataloguePage.CATALOGUE_DROP_DOWN, "Телевизоры"));
        softAssert.assertEquals(driver.getTitle(), "Телевизор купить в Минске");

        tvPage = new TVPage();
        tvPage.clickOnElement(String.format(TVPage.CHECKBOX_LOCATOR, brand));
        tvPage.setValue(TVPage.MAX_PRICE_LOCATOR, price);
        tvPage.clickOnElement(String.format(TVPage.CHECKBOX_LOCATOR, diagonalMin));
        tvPage.clickOnElement(String.format(TVPage.CHECKBOX_LOCATOR, diagonalMax));
        tvPage.clickOnElement(String.format(TVPage.CHECKBOX_LOCATOR, resolution));
        tvPage.waitTillResults(String.format(TVPage.PRODUCT_TITLE));
        softAssert.assertEquals(driver.getTitle(), "Товары в каталоге Onlíner");

        searchResult = new TVResultsPage();
        searchResult.checkSearchList(searchResult.titleResult, brand);
        searchResult.checkSearchList(searchResult.descriptionResult, resolution);
        searchResult.checkDiagonal(searchResult.descriptionResult, diagonalMin, diagonalMax);
        searchResult.checkPrice(searchResult.priceResult, price);
        softAssert.assertAll();
    }
}
