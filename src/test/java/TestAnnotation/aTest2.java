package TestAnnotation;

import org.testng.annotations.Test;

public class aTest2 {

    @Test
    public void demo3() {
        System.out.println("Ridwan");
    }

    @Test(groups = {"Smoke"})
    public void demo4() {
        System.out.println("Sumaiya");
    }


}
