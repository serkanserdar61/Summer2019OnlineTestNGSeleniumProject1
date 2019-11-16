package Tests.day8;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class practice {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("Dropdown")).click();
    }
    @Test(description = "Select option 2 from the dropdown")
    public void test1() {
        driver.findElement(By.id("dropdown")).click();
        WebElement input1=driver.findElement(By.cssSelector("#dropdown > option:nth-child(2)"));
        input1.click();
        input1.isSelected();
        System.out.println(input1.getText());
        WebElement input2=driver.findElement(By.cssSelector("#dropdown > option:nth-child(3)"));
        input2.click();
        input2.isSelected();
        System.out.println(input2.getText());
          }
          @Test
          public void test2(){
              List<WebElement> options=driver.findElements(By.id("dropdown"));
              for(WebElement each: options){
                  if(each.isEnabled()&&!each.isSelected())
                      each.click();
                  Assert.assertTrue(each.isDisplayed());
                          System.out.println(each.getText());
              }
          }
          @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
