import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenShot {


    WebDriver driver ;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
        driver.get("https://www.leafground.com/window.xhtml");
    }

    @Test
    public void takeScreenshot() throws IOException {
        // Capture full-page screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save the screenshot to a file
        File destination = new File("fullpage_screenshot.png");
        FileUtils.copyFile(screenshot, destination);

        System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
