package at.htlhl.vererbung;

public abstract class Aircraft {
    protected float speed;
    protected float altitude;

    public Aircraft() {
        System.out.println("Constructor Aircraft");
        speed = 0.0f;
        altitude = 0.0f;
    }

    public void takeoff() {
        System.out.println("An Aircraft is taking off. ");
    }

    public abstract void fly();

    public void land() {
        System.out.println("An Aircraft is landing. ");
    }

}
