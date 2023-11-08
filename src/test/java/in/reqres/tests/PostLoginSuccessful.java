package in.reqres.tests;

import in.reqres.models.LoginBodyModel;
import in.reqres.models.LoginResponseModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.LoginSpec.loginRequestSpec;
import static in.reqres.specs.LoginSpec.loginResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("restApi")
public class PostLoginSuccessful {
    @Test
    void successfulLoginWithPOSTMethodWithSpecsTest() {
        LoginBodyModel loginData = new LoginBodyModel();
        loginData.setEmail("eve.holt@reqres.in");
        loginData.setPassword("cityslicka");

        LoginResponseModel response =
                step("Make login request", () ->
                        given(loginRequestSpec)
                                .body(loginData)
                                .when()
                                .post("/login")
                                .then()
                                .spec(loginResponseSpec)
                                .extract().as(LoginResponseModel.class));
                step("Verify response", () ->
                    assertEquals("QpwL5tke4Pnpja7X4", response.getToken()));
    }
}