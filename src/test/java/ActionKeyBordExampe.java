import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyBordExampe {
    WebDriver driver;
    @BeforeMethod
    public void PreConditionsDropDownTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void ActionKeyBordActionsTest1() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement googleSearchTextBox =  driver.findElement(By.name("q"));
        googleSearchTextBox.sendKeys("welcome");

        Actions action = new Actions(driver);
        Action actionStringBuilder =  action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();
        actionStringBuilder.perform();

        Thread.sleep(300);
        //googleSearchTextBox.clear();

        action.keyDown(Keys.SHIFT).sendKeys("Writing Capital").keyUp(Keys.SHIFT).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.CONTROL)
                .sendKeys("x").perform();

        Thread.sleep(300);

        action.keyDown(googleSearchTextBox,Keys.SHIFT).sendKeys("learn with Hashir").build().perform();

    }

    @Test
    public void ActionKeyBordActionsTest2(){
        driver.get("https://www.leafground.com/list.xhtml");

        List<WebElement> selectedOptions = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).click(selectedOptions.get(0)).click(selectedOptions.get(1)).perform();

    }


    @Test
    public void ListTest(){
        driver.get("https://www.leafground.com/list.xhtml");                                                                      //li[@class='ui-orderlist-item ui-corner-all ui-sortable-handle']
        List<WebElement> listOne = driver.findElements(By.xpath("//li[@class='ui-orderlist-item ui-corner-all ui-sortable-handle']"));

        Actions clickAction = new Actions(driver);
        clickAction.keyDown(Keys.CONTROL).click(listOne.get(0)).click(listOne.get(2)).perform();

    }



























}
