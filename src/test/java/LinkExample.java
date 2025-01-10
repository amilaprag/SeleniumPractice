import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;
    @BeforeMethod
    public void PreConditionsLinkTests(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTests(){
       WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
       homeLink.click();
       driver.navigate().back();

        WebElement whereToGo = driver.findElement(By.partialLinkText("Find the URL without clicking me"));
        String path = whereToGo.getAttribute("href");
        System.out.println("This Link goes to "+path);

        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("the link is broken");
        }else{
            System.out.println("Not broken");
        }
        driver.navigate().back();

        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        List<WebElement> countAllLinks = driver.findElements(By.tagName("a"));
        int pageLinkCount = countAllLinks.size();
        System.out.println("count full page links:"+pageLinkCount);

        WebElement layoutElement =  driver.findElement(By.className("layout-main-content"));
        List<WebElement> countAllLaOutLinks  = layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of layout Links "+countAllLaOutLinks.size());

    }
}
