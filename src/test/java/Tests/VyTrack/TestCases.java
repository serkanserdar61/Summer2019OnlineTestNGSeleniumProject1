package Tests.VyTrack;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class TestCases {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        //explicit wait
        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

    }

    @Test
    public void test1() {

        Actions a = new Actions(driver);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        activitiesElement.click();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();

        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        //Creating actions object to perform mouse hover

        WebElement minimizeTheTarget = driver.findElement(By.xpath("//tr[13]//td[9]"));

        //we are using actions class to mouse hover on the target link.

        WebElement verifyViewEditDelete = minimizeTheTarget.findElement(By.className("dropdown-toggle"));

        a.moveToElement(verifyViewEditDelete).build().perform();


        // Narrowing the target location..

        WebElement minimizeTheTargetView = driver.findElement(By.xpath("//tr[13]"));

        //To move our object to VIEW. we are using actions class to mouse hover on the target link.

        WebElement view = minimizeTheTargetView.findElement(By.xpath("//i[@class='fa-eye hide-text']"));

        a.moveToElement(view).build().perform();

        //Using Assert to verify that target is displayed.

        Assert.assertTrue(view.isDisplayed());


        //To move our object to EDIT. we are using actions class to mouse hover on the target link.

        WebElement edit = minimizeTheTargetView.findElement(By.xpath("//i[@class='fa-pencil-square-o hide-text']"));

        a.moveToElement(edit).build().perform();

        //Using Assert to verify that target is displayed.

        Assert.assertTrue(edit.isDisplayed());


        //To move our object to DELETE. we are using actions class to mouse hover on the target link.

        WebElement delete = minimizeTheTargetView.findElement(By.xpath("//i[@class='fa-trash-o hide-text']"));

        a.moveToElement(delete).build().perform();

        //Using Assert to verify that target is displayed.

        Assert.assertTrue(delete.isDisplayed());


    }

    @Test
    public void test2() {
        Actions act = new Actions(driver);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        act.moveToElement(activitiesElement).build().perform();


        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        act.moveToElement(calendarEventsElement).build().perform();
        calendarEventsElement.click();


        BrowserUtils.wait(3);


        driver.findElement(By.xpath("//*[@class='fa-cog hide-text']")).click();

        BrowserUtils.wait(3);

        List<WebElement> row = driver.findElements(By.xpath("//div[@class='toolbar']//tr//td[1]"));

        for (int i = 0; i < row.size(); i++) {

            BrowserUtils.wait(1);

            WebElement name = driver.findElement(By.xpath("//div[@class='toolbar']//tr//td[1]"));
            System.out.println(name.getText());
            //finding the name which is not title and click the check box which is not title.

            if (!row.get(i).getText().equalsIgnoreCase("Title")) {

                row.get(i).click();


            }

        }
        String expectedtitle = "Title";
        String actuallTitle = driver.findElement(By.linkText("Title")).getText();
        Assert.assertEquals(actuallTitle, expectedtitle);
    }

    @Test
    public void test3() {
        Actions act = new Actions(driver);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        act.moveToElement(activitiesElement).build().perform();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        act.moveToElement(calendarEventsElement).build().perform();
        calendarEventsElement.click();

        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[2]/div/a")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//*[@class='btn-success btn dropdown-toggle']")).click();
        BrowserUtils.wait(3);


        List<WebElement> options = driver.findElements(By.xpath("//*[@class='btn-group pull-right open']/a/following-sibling::ul"));

        for (WebElement each : options) {

            each.isDisplayed();
            Assert.assertTrue(each.isEnabled());
            System.out.println(each.getText());

        }

        WebElement saveandclose = driver.findElement(By.xpath("//*[@class='action-button dropdown-item']"));
        act.moveToElement(saveandclose).build().perform();
        WebElement saveandnew = driver.findElement(By.xpath("//div[@id='container']//li[2]"));
        act.moveToElement(saveandnew).build().perform();
        WebElement save = driver.findElement(By.xpath("//div[@class='app-page__main']//li[3]"));
        act.moveToElement(save).build().perform();

        String Expectedresult = "Save And Close";
        String Actualresult1 = driver.findElement(By.xpath("//*[@class='action-button dropdown-item']")).getText();
        Assert.assertEquals(Actualresult1, Expectedresult);
        BrowserUtils.wait(3);
        String Expectedresult2 = "Save And New";
        String Actualresult2 = driver.findElement(By.xpath("//div[@id='container']//li[2]")).getText();
        BrowserUtils.wait(3);
        String Expectedresult3 = "Save";
        String Actualresult3 = driver.findElement(By.xpath("//div[@class='app-page__main']//li[3]")).getText();
        Assert.assertEquals(Actualresult3, Expectedresult3);
        BrowserUtils.wait(3);
    }

    @Test
    public void test4() {
        Actions act = new Actions(driver);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        act.moveToElement(activitiesElement).build().perform();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        act.moveToElement(calendarEventsElement).build().perform();
        calendarEventsElement.click();

        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[2]/div/a")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Cancel")).click();
        driver.findElement(By.xpath("//*[@class='oro-subtitle']")).isDisplayed();
        String excpectedtitle = "Create Calendar Event";
        String actualtitle = driver.findElement(By.xpath("//*[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualtitle, excpectedtitle);
        System.out.println(driver.getTitle());
        BrowserUtils.wait(3);

    }

    @Test
    public void test5() {
        Actions act = new Actions(driver);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        act.moveToElement(activitiesElement).build().perform();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        act.moveToElement(calendarEventsElement).build().perform();
        calendarEventsElement.click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[2]/div/a")).click();
        BrowserUtils.wait(2);

        //Clicking the first time.
        driver.findElement(By.xpath("//input[contains(@id,'time_selector_oro_calendar_event_form_start-uid')]")).click();
        BrowserUtils.wait(2);
        List<WebElement> ele = driver.findElements(By.xpath("//li[contains(@class,'timepicker')]"));
        for(int i=0; i <ele.size();i++){
            System.out.println(ele.get(i).getText());
            if(ele.get(i).getText().equalsIgnoreCase("8:00 AM")){
                ele.get(i).click();
                System.out.println("Clicked " + ele.get(i).getText());
                break;
            }
        }

        //clicking the second time
        driver.findElement(By.xpath("//input[contains(@id,''time_selector_oro_calendar_event_form_end')]")).click();
        BrowserUtils.wait(2);
        List<WebElement> ele1 = driver.findElements(By.xpath("//li[contains(@class,'timepicker')]"));
        for(int i=0; i <ele1.size();i++){
            System.out.println(ele1.get(i).getText());
            if(ele1.get(i).getText().equalsIgnoreCase("8:00 AM")){
                ele1.get(i).click();
                System.out.println("Clicked second " + ele1.get(i).getText());
                break;
            }
        }



        BrowserUtils.wait(2);
        List<WebElement> liststartdate = driver.findElements(By.xpath("//li[contains(@class,'ui-timepicker')]"));
        System.out.println(liststartdate.size());
        for(int i=0;i<liststartdate.size()-1;i++){

            System.out.println(liststartdate.get(i).getText());

        }

        //BrowserUtils.wait(2);
     //   driver.findElement(By.xpath("//input[contains(@id,'time_selector_oro_calendar_event_form_end-uid')]")).click();




        }

    @Test
    public void test6() {
        Actions act = new Actions(driver);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        act.moveToElement(activitiesElement).build().perform();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        act.moveToElement(calendarEventsElement).build().perform();
        calendarEventsElement.click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[2]/div/a")).click();
        BrowserUtils.wait(2);
        WebElement clickfirst = driver.findElement(By.xpath("//*[contains(@class,'ui-timepicker')]"));
        clickfirst.click();

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'ui-timepicker')]"));
        BrowserUtils.wait(10);


        for (int i = 0; i < list.size() - 1; i++) {

            // if(list.get(i).getText().equals(driver.findElement(By.xpath("//*[@class='ui-timepicker-list']/li[43]")).getText())){
            if (list.get(i).getText().equalsIgnoreCase("9:00 PM")) {
                Assert.assertEquals(list.get(i).getText(), "9:00 PM", "Text is wrong");
                list.get(i).click();

                System.out.println(list.get(i).getText());
                break;
            }

        }

    }

    @Test
    public void test7() {

        Actions act = new Actions(driver);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        act.moveToElement(activitiesElement).build().perform();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        act.moveToElement(calendarEventsElement).build().perform();
        calendarEventsElement.click();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[2]/div/a")).click();
        BrowserUtils.wait(2);

        WebElement checkbox = driver.findElement(By.xpath("//input[contains(@type,'checkbox')]"));
        checkbox.isSelected();
        checkbox.click();
        BrowserUtils.wait(2);
        WebElement verfystartandendtime = driver.findElement(By.xpath("//*[contains(@class,'ui-timepicker')]"));
        BrowserUtils.wait(2);
        if (!verfystartandendtime.isDisplayed()) {
            System.out.println("it is not displayed");

        } else {
            System.out.println("it is displayed");
        }

        WebElement verfystartandenddate = driver.findElement(By.xpath("//input[contains(@class,'input-small datepicker-input s')]"));
        BrowserUtils.wait(2);
        if (verfystartandenddate.isDisplayed()) {
            System.out.println("it is  displayed");

        } else {
            System.out.println("it is not displayed");
        }
        WebElement verfyanddate = driver.findElement(By.xpath("//input[contains(@class,'input-small datepicker-input end')]"));
        BrowserUtils.wait(2);
        if (verfyanddate.isDisplayed()) {
            System.out.println("it is  displayed");

        } else {
            System.out.println("it is not displayed");
        }

    }

    @Test
    public void test8() {
        Actions act = new Actions(driver);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        act.moveToElement(activitiesElement).build().perform();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        act.moveToElement(calendarEventsElement).build().perform();
        calendarEventsElement.click();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[2]/div/a")).click();
        BrowserUtils.wait(2);

        WebElement repeat = driver.findElement(By.id("recurrence-repeat-view1064"));
        repeat.click();
        boolean rep = repeat.isSelected();
        boolean exp = true;
        Assert.assertEquals(rep, exp, "result is true");
        System.out.println("Actual result :" + rep);

        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//select[contains(@id,'recurrence-repeats-')]")).click();
        BrowserUtils.wait(2);
        WebElement isavailable = driver.findElement(By.xpath("//*[@id='recurrence-repeats-view1064']/option"));

        if (isavailable.isEnabled()) {
            isavailable.click();
        }
        System.out.println(isavailable.getText());

        WebElement allavailable = driver.findElement(By.xpath("//*[@id='recurrence-repeats-view1064']"));
        System.out.println(allavailable.getText());
    }

    @Test
    public void test9() {
        Actions act = new Actions(driver);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        act.moveToElement(activitiesElement).build().perform();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        act.moveToElement(calendarEventsElement).build().perform();
        calendarEventsElement.click();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[2]/div/a")).click();
        BrowserUtils.wait(2);

        WebElement repeat = driver.findElement(By.id("recurrence-repeat-view1064"));
        repeat.click();
        boolean rep = repeat.isSelected();
        boolean exp = true;
        Assert.assertEquals(rep, exp, "result is true");
        System.out.println("Actual result :" + rep);
        BrowserUtils.wait(2);
        WebElement repeatevery = driver.findElement(By.xpath("//input[contains(@checked,'checked')]"));
        repeatevery.isSelected();
        BrowserUtils.wait(2);
        WebElement neverbutton = driver.findElement(By.xpath("//input[contains(@checked,'checked')]"));
        boolean actual = true;
        boolean expected = neverbutton.isSelected();
        Assert.assertEquals(actual, expected, "result is true");
        BrowserUtils.wait(2);
        WebElement message = driver.findElement(By.xpath("//*[contains(@class,'control-group recurrence-summary alert-info')]"));
        message.isDisplayed();
        System.out.println(message.getText());
        BrowserUtils.wait(2);
        String actualresult = message.getText();
        String expectedresult = "Summary:\n" + "Daily every 1 day";
        Assert.assertEquals(actualresult, expectedresult, "result is true");


    }

    @Test
    public void test10() {
        Actions act = new Actions(driver);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        act.moveToElement(activitiesElement).build().perform();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        act.moveToElement(calendarEventsElement).build().perform();
        calendarEventsElement.click();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[2]/div/a")).click();
        BrowserUtils.wait(2);
        WebElement repeat = driver.findElement(By.id("recurrence-repeat-view1063"));
        repeat.click();
        BrowserUtils.wait(2);

        WebElement after = driver.findElement(By.xpath("//*[contains(@data-name,'recurrence-ends')]/div/div[2]/div[2]/label/input"));
        after.click();
        BrowserUtils.wait(2);
        WebElement sent = driver.findElement(By.xpath("//*[contains(@data-related-field,'occurrences')]"));
        sent.sendKeys("10");
        sent.sendKeys(Keys.ENTER);
        BrowserUtils.wait(2);
        WebElement disp = driver.findElement(By.xpath("//div[@class='control-group recurrence-summary alert-info']"));
        String ar = disp.getText();
        String exr = "Summary:\n" + "Daily every 1 day, end after 10 occurrences";
        Assert.assertEquals(ar, exr, "Result is true");
        System.out.println(disp.getText());
    }

    @Test
    public void test11() {
        Actions act = new Actions(driver);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        act.moveToElement(activitiesElement).build().perform();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        act.moveToElement(calendarEventsElement).build().perform();
        calendarEventsElement.click();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[2]/div/a")).click();
        BrowserUtils.wait(2);

        WebElement repeat = driver.findElement(By.id("recurrence-repeat-view1063"));
        repeat.click();
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("//*[contains(@class,'recurrence-subview-control__item recurrence')]/label/input")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[contains(@class,'recurrence-subview-control__datetime-wrapper')]/div/input[2]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")).click();
        BrowserUtils.wait(2);
        Select option = new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")));
        option.selectByValue("2021");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")).click();
        BrowserUtils.wait(2);
        Select option2 = new Select(driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")));
        option2.selectByValue("10");
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[5]/a")).click();
        BrowserUtils.wait(2);
        WebElement print = driver.findElement(By.xpath("//*[@class='control-group recurrence-summary alert-info']"));
        System.out.println(print.getText());

    }

    @Test
    public void test12() {
        Actions act = new Actions(driver);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        act.moveToElement(activitiesElement).build().perform();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        act.moveToElement(calendarEventsElement).build().perform();
        calendarEventsElement.click();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[2]/div/a")).click();
        BrowserUtils.wait(2);

        WebElement repeat = driver.findElement(By.id("recurrence-repeat-view1063"));
        repeat.click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[contains(@id,'recurrence-repeats')]")).click();


        Select opt=new Select(driver.findElement(By.xpath("//*[contains(@class,'recurrence-repeats')]")));
         opt.selectByValue("weekly");



        }
    @AfterMethod
    public void teardown(){
        driver.quit();
        }
    }


















