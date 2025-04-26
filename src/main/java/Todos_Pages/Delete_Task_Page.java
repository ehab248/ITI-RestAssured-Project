package Todos_Pages;

import base.Base;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Delete_Task_Page extends Base {
    public Response deleteTodo(int userId, int todoId) {
        return given().spec(request)
                .header("Authorization", "Bearer " + authToken)
                .when().delete("/users/" + userId + "/todos/" + todoId)
                .then().assertThat().statusCode(200).extract().response();
    }
}

