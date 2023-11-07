package in.reqres;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.*;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

public class PostRegistrationSuccessful {
        @Test
    void successfulRegistrationWithPOSTMethod () {
            String registrationData = "{\n" +
                    "    \"email\": \"eve.holt@reqres.in\",\n" +
                    "    \"password\": \"pistol\"\n" +
                    "}";

        given()
                .log().uri()
                .log().body()
                .log().method()
                .contentType(JSON)
                .body(registrationData)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }
}
