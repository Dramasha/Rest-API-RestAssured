package in.reqres.tests;

import in.reqres.models.LoginNegativeBodyModel;
import in.reqres.models.LoginNegativeResponseModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.LoginSpec.loginNegativeRequestSpec;
import static in.reqres.specs.LoginSpec.loginNegativeResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("restApi")
public class PostLoginNegative {
    @Test
    void negativeLoginWithPOSTMethod() {
        LoginNegativeBodyModel loginNegativeData = new LoginNegativeBodyModel();
        loginNegativeData.setEmail("peter@klaven");

        LoginNegativeResponseModel response =
                step("Make login request", () ->
                        given(loginNegativeRequestSpec)
                                .body(loginNegativeData)
                                .when()
                                .post("/login")
                                .then()
                                .spec(loginNegativeResponseSpec)
                                .extract().as(LoginNegativeResponseModel.class));
                step("Verify response", () ->
                    assertEquals("Missing password", response.getError()));
    }
}