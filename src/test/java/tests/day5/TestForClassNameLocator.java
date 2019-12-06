package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestForClassNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);
        WebElement heading=driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());
        driver.close();


    }
}
