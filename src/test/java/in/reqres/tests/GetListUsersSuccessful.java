package in.reqres.tests;

import in.reqres.models.ListUsersBodyModel;
import in.reqres.models.ListUsersResponseModel;
import in.reqres.models.ListUsersSupportInfoModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static in.reqres.specs.ListUsersSpec.listUserRequestSpec;
import static in.reqres.specs.ListUsersSpec.listUserResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("restApi")
public class GetListUsersSuccessful {
    @Test
    void successfulGetListUsersWithGetMethod() {

        ListUsersResponseModel listUsersResponseModel =
                step("Get list users", () ->
                            given(listUserRequestSpec)
                                    .when()
                                    .get("/users?page=2")
                                    .then()
                                    .spec(listUserResponseSpec)
                                    .extract().as(ListUsersResponseModel.class));

        step("Check users", () -> {
            assertThat(listUsersResponseModel.getPage()).isEqualTo(2);
            assertThat(listUsersResponseModel.getPerPage()).isEqualTo(6);
            assertThat(listUsersResponseModel.getTotal()).isEqualTo(12);
            assertThat(listUsersResponseModel.getTotalPages()).isEqualTo(2);
        });

        step("Check second users из списка", () -> {
            List<ListUsersBodyModel> data = listUsersResponseModel.getData();
            assertThat(data.get(1).getId()).isEqualTo(8);
            assertThat(data.get(1).getEmail()).isEqualTo("lindsay.ferguson@reqres.in");
            assertThat(data.get(1).getFirstName()).isEqualTo("Lindsay");
            assertThat(data.get(1).getLastName()).isEqualTo("Ferguson");
            assertThat(data.get(1).getAvatar()).isEqualTo("https://reqres.in/img/faces/8-image.jpg");
        });

        step("Check info about Support", () -> {
            ListUsersSupportInfoModel support = listUsersResponseModel.getSupport();
            assertThat(support.getUrl()).isEqualTo("https://reqres.in/#support-heading");
            assertThat(support.getText()).isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");
        });
    }
}