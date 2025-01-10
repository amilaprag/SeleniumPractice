import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseInteractionExampe {

    WebDriver driver;
    @BeforeMethod
    public void PreConditionsWindowTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void MouseInteractionExampeTest(){

        driver.get("https://www.leafground.com/drag.xhtml");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();

       WebElement from =  driver.findElement(By.id("form:drag"));
       WebElement to =  driver.findElement(By.id("form:drop"));

       // Fistway
//       action.clickAndHold(from).moveToElement(to).release(to).perform();
       //Secondway
        action.dragAndDrop(from,to).perform();

        WebElement slider = driver.findElement(By.id("form:j_idt125"));
        slider.getLocation();
        action.dragAndDropBy(slider,100,0).perform();

    }

    @Test
    public void MouseClickExampeTest(){

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement   rightElementButtton =  driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions action = new Actions(driver);
        action.contextClick(rightElementButtton).perform();
        driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
        Alert alertTop = driver.switchTo().alert();
        System.out.println("Alert shows the text as "+alertTop.getText());
        alertTop.accept();




    }

}
