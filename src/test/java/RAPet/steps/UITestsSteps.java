package RAPet.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.ui.UserSwag;
import org.junit.Assert;
import pages.HomePage;
import pages.MainPage;
import pages.ShoppingCartPage;
import steps.BaseSteps;

public class UITestsSteps {

    private HomePage homePage = new HomePage();
    private MainPage mainPage = new MainPage();
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Before()
    public void maximizeDriver() {
        BaseSteps.maximizeDriver();
    }

    @Given("I opened Swag Labs homepage")
    public void openPage() {
        homePage.openHomePage();
    }

    @Given("I login with credentials:")
    public void loginToSite(UserSwag table) {
        homePage.login(table.getUsername(), table.getPassword());
    }

    @When("I add {string} to the Shopping Cart")
    public void addToCart(String productName) {
        mainPage.addToCart(productName);
    }

    @When("I open Shopping Cart")
    public void openShoppingCart() {
        mainPage.openShoppingCart();
    }

    @Then("I am on page URL ending in {string}")
    public void checkUrlEnding(String ending) {
        Assert.assertTrue(mainPage.checkUrlOnMainPage(ending));
    }

    @Then("{string} should be in the Shopping Cart")
    public void checkProductInCart(String name) {
        Assert.assertTrue(shoppingCartPage.checkProductIsInCart(name));
    }

    @After()
    public void closeDriver() {
        BaseSteps.quitDriver();
    }
}
