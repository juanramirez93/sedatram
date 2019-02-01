package com.sedatram.model.auxiliar;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ColorVehicle {

    private String id;

    public ColorVehicle(String color) {
        id = color;
    }

    public ColorVehicle() {
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
