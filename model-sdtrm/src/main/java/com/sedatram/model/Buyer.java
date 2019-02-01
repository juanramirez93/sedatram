package com.sedatram.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;
    private String typeDocument;
    @Column(nullable = false, unique = true)
    private String identification;
    private String firstName;
    private String lastName = "";
    private String acronym = "";
    private String phone = "";
    private String cell = "";
    private String email = "";
    private String address = "";
    private String city = "";
    private String department = "";

    @ManyToMany(mappedBy = "buyers")
    private List<Formality> procedures = new ArrayList<>();

    public Buyer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Formality> getFormalities() {
        return procedures;
    }

    public void setFormalities(List<Formality> procedures) {
        this.procedures = procedures;
    }
}
