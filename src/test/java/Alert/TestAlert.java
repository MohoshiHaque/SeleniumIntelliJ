package Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAlert {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
    }

    @Test
    public void TestAlert(){

        driver.findElement(By.id("name")).sendKeys("Mohoshi");
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());
        //Click Okay
        driver.switchTo().alert().accept();

        //Cancel
        //driver.findElement(By.id("confirmbtn")).click();
        //System.out.println(driver.switchTo().alert().getText());
        //driver.switchTo().alert().dismiss();
    }



}
