package in.reqres.tests;

import in.reqres.config.ConfigApi;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    static ConfigApi configApi = ConfigFactory.create(ConfigApi.class);

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = configApi.BaseUri();
        RestAssured.basePath = configApi.BasePath();
    }
}