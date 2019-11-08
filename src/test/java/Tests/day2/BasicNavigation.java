package Tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicNavigation {
    public static void main(String[] args) throws Throwable{
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");
       WebElement link=driver.findElement(By.partialLinkText("drag"));
        link.click();
        Thread.sleep(3000);
        driver.close();



    }
}
