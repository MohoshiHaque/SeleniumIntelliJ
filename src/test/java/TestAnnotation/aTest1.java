package TestAnnotation;

import org.testng.annotations.Test;

public class aTest1 {



    @Test
    public void demo1() {
        System.out.println("Mohoshi");
    }

    @Test(groups = {"Smoke"})
    public void demo2() {
        System.out.println("Nowmi");
    }

}
