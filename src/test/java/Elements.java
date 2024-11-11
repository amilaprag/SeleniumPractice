import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Elements {

    WebDriver driver;
    @BeforeMethod
    public void PreConditionsDropDownTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public  void ElementsTest() throws InterruptedException {
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("web element test");
        Thread.sleep(4000);
    }

    @Test
    public  void ElementsTest2() throws InterruptedException {
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("web element test");
        Thread.sleep(4000);
    }
}
