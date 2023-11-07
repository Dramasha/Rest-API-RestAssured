package in.reqres;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class PutUpdateSuccessful {
        @Test
    void successfulUpdateWithPUTMethod () {
            String updateData = "{\n" +
                    "    \"name\": \"morpheus\",\n" +
                    "    \"job\": \"zion resident\"\n" +
                    "}";

        given()
                .log().uri()
                .log().body()
                .log().method()
                .contentType(JSON)
                .body(updateData)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"));
    }
}
