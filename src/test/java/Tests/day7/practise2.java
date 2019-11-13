package Tests.day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class practise2 {
WebDriver driver;

    @BeforeMethod
    public void checkbox() {

        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        BrowserUtils.wait(2);
    }

    @Test
    public void veryfButtonandtext() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='content']/ul/li[9]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/a")).click();
        BrowserUtils.wait(2);
        String expectedresult="Not Found";
        String actualresult= driver.findElement(By.xpath("/html/body/h1")).getText();
        Assert.assertEquals(actualresult, expectedresult,"result is wrong");
    }





}