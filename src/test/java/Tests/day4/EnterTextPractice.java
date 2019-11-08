package Tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice {
    public static void main(String[] args) {

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox=driver.findElement(By.name("email"));
        inputBox.sendKeys("serkanserdar61@gmail.com");
        WebElement button=driver.findElement(By.id("form_submit"));
        button.click();
        String ExpectedUrl="http://practice.cybertekschool.com/email_sent";
        String actualUrl=driver.getCurrentUrl();
        if(ExpectedUrl.equals(actualUrl)){
            System.out.println("test passed");
        }else{
            System.out.println("test fail");
        }
        BrowserUtils.wait(2);
        driver.close();


    }
}
