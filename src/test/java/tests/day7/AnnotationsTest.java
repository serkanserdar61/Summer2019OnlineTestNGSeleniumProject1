package tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {

   @BeforeClass
    public void beforeClass() {
       System.out.println("Before class");
   }//it runs first and just one time

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
        //it runs last and one time
    }
    @BeforeMethod
    public void setup(){
        System.out.println("Before method!");
        //it runs before every method
    }
    @AfterMethod
    public void teardown(){
        System.out.println("After method!");
        //it runs after every method
    }
    @Test
    public void testB(){
        System.out.println("test 1!");
        Assert.assertTrue(5==5);
    }

    @Test
    public void testA(){
        System.out.println("test 2!");
    }
    @Test
    public void testC(){
        System.out.println("test 3!");
    }
    @BeforeSuite
    public void test5(){
        System.out.println("before suit");

    }
    @AfterSuite
    public void test7(){
        System.out.println("after suite");

    }
    //before suit==>before class==>before method==>METHOD==>after method==>After class==>After Suit
}
