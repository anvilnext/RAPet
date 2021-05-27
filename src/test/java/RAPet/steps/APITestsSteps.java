package RAPet.steps;

import RAPet.methods.APITestsAdditionalMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.api.User;
import org.junit.Assert;
import services.UserService;
import servicesimpl.UserServiceImplementation;

public class APITestsSteps {
    UserService userService = new UserServiceImplementation();

    @Given("I post next user in PetStore:")
    public void postUserInPetstoreStep(DataTable table) {
        userService.postUser(APITestsAdditionalMethods.buildUser(table));
    }

    @Given("I put changes to user {string} in PetStore:")
    public void putChangesToUserInPetStore(String username, DataTable table) {
        userService.putUser(username, APITestsAdditionalMethods.buildUser(table));
    }

    @Given("I login as a user {string} with password {string}")
    public void loginAsAUserWithPasswordStep(String login, String password) {
        userService.loginUser(login, password);
    }

    @Then("I get next user {string} in PetStore")
    public void getUserUserInPetstore(String username) {
        User getUserResponse = userService.getUser(username);
        Assert.assertEquals(getUserResponse.getUsername(), username);
    }
}
