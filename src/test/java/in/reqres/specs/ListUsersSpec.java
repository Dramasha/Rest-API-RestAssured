package in.reqres.specs;

import in.reqres.config.ConfigApi;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;

import static in.reqres.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class ListUsersSpec {
    private static ConfigApi config = ConfigFactory.create(ConfigApi.class);
    public static RequestSpecification listUserRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .log().method()
            .contentType(JSON)
            .baseUri(config.BaseUri())
            .basePath(config.BasePath());

    public static ResponseSpecification listUserResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();
}