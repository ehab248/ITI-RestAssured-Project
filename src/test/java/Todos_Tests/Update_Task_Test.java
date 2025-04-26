package Todos_Tests;

import base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Todos_Pages.Update_Task_Page;
import com.aventstack.extentreports.ExtentTest;

public class Update_Task_Test extends Base {
    @Test
    public void testUpdateTodo() {
        ExtentTest test = extent.createTest("Update Task Test");

        String requestBody = "{\"task\": \"Study Java\", \"status\": \"completed\",\"priority\":\"Medium\"}";
        test.info("Request Body: " + requestBody);

        Update_Task_Page updateTaskPage = new Update_Task_Page();
        Response response = updateTaskPage.updateTodo(requestBody, userId, taskId);
        String responseBody = response.asString();
        test.info("Response Body: " + responseBody);

        try {
            Assert.assertTrue(response.getTime() < 2000, "Response time is greater than 2 seconds.");
            test.pass("Response time is under 2000ms");

            Assert.assertTrue(responseBody.contains("Study Java"));
            test.pass("Updated task found in response");
        } catch (AssertionError e) {
            test.fail("Assertion Failed: " + e.getMessage());
            throw e;
        }
    }
}


