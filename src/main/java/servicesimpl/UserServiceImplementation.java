package servicesimpl;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import models.api.User;
import services.UserService;

import static config.BaseData.URI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class UserServiceImplementation implements UserService {

    private final String SERVICE_URL = "/user";
    private final String LOGIN_URL = "/login";

    public void enableLogging() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Override
    public User getUser(String username) {

        enableLogging();
        return given()
                .baseUri(URI)
                .basePath(SERVICE_URL + "/" + username)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().response().as(User.class);
    }

    @Override
    public void postUser(User user) {

        enableLogging();
        given()
                .baseUri(URI)
                .basePath(SERVICE_URL)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post()
                .then()
                .statusCode(200);
    }

    @Override
    public void putUser(String username, User user) {

        enableLogging();
        given()
                .baseUri(URI)
                .basePath(SERVICE_URL + "/" + username)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .put()
                .then()
                .statusCode(200);
    }

    @Override
    public void loginUser(String login, String password) {

        enableLogging();
        given()
                .baseUri(URI)
                .basePath(SERVICE_URL + LOGIN_URL)
                .param("username", login)
                .param("password", password)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("message", containsString("logged in user session"));
    }
}
