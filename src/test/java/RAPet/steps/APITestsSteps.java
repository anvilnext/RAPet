package RAPet.steps;

import RAPet.methods.APITestsAdditionalMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.api.User;
import models.api.ApiResponse;
import org.junit.Assert;
import services.UserService;
import servicesimpl.UserServiceImplementation;

public class APITestsSteps {
    UserService userService = new UserServiceImplementation();

    @Given("I post next user in PetStore:")
    public void postUserInPetstoreStep(DataTable table) {
        ApiResponse createdUserResponse =
                userService.postUser(APITestsAdditionalMethods.buildUser(table));
        Assert.assertNotNull(createdUserResponse);
    }

    @Given("I put changes to user {string} in PetStore:")
    public void putChangesToUserInPetStore(String username, DataTable table) {
        ApiResponse updatedUserResponse =
                userService.putUser(username, APITestsAdditionalMethods.buildUser(table));
        Assert.assertNotNull(updatedUserResponse);
    }

    @Given("I login as a user {string} with password {string}")
    public void loginAsAUserWithPasswordStep(String login, String password) {
        ApiResponse loggedUserResponse = userService.loginUser(login, password);
        Assert.assertTrue(loggedUserResponse.getMessage().contains("logged in user session"));
    }

    @Then("I get next user {string} in PetStore")
    public void getUserUserInPetstore(String username) {
        User getUserResponse = userService.getUser(username);
        Assert.assertEquals(getUserResponse.getUsername(), username);
    }
}
