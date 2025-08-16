package Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSoftAssertion {


    WebDriver driver;
    SoftAssert soft;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        soft = new SoftAssert();
    }

    @Test
    public void loginWithSoftAssert() {

        // Step 1 - Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Step 2 - Multiple Soft Assertions
        String actualTitle = driver.findElement(By.className("app_logo")).getText();
        soft.assertEquals(actualTitle, "Swags Labs", "Page title is incorrect"); // Intentional fail

        String currentUrl = driver.getCurrentUrl();
        soft.assertTrue(currentUrl.contains("inventory"), "URL does not contain 'inventory'"); // Likely pass

        String menuText = driver.findElement(By.id("react-burger-menu-btn")).getText();
        soft.assertEquals(menuText, "Open Menu", "Menu button text is wrong"); // Intentional fail

        System.out.println("✅ All soft assertions executed — not stopped in the middle!");

        // Step 3 - Final assertAll to report all failures together
        soft.assertAll();
    }
}

