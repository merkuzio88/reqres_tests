package tests;

import models.UserRequestBody;
import models.UserGetResponseBody;
import models.UserUpdateResponseBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;
import static specs.UserActionsSpecs.*;

@DisplayName("reqres.in tests")
public class ReqresTests extends TestBase {

    @DisplayName("Checking the successful creation of a new user")
    @Test
    void createNewUserTest() {
        UserRequestBody userBody = new UserRequestBody();
        userBody.setName("morpheus");
        userBody.setJob("leader");

        UserGetResponseBody response = step("Make request", ()->
        given(userGetRequestSpec)
                .body(userBody)
                .post("/users")
                .then()
                .spec(userGetResponseSpec)
                .extract().as(UserGetResponseBody.class));

        step("Check response", () -> {
            assertThat(userBody.getJob()).isEqualTo(response.getJob());
            assertThat(userBody.getName()).isEqualTo(response.getName());
        });
    }

    @DisplayName("Checking the unsuccessful creation of a new user with Bad Request error")
    @Test
    void unsuccessfulCreateNewUserTest() {
        step("Make unsuccessful request", ()->
        given(userGetRequestSpec)
                .body(".")
                .post("/users")
                .then()
                .spec(error400ResponseSpec));
    }

    @DisplayName("Checking the successful user update with put method")
    @Test
    void updateUserWithPutTest() {
        UserRequestBody userBody = new UserRequestBody();
        userBody.setName("morpheus");
        userBody.setJob("zion resident");

        UserUpdateResponseBody response = step("Make request", ()->
        given(userUpdateRequestSpec)
                .body(userBody)
                .put("/users/2")
                .then()
                .spec(userUpdateResponseSpec)
                .extract().as(UserUpdateResponseBody.class));

        step("Check response", () -> {
            assertThat(userBody.getJob()).isEqualTo(response.getJob());
            assertThat(userBody.getName()).isEqualTo(response.getName());
        });
    }

    @DisplayName("Checking the unsuccessful user update with put method and Bad Request error")
    @Test
    void unsuccessfulUpdateUserWithPutTest() {
        step("Make unsuccessful request", ()->
                given(userUpdateRequestSpec)
                        .body(".")
                        .put("/users/2")
                        .then()
                        .spec(error400ResponseSpec));
    }

    @DisplayName("Checking the successful user update with patch method")
    @Test
    void updateUserWithPatchTest() {
        UserRequestBody userBody = new UserRequestBody();
        userBody.setName("morpheus");
        userBody.setJob("zion resident");

        UserUpdateResponseBody response = step("Make request", ()->
                given(userUpdateRequestSpec)
                        .body(userBody)
                        .patch("/users/2")
                        .then()
                        .spec(userUpdateResponseSpec)
                        .extract().as(UserUpdateResponseBody.class));

        step("Check response", () -> {
            assertThat(userBody.getJob()).isEqualTo(response.getJob());
            assertThat(userBody.getName()).isEqualTo(response.getName());
        });
    }

    @DisplayName("Checking the unsuccessful user update with patch method and Bad Request error")
    @Test
    void unsuccessfulUpdateUserWithPatchTest() {
        step("Make unsuccessful request", ()->
                given(userUpdateRequestSpec)
                        .body(".")
                        .patch("/users/2")
                        .then()
                        .spec(error400ResponseSpec));
    }
}
