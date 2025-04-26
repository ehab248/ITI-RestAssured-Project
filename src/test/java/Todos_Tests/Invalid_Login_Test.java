package Todos_Tests;

import Todos_Pages.Login_Page;
import base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;

public class Invalid_Login_Test extends Base {

    @Test
    public void testInvalidUserLogin() {
        ExtentTest test = extent.createTest("Invalid Login Test");

        Login_Page loginPage = new Login_Page();
        test.info("Trying login with wrong password for user: " + username);

        Response response = loginPage.loginUser(username, "ehab1234");
        String responseBody = response.asString();
        test.info("Response: " + responseBody);

        try {
            Assert.assertTrue(responseBody.contains("Invalid username or password"));
            test.pass("Correct error message received for invalid login");
        } catch (AssertionError e) {
            test.fail("Assertion Failed: " + e.getMessage());
            throw e;
        }
    }
}
