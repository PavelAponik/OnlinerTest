package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition {

    @Given("I go to the {string}")
    public void iGoToThe(String arg0) {
    }

    @When("I open the {string} page")
    public void iOpenThePage(String arg0) {
    }

    @And("I select the catalog menu {string}, catalog submenu {string} and select {string}")
    public void iSelectTheCatalogMenuCatalogSubmenuAndSelect(String arg0, String arg1, String arg2) {
    }

    @And("I select brand as {string}")
    public void iSelectBrandAs(String arg0) {
    }

    @And("I set the maximum price as {string}")
    public void iSetTheMaximumPriceAs(String arg0) {
    }

    @And("I set the minimum {string} and maximum {string} diagonal")
    public void iSetTheMinimumAndMaximumDiagonal(String arg0, String arg1) {
    }

    @And("I set the screen resolution as {string}")
    public void iSetTheScreenResolutionAs(String arg0) {
    }

    @Then("I see the list of found items that matches {string}, {string}, {string} and {string} diagonal, {string} and {string}")
    public void iSeeTheListOfFoundItemsThatMatchesAndDiagonalAnd(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
    }

}
