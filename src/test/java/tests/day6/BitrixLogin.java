package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class BitrixLogin {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();
     driver.findElement(By.xpath("//*[starts-with(@name,'USER_L')]")).sendKeys("serkanserdar61@gmail.com");
        BrowserUtils.wait(3);
     driver.findElement(By.xpath("//*[contains(@name,'USER_P')]")).sendKeys("6153488");
        BrowserUtils.wait(3);
       WebElement element= driver.findElement(By.xpath("//*[@id='USER_REMEMBER']"));
       element.click();
        WebElement element2= driver.findElement(By.xpath("//*[@for='USER_REMEMBER']"));
        System.out.println(element2.getText());
        BrowserUtils.wait(3);

     driver.findElement(By.xpath("//*[@type='submit']")).click();
        BrowserUtils.wait(3);

     driver.close();



    }
}
