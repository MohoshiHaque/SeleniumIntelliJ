package TestAnnotation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2Beforetest {

    @BeforeTest

    public void TestBeforeTest(){
        System.out.println("Before test");

    }

    @Test
    public void demo5() {
        System.out.println("Akash");
    }

    @Test
    public void demo6() {
        System.out.println("Mrittika");
    }

}
