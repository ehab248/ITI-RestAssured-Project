package Todos_Tests;

import Todos_Pages.User_Tasks_Stats_Page;
import base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;

public class Invalid_User_Tasks_Stats_Test extends Base {
    @Test
    public void testInvalidGetStats() {
        ExtentTest test = extent.createTest("Invalid User Tasks Stats Test");

        User_Tasks_Stats_Page statsPage = new User_Tasks_Stats_Page();
        Response response = statsPage.getStats(userId);
        String responseBody = response.asString();
        test.info("Response Body: " + responseBody);

        try {
            Assert.assertTrue(response.getTime() < 2000, "Response time is greater than 2 seconds.");
            test.pass("Response time is under 2000ms");

            Assert.assertTrue(responseBody.contains("Invalid token. Please log in again."));
            test.pass("Correct 'Invalid token' message in response");
        } catch (AssertionError e) {
            test.fail("Assertion Failed: " + e.getMessage());
            throw e;
        }
    }
}

