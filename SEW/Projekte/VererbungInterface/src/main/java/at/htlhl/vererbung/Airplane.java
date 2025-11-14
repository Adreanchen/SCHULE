package at.htlhl.vererbung;

public class Airplane extends Aircraft implements Rentable {
    private float wingSpan;
    public Airplane() {
        this.wingSpan = 15.7f;
    }

    public void takeoff() {
        System.out.println("An Airplane is taking off.");
    }

    public void fly() {
        System.out.println("An Airplane is flying.");
    }

    public void land() {
        System.out.println("An Airplane is landing.");
    }

    @Override
    public boolean isRentable() {
        System.out.println("An airplane is not rentable!");
        return false;
    }
}
