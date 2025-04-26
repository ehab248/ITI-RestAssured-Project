package Todos_Pages;

import base.Base;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Show_Task_Page extends Base {
    public Response getTodo(int userId, int todoId) {
        return given().spec(request)
                .header("Authorization", "Bearer " + authToken)
                .when().get("/users/" + userId + "/todos/" + todoId);
    }
}

