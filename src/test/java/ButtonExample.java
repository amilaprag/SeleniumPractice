import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class ButtonExample {
    WebDriver driver;
    @BeforeMethod
    public void PreConditionsButtonTests(){
        //chrome browser version
//        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("126");
//        options.addArguments("--incognito");

        driver = new ChromeDriver();

//        Dimension newSize = new Dimension(900,700);
//        driver.manage().window().setSize(newSize);

        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }


    @Test
    public void Button(){

         driver.findElement(By.id("j_idt88:j_idt90")).click();
         String expectedTitle = "Dashboard";
         String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle,"Title Mismatched");

        driver.navigate().back();

        boolean disableButton = driver.findElement(By.id("j_idt88:j_idt92")).isEnabled();
        System.out.println("Button is enable  "+disableButton);

        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();

        System.out.println("Xposition is "+x+ " Yposition is "+ y);

        WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println("Background Colour "+color);

        WebElement sizeButton = driver.findElement(By.id("j_idt88:j_idt98"));
        int height= sizeButton.getSize().getHeight();
        int width = sizeButton.getSize().getWidth();
        System.out.println("height "+height+"width "+ width);

        // Changed colour on mousehover in button
        WebElement element = driver.findElement(By.id("j_idt88:j_idt100"));
        String initialColor = element.getCssValue("background-color");

        // Perform the mouseover action
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

        // Wait for the color change to take effect
        try {
            Thread.sleep(1000); // Adjust sleep time if needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the color of the element after mouseover
        String hoverColor = element.getCssValue("background-color");  // or "background-color"

        // Compare the colors
        if (!initialColor.equals(hoverColor)) {
            System.out.println("Color changed successfully.");
        } else {
            System.out.println("Color did not change.");
        }










    }
}
