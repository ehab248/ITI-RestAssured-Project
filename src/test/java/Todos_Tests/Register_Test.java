package Todos_Tests;

import Todos_Pages.Register_Page;
import base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;

import java.util.UUID;

public class Register_Test extends Base {
    @Test
    public void testUserRegistration() {
        ExtentTest test = extent.createTest("Register User Test");

        Register_Page registerPage = new Register_Page();
        username = "BoB" + UUID.randomUUID().toString().substring(0, 5);
        test.info("Generated Username: " + username);

        Response response = registerPage.registerUser(username, "ehab123");
        test.info("Sent POST /users/register");

        String responseBody = response.asString();
        test.info("Response: " + responseBody);

        try {
            Assert.assertTrue(responseBody.contains("User registered successfully"));
            test.pass("Success message exists in response");

            Assert.assertTrue(response.getTime() < 2000);
            test.pass("Response time < 2000ms");

            userId = response.jsonPath().getInt("userId");
            test.pass("User ID: " + userId);

            System.out.println(userId);
        } catch (AssertionError e) {
            test.fail("Assertion Failed: " + e.getMessage());
            throw e;
        }
    }
}

