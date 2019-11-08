package Tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class mavenproject {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        BrowserUtils.wait(3);
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        WebElement input= driver.findElement(By.id("prependedInput"));
        //driver.findElement(By.id("prependedInput")).sendKeys("storemanager219");
        System.out.println(input.getAttribute("required"));
        input.sendKeys("storemanager219");
        System.out.println(input.getAttribute("value"));
        BrowserUtils.wait(3);
        WebElement input2=driver.findElement(By.id("prependedInput2"));
        //driver.findElement(By.id("prependedInput")).sendKeys("UserUser123");
        System.out.println(input2.getAttribute("required"));
        input2.sendKeys("UserUser123");
        System.out.println(input2.getAttribute("value"));
        BrowserUtils.wait(3);
        WebElement input3=driver.findElement(By.id("_submit"));
        input3.submit();
        String actualUrl="https://qa2.vytrack.com/user/login";
        String ExpectingUrl="https://qa2.vytrack.com/user/login";
        if(actualUrl.equals(ExpectingUrl)){
            System.out.println("Test passsed");
        }
        else {
            System.out.println("test failed");
        }

    }
}
