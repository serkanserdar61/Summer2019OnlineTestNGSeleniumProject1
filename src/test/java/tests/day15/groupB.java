package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class groupB {
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
        System.out.println("serdar serkan");
    }

    @Test(enabled = false)//if we say enabled=false its mean skip this part.if we say enabled=true its execute again
    public void test2() {
        System.out.println("test2 failed");
    }
     @Test(timeOut = 5000)//That is mean this test case will be wait 5 second while running
      public void test3(){
     System.out.println("test3 will be wait 5 second");

        }
    @Parameters({ "URL" })
    @Test
    public void test4(String urlname){
        System.out.println("test4 passed");
        System.out.println(urlname);

    }

    }



