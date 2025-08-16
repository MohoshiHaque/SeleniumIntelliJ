package Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLocator {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void LocatorTest() {
        // id
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        // Name
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        //TagName :: Not use generally driver.findElement(By.tagName("input"));

        //ClassName
        driver.findElement(By.className("signInBtn")).click();

        //LinkText
        driver.findElement(By.linkText("Forgot your password?")).click();

        //Partial Link Text
        driver.findElement(By.partialLinkText("partialText"));
    }

    @Test
    public void xpathTest() {

        //xpath-id
        driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Mohoshi");

        //xpath-contains
        driver.findElement(By.xpath("//input[contains(@name, 'Password')]")).sendKeys("BanglaPassword");

        //Text Matching
        driver.findElement(By.xpath("//button[text()='Sign In']"));

        //starts-with
        //driver.findElement(By.xpath("//button[starts-with(@id, 'visitUs')]")).click();

        //Partial Text Matching
        driver.findElement(By.xpath("//a[contains(text(), 'Forgot')]")).click();

        //Relative with index
        //driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        //Customize xpath
        //driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

        //driver.findElement(By.xpath("//button[@class='go-to-login-btn']/parent::div[@class='forgot-pwd-btn-conainer']")).click();

    }

    @Test
    public void cssTest(){
        //id
        driver.findElement(By.cssSelector("#user-name")).sendKeys("Mohoshi");
        //Attribute Selector
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("12345");
        //Attribute contains
        driver.findElement(By.cssSelector("[id*='pass']")).sendKeys("12345");
        //Class
        driver.findElement(By.cssSelector(".submit-button")).click();
    }
}
