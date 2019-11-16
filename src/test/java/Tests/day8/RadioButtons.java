package Tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Radio Buttons")).click();
        //        linkText works only with <a> elements
        //        link text only in between >Text<
    }

    @Test(description="blue button is selected?")
    public void test1(){

        WebElement bluebutton=driver.findElement(By.id("blue"));
        boolean isselected=bluebutton.isSelected();
        Assert.assertTrue(isselected);
        //assert true that button is selected
        //if button is selected it will return true, otherwise false
    }
    @Test(description="red button is selected?")
    public void test2(){

        WebElement redbutton=driver.findElement(By.id("red"));
        Assert.assertFalse(redbutton.isSelected());
        // assertFalse will expect that condition is false
    }

    @Test(description="green button is enable?")
    public void test3(){

        WebElement greenbutton=driver.findElement(By.id("green"));
        Assert.assertFalse(greenbutton.isEnabled());
    }



@Test
public void test4(){

    List<WebElement> radioButtons =driver.findElements(By.cssSelector("input[type='radio']"));

    for(WebElement each:radioButtons){
        if(each.isEnabled()&&!each.isSelected()) {

            each.click();
            BrowserUtils.wait(2);
            System.out.println("Button clicked " + each.getAttribute("id"));
            BrowserUtils.wait(2);
        }else{
            System.out.println("Button was not clicked " + each.getAttribute("id"));
        }
    }

}


    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
