package Tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestForTagNameLocator {

    public static void main(String[] args) {

        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement tagname=driver.findElement(By.tagName("h3"));
        System.out.println(tagname.getText());
    }
}
