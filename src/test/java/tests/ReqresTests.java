package tests;

import models.UserRequestBody;
import models.UserGetResponseBody;
import models.UserUpdateResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.UserActionsSpecs.*;

@Tag("reqres_tests")
@DisplayName("reqres.in tests")
public class ReqresTests {

    @DisplayName("Checking the successful creation of a new user")
    @Test
    void createNewUserTest() {
        UserRequestBody userBody = new UserRequestBody();
        userBody.setName("morpheus");
        userBody.setJob("leader");

        UserGetResponseBody response = step("Make request", ()->
        given(userGetRequestSpec)
                .body(userBody)
                .post()
                .then()
                .spec(userGetResponseSpec)
                .extract().as(UserGetResponseBody.class));

        step("Check response", () -> {
            Assertions.assertEquals(userBody.getJob(), response.getJob());
            Assertions.assertEquals(userBody.getName(), response.getName());
        });
    }

    @DisplayName("Checking the unsuccessful creation of a new user with Bad Request error")
    @Test
    void unsuccessfulCreateNewUserTest() {
        step("Make unsuccessful request", ()->
        given(userGetRequestSpec)
                .body(".")
                .post()
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
                .put()
                .then()
                .spec(userUpdateResponseSpec)
                .extract().as(UserUpdateResponseBody.class));

        step("Check response", () -> {
            Assertions.assertEquals(userBody.getJob(), response.getJob());
            Assertions.assertEquals(userBody.getName(), response.getName());
        });
    }

    @DisplayName("Checking the unsuccessful user update with put method and Bad Request error")
    @Test
    void unsuccessfulUpdateUserWithPutTest() {
        step("Make unsuccessful request", ()->
                given(userUpdateRequestSpec)
                        .body(".")
                        .put()
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
                        .patch()
                        .then()
                        .spec(userUpdateResponseSpec)
                        .extract().as(UserUpdateResponseBody.class));

        step("Check response", () -> {
            Assertions.assertEquals(userBody.getJob(), response.getJob());
            Assertions.assertEquals(userBody.getName(), response.getName());
        });
    }

    @DisplayName("Checking the unsuccessful user update with patch method and Bad Request error")
    @Test
    void unsuccessfulUpdateUserWithPatchTest() {
        step("Make unsuccessful request", ()->
                given(userUpdateRequestSpec)
                        .body(".")
                        .patch()
                        .then()
                        .spec(error400ResponseSpec));
    }
}
