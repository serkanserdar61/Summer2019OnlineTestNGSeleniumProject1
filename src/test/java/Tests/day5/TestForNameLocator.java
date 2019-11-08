package Tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestForNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement input=driver.findElement(By.name("full_name"));
        input.sendKeys("serkan");
        //driver.findElement(By.name("full_name")).sendKeys("serkan");
        Thread.sleep(2000);
        WebElement input2=driver.findElement(By.name("email"));
        input2.sendKeys("serkanserdar61@gmail.com");
        //driver.findElement(By.name("email")).sendKeys("serkanserdar61@gmail.com");
        Thread.sleep(2000);
        WebElement input3=driver.findElement(By.name("wooden_spoon"));
        input3.click();
    }
}
