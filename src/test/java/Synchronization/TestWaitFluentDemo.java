package Synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWaitFluentDemo {

    WebDriver driver;
    FluentWait<WebDriver> wait;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20)) // Total wait time
                .pollingEvery(Duration.ofSeconds(2)) // Check every 2 sec
                .ignoring(NoSuchElementException.class); // Ignore this exception
    }

    @Test
    public void FluentWait() {

        // Wait for username field visible and then send keys
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        username.sendKeys("standard_user");

        // Wait for password field visible and then send keys
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys("secret_sauce");

        // Wait for login button to be clickable and then click
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        loginBtn.click();

    }

}
