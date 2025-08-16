package WindowsNavigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClassWindows {
    WebDriver driver;
    @Test
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        //driver.manage().window().maximize();
        //driver.navigate().back();
        //driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://trytestingthis.netlify.app/");
    }

    @Test
    public void setupTypeTab(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://trytestingthis.netlify.app/");

    }

    @Test
    public void setupTypeWindow(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://trytestingthis.netlify.app/");


    }


}
