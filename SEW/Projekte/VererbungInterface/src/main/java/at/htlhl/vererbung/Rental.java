package at.htlhl.vererbung;

import java.util.ArrayList;

/**
 * Rental
 */
public class Rental {

    // Fields *****************************************************************

    private ArrayList<Rentable> rentableList;


    // Instance creation ******************************************************

    public Rental() {
        rentableList = new ArrayList<>();

        rentableList.add(new Airplane());
        rentableList.add(new Helicopter());
        rentableList.add(new Bike());
    }

    // Accessors **************************************************************

    public void rent() {
        for (Rentable rentable : rentableList) {
            rentable.isRentable();
        }
    }

    public static void main(String[] args) {
        Rental rental = new Rental();
        rental.rent();
    }
}
