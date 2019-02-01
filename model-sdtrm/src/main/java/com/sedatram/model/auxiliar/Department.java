package com.sedatram.model.auxiliar;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
    private String id;

    public Department(String department) {
        id = department;
    }

    public Department() {
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
