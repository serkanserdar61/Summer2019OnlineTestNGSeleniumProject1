package tests.day22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class takescreenshots {
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
    public void takescreenshot()  {
        WebElement email=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement loginbutton=driver.findElement(By.id("loginBtn"));
        WebElement forgetpassword=driver.findElement(By.linkText("Forgot my password"));
        email.sendKeys("serkan");
        password.sendKeys("12345");
        loginbutton.click();
        takeElementscreenshot(email,"emailElement");
        takeElementscreenshot(password,"passwordElement");
        takeElementscreenshot(loginbutton,"loginbuttonElement");
        takeElementscreenshot(forgetpassword,"forgetpassElement");
    }

    public static void takeElementscreenshot(WebElement element, String Filename) {


        File scfile=element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scfile,new File("./target/screenshot/"+Filename+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
