package Todos_Tests;

import base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Todos_Pages.Login_Page;
import com.aventstack.extentreports.ExtentTest;

public class Login_Test extends Base {

    @Test
    public void testUserLogin() {
        ExtentTest test = extent.createTest("Login User Test");

        Login_Page loginPage = new Login_Page();
        System.out.println(username);
        test.info("Logging in with username: " + username);

        Response response = loginPage.loginUser(username, "ehab123");
        String responseBody = response.asString();
        test.info("Response: " + responseBody);

        try {
            Assert.assertTrue(responseBody.contains("Login successful"));
            test.pass("Login success message found");

            Assert.assertTrue(responseBody.contains("token"));
            test.pass("Token found in response");

            authToken = response.jsonPath().getString("token");
            test.pass("Extracted token: " + authToken);
        } catch (AssertionError e) {
            test.fail("Assertion Failed: " + e.getMessage());
            throw e;
        }
    }
}

