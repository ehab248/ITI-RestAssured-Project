package Todos_Tests;

import base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Todos_Pages.Delete_Task_Page;
import com.aventstack.extentreports.ExtentTest;

public class Delete_Task_Test extends Base {
    @Test
    public void testDeleteTodo() {
        ExtentTest test = extent.createTest("Delete Task Test");

        Delete_Task_Page deleteTaskPage = new Delete_Task_Page();
        Response response = deleteTaskPage.deleteTodo(userId, 1);
        String responseBody = response.asString();
        test.info("Response Body: " + responseBody);

        try {
            Assert.assertTrue(responseBody.contains("Task deleted successfully."));
            test.pass("Deletion confirmation found in response");

            Assert.assertTrue(response.getTime() < 2000, "Response time is greater than 2 seconds.");
            test.pass("Response time is under 2000ms");
        } catch (AssertionError e) {
            test.fail("Assertion Failed: " + e.getMessage());
            throw e;
        }
    }
}

