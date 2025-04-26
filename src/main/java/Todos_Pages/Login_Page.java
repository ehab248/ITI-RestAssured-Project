package Todos_Pages;

import base.Base;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Login_Page extends Base {
    public Response loginUser(String username, String password) {
        String requestBody = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";
        return given().spec(request).body(requestBody)
                .when().post("/users/login")
                .then().extract().response();
    }
}
