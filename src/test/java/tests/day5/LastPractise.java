package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class LastPractise {

    public static void main(String[] args) throws InterruptedException {
        Information("ser","fg","re","er@gmail.com","1234567","978-456-38475");

    }

        public static void Information(String Firstname,String Lastname,String Username,String Email,String Password,String Phone) throws InterruptedException {
        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        String ExpectingText="Registration form";
        String ActualTest="Registration form";
        WebElement text1=driver.findElement(By.cssSelector("#content > div > div > div > div > h2"));


        if(ExpectingText==ActualTest){
            System.out.println("Test passed");
        }
        else{
            System.out.println("test failed");
        }
        Thread.sleep(2000);

        WebElement button=driver.findElement(By.name("firstname"));
        button.sendKeys("serkan");
        Thread.sleep(2000);
        WebElement button2=driver.findElement(By.name("lastname"));
        button2.sendKeys("serdar");
        Thread.sleep(2000);
        WebElement button3=driver.findElement(By.name("username"));
        button3.sendKeys("serkanserdar61");
        Thread.sleep(2000);
        WebElement button4=driver.findElement(By.name("email"));
        button4.sendKeys("serkanserdar61@gmail.com");
        Thread.sleep(2000);
        WebElement button5=driver.findElement(By.name("password"));
        button5.sendKeys("61553421");
        Thread.sleep(2000);
        WebElement input6=driver.findElement(By.name("phone"));
        input6.sendKeys("865-978-4078");
        Thread.sleep(2000);




            }







    }

