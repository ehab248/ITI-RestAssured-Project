package Todos_Tests;

import base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Todos_Pages.Logout_Page;
import com.aventstack.extentreports.ExtentTest;

public class Logout_Test extends Base {
    @Test
    public void testUserLogout() {
        ExtentTest test = extent.createTest("User Logout Test");

        Logout_Page logoutPage = new Logout_Page();
        Response response = logoutPage.logoutUser();
        String responseBody = response.asString();
        test.info("Response Body: " + responseBody);

        try {
            Assert.assertTrue(response.getTime() < 2000, "Response time is greater than 2 seconds.");
            test.pass("Response time is under 2000ms");

            Assert.assertTrue(responseBody.contains("Logged out successfully."));
            test.pass("Correct 'Logged out successfully' message in response");
        } catch (AssertionError e) {
            test.fail("Assertion Failed: " + e.getMessage());
            throw e;
        }
    }
}

