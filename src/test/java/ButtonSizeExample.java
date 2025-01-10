import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonSizeExample {


    WebDriver driver ;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void VerifyBurronSize(){
        WebElement searchButton = driver.findElement(By.name("btnK"));

        // Get the width and height of the button
        Dimension size = searchButton.getSize();
        int buttonWidth = size.getWidth();
        int buttonHeight = size.getHeight();
        System.out.println("Button size: " + searchButton.getSize() + "");

        // Print the dimensions
        System.out.println("Button width: " + buttonWidth + "px");
        System.out.println("Button height: " + buttonHeight + "px");

        String width = searchButton.getCssValue("width");
        String height = searchButton.getCssValue("height");

        System.out.println("CSS Button Width: " + width);
        System.out.println("CSS Button Height: " + height);

    }

    @AfterMethod
    public void Clear(){
       driver.quit();
    }

}
