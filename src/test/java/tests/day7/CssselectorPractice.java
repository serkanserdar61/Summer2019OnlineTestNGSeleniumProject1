package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CssselectorPractice {
    public static void main(String[] args) {

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //.classname  but if there is some space in class name then put .(origin class name is btn btn-primary)
        // or we can use [class='btn btn-primary']
        List<WebElement> buttons=driver.findElements(By.cssSelector(".btn.btn-primary"));
        for(WebElement each:buttons) {
            each.click();
            BrowserUtils.wait(1);
            WebElement message = driver.findElement(By.cssSelector("#result"));
            System.out.println(message.getText());
        }
            WebElement header=driver.findElement(By.cssSelector(".container>h3"));
            System.out.println(header.getText());
            WebElement p=driver.findElement(By.cssSelector("[class='container']"));
            System.out.println(p.getText());
        }
        }



