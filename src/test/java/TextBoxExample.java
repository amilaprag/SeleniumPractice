import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;
    @BeforeMethod
    public void PreConditionsTexboxTests(){
        // Set chrome browser version
//        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("126");
//        options.addArguments("--incognito");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void TexboxTests(){
        WebElement name =  driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Amila Prageeth");

        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("Sri Lanka");

        boolean Enable = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is textbox  enable. "+Enable);

        WebElement ClearTextBox = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        ClearTextBox.clear();

        WebElement retriveText = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = retriveText.getAttribute("value");
        System.out.println("Value "+value);


        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("a@gmail.com"+ Keys.TAB+"CONFIRM TO TAB");













    }

}
