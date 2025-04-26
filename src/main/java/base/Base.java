package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Base {

    public static RequestSpecification request;
    public static String authToken;
    public static int taskId;
    public static int userId;
    public static String username;
    protected static ExtentReports extent;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:5000";
        request = RestAssured.given().header("Content-Type", "application/json");

    }
    @BeforeSuite
    public void setupReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/SparkReport.html");
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
