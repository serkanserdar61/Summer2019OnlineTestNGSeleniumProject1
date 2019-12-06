package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;


public class demo {
    public static void main(String[] args) {

            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("https://qa2.vytrack.com/user/login");
            WebElement input = driver.findElement(By.id("prependedInput"));
            System.out.println(input.getAttribute("required"));
            input.sendKeys("storemanager220");
            System.out.println(input.getAttribute("value"));
            WebElement input2 = driver.findElement(By.id("prependedInput2"));
            System.out.println(input2.getAttribute("required"));
            input2.sendKeys("UserUser123");
            System.out.println(input2.getAttribute("value"));
            WebElement button = driver.findElement(By.id("_submit"));
            button.click();
            driver.close();
    }
}
