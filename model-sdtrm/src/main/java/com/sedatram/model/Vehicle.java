package com.sedatram.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;
    @Column(nullable = false, unique = true)
    private String plaque;
    private String service = "";
    private String type = "";
    private String brand = "";
    private String line = "";
    private String model = "";
    private String color = "";
    private String serial = "";
    private String motor = "";
    private String chassis = "";
    private String vin = "";
    private String displacement = "";
    private String bodywork = "";
    private String gasoline = "";
    @Temporal(TemporalType.DATE)
    private Date registration;
    private String transit = "";
    private String capacity = "";
    private String PBV = "";
    private String axes = "";

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Vehicle_Owner", joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private List<Person> owners = new ArrayList<>();

    public Vehicle() {
    }

    public void addOwner(Person owner) {
        owners.add(owner);
        owner.getVehicles().add(this);
    }

    public void removeOwner(Person owner) {
        owners.remove(owner);
        owner.getVehicles().remove(this);
    }

    public boolean existOwner(Person owner) {
        for(Person o : owners) {
            if(o.getIdentification().equals(owner.getIdentification())) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getBodywork() {
        return bodywork;
    }

    public void setBodywork(String bodywork) {
        this.bodywork = bodywork;
    }

    public String getGasoline() {
        return gasoline;
    }

    public void setGasoline(String gasoline) {
        this.gasoline = gasoline;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public String getTransit() {
        return transit;
    }

    public void setTransit(String transit) {
        this.transit = transit;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getPBV() {
        return PBV;
    }

    public void setPBV(String PBV) {
        this.PBV = PBV;
    }

    public String getAxes() {
        return axes;
    }

    public void setAxes(String axes) {
        this.axes = axes;
    }

    public List<Person> getOwners() {
        return owners;
    }

    public void setOwners(List<Person> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return plaque;
    }

    @OneToMany(mappedBy = "vehicle")
    private Collection<Formality> formality;

    public Collection<Formality> getFormality() {
        return formality;
    }

    public void setFormality(Collection<Formality> formality) {
        this.formality = formality;
    }
}
