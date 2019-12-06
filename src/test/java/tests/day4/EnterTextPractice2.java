package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice2 {
    public static void main(String[] args) {


        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox = driver.findElement(By.name("email"));
        inputBox.sendKeys("serkanserdar61@gmail.com", Keys.ENTER);//Keys.ENTER will simulate ENTER button press
        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));
        confirmationMessage.click();
        String Expectedmessage = "Your e-mail's been sent!";
        String actualmessage = confirmationMessage.getText();
        if (Expectedmessage.equals(actualmessage)) {
            System.out.println("test passed");
        } else {
            System.out.println("test fail");
        }
        BrowserUtils.wait(2);
        driver.close();

    }
}
