package micronaut.dbclient.model.builder;

import micronaut.dbclient.model.Bicycle;
import micronaut.dbclient.model.BicycleType;
import org.bson.types.ObjectId;

import java.util.Objects;

public class BicycleBuilder {

    private String id;
    private String brand;
    private String name;
    private int gear;
    private BicycleType type;
    private String colour;
    private Double price;

    public BicycleBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public BicycleBuilder setBrand(String brand){
        this.brand = brand;
        return this;
    }

    public BicycleBuilder setName(String name){
        this.name = name;
        return this;
    }

    public BicycleBuilder setGear(int gear){
        this.gear = gear;
        return this;
    }

    public BicycleBuilder setType(BicycleType type){
        this.type = type;
        return this;
    }

    public BicycleBuilder setColour(String colour){
        this.colour = colour;
        return this;
    }

    public BicycleBuilder setPrice(double price){
        this.price = price;
        return this;
    }

    public Bicycle createBike() {
        if (Objects.isNull(id)) {
            return new Bicycle(null, brand, name, gear, type, colour, price);
        } else {
            return new Bicycle(new ObjectId(id), brand, name, gear, type, colour, price);
        }
    }

}
