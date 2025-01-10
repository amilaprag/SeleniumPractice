import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FramesExample {
        WebDriver driver;
        @BeforeMethod
        public void PreConditionsWindowTest(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.leafground.com/frame.xhtml");
        }

        @Test
        public void FrameTest(){

           driver.switchTo().frame(0);
           WebElement iframeElementButton = driver.findElement(By.xpath("//button[@id='Click']"));
           iframeElementButton.click();

           String buttonText = iframeElementButton.getText();
           System.out.println(buttonText);

           driver.switchTo().defaultContent();
           driver.switchTo().frame(2);
           driver.switchTo().frame("frame2");

           WebElement button3 = driver.findElement(By.id("Click"));
           button3.click();

            driver.switchTo().defaultContent();
            List<WebElement> countOfIframes =  driver.findElements(By.tagName("iframe"));
            int size = countOfIframes.size();
            System.out.println("Iframe Size "+size);






        }
}
