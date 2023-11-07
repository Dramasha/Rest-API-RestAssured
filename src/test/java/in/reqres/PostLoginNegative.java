package in.reqres;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class PostLoginNegative {
        @Test
    void negativeLoginWithPOSTMethod () {
            String loginData = "{\n" +
                    "    \"email\": \"peter@klaven\"\n" +
                    "}";

        given()
                .log().uri()
                .log().body()
                .log().method()
                .contentType(JSON)
                .body(loginData)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }
}
