package Todos_Tests;

import base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Todos_Pages.Create_Task_Page;
import com.aventstack.extentreports.ExtentTest;

public class Create_Task_Test extends Base {

    @Test
    public void testCreateTodo() {
        ExtentTest test = extent.createTest("Create Task Test");

        System.out.println(authToken);
        test.info("Using token: " + authToken);

        Create_Task_Page createTaskPage = new Create_Task_Page();
        Response response = createTaskPage.createTodo(userId);

        taskId = response.jsonPath().getInt("id");
        test.info("Task ID: " + taskId);

        try {
            Assert.assertTrue(taskId > 0, "Task ID should be greater than 0");
            test.pass("Task ID is valid: " + taskId);

            Assert.assertTrue(response.getTime() < 2000, "Response time is greater than 2 seconds.");
            test.pass("Response time is under 2000ms");

            String responseBody = response.asString();
            test.info("Response Body: " + responseBody);

            Assert.assertTrue(responseBody.contains("Study Appium"), "Response Body doesn't contain the expected message.");
            test.pass("Correct task content found in response");

        } catch (AssertionError e) {
            test.fail("Assertion Failed: " + e.getMessage());
            throw e;
        }
    }
}
