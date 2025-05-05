package Todos_Pages;

import base.Base;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Register_Page  extends Base {


        public Response registerUser(String username, String password) {
            String requestBody = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";
            return given().spec(request)
                    .body(requestBody)
                    .when().post("/users/register")
                    .then().extract().response();
        }


    }

