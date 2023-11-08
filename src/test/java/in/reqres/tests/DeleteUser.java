package in.reqres.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.DeleteSpec.deleteRequestSpec;
import static in.reqres.specs.DeleteSpec.deleteResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

@Tag("restApi")
public class DeleteUser {
    @Test
    void deleteMethod() {
        step("Delete user", () -> {
            given(deleteRequestSpec)
                    .when()
                    .delete("users/2")
                    .then()
                    .spec(deleteResponseSpec);
        });
    }
}