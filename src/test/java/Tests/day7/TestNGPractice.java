package Tests.day7;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGPractice {


    @Test
    public void test(){
        Assert.assertEquals("apple","apple","word is not correct!,should be apple");

    }
    @Test(description="Verify that header is displayed")
    public void verfyTitle(){
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String expectedTitle="Practice";
        String actualTitle=driver.getTitle() ;
        Assert.assertEquals(actualTitle,expectedTitle,"title is wrong");
        driver.quit();
    }
    @Test
    public void veryfyHeadingIsDisplayed(){
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        WebElement heading=driver.findElement(By.xpath("//*[@id='content']/div/div/h1/span"));
        Assert.assertTrue(heading.isDisplayed());


    }

}
