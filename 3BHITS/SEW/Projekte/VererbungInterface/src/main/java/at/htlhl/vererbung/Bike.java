package at.htlhl.vererbung;

/**
 * Bike
 */
public class Bike implements Rentable{

    // Accessors **************************************************************

    public boolean isRentable() {
        System.out.println("A bike is rentable!");
        return true;
    }
}
