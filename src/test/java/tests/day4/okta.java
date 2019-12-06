package tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;

public class okta {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://cybertekschool.okta.com");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
         BrowserUtils.wait(2);
        WebElement input=driver.findElement(By.id("okta-signin-username"));
        input.sendKeys("serkanserdar61@gmail.com");
        BrowserUtils.wait(2);
        WebElement input2=driver.findElement(By.id("okta-signin-password"));
        input2.sendKeys("Ser615534..");
        BrowserUtils.wait(2);
        WebElement button=driver.findElement(By.id("okta-signin-submit"));
        button.click();




    }
}
