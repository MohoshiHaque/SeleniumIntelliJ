package POM_T2_Reports.Test;
import POM_T2_Reports.Base.BaseClassR;
import POM_T2_Reports.Pages.LoginPageClassR;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/* test methods */
public class LoginTestClassR extends BaseClassR {

    private LoginPageClassR loginPage; // class-level variable
    private ExtentReports extent;


    @BeforeMethod
    public void pageSetup() {
        loginPage = new LoginPageClassR(driver);
    }

    @BeforeTest

    public void config(){

        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("Swag Labs Automation Report");
        reporter.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();

        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Mohoshi haque");

    }

    @Test

    public void invalidPassword() throws InterruptedException {

        extent.createTest("InValid Password Test");

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce_Wrong");
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password.");
        extent.flush();

        Thread.sleep(3000);

    }

    @Test
    public void invalidUserName() throws InterruptedException {

        extent.createTest("InValid Username Test");

        loginPage.enterUserName("standard_user_Wrong");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password.");
        extent.flush();
        Thread.sleep(3000);

    }

    @Test
    public void invalidUserNamePassword() throws InterruptedException {

        extent.createTest("InValid Username and Password Test");

        loginPage.enterUserName("standard_user_Wrong");
        loginPage.enterPassword("secret_sauce_Wrong");
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password.");

        extent.flush();
        Thread.sleep(3000);

    }

    @Test
    public void checkUsernameRequired() throws InterruptedException {

        extent.createTest("Username Requried");


        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password.");
        extent.flush();
        Thread.sleep(3000);

    }

    @Test
    public void checkPasswordRequired() throws InterruptedException {

        extent.createTest("Password Requried");

        loginPage.enterUserName("standard_user");
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password.");
        extent.flush();
        Thread.sleep(3000);

    }

    @Test
    public void validLoginTest() throws InterruptedException {

        extent.createTest("Valid Login");

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        extent.flush();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void resetPage() {
        driver.get("https://www.saucedemo.com/");  // go back to login page
    }


}
