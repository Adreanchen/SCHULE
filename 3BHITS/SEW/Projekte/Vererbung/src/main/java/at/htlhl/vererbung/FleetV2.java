package at.htlhl.vererbung;

import java.util.ArrayList;

public class FleetV2 {

    private ArrayList<Aircraft> aircraftList;

    public FleetV2() {

        aircraftList = new ArrayList<>();
        //TODO So ...
        aircraftList.add(new Aircraft());
        //TODO ... oder so:
        // Aircraft aircraft = new Aircraft();
        // aircraftList.add(aircraft);

        aircraftList.add(new Airplane());
        aircraftList.add(new Helicopter());
    }

    public void takeoffAll() {
        for (Aircraft aircraft : aircraftList) {
            aircraft.takeoff();
        }
    }

    public void flyAll() {
        for (Aircraft aircraft : aircraftList) {
            aircraft.fly();
        }
    }

    public void landAll() {
        for (Aircraft aircraft : aircraftList) {
            aircraft.land();
        }
    }

    public static void main(String[] args) {
        FleetV2 fleet = new FleetV2();
        System.out.println();
        fleet.takeoffAll();
        System.out.println();
        fleet.flyAll();
        System.out.println();
        fleet.landAll();
    }
}
