package api;

import models.UserCreateResponseBody;
import models.UserGetResponseBody;
import models.UserRequestBody;
import models.UserUpdateResponseBody;

import static io.restassured.RestAssured.given;
import static specs.UserActionsSpecs.*;

public class UserActionsApi {

    public UserGetResponseBody userGet() {
        return given(userRequestSpec)
                .get("/users/2")
                .then()
                .spec(userResponseSpec200)
                .extract().as(UserGetResponseBody.class);
    }

    public void userDelete() {
        given(userRequestSpec)
                .delete("/users/2")
                .then()
                .spec(userResponseSpec204);
    }

    public UserCreateResponseBody userCreate(UserRequestBody requestBody) {
        return given(userRequestSpec)
                .body(requestBody)
                .post("/users")
                .then()
                .spec(userResponseSpec201)
                .extract().as(UserCreateResponseBody.class);
    }

    public void unsuccessfulUserCreate() {
        given(userRequestSpec)
                .body(".")
                .post("/users")
                .then()
                .spec(userResponseSpec400);
    }

    public UserUpdateResponseBody userPutUpdate(UserRequestBody requestBody) {
        return given(userRequestSpec)
                .body(requestBody)
                .put("/users/2")
                .then()
                .spec(userResponseSpec200)
                .extract().as(UserUpdateResponseBody.class);
    }

    public void unsuccessfulUserPutUpdate() {
        given(userRequestSpec)
                .body(".")
                .put("/users/2")
                .then()
                .spec(userResponseSpec400);
    }

    public UserUpdateResponseBody userPatchUpdate(UserRequestBody requestBody) {
        return given(userRequestSpec)
                .body(requestBody)
                .patch("/users/2")
                .then()
                .spec(userResponseSpec200)
                .extract().as(UserUpdateResponseBody.class);
    }

    public void unsuccessfulUserPatchUpdate() {
        given(userRequestSpec)
                .body(".")
                .patch("/users/2")
                .then()
                .spec(userResponseSpec400);
    }
}
