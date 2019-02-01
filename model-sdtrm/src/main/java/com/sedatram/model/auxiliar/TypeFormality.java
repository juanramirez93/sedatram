package com.sedatram.model.auxiliar;

import javax.persistence.*;

@Entity
public class TypeFormality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;
    @Column(nullable = false)
    private String name;
    private boolean customer;
    private boolean vehicle;
    private boolean buyers;
    private boolean state;
    private boolean transitPay;
    private boolean serviceSedatram;
    private boolean total;

    public TypeFormality() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVehicle() {
        return vehicle;
    }

    public void setVehicle(boolean vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isBuyers() {
        return buyers;
    }

    public void setBuyers(boolean buyers) {
        this.buyers = buyers;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isTransitPay() {
        return transitPay;
    }

    public void setTransitPay(boolean transitPay) {
        this.transitPay = transitPay;
    }

    public boolean isServiceSedatram() {
        return serviceSedatram;
    }

    public void setServiceSedatram(boolean serviceSedatram) {
        this.serviceSedatram = serviceSedatram;
    }

    public boolean isTotal() {
        return total;
    }

    public void setTotal(boolean total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isCustomer() {
        return customer;
    }

    public void setCustomer(boolean customer) {
        this.customer = customer;
    }
}
