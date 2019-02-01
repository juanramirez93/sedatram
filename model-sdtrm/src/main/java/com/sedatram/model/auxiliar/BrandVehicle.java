package com.sedatram.model.auxiliar;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BrandVehicle {

    private String id;

    public BrandVehicle(String brand) {
        id = brand;
    }

    public BrandVehicle() {
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getId();
    }
}
