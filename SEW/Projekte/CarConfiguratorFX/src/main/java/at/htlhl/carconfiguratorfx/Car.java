package at.htlhl.carconfiguratorfx;

public class Car {

    public static final int MAX_POWER = 100;
    public static final int MAX_RANGE = 925;

    private String manufacturer = "";
    private String type = "";
    private int power = 0;
    private int range = 0;

    public Car() {

    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power > Car.MAX_POWER) {
            this.power = Car.MAX_POWER;
        }
        this.power = power;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", type='" + type + '\'' +
                ", power=" + power +
                ", range=" + range +
                '}';
    }
}
