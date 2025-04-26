package Todos_Pages;

import base.Base;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Logout_Page extends Base {
    public Response logoutUser() {
        return given().spec(request)
                .header("Authorization", "Bearer " + authToken)
                .when().post("/users/logout")
                .then().assertThat().statusCode(200).extract().response();
    }
}

