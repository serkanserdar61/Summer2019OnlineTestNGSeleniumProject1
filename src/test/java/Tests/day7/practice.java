package Tests.day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class practice {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
        BrowserUtils.wait(3);
        String expectedresult="http://www.tizag.com/htmlT/htmlcheckboxes.php";
        String actuallyresult=driver.getCurrentUrl();
        if(expectedresult.equals(actuallyresult)) {
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        List<WebElement>buttons=driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]")).getText());

       for(WebElement each:buttons) {
          BrowserUtils.wait(3);
           each.click();

       }





    }
}
