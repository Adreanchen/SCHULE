package at.htlhl.carconfiguratorfx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model
 *
 * @author Adrian Fritz
 */
public class Car {

    // Constants **************************************************************

    public static final int MAX_POWER = 200;
    public static final int MAX_RANGE = 1000;

    // Fields *****************************************************************

    // private String manufacturer = "";
    private final StringProperty manufacturerProperty = new SimpleStringProperty(this, "manufacturer");

    // private String type = "";
    private final StringProperty typeProperty = new SimpleStringProperty(this, "type");

    // private int power = 0;
    private final IntegerProperty powerProperty = new SimpleIntegerProperty(this, "power");

    // private int range = 0;
    private final IntegerProperty rangeProperty = new SimpleIntegerProperty(this, "range");

    

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
