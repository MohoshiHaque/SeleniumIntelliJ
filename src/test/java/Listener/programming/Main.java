package Listener.programming;

public class Main {
    public static void main(String[] args) {
        // Create an object of SamsungTV
        // tv is an interface-type reference pointing to a SamsungTV object, allowing only interface methods
        RemoteControl tv = new SamsungTV();
        // Call method for only interface class
        tv.power();
        tv.VolumnUp();
        tv.VolumnDown();


        // tv1 is a class-type reference pointing to a SamsungTV object, allowing all class methods
        SamsungTV tv1 = new SamsungTV();
        // Call methods for only Samsung Class
        tv1.power();
        tv1.VolumnUp();
        tv1.VolumnDown();
        tv1.extraMethod();
    }
}