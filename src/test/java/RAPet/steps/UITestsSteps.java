package RAPet.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.ui.UserSwag;
import org.junit.Assert;
import steps.BaseSteps;

import static config.BaseData.SWAG;
import static config.PagePaths.ADD_TO_CART_BUTTON;
import static config.PagePaths.PASSWORD_INPUT;
import static config.PagePaths.SHOPPING_CART_ITEM_LABEL;
import static config.PagePaths.SHOPPING_CART_LABEL;
import static config.PagePaths.USERNAME_INPUT;
import static java.lang.String.format;
import static steps.BaseSteps.checkPageUrlEnding;
import static steps.BaseSteps.getElement;

public class UITestsSteps {

    @Before()
    public void maximizeDriver() {
        BaseSteps.maximizeDriver();
    }

    @Given("I opened Swag Labs homepage")
    public void openPage() {
        BaseSteps.openPage(SWAG);
    }

    @Given("I login with credentials:")
    public void loginToSite(UserSwag table) {
        getElement(USERNAME_INPUT).sendKeys(table.getUsername());
        getElement(PASSWORD_INPUT).sendKeys(table.getPassword());
        getElement(PASSWORD_INPUT).submit();
    }

    @When("I add {string} to the Shopping Cart")
    public void addToCart(String productName) {
        getElement(format(ADD_TO_CART_BUTTON, productName)).click();
    }

    @When("I open Shopping Cart")
    public void openShoppingCart() {
        getElement(SHOPPING_CART_LABEL).click();
    }

    @Then("I am on page URL ending in {string}")
    public void checkUrlEnding(String ending) {
        Assert.assertTrue(checkPageUrlEnding(ending));
    }

    @Then("{string} should be in the Shopping Cart")
    public void checkProductInCart(String name) {
        Assert.assertTrue(getElement(format(SHOPPING_CART_ITEM_LABEL, name)).isDisplayed());
    }

    @After()
    public void closeDriver() {
        BaseSteps.quitDriver();
    }
}
