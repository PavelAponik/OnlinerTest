package Onliner.tests;

import framework.Browser;
import framework.ConfigProperties;
import Onliner.pages.TVPage;
import Onliner.pages.CataloguePage;
import Onliner.pages.HomePage;
import Onliner.pages.TVResultsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class OnlinerTest {
    static HomePage homePage;
    static CataloguePage cataloguePage;
    static TVPage tvPage;
    static SoftAssert softAssert;
    static ConfigProperties configProperties;
    static TVResultsPage searchResult;
    private Browser browser;

    @BeforeTest
    public void setUp() {
        browser = new Browser(new ChromeDriver(), ConfigProperties.getProperty("browserName"));
    }

    @Test
    @Parameters({"Brand", "MaxPrice", "ScreenResolution", "ScreenDiagonalMin", "ScreenDiagonalMax"})
    public void TestOnliner(String Brand, String MaxPrice,
                            String ScreenResolution, String ScreenDiagonalMin, String ScreenDiagonalMax) {
        softAssert = new SoftAssert();
        softAssert.assertEquals(browser.getDriver().getTitle(), "Onliner");

        configProperties = new ConfigProperties();
        homePage = new HomePage(browser);
        homePage.navigateTo(String.format(HomePage.category,"Каталог"));

        cataloguePage = new CataloguePage(browser.getDriver());
        cataloguePage.selectCatMenu("Электроника");
        cataloguePage.selectCatSubMenu("Телевидение");
        cataloguePage.selectDropDownItem("Телевизоры");
        softAssert.assertEquals(browser.getDriver().getTitle(), "Телевизор купить в Минске");

        tvPage = new TVPage(browser.getDriver());
        tvPage.selectCheckbox(Brand);
        tvPage.setMaxPrice(MaxPrice);
        tvPage.selectCheckbox(ScreenDiagonalMin);
        tvPage.selectCheckbox(ScreenDiagonalMax);
        tvPage.selectCheckbox(ScreenResolution);
        tvPage.waitTillResults();
        softAssert.assertEquals(browser.getDriver().getTitle(), "Товары в каталоге Onlíner");

        searchResult = new TVResultsPage(browser.getDriver());
        searchResult.checkSearchList(searchResult.titleResult, Brand);
        searchResult.checkSearchList(searchResult.descriptionResult, ScreenResolution);
        searchResult.checkDiagonal(searchResult.descriptionResult, ScreenDiagonalMin, ScreenDiagonalMax);
        searchResult.checkPrice(searchResult.priceResult, MaxPrice);
        softAssert.assertAll();
    }

    @AfterTest
    public void tearDown() {
        Browser.browserQuit();
    }

}
