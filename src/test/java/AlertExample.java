import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {
    WebDriver driver;
    @BeforeMethod
    public void PreConditionsDropDownTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void AlertTest(){
        driver.get("https://www.leafground.com/alert.xhtml");
        WebElement basicAlertButton =  driver.findElement(By.id("j_idt88:j_idt91"));
        basicAlertButton.click();
        Alert basicAlert = driver.switchTo().alert();
        basicAlert.accept();

        WebElement cancelAlertButton = driver.findElement(By.id("j_idt88:j_idt93"));
        cancelAlertButton.click();
        Alert cancelAlert = driver.switchTo().alert();
        cancelAlert.dismiss();

        WebElement  dialogAlertutton = driver.findElement(By.id("j_idt88:j_idt104"));
        dialogAlertutton.click();
        Alert  dialogAlert = driver.switchTo().alert();
        String dialogAlertText = dialogAlert.getText();
        System.out.println("Alert text is "+dialogAlertText);
        dialogAlert.sendKeys("OK");
        dialogAlert.accept();

    }

    @Test
    public void AlertTest2(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement simpleAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        simpleAlert.click();
        Alert simpleAlertBox = driver.switchTo().alert();
        System.out.println("simpleAlertBox Text" +simpleAlertBox.getText());
        simpleAlertBox.accept();
        if(driver.getPageSource().contains("You successfully clicked an alert")){
            System.out.println("contains the alert");
        }

    }
}
