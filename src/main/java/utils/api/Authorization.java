package utils.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojo.user.User;
import utils.data.JsonObjectHelper;
import utils.data.builder.BuilderUser;

import static io.restassured.RestAssured.given;
import static utils.api.Constants.BASE_URL;

public class Authorization {

    public static String SESSIONID;

    static User user = BuilderUser.defaultUser();

    public static void loginToPetStore() {
        RestAssured.baseURI = BASE_URL;
        String loginJson = JsonObjectHelper.generateJSONForLogin(user);
        SESSIONID =
                given().
                        header("Content-Type", ContentType.JSON).
                        body(loginJson).
                        when().
                        post(APIPathes.login).
                        then().
                        statusCode(200).contentType(ContentType.JSON).
                        extract().
                        path("message").toString().replaceAll("[^0-9]", "");
    }
}
