package Tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class homedepot {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://citiretailservices.citibankonline.com/RSnextgen/svc/launch/index.action?siteId=PLCN_HOMEDEPOT#signon");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement input=driver.findElement(By.name("userId"));
        input.sendKeys("serkanserdar61@gmail.com");
        BrowserUtils.wait(2);
        WebElement input2=driver.findElement(By.name("password"));
        input2.sendKeys("serkan615534");
        BrowserUtils.wait(2);
        WebElement button=driver.findElement(By.className("featured"));
        button.click();



    }
}
