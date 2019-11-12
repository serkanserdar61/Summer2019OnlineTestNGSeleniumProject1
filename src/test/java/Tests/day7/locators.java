package Tests.day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class locators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://cybertekschool.com/");
        driver.manage().window().maximize();
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        //size of the elements=number of links
        System.out.println("number of links " + links.size());
        //loop through the collection of links
        for (WebElement each : links) {
            //print text of every link
            if (!each.getText().isEmpty()) {//bunu kullandiginda ici bos olanlari siler
                System.out.println(each.getText());
            }
            }
            driver.close();

    }
}