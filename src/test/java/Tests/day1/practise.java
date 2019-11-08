package Tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class practise {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get("http://google.com");
        WebElement btn1=driver.findElement(By.id("gbgfbb"));
        btn1.click();
        Thread.sleep(2000);
        driver.close();

    }
}
