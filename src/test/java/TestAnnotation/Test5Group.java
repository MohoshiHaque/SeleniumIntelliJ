package TestAnnotation;

import org.testng.annotations.Test;

public class Test5Group {

    @Test
    public void demoG1() {
        System.out.println("Aminul");
    }

    @Test(groups = {"Smoke"})
    public void demoG2() {
        System.out.println("Munna");
    }
}
