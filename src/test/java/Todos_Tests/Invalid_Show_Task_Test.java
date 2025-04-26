package Todos_Tests;

import Todos_Pages.Show_Task_Page;
import base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;

public class Invalid_Show_Task_Test extends Base {
    @Test
    public void testInvalidGetTodos() {
        ExtentTest test = extent.createTest("Invalid Show Task Test");

        Show_Task_Page showTaskPage = new Show_Task_Page();
        Response response = showTaskPage.getTodo(userId, 1);
        String responseBody = response.asString();
        test.info("Response Body: " + responseBody);

        try {
            Assert.assertTrue(response.getTime() < 2000, "Response time is greater than 2 seconds.");
            test.pass("Response time is under 2000ms");

            Assert.assertTrue(responseBody.contains("Task not found."));
            test.pass("Correct 'Task not found' message in response");
        } catch (AssertionError e) {
            test.fail("Assertion Failed: " + e.getMessage());
            throw e;
        }
    }
}
