package Todos_Pages;

import base.Base;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class User_Tasks_Stats_Page extends Base {
    public Response getStats(int userId) {
        return given().spec(request)
                .header("Authorization", "Bearer " + authToken)
                .when().get("/users/" + userId + "/todos/stats");
    }
}
