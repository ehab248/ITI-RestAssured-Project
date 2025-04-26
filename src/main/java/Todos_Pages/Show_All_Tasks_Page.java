package Todos_Pages;

import base.Base;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Show_All_Tasks_Page extends Base {
    public Response getTodos(int userId) {
        return given().spec(request)
                .header("Authorization", "Bearer " + authToken)
                .when().get("/users/" + userId + "/todos");
    }
}
