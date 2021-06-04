package servicesimpl;

import io.restassured.response.Response;
import models.api.DataItem;
import models.api.UserList;
import serenity.SessionVariable;
import services.ReqresService;
import specifications.SpecificationBuilder;
import utils.ReqWrapper;

import java.util.List;

import static io.restassured.RestAssured.given;


public class ReqresServiceImplementation extends BasicServiceImplementation implements ReqresService {

    @Override
    public UserList getUserList(int page) {
        enableLogging();
        return given()
                .spec(SpecificationBuilder.getUserSpec(page))
                .when().get()
                .then().spec(SpecificationBuilder.getResponseSpec())
                .extract().response().as(UserList.class);
    }

    @Override
    public Response getResponseUserList(int page) {
        enableLogging();
        return given()
                .spec(SpecificationBuilder.getUserSpec(page))
                .when().get()
                .then().spec(SpecificationBuilder.getResponseSpec())
                .extract().response();
    }

    @Override
    public List<DataItem> getUserDataFromListOfUsers(int page) {
        enableLogging();
        return given()
                .spec(SpecificationBuilder.getUserSpec(page))
                .when().get()
                .then().spec(SpecificationBuilder.getResponseSpec())
                .extract().jsonPath().getList("data", DataItem.class);
    }

    @Override
    public void loginUser(String login, String password) {
        enableLogging();
        ReqWrapper wrapper = ReqWrapper.userLogin(login, password);
    }

    public enum Variables implements SessionVariable {
        USER_DATA
    }
}
