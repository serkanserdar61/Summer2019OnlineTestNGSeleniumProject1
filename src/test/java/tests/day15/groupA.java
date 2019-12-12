package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class groupA {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
//        <a href="/checkboxes">Checkboxes</a>
        driver.findElement(By.linkText("Checkboxes")).click();
    }

    @Test(groups={"hello"})
    public void test1() {
        System.out.println("serkan serdar");
    }

    @Test(dependsOnMethods ={"test4"})//if we say dependsOnMethod and write test name as a parameter first tes4 then test 2 executed
    public void test2() {//test1 first and then test3 and then test4 and finally test2

        System.out.println("test2 passed");
    }
    @Test(dependsOnMethods = {"test4","test2"}) //and also we can add more than one method name.if we say something like that firs test1 is runnig
     public void test3() {//and then test4 and test2 and finally test3
      System.out.println("test3 passed");
    }
    @Test
    public void test4() {
        System.out.println("test4 passed");
    }
}

