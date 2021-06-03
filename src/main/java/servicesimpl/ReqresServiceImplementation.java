package servicesimpl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import models.api.DataItem;
import models.api.UserList;
import services.ReqresService;
import utils.ReqWrapper;

import java.util.List;

import static config.BaseData.REQRES;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class ReqresServiceImplementation extends BasicServiceImplementation implements ReqresService {

    private final String USERS_SERVICE = "/api/users";

    private final RequestSpecification USER_SPEC =
            new RequestSpecBuilder()
            .setBaseUri(REQRES)
            .setBasePath(USERS_SERVICE)
            .build();

    @Override
    public UserList getUserList(int page) {
        enableLogging();
        return given()
                .spec(USER_SPEC)
                .param("page", page)
                .when().get()
                .then()
                .statusCode(200)
                .extract().response().as(UserList.class);
    }

    @Override
    public List<DataItem> getUserDataFromListOfUsers(int page, int idOnPage) {
        enableLogging();
        return given()
                .spec(USER_SPEC)
                .param("page", page)
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data", DataItem.class);
    }

    @Override
    public void loginUser(String login, String password) {
        enableLogging();
        ReqWrapper wrapper = ReqWrapper.userLogin(login, password);
    }
}
