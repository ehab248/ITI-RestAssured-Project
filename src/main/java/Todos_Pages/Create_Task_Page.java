package Todos_Pages;

import base.Base;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Create_Task_Page extends Base {
    public Response createTodo(int userId) {
        String requestBody = "{\"task\": \"Study Appium\", \"status\": \"completed\", \"priority\": \"High\"}";
        return given().spec(request).body(requestBody)
                .header("Authorization", "Bearer " + authToken)
                .when().post("/users/" + userId + "/todos")
                .then().assertThat().statusCode(201).extract().response();
    }
}
