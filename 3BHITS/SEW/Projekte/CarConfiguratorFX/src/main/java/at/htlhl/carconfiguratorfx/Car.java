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

    public static final int MAX_POWER = 100;
    public static final int MAX_RANGE = 925;

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
        return manufacturerProperty.get();
    }

    public void setManufacturer(String manufacturer) {
        manufacturerProperty.set(manufacturer);
    }

    public StringProperty manufacturerProperty() {
        return  manufacturerProperty;
    }

    public String getType() {
        return typeProperty.get();
    }

    public void setType(String type) {
        typeProperty.set(type);
    }

    public StringProperty typeProperty() {
        return  typeProperty;
    }

    public int getPower() {
        return powerProperty.get();
    }

    public void setPower(int power) {
        if (power > Car.MAX_POWER) {
            powerProperty.set(Car.MAX_POWER);
        }
        powerProperty.set(power);
    }

    public IntegerProperty powerProperty() {
        return  powerProperty;
    }

    public int getRange() {
        return rangeProperty.get();
    }

    public void setRange(int range) {
        rangeProperty.set(range);
    }

    public IntegerProperty rangeProperty() {
        return  rangeProperty;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + getManufacturer() + '\'' +
                ", type='" + getType() + '\'' +
                ", power=" + getPower() +
                ", range=" + getRange() +
                '}';
    }
}
