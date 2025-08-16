package POM_T2_Reports.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* locators + actions */
public class LoginPageClassR {

    private WebDriver driver;

    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage  = By.cssSelector("h3[data-test='error']");



    // Constructor — same name as class, no return type
    public LoginPageClassR(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username) {

        driver.findElement(usernameInput).sendKeys(username);

    }

    public void enterPassword(String password) {

        driver.findElement(passwordInput).sendKeys(password);

    }

    public void clickLogin() {

        driver.findElement(loginButton).click();

    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clearLoginFields() {
        driver.findElement(usernameInput).clear();
        driver.findElement(passwordInput).clear();
    }
}
