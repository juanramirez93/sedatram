package com.sedatram.model.auxiliar;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
    private String id;

    public City(String city) {
        id = city;
    }

    public City() {
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
