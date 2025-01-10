import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropDownExample {
    WebDriver driver;
    @BeforeMethod
    public void PreConditionsDropDownTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void DropDownTest(){
        driver.get("https://www.leafground.com/select.xhtml");

              WebElement dropDown =  driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
              Select select = new Select(dropDown);
              select.selectByIndex(1);
              //Thread.sleep(3000);
              select.selectByVisibleText("Playwright");
              //Thread.sleep(3000);

              //Get the number of dropdown options
              List<WebElement> listofOptions = select.getOptions();
              int SizeOfList = listofOptions.size();
              System.out.println("SizeOfList "+SizeOfList);

              for(WebElement element : listofOptions){
                  System.out.println(element.getText());
              }

              dropDown.sendKeys("Puppeteer");

             WebElement dropDown2 =  driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
             dropDown2.click();

             List<WebElement> selectOptions  = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
             for(WebElement element:selectOptions){
                 String option=  element.getText();
                 System.out.println("XXX"+option );
                 if (option.equals("USA")) {
                     element.click();
                     break;
                 }
             }

             //Google search pick value from suggestions

    }

    @Test
    public void GoogleTest(){
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("palitha");
        List<WebElement> googleTestElements = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        System.out.println(googleTestElements.size());

        for(WebElement element:googleTestElements){
            String option=  element.getText();

            if (option.equals("Palitha Thewarapperuma")) {
                element.click();
                break;
            }
        }


    }

}
