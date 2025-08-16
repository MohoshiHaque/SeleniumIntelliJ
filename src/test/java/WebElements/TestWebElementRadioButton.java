package WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestWebElementRadioButton {


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
    public void radiobutton(){

        WebElement radiobutton = driver.findElement(By.id("male"));
        radiobutton.click();

    }




}
