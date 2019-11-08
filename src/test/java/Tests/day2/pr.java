package Tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class pr {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println(h1.getText());
        driver.close();
    }
}