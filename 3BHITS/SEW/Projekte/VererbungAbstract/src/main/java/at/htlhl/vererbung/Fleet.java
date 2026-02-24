package at.htlhl.vererbung;

public class Fleet {
    private Aircraft[] aircrafts = new Aircraft[10];

    public Fleet() {
        for (int i = 0; i < aircrafts.length/2; i++) {
            aircrafts[i] = new Airplane();
        }
        for (int i = aircrafts.length/2; i < aircrafts.length; i++) {
            aircrafts[i] = new Helicopter();
        }
    }

    public void takeoffAll() {
        for (Aircraft aircraft : aircrafts) {
            aircraft.takeoff();
        }
    }

    public void flyAll() {
        for (Aircraft aircraft : aircrafts) {
            aircraft.fly();
        }
    }

    public void landAll() {
        for (Aircraft aircraft : aircrafts) {
            aircraft.land();
        }
    }

    public static void main(String[] args) {
        Fleet united = new Fleet();
        united.takeoffAll();
        System.out.println();
        united.flyAll();
        System.out.println();
        united.landAll();
    }
}
