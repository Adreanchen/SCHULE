package at.htlhl.vererbung;

public class Airplane extends Aircraft {
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

}
