package at.htlhl.vererbung;

public class Fleet {
    private Aircraft aircraft1;
    private Aircraft aircraft2;
    private Aircraft aircraft3;

    public Fleet() {
        aircraft1 = new Aircraft();
        aircraft2 = new Airplane();
        aircraft3 = new Helicopter();
    }

    public void takeoffAll() {
        aircraft1.takeoff();
        aircraft2.takeoff();
        aircraft3.takeoff();
    }

    public void flyAll() {
        aircraft1.fly();
        aircraft2.fly();
        aircraft3.fly();
    }

    public void landAll() {
        aircraft1.land();
        aircraft2.land();
        aircraft3.land();
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
