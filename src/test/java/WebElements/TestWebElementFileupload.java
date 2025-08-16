package WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestWebElementFileupload {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://trytestingthis.netlify.app/");
        //driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
    }

    @Test
    public void fileupload(){
        driver.findElement(By.id("myfile")).sendKeys("D:\\MohoshiHaqueRequestForm.pdf");
        driver.findElement(By.xpath("//button[text()=' Submit']")).click();

    }
}
