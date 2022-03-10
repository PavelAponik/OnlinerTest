package stepsdefenition;

import Onliner.pageObjects.CataloguePage;
import Onliner.pageObjects.HomePage;
import Onliner.pageObjects.TVPage;
import Onliner.pageObjects.TVResultsPage;
import framework.PropertiesManager;
import framework.base.BasePage;
import framework.webdriver.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class StepsDefinition extends BasePage {

    static HomePage homePage;
    static CataloguePage cataloguePage;
    static TVPage tvPage;
    static SoftAssert softAssert = new SoftAssert();;
    static PropertiesManager propertiesManager = new PropertiesManager();;
    static TVResultsPage searchResult;

    public StepsDefinition(WebDriver driver) {
        super(driver);
    }

    @Given("I am on the main page and go to the Catalogue page")
    public void navigateToCatalogue() {
        homePage = new HomePage(driver);
        softAssert.assertEquals(driver.getTitle(), "Onliner");
        homePage.clickOnElement(String.format(HomePage.category, "Каталог"));
    }


    @When("I select the catalog menu 'Электроника', catalog submenu 'Телевидение и видео' and select 'Телевизоры'")
    public void selectSubCategoryAndItem() {
        CataloguePage cataloguePage = new CataloguePage(driver);
        //cataloguePage.

    }

    @And("I select brand as {string}")
    public void selectBrand(String brand) {
    }

    @And("I set the maximum price as {string}")
    public void setMaxPrice(String price) {
    }

    @And("I set the minimum {string} and maximum {string} diagonal")
    public void setMaxAndMinDiagonal(String min, String max) {
    }

    @And("I set the screen resolution as {string}")
    public void setScreenResolution(String resolution) {
    }

    @Then("I see the list of found items that matches {string}, {string} and {string} diagonal, {string} and {string}")
    public void checkSearchResults(String brand, String min, String max, String resolution, String price) {
    }

}
