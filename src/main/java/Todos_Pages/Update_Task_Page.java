package Todos_Pages;

import base.Base;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Update_Task_Page extends Base {
    public Response updateTodo(String requestBody, int userId, int todoId) {
        return given().spec(request)
                .body(requestBody)
                .header("Authorization", "Bearer " + authToken)
                .when().put("/users/" + userId + "/todos/" + todoId)
                .then().assertThat().statusCode(200).extract().response();
    }
}
