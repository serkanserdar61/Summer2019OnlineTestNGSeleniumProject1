package Tests.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class PopUpPractice {
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[1]")).click();
        BrowserUtils.wait(3);
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        BrowserUtils.wait(3);
    }
    @Test
    public void test2(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[2]")).click();
        BrowserUtils.wait(3);
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        BrowserUtils.wait(3);
        System.out.println(driver.findElement(By.id("result")).getText());
    }
    @Test
    public void test3(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//*[@id='content']/div/button[3]")).click();
        BrowserUtils.wait(3);
        driver.switchTo().alert().sendKeys("ya seve seve ya serkan serdar");
        driver.switchTo().alert().accept();
        BrowserUtils.wait(3);
        System.out.println(driver.findElement(By.id("result")).getText());
        BrowserUtils.wait(3);
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
