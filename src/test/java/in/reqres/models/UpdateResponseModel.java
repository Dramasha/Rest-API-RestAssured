package in.reqres.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class UpdateResponseModel {
    String name, job;
    @JsonIgnoreProperties(ignoreUnknown = true)
    String updatedAt;
}