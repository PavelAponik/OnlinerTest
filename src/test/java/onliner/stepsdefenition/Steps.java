package onliner.stepsdefenition;

import onliner.pageObjects.CataloguePage;
import onliner.pageObjects.HomePage;
import onliner.pageObjects.TVPage;
import onliner.pageObjects.TVResultsPage;
import framework.base.BaseTest;
import framework.webdriver.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseTest {

    HomePage homePage = new HomePage();
    CataloguePage cataloguePage = new CataloguePage();
    TVPage tvPage = new TVPage();
    TVResultsPage searchResult = new TVResultsPage();

    @Before
    public static void setUp(){
        Browser.setUp();
    }

    @After
    public static void tearDown(){
        Browser.tearDown();
    }

    @Given("^I am on the main page and go to the Catalogue page$")
    public void navigateToCatalogue() {
        homePage.navigateToCategory("Каталог");
    }

    @When("^I select the catalog menu 'Электроника', catalog submenu 'Телевидение и видео' and select 'Телевизоры'$")
    public void selectSubCategoryAndItem() {
        cataloguePage.navigateToCatalogueMenu("Электроника", "Телевидение");
        cataloguePage.navigateToDropdownItem("Телевизоры");
    }

    @And("^I select brand as (.*)$")
    public void selectBrand(String brand) {
        tvPage.selectCheckbox(brand);
    }

    @And("^I set the maximum price as (.*)$")
    public void setMaxPrice(String price) {
        tvPage.setPrice(price);
    }

    @And("^I set the minimum (.*) and maximum (.*) diagonal$")
    public void setMaxAndMinDiagonal(String diagonalMin, String diagonalMax) {
        tvPage.selectCheckbox(diagonalMin);
        tvPage.selectCheckbox(diagonalMax);
    }

    @And("^I set the screen resolution as (.*)$")
    public void setScreenResolution(String resolution) {
        tvPage.selectCheckbox(resolution);
    }

    @Then("^I see the list of found items that matches (.*), (.*) and (.*) diagonal, (.*) and (.*)$")
    public void checkSearchResults(String brand, String diagonalMin, String diagonalMax, String resolution, String price) {
        searchResult.checkSearchList(searchResult.titleResult, brand);
        searchResult.checkSearchList(searchResult.descriptionResult, resolution);
        searchResult.checkDiagonal(searchResult.descriptionResult, diagonalMin, diagonalMax);
        searchResult.checkPrice(searchResult.priceResult, price);
    }

}
