import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class BrowserActions {
    WebDriver driver;
    @BeforeMethod
    public void PreConditionsDropDownTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void BrowserActionTest () throws InterruptedException, IOException {

        //url navigate
        driver.get("https://google.com");
        driver.navigate().to("https://automationstepbystep.com");

        // back refresh and forward SSSS
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        //switch to window ss
        String originalWindow = driver.getWindowHandle();
        driver.switchTo().window(originalWindow);

        //open new  window
        driver.switchTo().newWindow(WindowType.WINDOW);

        //open new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().window(originalWindow);

        //set size window
        driver.manage().window().setSize(new Dimension(800,600));

        //position
        Point point  = driver.manage().window().getPosition();
        System.out.println("position get x "+point.getX());
        System.out.println("position get y "+point.getY());

        driver.manage().window().setPosition(new Point(500,800));

        // fulscreen maximized minimzed
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.manage().window().minimize();
        Thread.sleep(2000);

        //getscreen shot

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("./image1.png"));

        //js run inside selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;


        //driver.close();
    }
}
