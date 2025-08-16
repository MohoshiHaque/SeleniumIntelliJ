package WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestWebElementDropDown {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.get("https://trytestingthis.netlify.app/");
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

    }

    @Test(description = "Static dropdown in Try Testing Nights Netlify")
    public void StaticDropwDown() {

        WebElement testDropDown = driver.findElement(By.id("option"));
        Select dropdown = new Select(testDropDown);

        //  dropdown.selectByIndex(2);
        // dropdown.selectByValue("Database");
        dropdown.selectByVisibleText("Option 1");
    }

    @Test(description = "Loop dropdown in Rahul shetty Academy")
    public void LoopDropDown() throws InterruptedException {

        driver.findElement(By.id("divpaxinfo")).click();
        int i = 1;
        while (i < 5) {
            Thread.sleep(2000);
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
    }


    @Test(description = "Dynamic DropDown dropdown in Rahul shetty Academy")

    public void DynamicDropDown() throws InterruptedException {
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
    }

    @Test(description = "Auto Suggestion DropDown dropdown in Rahul shetty Academy")

    public void AutoSuggestionDropdown() throws InterruptedException {
        driver.findElement(By.id("autosuggest")).sendKeys("Ban");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option : options)
        {
            if (option.getText().equalsIgnoreCase("Bangladesh"))
            {
                option.click();
                break;
            }
        }
    }


}
