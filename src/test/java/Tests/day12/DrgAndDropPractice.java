package Tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DrgAndDropPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
    }

    @Test(description = "Drag and Drop example")
    public void test1() {
        driver.findElement(By.cssSelector("button[title='Accept Cookies")).click();
        Actions actions=new Actions(driver);
        WebElement moon=driver.findElement(By.id("draggable"));
        WebElement earth=driver.findElement(By.id("droptarget"));
        BrowserUtils.wait(3);
        actions.dragAndDrop(moon,earth).perform();
        BrowserUtils.wait(3);
    }
















    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
