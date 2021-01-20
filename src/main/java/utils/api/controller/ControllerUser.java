package utils.api.controller;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import pojo.user.User;

import static base.BaseTest.requestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static utils.api.Constants.USER_ENDPOINT;

public class ControllerUser {
    public ValidatableResponse addNewUser(User user) {
        return given(requestSpecification)
                .body(user)
                .post(USER_ENDPOINT)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public void deleteUser(User user) {
        given(requestSpecification)
                .pathParam("username", user.getUsername())
                .delete(USER_ENDPOINT + "/{username}")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    public void verifyUserDeleted(User user) {
        given(requestSpecification)
                .pathParam("username", user.getId())
                .get(USER_ENDPOINT + "/{username}")
                .then()
                .body(containsString("User not found"))
                .statusCode(404)
                .contentType(ContentType.JSON);
    }

    public User getUser(User user) {
        return given(requestSpecification)
                .pathParam("username", user.getId())
                .get(USER_ENDPOINT + "/{username}").as(User.class);
    }

    public User updatePet(User user) {
        return given(requestSpecification)
                .body(user)
                .put(USER_ENDPOINT + "/{username}").as(User.class);
    }
}
