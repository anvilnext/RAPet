package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import models.api.ReqUser;

import static config.BaseData.REQRES;
import static io.restassured.RestAssured.given;

public class ReqWrapper {
    private final Cookies cookies;
    private static final String LOGIN_SERVICE = "/api/login";
    private static RequestSpecification LOGIN_SPEC;

    private ReqWrapper(Cookies cookies) {
        this.cookies = cookies;

        LOGIN_SPEC = new RequestSpecBuilder()
                        .addCookies(cookies)
                        .setBaseUri(REQRES)
                        .setBasePath(LOGIN_SERVICE)
                        .setContentType(ContentType.JSON)
                        .build();
    }

    public static ReqWrapper userLogin(String login, String password) {
        Cookies cookies = given()
                .baseUri(REQRES)
                .basePath(LOGIN_SERVICE)
                .contentType(ContentType.JSON)
                .body(new ReqUser(login, password))
                .when().post()
                .getDetailedCookies();

        return new ReqWrapper(cookies);
    }
}
