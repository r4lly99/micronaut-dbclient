package micronaut.dbclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;

public class Bicycle {

    @JsonIgnore
    private ObjectId id;
    private String brand;
    private String name;
    private int gear;
    private BicycleType type;
    private String colour;
    private Double price;

    public Bicycle() {
    }

    public Bicycle(ObjectId id, String brand, String name, int gear, BicycleType type, String colour, Double price) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.gear = gear;
        this.type = type;
        this.colour = colour;
        this.price = price;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public BicycleType getType() {
        return type;
    }

    public void setType(BicycleType type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
