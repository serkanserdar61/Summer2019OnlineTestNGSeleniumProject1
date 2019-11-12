package Tests.day7;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {

   @BeforeClass
    public void beforeClass(){
       System.out.println("Before class");//it runs first and just one time
   }
    @AfterClass
    public void afterClass(){
        System.out.println("After class");//it runs last and one time
    }
    @BeforeMethod
    public void setup(){
        System.out.println("Before method!");//it runs before every method
    }
    @AfterMethod
    public void teardown(){
        System.out.println("After method!");//it runs after every method
    }
    @Test
    public void test1(){
        System.out.println("test 1!");
        Assert.assertTrue(5==5);
    }
    @Test
    public void test2(){
        System.out.println("test 2!");
    }
    @Test
    public void test3(){
        System.out.println("test 3!");
    }

}
