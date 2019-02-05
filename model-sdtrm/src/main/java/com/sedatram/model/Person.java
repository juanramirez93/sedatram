package com.sedatram.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Person {

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
    private String contact = "";
    private String cellContact = "";
    private String managerId = "";
    private String managerName = "";
    private String typePerson = "";
    private Boolean customer;
    private String createdBy;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    private String editedBy;
    @Temporal(TemporalType.DATE)
    private Date editedAt;
    @ManyToMany(mappedBy = "owners")
    private List<Vehicle> vehicles = new ArrayList<>();
    @OneToMany(mappedBy = "customer")
    private List<Formality> formalities = new ArrayList<>();

    public Person(String identification) {
        this.identification = identification;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCellContact() {
        return cellContact;
    }

    public void setCellContact(String cellContact) {
        this.cellContact = cellContact;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }

    public String getName() {
        if (typeDocument == null) {
            return "";
        }
        if (typeDocument.equals("NIT")) {
            if (acronym.isEmpty()) {
                return firstName;
            }
            return acronym + " - " + firstName;
        }
        return firstName + " " + lastName;
    }

    public Person() {
    }

    public Boolean getCustomer() {
        return customer;
    }

    public void setCustomer(Boolean customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return identification + "/" + getName();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Formality> getFormalities() {
        return formalities;
    }

    public void setFormalities(List<Formality> formalities) {
        this.formalities = formalities;
    }

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public Date getEditedAt() {
		return editedAt;
	}

	public void setEditedAt(Date editedAt) {
		this.editedAt = editedAt;
	}

	public Buyer asBuyer() {
		// TODO Auto-generated method stub
		return null;
	}
}
