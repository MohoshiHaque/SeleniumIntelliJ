package Synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWaitExplicit {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        // Create explicit wait object (applies only when we call wait.until)
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void loginWithExplicitWait() {

        // Wait until username field is visible, then type
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        username.sendKeys("standard_user");

        // Wait until password field is visible, then type
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys("secret_sauce");

        // Wait until login button is clickable, then click
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        loginBtn.click();
    }


    @Test
    public void loginHybridWait() {

        // Using implicit wait here (fast element)
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Using implicit wait here too
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Explicit wait for the login button (might load after form validation)
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        loginBtn.click();

    }


}
