package Tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        //Test.1 verify that title of the page is a "google"
        String actualResult=driver.getTitle();
        String expectedResult="Google";
        if(actualResult.contains(expectedResult)){
            System.out.println("Test pass");
        }
        else{
            System.out.println("Fail");
        }
    driver.close();

    }
}
