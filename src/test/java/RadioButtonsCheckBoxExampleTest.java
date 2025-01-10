import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButtonsCheckBoxExampleTest {

    WebDriver driver;
    @BeforeMethod
    public void PreConditionsLinkTests(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void RadioButtonTests(){
        driver.get("https://www.leafground.com/radio.xhtml");

        // Find the default radio button
        boolean safariRadioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean firefoxRadioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean chromeRadioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean edgeRadioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if(chromeRadioOption){
            String  chromeText =  driver.findElement(By.id("j_idt87:console2:0")).getText();
            System.out.println("Default select radio button is chrome");
        } else if (safariRadioOption) {
            String  SafariText =  driver.findElement(By.id("j_idt87:console2:2")).getText();
            System.out.println("Default select radio button is Safari");
        }else if (firefoxRadioOption) {
            String  firefoxText =  driver.findElement(By.id("j_idt87:console2:1")).getText();
            System.out.println("Default select radio button is firefox");
        }
        else if (edgeRadioOption) {
            String  edgeText =  driver.findElement(By.id("j_idt87:console2:3")).getText();
            System.out.println("Default select radio button is edge");
        }
        //Advance java way

        List<WebElement> radioButtons = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input"));
        System.out.println( "size "+radioButtons.size());
        int index = -1;

        for (WebElement element : radioButtons){
            index++;
            if(element.isSelected()){
                String item = "j_idt87:console2:"+index;
                WebElement element1 = driver.findElement(By.id(item));
                String defaultText = element1.getText();
                System.out.println("selected element text is "+defaultText);
                break;
            }
        }

        //Select radio button if not selected
         WebElement selectRadioButton = driver.findElement(By.id("j_idt87:age:0"));
         boolean isChecked = selectRadioButton.isSelected();
         if(!isChecked){
             driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
         }

    }

    @Test
    public void CheckBoxTests(){
        driver.get("https://www.leafground.com/checkbox.xhtml");

        List<WebElement> selectedCheckbox = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        System.out.println(selectedCheckbox.size());

        for(WebElement element : selectedCheckbox){
            if(element.getText().equals("Others")){
                element.click();
            }
        }

        for (int i = 1;i<=selectedCheckbox.size();i++){
            boolean checkboxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["+i+"]")).isSelected();
            System.out.println("checkbox"+i+"selected status is : "+checkboxStatus);
        }

        boolean isEnabled = driver.findElement(By.id("j_idt87:j_idt102_input")).isEnabled();
        System.out.println("checkbox is "+isEnabled);















    }
}
