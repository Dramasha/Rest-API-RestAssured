package in.reqres.tests;

import in.reqres.models.UpdateBodyModel;
import in.reqres.models.UpdateResponseModel;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.UpdateSpec.updateRequestSpec;
import static in.reqres.specs.UpdateSpec.updateResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("restApi")
public class PutUpdateSuccessful {
    @Test
    void successfulUpdateWithPUTMethod() {

        UpdateBodyModel updateData = new UpdateBodyModel();
        updateData.setName("morpheus");
        updateData.setJob("zion resident");

        UpdateResponseModel response =
                step("Update user request", () ->
                        given(updateRequestSpec)
                                .body(updateData)
                                .when()
                                .put("/users/2")
                                .then()
                                .spec(updateResponseSpec)
                                .extract().as(UpdateResponseModel.class));
        step("Verify response", () -> {
            assertEquals("morpheus", response.getName());
            assertEquals("zion resident", response.getJob());
        });
    }
}