import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@DisplayName("reqres.in tests")
public class ReqresTests {

    private final String newUserData = "{\"name\": \"morpheus\", \"job\": \"leader\"}",
    updateUserData = "{\"name\": \"morpheus\", \"job\": \"zion resident\"}",
    incorrectUserData = "{\"name\": \"morpheus\" \"job\": \"zion resident\"}";

    @DisplayName("Checking the successful creation of a new user")
    @Test
    void createNewUserTest() {
        given()
                .body(newUserData)
                .contentType(ContentType.JSON)
                .log().all()
                .post("https://reqres.in/api/users/")
                .then()
                .log().all()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"));
    }

    @DisplayName("Checking the unsuccessful creation of a new user with Unsupported Media Type error")
    @Test
    void unsuccessfulCreateNewUserTest() {
        given()
                .log().all()
                .post("https://reqres.in/api/users/")
                .then()
                .log().all()
                .statusCode(415);
    }

    @DisplayName("Checking the successful user update with put method")
    @Test
    void updateUserWithPutTest() {
        given()
                .body(updateUserData)
                .contentType(ContentType.JSON)
                .log().all()
                .put("https://reqres.in/api/users/")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"));
    }

    @DisplayName("Checking the unsuccessful user update with put method and Bad Request error")
    @Test
    void unsuccessfulUpdateUserWithPutTest() {
        given()
                .body(incorrectUserData)
                .contentType(ContentType.JSON)
                .log().all()
                .put("https://reqres.in/api/users/")
                .then()
                .log().all()
                .statusCode(400);
    }

    @DisplayName("Checking the successful user update with patch method")
    @Test
    void updateUserWithPatchTest() {
        given()
                .body(updateUserData)
                .contentType(ContentType.JSON)
                .log().all()
                .patch("https://reqres.in/api/users/")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"));
    }

    @DisplayName("Checking the unsuccessful user update with patch method and Bad Request error")
    @Test
    void unsuccessfulUpdateUserWithPatchTest() {
        given()
                .body(incorrectUserData)
                .contentType(ContentType.JSON)
                .log().all()
                .put("https://reqres.in/api/users/")
                .then()
                .log().all()
                .statusCode(400);
    }
}
