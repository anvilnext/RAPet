package RAPet.steps;

import cucumber.ScenarioContext;
import enums.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import models.api.DataItem;
import models.api.User;
import models.api.UserList;
import org.junit.Assert;
import services.ReqresService;
import services.UserService;

import java.util.List;

import static servicesimpl.ReqresServiceImplementation.Variables.USER_DATA;

@AllArgsConstructor
@NoArgsConstructor
public class APITestsSteps {
    UserService userService;
    ReqresService reqresService;
    ScenarioContext scenarioContext;

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

    @Then("the last name of the user is {string}")
    public void getLastNameOfTheUser(String name) {
        Assert.assertEquals(scenarioContext.getContext(Context.USERNAME), name);
    }

    @Given("I get data of user on page '{int}', who is '{int}' on page")
    public void getUserDataFromListOfUsersOnPage(int page, int userPageId) {
        List<DataItem> users = reqresService.getUserDataFromListOfUsers(page);
        USER_DATA.set(users.get(userPageId - 1));
    }

    @Then("I check that the last name is {string}")
    public void checkLastNameOfTheUser(String name) {
        DataItem user = USER_DATA.get();
        Assert.assertEquals(user.getLastName(), name);
    }

    @Given("I get response data of users on page '{int}'")
    public void getResponseUserList(int page) {
        Response response = reqresService.getResponseUserList(page);
        scenarioContext.setContext(Context.RESPONSE, response);
    }

    @Then("the email of the '{int}' user is {string}")
    public void getEmailOfTheUser(int userId, String email) {
        Response response = scenarioContext.getContext(Context.RESPONSE);
        UserList actualData = response.as(UserList.class);
        Assert.assertEquals(actualData.getData().get(userId - 1).getEmail(), email);
    }

    @Given("I login as a Reqres user {string} with password {string}")
    public void loginAsAReqresUserWithPasswordStep(String login, String password) {
        reqresService.loginUser(login, password);
    }
}
