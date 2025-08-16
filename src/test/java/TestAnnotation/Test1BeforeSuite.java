package TestAnnotation;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test1BeforeSuite {

    @BeforeSuite

    public void TestBeforeSuite(){
        System.out.println("Before Suite");

    }

    @Test
    public void demo5() {
        System.out.println("Nayem");
    }

    @Test
    public void demo6() {
        System.out.println("Hasnat");
    }

}
