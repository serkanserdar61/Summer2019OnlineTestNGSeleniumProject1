package tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;

public class salesforce {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://login.salesforce.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("serkanserdar61@gmail.com");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\'Login\']")).click();
        //WebElement text=driver.findElement(By.cssSelector("div#error.loginError"));
        //System.out.println(text.getText());
        driver.findElement(By.cssSelector("div#error.loginError")).getText();
        System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
    }
    }





