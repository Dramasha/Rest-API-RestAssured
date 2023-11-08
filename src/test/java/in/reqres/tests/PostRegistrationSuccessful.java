package in.reqres.tests;

import in.reqres.models.RegistrationBodyModel;
import in.reqres.models.RegistrationResponseModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.RegistrationSpec.registrationRequestSpec;
import static in.reqres.specs.RegistrationSpec.registrationResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("restApi")
public class PostRegistrationSuccessful {
    @Test
    void successfulRegistrationWithPOSTMethod() {
        RegistrationBodyModel registrationData = new RegistrationBodyModel();
        registrationData.setEmail("eve.holt@reqres.in");
        registrationData.setPassword("pistol");

        RegistrationResponseModel response =
                step("Registration user request", () ->
                        given(registrationRequestSpec)
                                .body(registrationData)
                                .when()
                                .post("/register")
                                .then()
                                .spec(registrationResponseSpec)
                                .extract().as(RegistrationResponseModel.class));
        step("Verify response", () -> {
                assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
                assertEquals("4", response.getId());
        });

    }
}
