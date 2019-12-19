package tests.day22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class takescreenshot2 {

        WebDriver driver;

        @BeforeMethod
        public void test(){


            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            driver.get("https://app.hubspot.com/login");

        }


        @Test
        public void takescreenshot() throws IOException {
            WebElement email=driver.findElement(By.id("username"));
            WebElement password=driver.findElement(By.id("password"));
            WebElement loginbutton=driver.findElement(By.id("loginBtn"));
            WebElement forgetpassword=driver.findElement(By.linkText("Forgot my password"));
            email.sendKeys("serkan");
            password.sendKeys("12345");

         TakesScreenshot srcShot=  ((TakesScreenshot)driver);

            File srcFile= srcShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("./test-output/Screenshot/page.png"));



        }
}
