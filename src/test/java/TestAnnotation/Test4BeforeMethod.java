package TestAnnotation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test4BeforeMethod {

    @BeforeMethod

    public void TestBeforeMethod() {
        System.out.println("Before Method");

    }

    @Test
    public void demo5() {
        System.out.println("Arman");
    }

    @Test
    public void demo6() {
        System.out.println("Sojol");
    }
}
