package ExcelData.Test;

import ExcelData.Base.BaseClass;
import ExcelData.Pages.LoginPageClass;
import ExcelData.Utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTestClass extends BaseClass {

    private LoginPageClass loginPage; // class-level variable
    private static final String EXCEL_PATH = "C:\\Users\\USER\\IdeaProjects\\TestData\\LoginTestData.xlsx";

    @BeforeMethod
    public void pageSetup() {
        loginPage = new LoginPageClass(driver);
    }

    @Test

    public void invalidPassword() throws InterruptedException, IOException {

        String username = ExcelUtils.getCell(EXCEL_PATH, "Sheet1", 1, 0); // row 1, col 0 = username
        String password = ExcelUtils.getCell(EXCEL_PATH, "Sheet1", 1, 1); // row 1, col 1 = password

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password.");


    }

    @Test
    public void invalidUserName() throws InterruptedException, IOException {

        String username = ExcelUtils.getCell(EXCEL_PATH, "Sheet1", 2, 0); // row 1, col 0 = username
        String password = ExcelUtils.getCell(EXCEL_PATH, "Sheet1", 2, 1); // row 1, col 1 = password

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        System.out.println(actualErrorMessage);
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password.");


    }

    @Test
    public void invalidUserNamePassword() throws InterruptedException, IOException {

        String username = ExcelUtils.getCell(EXCEL_PATH, "Sheet1", 3, 0); // row 1, col 0 = username
        String password = ExcelUtils.getCell(EXCEL_PATH, "Sheet1", 3, 1); // row 1, col 1 = password

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password & username.");

    }

    @Test
    public void checkUsernameRequired() throws InterruptedException, IOException {


        String password = ExcelUtils.getCell(EXCEL_PATH, "Sheet1", 4, 1); // row 1, col 1 = password
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for Username required");
        Thread.sleep(3000);

    }

    @Test
    public void checkPasswordRequired() throws InterruptedException, IOException {

        String username = ExcelUtils.getCell(EXCEL_PATH, "Sheet1", 5, 0); // row 1, col 0 = username
        loginPage.enterUserName(username);
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for Password required.");

    }

    @AfterMethod
    public void resetPage() {
        driver.get("https://www.saucedemo.com/");  // go back to login page
    }


}
