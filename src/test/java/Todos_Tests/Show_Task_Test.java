package Todos_Tests;

import base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Todos_Pages.Show_Task_Page;
import com.aventstack.extentreports.ExtentTest;

public class Show_Task_Test extends Base {
    @Test
    public void testGetTodos() {
        ExtentTest test = extent.createTest("Show Task Test");

        Show_Task_Page showTaskPage = new Show_Task_Page();
        Response response = showTaskPage.getTodo(userId, taskId);
        String responseBody = response.asString();
        test.info("Response Body: " + responseBody);

        try {
            Assert.assertTrue(response.getTime() < 2000, "Response time is greater than 2 seconds.");
            test.pass("Response time is under 2000ms");

            Assert.assertTrue(responseBody.contains("Study Appium"));
            test.pass("Task content found in response");
        } catch (AssertionError e) {
            test.fail("Assertion Failed: " + e.getMessage());
            throw e;
        }
    }
}

