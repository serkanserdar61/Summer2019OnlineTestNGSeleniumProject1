package Tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class TestForTextLinkLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement input=driver.findElement(By.linkText("Autocomplete"));
        input.click();
        Thread.sleep(2000);
        driver.close();




    }
}
