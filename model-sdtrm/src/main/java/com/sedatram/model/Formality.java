package com.sedatram.model;
import com.sedatram.model.auxiliar.TypeFormality;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Formality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_customer")
    private Person customer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type")
    private TypeFormality type;
    @Temporal(TemporalType.DATE)
    private Date initDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicle")
    private Vehicle vehicle;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Formality_Buyer", joinColumns = @JoinColumn(name = "formality_id"),
            inverseJoinColumns = @JoinColumn(name = "buyer_id"))
    private List<Buyer> buyers;
    private String status;
    @Temporal(TemporalType.DATE)
    private Date finishDate;
    private int advance;
    private int transitPay;
    private int serviceSedatram;
    private int total;

    public Formality() {
        buyers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public TypeFormality getType() {
        return type;
    }

    public void setType(TypeFormality procedureType) {
        this.type = procedureType;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public int getTransitPay() {
        return transitPay;
    }

    public void setTransitPay(int transitPay) {
        this.transitPay = transitPay;
    }

    public int getServiceSedatram() {
        return serviceSedatram;
    }

    public void setServiceSedatram(int serviceSedatram) {
        this.serviceSedatram = serviceSedatram;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
        buyer.getFormalities().add(this);
    }

    public void removeBuyer(Buyer buyer) {
        buyers.remove(buyer);
        buyer.getFormalities().remove(this);
    }

    public boolean existBuyer(Buyer buyer) {
        for(Buyer o : buyers) {
            if(o.getIdentification().equals(buyer.getIdentification())) {
                return true;
            }
        }
        return false;
    }
}
