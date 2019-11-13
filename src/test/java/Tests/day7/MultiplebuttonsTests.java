package Tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class MultiplebuttonsTests {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }
    @Test
    public void verfyButton(){
        String Expectedresult="Clicked on button one!";
        driver.findElement(By.xpath("//*[text()='Button 1']")).click();
        String actualresult=driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(actualresult, Expectedresult, "Result is wrong");
    }
    @Test
    public void verfyButton2(){
        String Expectedresult="Clicked on button two!";
        driver.findElement(By.name("button2")).click();
        String actualresult=driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(actualresult, Expectedresult, "Result is wrong");
    }


    @AfterMethod
    public void teardown(){

        driver.quit();
    }




}
