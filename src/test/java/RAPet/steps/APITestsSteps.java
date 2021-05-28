package RAPet.steps;

import RAPet.methods.APITestsAdditionalMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.api.DataItem;
import models.api.User;
import org.junit.Assert;
import services.ReqresService;
import services.UserService;
import servicesimpl.ReqresServiceImplementation;
import servicesimpl.UserServiceImplementation;

import java.util.List;

public class APITestsSteps {
    UserService userService = new UserServiceImplementation();
    ReqresService reqresService = new ReqresServiceImplementation();

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

    @Given("I get last name of user on page '{int}', who is '{int}' on page, and the name is {string}")
    public void getLastNameFromListOfUsersOnPage(int page, int userPageId, String name) {
        Assert.assertEquals(reqresService.getLastNameFromListOfUsers(page, userPageId), name);
    }

    @Given("I get data of user on page '{int}', who is '{int}' on page, and last name is {string}")
    public void getUserDataFromListOfUsersOnPage(int page, int userPageId, String lastName) {
        List<DataItem> users = reqresService.getUserDataFromListOfUsers(page, userPageId);
        Assert.assertEquals(users.get(userPageId - 1).getLastName(), lastName);
    }

    @Given("I login as a Reqres user {string} with password {string}")
    public void loginAsAReqresUserWithPasswordStep(String login, String password) {
        reqresService.loginUser(login, password);
    }
}
