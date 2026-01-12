package at.htl.gebrauchtwagenverwaltung;

import java.util.Date;

public class Car {
    private int range;
    private int firstRegistration;
    private String brand;
    private String model;
    private double price;
    private boolean automatic;
    private int power;
    private double kilometer;
    private Date priceChangeDate;// Change to string bc of some problems
    private int id; //wird eigentlich nicht im gui gebraucht

    public Car() {
    }

    public Car(int id, String brand, String model, int firstRegistration, double kilometer, double price, Date priceChangeDate, boolean automatic, int range, int power) {
        this.range = range;
        this.firstRegistration = firstRegistration;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.automatic = automatic;
        this.power = power;
        this.kilometer = kilometer;
        this.priceChangeDate = priceChangeDate;
        this.id = id;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getFirstRegistration() {
        return firstRegistration;
    }

    public void setFirstRegistration(int firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public double getKilometer() {
        return kilometer;
    }

    public void setKilometer(double kilometer) {
        this.kilometer = kilometer;
    }

    public Date getPriceChangeDate() {
        return priceChangeDate;
    }

    public void setPriceChangeDate(Date priceChangeDate) {
        this.priceChangeDate = priceChangeDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
