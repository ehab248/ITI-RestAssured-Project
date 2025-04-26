package Todos_Tests;

import base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Todos_Pages.Show_All_Tasks_Page;
import com.aventstack.extentreports.ExtentTest;

public class Show_All_Tasks_Test extends Base {
    @Test
    public void testGetTodos() {
        ExtentTest test = extent.createTest("Show All Tasks Test");

        Show_All_Tasks_Page showAllTasksPage = new Show_All_Tasks_Page();
        Response response = showAllTasksPage.getTodos(userId);
        String responseBody = response.asString();
        test.info("Response Body: " + responseBody);

        try {
            Assert.assertTrue(response.getTime() < 2000, "Response time is greater than 2 seconds.");
            test.pass("Response time is under 2000ms");

            Assert.assertTrue(responseBody.contains("Study Appium"));
            test.pass("Expected task content found in all tasks response");
        } catch (AssertionError e) {
            test.fail("Assertion Failed: " + e.getMessage());
            throw e;
        }
    }
}

