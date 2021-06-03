package RAPet.steps;

import cucumber.ScenarioContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.api.DataItem;
import models.api.User;
import models.api.UserList;
import org.junit.Assert;
import services.ReqresService;
import services.UserService;
import servicesimpl.ReqresServiceImplementation;
import servicesimpl.UserServiceImplementation;

import java.util.List;

public class APITestsSteps {
    UserService userService = new UserServiceImplementation();
    ReqresService reqresService = new ReqresServiceImplementation();
    ScenarioContext scenarioContext = new ScenarioContext();

    @Given("I post next user in PetStore:")
    public void postUserInPetstoreStep(User table) {
        userService.postUser(table);
    }

    @Given("I put changes to user {string} in PetStore:")
    public void putChangesToUserInPetStore(String username, User table) {
        userService.putUser(username, table);
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

    @Given("I get last name of user on page '{int}', who is '{int}' on page")
    public void getLastNameFromListOfUsersOnPage(int page, int userPageId) {
        UserList userList = reqresService.getUserList(page);
        scenarioContext.setContext(Context.USERNAME, userList.getData().get(userPageId - 1).getLastName());
    }

    @Given("the last name of the user is {string}")
    public void getLastNameOfTheUser(String name) {
        Assert.assertEquals(scenarioContext.getContext(Context.USERNAME), name);
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
