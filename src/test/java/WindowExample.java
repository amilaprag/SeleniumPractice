import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowExample {
    WebDriver driver;
    @BeforeMethod
    public void PreConditionsWindowTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
    }

    @Test
    public void WindowTest(){

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window Identity : "+parentWindow);

        //Click and confirm new conditions open
        WebElement openButton =  driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
        openButton.click();

        Set<String> windowsHandler = driver.getWindowHandles();
        Iterator<String> it = windowsHandler.iterator();
        String Parent = it.next();
        String child = it.next();

        driver.switchTo().window(child);
        System.out.println("window title "+driver.getTitle());
        driver.switchTo().window(Parent);
        System.out.println("window title "+driver.getTitle());

        Set<String> windows = driver.getWindowHandles();
        System.out.println("window Size : "+windows.size());

        for (String newWindow:windows){
            System.out.println("window ="+newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("window title "+driver.getTitle());
        }
        driver.close();

        driver.switchTo().window(parentWindow);

        WebElement openButton1 =  driver.findElement(By.xpath("//button[@id='j_idt88:new']"));
        boolean isOpend = openButton1.isDisplayed();
        System.out.println("Button is visible "+isOpend);

//        List<String> list = new ArrayList<>(windows);
//        if(list.size()>1){
//            driver.switchTo().window(list.get(1));
//            System.out.println("child tab titile is :"+driver.getTitle());
//            driver.close();
//            driver.switchTo().window(parentWindow);
//        }

        WebElement multiWindow =  driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
        multiWindow.click();
        Set<String> OpenWindows = driver.getWindowHandles();
        System.out.println("Open windows "+OpenWindows.size());

        WebElement doNotClose = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']"));
        doNotClose.click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows){
            if(!window.equals(parentWindow)){
               driver.switchTo().window(window);
               driver.close();
            }
        }

        driver.quit();

        //Driver.close  close single browser window which focus
        //Driver.quit close all browser windows




    }
}
