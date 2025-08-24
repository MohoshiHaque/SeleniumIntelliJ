package Listener.programming;

public class SamsungTV implements RemoteControl {

    @Override
    public void power() {

        System.out.println("Power Up");

    }

    @Override
    public void VolumnUp() {

        System.out.println("Volumn ++");

    }

    @Override
    public void VolumnDown() {

        System.out.println("Volumn --");

    }

    public void extraMethod(){
        System.out.println("Extra Info");
    }

}
