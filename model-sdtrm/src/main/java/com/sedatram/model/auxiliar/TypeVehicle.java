package com.sedatram.model.auxiliar;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TypeVehicle {

    private String id;

    public TypeVehicle(String type) {
        id = type;
    }

    public TypeVehicle() {
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
