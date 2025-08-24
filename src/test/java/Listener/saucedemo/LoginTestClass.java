package Listener.saucedemo;

import POM_T1.Base.BaseClass;
import POM_T1.Pages.LoginPageClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.saucedemo.CustomListener.class)
public class LoginTestClass extends BaseClass {

    private POM_T1.Pages.LoginPageClass loginPage; // class-level variable

    @BeforeMethod
    public void pageSetup() {
        loginPage = new LoginPageClass(driver);
    }

    @Test

    public void invalidPassword() throws InterruptedException {

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce_Wrong");
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface:: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password.");
        Thread.sleep(3000);

    }

    @Test
    public void invalidUserName() throws InterruptedException {

        loginPage.enterUserName("standard_user_Wrong");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password.");
        Thread.sleep(3000);

    }

    @Test
    public void invalidUserNamePassword() throws InterruptedException {

        loginPage.enterUserName("standard_user_Wrong");
        loginPage.enterPassword("secret_sauce_Wrong");
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password.");
        Thread.sleep(3000);

    }

    @Test
    public void checkUsernameRequired() throws InterruptedException {


        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password.");
        Thread.sleep(3000);

    }

    @Test
    public void checkPasswordRequired() throws InterruptedException {


        loginPage.enterUserName("standard_user");
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for invalid password.");
        Thread.sleep(3000);

    }

    @Test
    public void validLoginTest() throws InterruptedException {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void resetPage() {
        driver.get("https://www.saucedemo.com/");  // go back to login page
    }


}

