package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class CheckBoxes {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
//        <a href="/checkboxes">Checkboxes</a>
        driver.findElement(By.linkText("Checkboxes")).click();
    }
    @Test
    public void test1() {
        //    find all checkboxes
        //    any checkbox will have [type='checkbox']
        //    <form id="checkboxes">
        //    <input type="checkbox" checked=""> checkbox 1
        //    <br>
        //    <input type="checkbox" checked=""> checkbox 2
//                </form>
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        int index = 1;
        for (WebElement checkbox : checkboxes) {
            if(checkbox.isEnabled() && !checkbox.isSelected()){
                checkbox.click();
                System.out.println("Checkbox #1: "+index+" was clicked");
            }else {
                System.out.println("Checkbox #2: "+index+" was not clicked");
            }
            index++;
        }
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}




