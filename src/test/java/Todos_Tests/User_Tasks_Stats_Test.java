package Todos_Tests;

import base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Todos_Pages.User_Tasks_Stats_Page;
import com.aventstack.extentreports.ExtentTest;

public class User_Tasks_Stats_Test extends Base {
    @Test
    public void testGetStats() {
        ExtentTest test = extent.createTest("User Tasks Stats Test");

        User_Tasks_Stats_Page statsPage = new User_Tasks_Stats_Page();
        Response response = statsPage.getStats(userId);
        String responseBody = response.asString();
        test.info("Response Body: " + responseBody);

        try {
            Assert.assertTrue(response.getTime() < 2000, "Response time is greater than 2 seconds.");
            test.pass("Response time is under 2000ms");
        } catch (AssertionError e) {
            test.fail("Assertion Failed: " + e.getMessage());
            throw e;
        }
    }
}

