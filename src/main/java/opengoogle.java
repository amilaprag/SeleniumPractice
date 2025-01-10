import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class opengoogle {
    public static void main(String[] args) {
//          System.setProperty("webdriver.chrome.driver","C:\\Users\\amila\\Downloads\\chromedriver\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com/");

//        WebDriverManager.chromedriver().setup();
//         WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com/");

         WebDriver driver = new ChromeDriver();
         driver.get("https://www.google.com/");
         driver.quit();

    }
}
