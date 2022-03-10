package stepsdefenition;

import Onliner.pageObjects.CataloguePage;
import Onliner.pageObjects.HomePage;
import Onliner.pageObjects.TVPage;
import framework.base.BaseTest;
import framework.webdriver.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition extends BaseTest {

    HomePage homePage = new HomePage();
    CataloguePage cataloguePage = new CataloguePage();
    TVPage tvPage = new TVPage();

    @Before
    public static void setUp(){
        Browser.setUp();
    }

    @After
    public static void tearDown(){
        //Browser.tearDown();
    }

    @Given("^I am on the main page and go to the Catalogue page$")
    public void navigateToCatalogue() {
        homePage.navigateToCategory(String.format(HomePage.CATEGORY, "Каталог"));
    }


    @When("^I select the catalog menu 'Электроника', catalog submenu 'Телевидение и видео' and select 'Телевизоры'$")
    public void selectSubCategoryAndItem() {
        cataloguePage.navigateToCatalogueMenu("Электроника", "Телевидение");
        cataloguePage.navigateToDropdownItem("Телевизоры");
    }

    @And("^I select brand as (.*)$")
    public void selectBrand(String brand) {
        tvPage.selectBrand(brand);
    }

    @And("^I set the maximum price as (.*)$")
    public void setMaxPrice(String price) {
        tvPage.setPrice(price);
    }

    @And("^I set the minimum (.*) and maximum (.*) diagonal$")
    public void setMaxAndMinDiagonal(String min, String max) {
    }

    @And("^I set the screen resolution as (.*)$")
    public void setScreenResolution(String resolution) {
    }

    @Then("^I see the list of found items that matches (.*), (.*) and (.*) diagonal, (.*) and (.*)$")
    public void checkSearchResults(String brand, String min, String max, String resolution, String price) {
    }

}
