package TestAnnotation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test3BeforeClass {

    @BeforeClass
    public void TestBeforeClass(){
        System.out.println("Before Class");

    }

    @Test
    public void demo7() {
        System.out.println("Shovon");
    }

    @Test
    public void demo8() {
        System.out.println("Iffa");
    }



}
