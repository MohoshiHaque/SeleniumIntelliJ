package ExcelData.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {

    protected WebDriver driver;

    @BeforeClass
    public void setupBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}
