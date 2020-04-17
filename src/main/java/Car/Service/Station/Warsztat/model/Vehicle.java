package Car.Service.Station.Warsztat.model;

import java.time.LocalDate;
import java.util.Date;

public class Vehicle {
    private int id;
    private String brand;
    private String engine;
    private String colour;
    private Date productionYear;
    private String gearBox;
    private String registrationNumber;
    private String model;
    private Date nextTechnicalReview;

    public Vehicle() {
    }

    public Vehicle(int id) {
        this.id = id;
    }

    public Vehicle(String brand, String engine, String colour, Date productionYear, String gearBox, String registrationNumber, String model, Date nextTechnicalReview) {
        this.brand = brand;
        this.engine = engine;
        this.colour = colour;
        this.productionYear = productionYear;
        this.gearBox = gearBox;
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.nextTechnicalReview = nextTechnicalReview;
    }

    public Vehicle(int id, String brand, String engine, String colour, Date productionYear, String gearBox, String registrationNumber, String model, Date nextTechnicalReview) {
        this.id = id;
        this.brand = brand;
        this.engine = engine;
        this.colour = colour;
        this.productionYear = productionYear;
        this.gearBox = gearBox;
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.nextTechnicalReview = nextTechnicalReview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Date getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Date productionYear) {
        this.productionYear = productionYear;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getNextTechnicalReview() {
        return nextTechnicalReview;
    }

    public void setNextTechnicalReview(Date nextTechnicalReview) {
        this.nextTechnicalReview = nextTechnicalReview;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", engine='" + engine + '\'' +
                ", colour='" + colour + '\'' +
                ", productionYear=" + productionYear +
                ", gearBox='" + gearBox + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", model='" + model + '\'' +
                ", nextTechnicalReview=" + nextTechnicalReview +
                '}';
    }
}
