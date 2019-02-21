package com.sedatram.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Temporal(TemporalType.TIMESTAMP)
	private Date registration;
	private String transit = "";
	private String capacity = "";
	private String PBV = "";
	private String axes = "";
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	private String editedBy;
	@Temporal(TemporalType.TIMESTAMP)
	private Date editedAt;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "Vehicle_Owner", joinColumns = @JoinColumn(name = "vehicle_id"), inverseJoinColumns = @JoinColumn(name = "owner_id"))
	private List<Person> owners = new ArrayList<>();

	@OneToMany(mappedBy = "vehicle")
	private Collection<Formality> formality;

	public Vehicle() {
	}

	public Vehicle(String plaque) {
		this.plaque = plaque;
		this.createdAt = new Date();
		this.createdBy = Session.userActive.getName();
	}

	public void addOwner(Person owner) {
		owners.add(owner);
		owner.getVehicles().add(this);
	}

	public boolean existOwner(Person owner) {
		for (Person o : owners) {
			if (o.getIdentification().equals(owner.getIdentification())) {
				return true;
			}
		}
		return false;
	}

	public String getAxes() {
		return axes;
	}

	public String getBodywork() {
		return bodywork;
	}

	public String getBrand() {
		return brand;
	}

	public String getCapacity() {
		return capacity;
	}

	public String getChassis() {
		return chassis;
	}

	public String getColor() {
		return color;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getDisplacement() {
		return displacement;
	}

	public Date getEditedAt() {
		return editedAt;
	}

	public String getEditedBy() {
		return editedBy;
	}

	public Collection<Formality> getFormality() {
		return formality;
	}

	public String getGasoline() {
		return gasoline;
	}

	public int getId() {
		return id;
	}

	public String getLine() {
		return line;
	}

	public String getModel() {
		return model;
	}

	public String getMotor() {
		return motor;
	}

	public List<Person> getOwners() {
		return owners;
	}

	public String getPBV() {
		return PBV;
	}

	public String getPlaque() {
		return plaque;
	}

	public Date getRegistration() {
		return registration;
	}

	public String getSerial() {
		return serial;
	}

	public String getService() {
		return service;
	}

	public String getTransit() {
		return transit;
	}

	public String getType() {
		return type;
	}

	public String getVin() {
		return vin;
	}

	public void removeOwner(Person owner) {
		owners.remove(owner);
		owner.getVehicles().remove(this);
	}

	public void setAxes(String axes) {
		this.axes = axes;
	}

	public void setBodywork(String bodywork) {
		this.bodywork = bodywork;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	public void setEditedAt(Date editedAt) {
		this.editedAt = editedAt;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public void setFormality(Collection<Formality> formality) {
		this.formality = formality;
	}

	public void setGasoline(String gasoline) {
		this.gasoline = gasoline;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public void setOwners(List<Person> owners) {
		this.owners = owners;
	}

	public void setPBV(String PBV) {
		this.PBV = PBV;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setTransit(String transit) {
		this.transit = transit;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Override
	public String toString() {
		return plaque;
	}
}
