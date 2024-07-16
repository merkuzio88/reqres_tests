package tests;

import api.UserActionsApi;
import models.UserGetResponseBody;
import models.UserRequestBody;
import models.UserCreateResponseBody;
import models.UserUpdateResponseBody;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("reqres.in tests")
public class ReqresTests extends TestBase {

    UserActionsApi userActionsApi = new UserActionsApi();

    @DisplayName("Checking the successful getting of a user")
    @Test
    void getUserTest() {
        UserGetResponseBody response = step("Make request", ()->
                userActionsApi.userGet());

        SoftAssertions softAssertions = new SoftAssertions();
        step("Check response", () -> {
            softAssertions.assertThat("Janet").isEqualTo(response.getData().first_name);
            softAssertions.assertThat("Weaver").isEqualTo(response.getData().last_name);
        });
        softAssertions.assertAll();
    }

    @DisplayName("Checking the successful deleting of a user")
    @Test
    void deleteUserTest() {
        step("Make successful delete request", ()->
                userActionsApi.userDelete());
    }

    @DisplayName("Checking the successful creation of a new user")
    @Test
    void createNewUserTest() {
        UserRequestBody userBody = new UserRequestBody();
        userBody.setName("morpheus");
        userBody.setJob("leader");

        UserCreateResponseBody response = step("Make request", ()->
                userActionsApi.userCreate(userBody));

        SoftAssertions softAssertions = new SoftAssertions();
        step("Check response", () -> {
            softAssertions.assertThat(userBody.getJob()).isEqualTo(response.getJob());
            softAssertions.assertThat(userBody.getName()).isEqualTo(response.getName());
        });
        softAssertions.assertAll();
    }

    @DisplayName("Checking the unsuccessful creation of a new user with Bad Request error")
    @Test
    void unsuccessfulCreateNewUserTest() {
        step("Make unsuccessful post request", ()->
                userActionsApi.unsuccessfulUserCreate());
    }

    @DisplayName("Checking the successful user update with put method")
    @Test
    void updateUserWithPutTest() {
        UserRequestBody userBody = new UserRequestBody();
        userBody.setName("morpheus");
        userBody.setJob("zion resident");

        UserUpdateResponseBody response = step("Make request", ()->
                userActionsApi.userPutUpdate(userBody));

        SoftAssertions softAssertions = new SoftAssertions();
        step("Check response", () -> {
            softAssertions.assertThat(userBody.getJob()).isEqualTo(response.getJob());
            softAssertions.assertThat(userBody.getName()).isEqualTo(response.getName());
        });
        softAssertions.assertAll();
    }

    @DisplayName("Checking the unsuccessful user update with put method and Bad Request error")
    @Test
    void unsuccessfulUpdateUserWithPutTest() {
        step("Make unsuccessful put request", ()->
                userActionsApi.unsuccessfulUserPutUpdate());
    }

    @DisplayName("Checking the successful user update with patch method")
    @Test
    void updateUserWithPatchTest() {
        UserRequestBody userBody = new UserRequestBody();
        userBody.setName("morpheus");
        userBody.setJob("zion resident");

        UserUpdateResponseBody response = step("Make request", ()->
                userActionsApi.userPatchUpdate(userBody));

        SoftAssertions softAssertions = new SoftAssertions();
        step("Check response", () -> {
            softAssertions.assertThat(userBody.getJob()).isEqualTo(response.getJob());
            softAssertions.assertThat(userBody.getName()).isEqualTo(response.getName());
        });
        softAssertions.assertAll();
    }

    @DisplayName("Checking the unsuccessful user update with patch method and Bad Request error")
    @Test
    void unsuccessfulUpdateUserWithPatchTest() {
        step("Make unsuccessful patch request", ()->
                userActionsApi.unsuccessfulUserPatchUpdate());
    }
}
