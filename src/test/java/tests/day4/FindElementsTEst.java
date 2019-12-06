package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementsTEst {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedTitle=driver.getTitle();

        WebElement button=driver.findElement(By.id("form_submit"));
        button.click();
        String actualTitle=driver.getTitle();
        if(actualTitle.equals((expectedTitle))){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test fail");
            System.out.println("Expected title is "+expectedTitle);
            System.out.println("Actual title is "+actualTitle);
        }
        BrowserUtils.wait(2);
        driver.close();




    }
}
