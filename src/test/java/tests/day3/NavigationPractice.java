package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) throws Exception {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.get("http://google.com");
        BrowserUtils.wait(3);
        System.out.println(driver.getTitle());
        driver.navigate().to("http://amazon.com");
        Thread.sleep(4000);
        driver.navigate().back();
        Thread.sleep(4000);

        driver.navigate().forward();
        Thread.sleep(4000);
        driver.navigate().refresh();
        driver.quit();
        driver.get("http://google.com");

    }
}
