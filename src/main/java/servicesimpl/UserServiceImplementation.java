package servicesimpl;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.api.User;
import models.api.ApiResponse;
import services.UserService;

import static config.BaseData.URI;
import static io.restassured.RestAssured.given;

public class UserServiceImplementation implements UserService {

    private String SERVICE_URL = "/user";
    private String LOGIN_URL = "/login";

    public void enableLogging() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Override
    public User getUser(String username) {

        enableLogging();
        String url = URI + SERVICE_URL + "/" + username;

        Response r = given()
                .get(url);

        if (r.statusCode() == 200) {
            return r.as(User.class);
        }
        else return null;
    }

    @Override
    public ApiResponse postUser(User user) {

        enableLogging();
        String url = URI + SERVICE_URL;

        Response r = given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(url);

        if (r.statusCode() == 200) {
            return r.as(ApiResponse.class);
        }
        else return null;
    }

    @Override
    public ApiResponse putUser(String username, User user) {

        enableLogging();
        String url = URI + SERVICE_URL + "/" + username;

        Response r = given()
                .contentType(ContentType.JSON)
                .body(user)
                .put(url);

        if (r.statusCode() == 200) {
            return r.as(ApiResponse.class);
        }
        else return null;
    }

    @Override
    public ApiResponse loginUser(String login, String password) {

        enableLogging();
        String url = URI + SERVICE_URL + LOGIN_URL;

        Response r = given()
                .queryParam("username", login)
                .queryParam("password", password)
                .get(url);

        if (r.statusCode() == 200) {
            return r.as(ApiResponse.class);
        }
        else return null;
    }
}
