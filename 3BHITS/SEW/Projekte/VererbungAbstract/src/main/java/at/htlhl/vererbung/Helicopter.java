package at.htlhl.vererbung;

public class Helicopter extends Aircraft {
    private float rotorBladeSize;

    public Helicopter() {
        this.rotorBladeSize = 8.3f;
    }

    public void takeoff() {
        System.out.println("An Helicopter is taking off.  ");
    }

    public void fly() {
        System.out.println("An Helicopter is flying.  ");
    }

    public void land() {
        super.land();
        System.out.println("An Helicopter is landing.  ");
    }
}
