import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageLoadingExample {
    WebDriver driver;
    @BeforeMethod
    public void PreConditionsDropDownTest(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void AlertTest(){
        driver.get("https://google.com");
    }

}
