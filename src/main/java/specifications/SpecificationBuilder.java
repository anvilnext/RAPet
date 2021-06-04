package specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static config.BaseData.REQRES;

public class SpecificationBuilder {

    private static final String USERS_SERVICE = "/api/users";

    public static RequestSpecification getUserSpec(int page) {
        return new RequestSpecBuilder()
                .setBaseUri(REQRES)
                .setBasePath(USERS_SERVICE)
                .addQueryParam("page", page)
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}
